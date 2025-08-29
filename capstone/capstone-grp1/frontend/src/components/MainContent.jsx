import React, { useState, useEffect } from "react";
import { DownloadOutlined, PlusOutlined } from "@ant-design/icons";
import { Input, DatePicker, Select, Dropdown, Button } from "antd";
import DashboardCard from "./DashboardCard";
import CargoTable from "./CargoTable";
import CreateCargoModal from "./modals/createCargoModal";
import CargoDummyData from "../assets/CargoDummyData";
import PortDummyData from "../assets/POrtDummyData";
import DeleteCargoModal from "./modals/DeleteCargoModal";
import {
  LayoutDashboard,
  Truck,
  Container as LucideContainer,
  Ship,
  PlusCircle,
  CalendarArrowUp,
  CalendarArrowDown,
  CircleCheckBig,
  ArrowUpDown,
  ArrowUpAZ,
  ArrowDownAZ,
  CalendarFold,
} from "lucide-react";

function MainContent() {
  const { Search } = Input;
  const [currentSortLabel, setCurrentSortLabel] = useState("Sort by");
  const [currentDateLabel, setCurrentDateLabel] = useState("Day");
  const { RangePicker } = DatePicker;
  const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
  const [isLogoutModalOpen, setIsLogoutModalOpen] = useState(false);
  const [isViewModalOpen, setIsViewModalOpen] = useState(false);
  const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false);
  const [ports, setPorts] = useState(PortDummyData);
  const [cargoToBeDeleted, setCargoToBeDeleted] = useState(null);

  const dateRangeItems = [
    {
      label: "Day",
      value: 0,
    },
    {
      label: "Month",
      value: 1,
    },
    {
      label: "Year",
      value: 2,
    },
  ];
  const items = [
    {
      label: "Date Asc.",
      key: 0,
      icon: <CalendarArrowUp size={15} />,
    },
    {
      label: "Date Desc.",
      key: 1,
      icon: <CalendarArrowDown size={15} />,
    },
    {
      label: "A-Z Asc.",
      key: 2,
      icon: <ArrowUpAZ size={15} />,
    },
    {
      label: "A-Z Desc.",
      key: 3,
      icon: <ArrowDownAZ size={15} />,
    },
  ];

  function onSearch() {
    console.log("Insert the search logic here MyNaga");
  }

  useEffect(() => {
    if (currentSortLabel == "" || currentSortLabel == null) {
      setCurrentSortLabel("Sort by");
    }
  }, [currentSortLabel]);

  function handleSortClick(e) {
    //console.log(e);
    setCurrentSortLabel(items[e].label);
  }

  function handleDateClick(e) {
    //console.log(e);
    setCurrentDateLabel(dateRangeItems[e].label);
  }

  return (
    <section className="flex flex-col w-screen h-screen p-5 bg-white">
      {/* MODALS */}
      <CreateCargoModal
        open={isCreateModalOpen}
        setIsCreateModalOpen={setIsCreateModalOpen}
        ports={ports.map((port) => ({
          value: port.portCode,
          label: port.portLocation,
        }))}
      />
      <DeleteCargoModal
        open={isDeleteModalOpen}
        setIsDeleteModalOpen={setIsDeleteModalOpen}
        cargoToBeDeleted={cargoToBeDeleted}
        setCargoToBeDeleted={setCargoToBeDeleted}
      />
      {/* BODY */}
      <article className="flex flex-row items-center w-full gap-3 pb-5 border-b">
        <LayoutDashboard size={40} className="text-blue-600" />
        <div className="text-2xl font-semibold">
          Cargo Monitoring Dashboard (Admin)
        </div>
        <div className="flex flex-row items-center gap-2 ml-auto">
          <span className="mr-3 font-semibold text-md">Date Range:</span>

          <Select
            value={currentDateLabel}
            style={{ width: 120 }}
            allowClear
            options={dateRangeItems}
            placeholder="Select Day"
            size={"large"}
            onChange={(e) => {
              handleDateClick(e);
            }}
          />
          {currentDateLabel === "Year" ? (
            <RangePicker
              picker="year"
              className="h-[40px]"
              id={{
                start: "startInput",
                end: "endInput",
              }}
            />
          ) : currentDateLabel === "Day" ? (
            <RangePicker
              picker="date"
              className="h-[40px]"
              id={{
                start: "startInput",
                end: "endInput",
              }}
            />
          ) : (
            <RangePicker
              picker="month"
              className="h-[40px]"
              id={{
                start: "startInput",
                end: "endInput",
              }}
            />
          )}
        </div>
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
          category={"In-Process"}
          number={82}
          item={"Cargoes"}
          message={"-10 than last week"}
          percentage={-6.67}
        />
        <DashboardCard
          icon={<Ship className="text-gray-500" />}
          category={"In-Transit"}
          number={82}
          item={"Cargoes"}
          message={"+69 than last week"}
          percentage={9.7}
        />
        <DashboardCard
          icon={<CircleCheckBig className="text-gray-500" />}
          category={"Delivered"}
          number={20}
          item={"Cargoes"}
          message={"-10 than last week"}
          percentage={-8.08}
        />
      </article>

      {/* Table Portion */}
      <article className="border-2 border-gray-200 rounded-lg">
        <div className="flex flex-row items-center gap-3 p-5">
          {/* Search Input */}
          <Search
            placeholder="Input Container #"
            onSearch={onSearch}
            enterButton
            size="large"
            className="w-64"
          />

          {/* Dropdown */}
          <Dropdown.Button
            menu={{ items, onClick: ({ key }) => handleSortClick(key) }}
            placement="bottom"
            icon={<ArrowUpDown size={17} />}
            size="large"
            className="w-64"
          >
            {currentSortLabel}
          </Dropdown.Button>

          {/* Action Buttons */}
          <div className="flex items-center gap-2 ml-auto">
            <Button
              type="primary"
              size="large"
              className="text-gray-700 bg-white border border-gray-300"
              icon={<PlusOutlined />}
              onClick={() => {
                console.log("create click");
                setIsCreateModalOpen(true);
              }}
            >
              Create Cargo
            </Button>
            <a
              href="https://www.youtube.com/watch?v=0FUuPgoWRYU"
              target="_blank"
            >
              <Button
                type="primary"
                size="large"
                className="text-gray-700 bg-white border border-gray-300"
                icon={<DownloadOutlined />}
              >
                Generate Report
              </Button>
            </a>
          </div>
        </div>

        <CargoTable
          isDeleteModalOpen={isDeleteModalOpen}
          setIsDeleteModalOpen={setIsDeleteModalOpen}
          cargoToBeDeleted={cargoToBeDeleted}
          setCargoToBeDeleted={setCargoToBeDeleted}
        />
      </article>
    </section>
  );
}

export default MainContent;
