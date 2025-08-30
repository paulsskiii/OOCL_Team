import CargoDummyData from "../assets/CargoDummyData";
import React, { useState, useEffect, useContext } from "react";
import { Table, Button, Dropdown, Menu } from "antd";
import {
	SettingOutlined,
	DeleteOutlined,
	EyeOutlined,
} from "@ant-design/icons";
import { MapPin } from "lucide-react";
import StatusColumnRecord from "./StatusColumnRecord";
import { MainPageContext } from "../pages/MainAppPage";

function CargoTable({
	isDeleteModalOpen,
	setIsDeleteModalOpen,
	cargoToBeDeleted,
	setCargoToBeDeleted,
}) {
	// const [data, setData] = useState(CargoDummyData);
	const { cargoes, fetchCargoes } = useContext(MainPageContext);

	const handleMenuClick = (e, record) => {
		if (e.key === "delete") {
			setCargoToBeDeleted(record);
			setIsDeleteModalOpen(true);
			console.log("clicked delete", record);
		}
	};

	// Updated menuItems using 'items' instead of 'children'
	const menuItems = [
		{
			key: "viewDetails",
			icon: <EyeOutlined />,
			label: "View Details",
		},
		{
			key: "viewEvents",
			icon: <MapPin size={14} />,
			label: "View Tracking Events",
		},
		{
			key: "delete",
			icon: <DeleteOutlined />,
			label: "Delete Cargo",
			danger: true,
		},
	];

	// Updated Menu with 'items' prop
	const menu = (
		<Menu
			onClick={(e) => handleMenuClick(e, cargoToBeDeleted)}
			items={menuItems}
		/>
	);

	const columns = [
		{
			title: "Container #",
			dataIndex: "name",
			key: "name",
			render: (text) => <a>{text}</a>,
		},
		{
			title: "Origin",
			dataIndex: "origin",
			key: "origin",
		},
		{
			title: "Destination",
			dataIndex: "destination",
			key: "destination",
		},
		{
			title: "Shipper",
			dataIndex: "shipper",
			key: "shipper",
		},
		{
			title: "Consignee",
			dataIndex: "consignee",
			key: "consignee",
		},
		{
			title: "Status",
			key: "status",
			dataIndex: "status",
			render: (text) => <StatusColumnRecord status={text} />,
		},
		{
			title: "Action",
			key: "action",
			render: (text, record) => (
				<Dropdown overlay={menu} placement="right">
					<Button
						onClick={() => {
							setCargoToBeDeleted(record); // Set the record to be deleted
							console.log("selected", record);
						}}
						onMouseEnter={() => {
							setCargoToBeDeleted(record);
							console.log("selected", record);
						}}
					>
						<SettingOutlined />
					</Button>
				</Dropdown>
			),
		},
	];
	useEffect(() => {
		console.log(CargoDummyData);
	}, []);

	return (
		<section className="mx-5 my-3 border-2 border-gray-200 rounded-lg">
			<Table
				pagination={{ pageSize: 10 }}
				columns={columns}
				dataSource={cargoes}
			/>
		</section>
	);
}

export default CargoTable;
