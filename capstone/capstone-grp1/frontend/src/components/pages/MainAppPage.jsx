// --- Frontend: src/App.js ---
import React, { useState, useEffect } from "react";
import { MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { Button, Layout, Menu, theme } from "antd";
import UserSideBar from "../UserSideBar";
const { Sider } = Layout;
import { LayoutDashboard, SquareUserRound, ScrollText } from "lucide-react";
import MainContent from "../MainContent";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const MainAppPage = () => {
	const [containers, setContainers] = useState([]);
	const [loading, setLoading] = useState(false); //turn back to true after finishing frontend and integration
	const [error, setError] = useState(null);
	const [searchTerm, setSearchTerm] = useState("");
	const [collapsed, setCollapsed] = useState(false);
	const {
		token: { colorBgContainer, borderRadiusLG },
	} = theme.useToken();

	// State for the new container form
	const [newContainer, setNewContainer] = useState({
		containerNumber: "",
		origin: "",
		destination: "",
		weightKg: "",
	});

	// Fetch container data from the backend API
	const fetchContainers = async () => {
		try {
			const response = await fetch(API_URL);
			if (!response.ok) {
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			const data = await response.json();
			setContainers(data);
		} catch (e) {
			console.error("Failed to fetch containers:", e);
			setError("Failed to load containers. Please check the backend.");
		} finally {
			setLoading(false);
		}
	};

	// Handler for form input changes
	const handleInputChange = (e) => {
		const { name, value } = e.target;
		setNewContainer((prev) => ({ ...prev, [name]: value }));
	};

	// Handler for form submission
	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			const response = await fetch(API_URL, {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(newContainer),
			});
			if (!response.ok) {
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			// Re-fetch containers to update the list
			await fetchContainers();
			// Reset the form
			setNewContainer({
				containerNumber: "",
				origin: "",
				destination: "",
				weightKg: "",
			});
		} catch (e) {
			console.error("Failed to add container:", e);
			setError("Failed to add new container. Please check the backend.");
		}
	};

	// Filtered containers based on search term
	const filteredContainers = containers.filter(
		(container) =>
			container.containerNumber
				.toLowerCase()
				.includes(searchTerm.toLowerCase()) ||
			container.origin.toLowerCase().includes(searchTerm.toLowerCase()) ||
			container.destination.toLowerCase().includes(searchTerm.toLowerCase())
	);

	// Initial data fetch on component mount
	useEffect(() => {
		// fetchContainers();
	}, []);

	if (loading)
		return (
			<div className="mt-8 text-2xl font-bold text-center text-gray-700 animate-pulse">
				Loading containers...
			</div>
		);
	if (error)
		return (
			<div className="mt-8 text-2xl font-bold text-center text-red-600">
				{error}
			</div>
		);

	return (
		<Layout className="overflow-auto">
			<Sider
				width={240}
				style={{
					background: colorBgContainer,
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
				{/* Logo + Toggle */}
				<div className="flex flex-row items-center gap-1 px-2 py-5">
					{!collapsed ? (
						<div className="flex flex-row items-center w-full gap-2">
							<img src=".\caplogo.png" className="w-10 h-10" />
							<span className="flex-1 text-2xl font-bold">CargoGo</span>
							<Button
								type="text"
								icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
								onClick={() => setCollapsed(!collapsed)}
							/>
						</div>
					) : (
						<div className="flex flex-row w-full gap-1">
							<img src=".\caplogo.png" className="w-10 h-10" />
							<Button
								type="text"
								className="text-gray-7700"
								icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
								onClick={() => setCollapsed(!collapsed)}
							/>
						</div>
					)}
				</div>

				{/* Menu in the middle */}
				<div className="flex-1 overflow-auto h-3/4">
					<Menu
						theme="light"
						mode="inline"
						defaultSelectedKeys={["1"]}
						style={{ borderBottom: "none" }}
						items={[
							{
								key: "1",
								icon: <LayoutDashboard size={20} />,
								label: "Dashboard",
								style: collapsed ? { marginLeft: "-3px" } : {},
							},
							{
								key: "2",
								icon: <ScrollText size={20} />,
								label: "Reports",
								style: collapsed ? { marginLeft: "-3px" } : {},
							},
							{
								key: "3",
								icon: <SquareUserRound size={20} />,
								label: "Profile",
								style: collapsed ? { marginLeft: "-3px" } : {},
							},
						]}
					/>
				</div>

				{/* User info fixed at bottom */}
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
			{/* <PreviousLanding /> */}
			<MainContent />
		</Layout>
	);
};

export default MainAppPage;
