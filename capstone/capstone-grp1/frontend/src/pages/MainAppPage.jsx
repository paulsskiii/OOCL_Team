import React, { useState, useEffect, createContext } from "react";
import { MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { Button, Layout, Menu } from "antd";
import UserSideBar from "../components/UserSideBar";
import { LayoutDashboard, SquareUserRound } from "lucide-react";
import MainContent from "../components/MainContent";

const { Sider } = Layout;
const API_URL = "http://localhost:8080/api";

export const MainPageContext = createContext();

const MainAppPage = () => {
	const [rawCargoes, setRawCargoes] = useState([]);
	const [cargoes, setCargoes] = useState([]);
	const [usersList, setUsersList] = useState([]);
	const [portsList, setPortsList] = useState([]);
	const [statusList, setStatusList] = useState([]);
	const [loading, setLoading] = useState(true);
	const [error, setError] = useState(null);
	const [collapsed, setCollapsed] = useState(false);

	const transformCargoes = (cargoes, users, ports, statuses) => {
		return cargoes.map((cargo) => {
			// find port objects
			const originPort = ports.find((p) => p.portCode === cargo.origin);
			const destinationPort = ports.find(
				(p) => p.portCode === cargo.destination
			);

			// find status object
			const statusObj = statuses.find((s) => s.statusCode === cargo.statusCode);

			// find user objects
			const createdByUser = users.find((u) => u.id === cargo.createdBy);
			const consigneeUser = users.find((u) => u.id === cargo.consignee);
			const courierUser = users.find((u) => u.id === cargo.courier);

			return {
				...cargo,
				origin: originPort ? originPort.portLocation : cargo.origin,
				destination: destinationPort
					? destinationPort.portLocation
					: cargo.destination,
				status: statusObj ? statusObj.statusType : cargo.statusCode,
				createdBy: createdByUser
					? `${createdByUser.firstName} ${createdByUser.lastName}`
					: cargo.createdBy,
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

			const res = await fetch(API_URL + "/cargo");

			if (!res.ok) throw new Error(`HTTP error ${res.status}`);

			const rawCargoes = await res.json();

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
			const res = await fetch(API_URL + "/user");
			if (!res.ok) throw new Error(`HTTP error ${res.status}`);
			setUsersList(await res.json());
		} catch (e) {
			setError("Failed to load users.");
		}
	};

	const fetchPorts = async () => {
		try {
			const res = await fetch(API_URL + "/port");
			if (!res.ok) throw new Error(`HTTP error ${res.status}`);
			setPortsList(await res.json());
		} catch (e) {
			setError("Failed to load ports.");
		}
	};

	const fetchStatus = async () => {
		try {
			const res = await fetch(API_URL + "/status");
			if (!res.ok) throw new Error(`HTTP error ${res.status}`);
			setStatusList(await res.json());
		} catch (e) {
			setError("Failed to load status.");
		}
	};

	// Initial fetch
	useEffect(() => {
		fetchUsers();
		fetchStatus();
		fetchPorts();
		fetchCargoes(); // sets rawCargoes instead of transformed
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
				setCargoes,
				fetchCargoes,
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
						<Button
							type="text"
							icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
							onClick={() => setCollapsed(!collapsed)}
						/>
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

				{/* Children can now consume context */}
				<MainContent />
			</Layout>
		</MainPageContext.Provider>
	);
};

export default MainAppPage;
