import { useEffect, useContext, useState } from "react";
import { Modal, Button, Segmented } from "antd";
import { Input, Select, Form } from "antd";
import { MainPageContext } from "../../pages/MainAppPage";

function ViewCargoModal() {
	return (
		<Modal
			open={open}
			title={
				<div className="flex flex-row items-center gap-2 pb-3">
					<LucideContainer size={25} className="text-green-600" />
					<span className="text-2xl font-semibold">View Cargo Details</span>
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
		></Modal>
	);
}

export default ViewCargoModal;
