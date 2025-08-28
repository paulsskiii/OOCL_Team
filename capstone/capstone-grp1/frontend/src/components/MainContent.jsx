import React, { useState, useEffect } from "react";
import { AudioOutlined } from "@ant-design/icons";
import { Input, Space, Dropdown } from "antd";
import { LayoutDashboard, SquareUserRound, ScrollText } from "lucide-react";
import DashboardCard from "./DashboardCard";
import {
	Truck,
	Container as LucideContainer,
	Ship,
	PlusCircle,
	Search,
	ChevronUp,
	ChevronDown,
	CalendarArrowUp,
	CalendarArrowDown,
	CircleCheckBig,
	ArrowUpDown,
	ArrowUpAZ,
	ArrowDownAZ,
} from "lucide-react";

function MainContent() {
	const { Search } = Input;
	const [currentSortLabel, setCurrentSortLabel] = useState("Sort by");
	const items = [
		{
			label: "Date Asc.",
			key: "1",
			icon: <CalendarArrowUp size={15} />,
		},
		{
			label: "Date Desc.",
			key: "2",
			icon: <CalendarArrowDown size={15} />,
		},
		{
			label: "A-Z Asc.",
			key: "3",
			icon: <ArrowUpAZ size={15} />,
		},
		{
			label: "A-Z Desc.",
			key: "4",
			icon: <ArrowDownAZ size={15} />,
		},
	];

	function onSearch() {
		console.log("Insert the search logic here MyNaga");
	}

	function handleSortClick(e) {
		setCurrentSortLabel(e.target.value?.label);
	}
	return (
		<section className="flex flex-col w-screen h-screen p-5 bg-white">
			<article className="flex flex-row items-center w-full gap-3 pb-5 border-b">
				<LayoutDashboard size={40} className="text-blue-600" />
				<div className="text-2xl font-semibold">Cargo Monitoring Dashboard</div>
			</article>
			{/* Cards Section for Summary */}
			<article className="flex flex-row w-full gap-5 my-5 ">
				<DashboardCard
					icon={<LucideContainer className="text-gray-500" />}
					category={"Created"}
					number={70}
					item={"Cargoes"}
					message={"+15 than last week"}
					percentage={10.2}
				/>
				<DashboardCard
					icon={<Truck className="text-gray-500" />}
					category={"In Transit"}
					number={82}
					item={"Cargoes"}
					message={"-10 than last week"}
					percentage={-6.67}
				/>
				<DashboardCard
					icon={<Ship className="text-gray-500" />}
					category={"Shipped"}
					number={82}
					item={"Cargoes"}
					message={"+69 than last week"}
					percentage={9.7}
				/>
				<DashboardCard
					icon={<CircleCheckBig className="text-gray-500" />}
					category={"Completed"}
					number={20}
					item={"Cargoes"}
					message={"-10 than last week"}
					percentage={-8.08}
				/>
			</article>

			{/* Table Portion */}
			<article className="h-full border-2 border-gray-200 rounded-lg">
				<div className="m-5">
					<Search
						placeholder="Input Container #"
						onSearch={onSearch}
						enterButton
						className="w-64"
					/>
				</div>

				<div>
					<Dropdown.Button
						menu={{ items }}
						placement="bottom"
						onClick={(e) => handleSortClick(e)}
						icon={<ArrowUpDown size={17} />}
					>
						{currentSortLabel}
					</Dropdown.Button>
				</div>
			</article>
		</section>
	);
}

export default MainContent;
