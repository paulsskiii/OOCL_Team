import React, { useState, useEffect, createContext } from "react";
import { MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { Button, Layout, Menu } from "antd";
import UserSideBar from "../components/UserSideBar";
import { LayoutDashboard, SquareUserRound } from "lucide-react";
import MainContent from "../components/MainContent";
import axios from "axios";

const { Sider } = Layout;

export const MainPageContext = createContext();

const MainAppPage = () => {
	const [rawCargoes, setRawCargoes] = useState([]);
	const [cargoes, setCargoes] = useState([]);
	const [usersList, setUsersList] = useState([]);
	const [portsList, setPortsList] = useState([]);
	const [statusList, setStatusList] = useState([]);
	const [trackingEventList, setTrackingEventList] = useState([]);
	const [loading, setLoading] = useState(true);
	const [error, setError] = useState(null);
	const [collapsed, setCollapsed] = useState(false);
	const API_URL = "http://localhost:8080/api";
	const transformCargoes = (cargoes, users, ports, statuses) => {
		return cargoes.map((cargo) => {
			// find port objects
			const originPort = ports.find((p) => p.portCode === cargo.origin);
			const destinationPort = ports.find(
				(p) => p.portCode === cargo.destination
			);

			// find status object
			const statusObj = statuses.find((s) => s.id === cargo.statusId);

			// find user objects
			const createdByUser = users.find((u) => u.id === cargo.createdBy);
			const consigneeUser = users.find((u) => u.id === cargo.consignee);
			const shipperUser = users.find((u) => u.id === cargo.shipper);
			const courierUser = users.find((u) => u.id === cargo.courier);

			return {
				...cargo,
				origin: originPort ? originPort.portLocation : cargo.origin,
				destination: destinationPort
					? destinationPort.portLocation
					: cargo.destination,
				status: statusObj ? statusObj.statusType : cargo.statusId,
				createdBy: createdByUser
					? `${createdByUser.firstName} ${createdByUser.lastName}`
					: cargo.createdBy,
				shipper: shipperUser
					? `${shipperUser.firstName} ${shipperUser.lastName}`
					: cargo.shipper,
				consignee: consigneeUser
					? `${consigneeUser.firstName} ${consigneeUser.lastName}`
					: cargo.consignee,
				courier: courierUser
					? `${courierUser.firstName} ${courierUser.lastName}`
					: cargo.courier,
			};
		});
	};

	const fetchCargoes = async () => {
		try {
			if (
				usersList.length === 0 ||
				portsList.length === 0 ||
				statusList.length === 0
			) {
				await Promise.all([fetchUsers(), fetchStatus(), fetchPorts()]);
				console.log("You are here");
			}

			const res = await axios.get(API_URL + "/cargo");

			const rawCargoes = res.data;

			let processedCargoes = transformCargoes(
				rawCargoes,
				usersList,
				portsList,
				statusList
			);

			setRawCargoes(processedCargoes);
		} catch (e) {
			setError("Failed to load cargoes.");
		} finally {
			setLoading(false);
		}
	};

	const fetchUsers = async () => {
		try {
			const res = await axios.get(API_URL + "/user");
			setUsersList(res.data);
		} catch (e) {
			setError("Failed to load users.");
		}
	};

	const fetchPorts = async () => {
		try {
			const res = await axios.get(API_URL + "/port");
			setPortsList(res.data);
		} catch (e) {
			setError("Failed to load ports.");
		}
	};

	const fetchStatus = async () => {
		try {
			const res = await axios.get(API_URL + "/status");
			setStatusList(res.data);
		} catch (e) {
			setError("Failed to load status.");
		}
	};

	const fetchTrackingEvents = async () => {
		try {
			const res = await axios.get(API_URL + "/tracking-event");
			setTrackingEventList(res.data);
		} catch (e) {
			setError("Failed to load status.");
		}
	};

	// Initial fetch
	useEffect(() => {
		fetchUsers();
		fetchStatus();
		fetchPorts();
		fetchCargoes();
		fetchTrackingEvents();
	}, []);

	useEffect(() => {
		if (
			rawCargoes.length &&
			usersList.length &&
			portsList.length &&
			statusList.length
		) {
			setCargoes(
				transformCargoes(rawCargoes, usersList, portsList, statusList)
			);
		}
	}, [rawCargoes, usersList, portsList, statusList]);

	if (loading) return <div>Loading...</div>;
	if (error) return <div className="text-red-600">{error}</div>;

	return (
		<MainPageContext.Provider
			value={{
				cargoes,
				usersList,
				portsList,
				statusList,
				trackingEventList,
				setCargoes,
				fetchCargoes,
				fetchTrackingEvents,
				API_URL,
			}}
		>
			<Layout className="overflow-auto bg-white">
				<Sider
					width={240}
					style={{
						background: "white",
						display: "flex",
						flexDirection: "column",
						height: "100vh",
						position: "sticky",
						top: 0,
						left: 0,
					}}
					className="border-r"
					trigger={null}
					collapsible
					collapsed={collapsed}
				>
					{/* Sidebar */}
					<div className="flex flex-row items-center gap-1 px-2 py-5">
						{/* Logo + Toggle */}
						<div className="flex flex-row items-center gap-1 px-2 py-5">
							{!collapsed ? (
								<div className="flex flex-row items-center w-full gap-2">
									<img src=".\caplogo.png" className="w-10 h-10" />
									<span className="flex-1 text-2xl font-bold">CargoGo</span>
									<Button
										type="text"
										icon={
											collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />
										}
										onClick={() => setCollapsed(!collapsed)}
									/>
								</div>
							) : (
								<div className="flex flex-row w-full gap-1">
									<img src=".\caplogo.png" className="w-10 h-10" />
									<Button
										type="text"
										className="text-gray-7700"
										icon={
											collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />
										}
										onClick={() => setCollapsed(!collapsed)}
									/>
								</div>
							)}
						</div>
					</div>

					<div className="flex-1 overflow-auto h-3/4">
						<Menu
							theme="light"
							mode="inline"
							defaultSelectedKeys={["1"]}
							items={[
								{
									key: "1",
									icon: <LayoutDashboard size={20} />,
									label: "Dashboard",
								},
								{
									key: "2",
									icon: <SquareUserRound size={20} />,
									label: "Users",
								},
							]}
						/>
					</div>

					<div className="p-3 mt-5 border-t">
						<UserSideBar
							user={{
								name: "Juan Icarus",
								email: "juanicarus@gmail.com",
								username: "@CourageTheCowardlyDog",
							}}
							collapsed={collapsed}
						/>
					</div>
				</Sider>
				<MainContent />
			</Layout>
		</MainPageContext.Provider>
	);
};

export default MainAppPage;
