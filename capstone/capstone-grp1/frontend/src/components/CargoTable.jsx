import CargoDummyData from "../assets/CargoDummyData";
import React, { useState, useEffect } from "react";
import { Table, Button, Dropdown } from "antd";
import {
	SettingOutlined,
	DeleteOutlined,
	EyeOutlined,
} from "@ant-design/icons";
function CargoTable() {
	const [data, setData] = useState(CargoDummyData);
	//const [data, setData] = useState([]);

	const menuItems = [
		{
			key: "view",
			icon: <EyeOutlined />,
			label: "View Details",
		},
		{
			key: "delete",
			icon: <DeleteOutlined />,
			label: "Delete Cargo",
		},
	];

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
			title: "Consignee",
			dataIndex: "consignee",
			key: "consignee",
		},
		{
			title: "Status",
			key: "status",
			dataIndex: "status",
			// render: (_, { tags }) => (
			// 	<>
			// 		{tags.map((tag) => {
			// 			let color = tag.length > 5 ? "geekblue" : "green";
			// 			if (tag === "loser") {
			// 				color = "volcano";
			// 			}
			// 			return (
			// 				<Tag color={color} key={tag}>
			// 					{tag.toUpperCase()}
			// 				</Tag>
			// 			);
			// 		})}
			// 	</>
			// ),
		},
		{
			title: "Action",
			key: "action",
			render: () => (
				<Dropdown menu={{ items: menuItems }} placement="right">
					<Button>
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
				dataSource={data}
			/>
		</section>
	);
}

export default CargoTable;
