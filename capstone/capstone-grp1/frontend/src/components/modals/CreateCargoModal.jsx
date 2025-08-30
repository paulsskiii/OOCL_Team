import { Modal, Button, Segmented } from "antd";
import { useEffect, useState, useContext } from "react";
import { Container as LucideContainer } from "lucide-react";
import { Input, Select, Form } from "antd";
import { MainPageContext } from "../../pages/MainAppPage";
function CreateCargoModal({ open, handleOk, setIsCreateModalOpen }) {
	const [loading, setLoading] = useState(false);
	const [form] = Form.useForm();
	const [name, setName] = useState("");
	const [origin, setOrigin] = useState("");
	const [destination, setDestination] = useState("");
	const [weight, setWeight] = useState(0);
	const [description, setDescription] = useState("");
	const [portOptions, setPortOptions] = useState([]);
	const [userOptions, setUserOptions] = useState([]);
	const loggedInUserId = 1;
	const [shipper, setShipper] = useState(null);
	const [consignee, setConsignee] = useState(null);

	const { portsList, fetchCargoes, usersList, API_URL } =
		useContext(MainPageContext);

	useEffect(() => {
		setPortOptions(
			portsList?.map((port) => ({
				value: port.portCode,
				label: port.portLocation,
			}))
		);
	}, [portsList]);

	useEffect(() => {
		setUserOptions(
			usersList?.map((user) => ({
				value: user.id,
				label: user.firstName + " " + user.lastName,
			}))
		);
		console.log("users", usersList);
	}, [usersList]);

	async function handleValidate(e) {
		e.preventDefault();
		console.log("connecting to api" + API_URL);
		try {
			await form.validateFields();
			console.log("Validation successful!");
			try {
				const response = await fetch(API_URL + "/cargo", {
					method: "POST",
					headers: {
						"Content-Type": "application/json",
					},
					body: JSON.stringify({
						name: name,
						descriptions: description,
						weight: weight,
						statusCode: "PND",
						origin: origin,
						destination: destination,
						shipper: shipper,
						consignee: consignee,
					}),
				});
				if (!response.ok) {
					throw new Error(`HTTP error! status: ${response.status}`);
				}
				// Re-fetch containers to update the list
				await fetchCargoes();
				// Reset the form
				handleCancel();
			} catch (e) {
				console.error("Failed to add cargo:", e);
				///	setError("Failed to add new cargo. Please check the backend.");
			}
		} catch (errorInfo) {
			console.log("Validation failed:", errorInfo);
		}
	}

	const handleSubmit = async () => {};

	function handleCancel() {
		form.resetFields();
		setName("");
		setOrigin("");
		setDescription("");
		setDestination("");
		setConsignee("");
		setShipper("");
		setWeight("");
		setIsCreateModalOpen(false);
	}
	function handleNameChange(e) {
		setName(e.target.value);
	}

	function handleOriginChange(e) {
		setOrigin(e);
	}

	function handleDestinationChange(e) {
		setDestination(e);
	}

	function handleShipperChange(e) {
		setShipper(e);
	}

	function handleConsigneeChange(e) {
		setConsignee(e);
	}

	function handleWeightChange(e) {
		setWeight(e.target.value);
	}

	function handleDescriptionChange(e) {
		setDescription(e.target.value);
	}

	return (
		<Modal
			open={open}
			title={
				<div className="flex flex-row items-center gap-2 pb-3">
					<LucideContainer size={25} className="text-green-600" />
					<span className="text-2xl font-semibold">Create New Cargo</span>
				</div>
			}
			onOk={handleOk}
			onCancel={handleCancel}
			footer={[
				<Button key="back" onClick={handleCancel} size={"large"}>
					Cancel
				</Button>,
				<Button
					key="submit"
					type="primary"
					loading={loading}
					onClick={(e) => handleValidate(e)}
					htmlType="submit"
					size={"large"}
				>
					Submit
				</Button>,
			]}
		>
			<div className="flex flex-col w-full ">
				<Form form={form}>
					<article className="flex flex-col w-full gap-2">
						<span className="font-semibold ">
							Cargo Name:<span className="text-red-500"> *</span>
						</span>
						<Form.Item
							name="cargoName"
							rules={[{ required: true, message: "Please input cargo name!" }]}
						>
							<Input
								size="large"
								placeholder="Input container name"
								maxLength={50}
								showCount={true}
								value={name}
								onChange={(e) => handleNameChange(e)}
								required
							/>
						</Form.Item>
					</article>
					<section className="flex flex-row w-full gap-1">
						<article className="flex flex-col w-1/2 gap-2">
							<span className="font-semibold ">
								Origin:<span className="text-red-500"> *</span>
							</span>
							<Form.Item
								name="origin"
								rules={[
									{ required: true, message: "Please select port of origin!" },
									({ getFieldValue }) => ({
										validator(_, value) {
											if (!value || value !== getFieldValue("destination")) {
												return Promise.resolve();
											}
											return Promise.reject(
												new Error("Origin/Destination cannot be the same!")
											);
										},
									}),
								]}
							>
								<Select
									size="large"
									showSearch
									placeholder="Select port of origin"
									required
									value={origin}
									onChange={(e) => handleOriginChange(e)}
									options={portOptions}
								/>
							</Form.Item>
						</article>
						<article className="flex flex-col w-1/2 gap-2">
							<span className="font-semibold ">
								Destination: <span className="text-red-500"> *</span>
							</span>
							<Form.Item
								name="destination"
								rules={[
									{
										required: true,
										message: "Please input select final destination!",
									},
									({ getFieldValue }) => ({
										validator(_, value) {
											if (!value || value !== getFieldValue("origin")) {
												return Promise.resolve();
											}
											return Promise.reject(
												new Error("Origin/Destination cannot be the same!")
											);
										},
									}),
								]}
							>
								<Select
									size="large"
									showSearch
									placeholder="Select final destination"
									required
									value={destination}
									onChange={(e) => handleDestinationChange(e)}
									options={portOptions}
								/>
							</Form.Item>
						</article>
					</section>

					<section className="flex flex-row w-full gap-1">
						<article className="flex flex-col w-full gap-2">
							<span className="font-semibold ">
								Shipper: <span className="text-red-500"> *</span>
							</span>
							<Form.Item
								name="shipper"
								rules={[
									{
										required: true,
										message: "Please input select shipper!",
									},
									({ getFieldValue }) => ({
										validator(_, value) {
											const consignee = getFieldValue("consignee");
											if (!value) return Promise.resolve();

											if (value === consignee) {
												return Promise.reject(
													new Error("Shipper and Consignee cannot be the same!")
												);
											}

											// at least one must be loggedInUserId
											if (
												value === loggedInUserId ||
												consignee === loggedInUserId
											) {
												return Promise.resolve();
											}

											return Promise.reject(
												new Error(
													"Either Shipper or Consignee must be the logged-in user!"
												)
											);
										},
									}),
								]}
							>
								<Select
									size="large"
									showSearch
									placeholder="Select shipper"
									required
									value={shipper}
									onChange={(e) => handleShipperChange(e)}
									options={userOptions}
								/>
							</Form.Item>
						</article>

						<article className="flex flex-col w-full gap-2">
							<span className="font-semibold ">
								Consignee: <span className="text-red-500"> *</span>
							</span>
							<Form.Item
								name="consignee"
								rules={[
									{
										required: true,
										message: "Please input select consignee!",
									},
									({ getFieldValue }) => ({
										validator(_, value) {
											const shipper = getFieldValue("shipper");
											if (!value) return Promise.resolve();

											if (value === shipper) {
												return Promise.reject(
													new Error("Consignee and Shipper cannot be the same!")
												);
											}

											// at least one must be loggedInUserId
											if (
												value === loggedInUserId ||
												shipper === loggedInUserId
											) {
												return Promise.resolve();
											}

											return Promise.reject(
												new Error(
													"Either Shipper or Consignee must be the logged-in user!"
												)
											);
										},
									}),
								]}
							>
								<Select
									size="large"
									showSearch
									placeholder="Select consignee"
									required
									value={consignee}
									onChange={(e) => handleConsigneeChange(e)}
									options={userOptions}
								/>
							</Form.Item>
						</article>
					</section>
					<article className="flex flex-col w-full gap-2">
						<span className="font-semibold ">
							Weight: <span className="text-red-500">*</span>
						</span>
						<Form.Item
							rules={[
								{ required: true, message: "Please input cargo weight!" },
							]}
							name="weight"
						>
							<Input
								size="large"
								type="number"
								placeholder="Input weight"
								required
								min={1}
								value={weight}
								onChange={(e) => handleWeightChange(e)}
								step="0.01"
							/>
						</Form.Item>
					</article>
					<article className="flex flex-col w-full gap-2 ">
						<span className="font-semibold ">Description:</span>
						<Form.Item name="description">
							<Input.TextArea
								size="large"
								placeholder="Input description"
								maxLength={100}
								showCount={true}
								value={description}
								onChange={(e) => handleDescriptionChange(e)}
							/>
						</Form.Item>
					</article>
				</Form>
			</div>
		</Modal>
	);
}

export default CreateCargoModal;
