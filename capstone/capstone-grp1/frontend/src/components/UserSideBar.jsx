import React, { useState, useEffect } from "react";
import { Avatar, Dropdown, Typography } from "antd";
import {
	SettingOutlined,
	LogoutOutlined,
	MoreOutlined,
} from "@ant-design/icons";

function UserSideBar({ user, collapsed }) {
	const menuItems = [
		{
			key: "settings",
			icon: <SettingOutlined />,
			label: "Settings",
		},
		{
			key: "logout",
			icon: <LogoutOutlined />,
			label: "Logout",
		},
	];

	const [showText, setShowText] = useState(!collapsed);

	useEffect(() => {
		let timer;
		if (!collapsed) {
			// delay text until animation ends
			timer = setTimeout(() => setShowText(true), 200);
		} else {
			// hide immediately when collapsing
			setShowText(false);
		}
		return () => clearTimeout(timer);
	}, [collapsed]);

	return (
		<div className="sticky flex items-center w-full gap-2 overflow-hidden">
			{showText ? (
				<Dropdown menu={{ items: menuItems }} placement="topRight" arrow>
					<div className="flex items-center w-full min-w-0 cursor-pointer">
						{/* Avatar */}
						<Avatar size="large" className="flex-shrink-0">
							UM
						</Avatar>

						{/* Text container grows and truncates */}
						<div className="flex flex-col flex-1 min-w-0 ml-2">
							<Typography.Text strong ellipsis>
								{user.name}
							</Typography.Text>
							<Typography.Text type="secondary" ellipsis className="text-xs">
								{user.email}
							</Typography.Text>
						</div>

						{/* Menu trigger stays fixed */}
						<MoreOutlined className="flex-shrink-0 ml-2" />
					</div>
				</Dropdown>
			) : (
				<Dropdown menu={{ items: menuItems }} placement="topRight" arrow>
					<div className="flex items-center cursor-pointer">
						<Avatar size="large" className="flex-shrink-0">
							UM
						</Avatar>
						<MoreOutlined className="flex-shrink-0 ml-2" />
					</div>
				</Dropdown>
			)}
		</div>
	);
}

export default UserSideBar;
