import React, { useState } from "react";
import { Table, Input, Button, Empty } from "antd";
import type { ColumnsType } from "antd/es/table";

interface Customer {
  customerId: number;
  firstName: string;
  lastName: string;
  contactNumber: string;
  emailAddress: string;
  addressLine1: string;
  addressLine2: string;
  locationId: number;
}

const CustomerSearch: React.FC = () => {
  const [query, setQuery] = useState("");
  const [customers, setCustomers] = useState<Customer[]>([]);

  const handleSearch = async () => {
    if (!query.trim()) {
      setCustomers([]); 
    }

    try {
      const response = await fetch(
        `http://localhost:8080/api/customer/search?keyword=${query}`
      );
      if (!response.ok) throw new Error("Search failed");
      const data = await response.json();
      setCustomers(data);
    } catch (error) {
      console.error(error);
    }
  };

  const columns: ColumnsType<Customer> = [
    { title: "Customer ID", dataIndex: "customerId", key: "customerId" },
    { title: "First Name", dataIndex: "firstName", key: "firstName" },
    { title: "Last Name", dataIndex: "lastName", key: "lastName" },
    { title: "Contact Number", dataIndex: "contactNumber", key: "contactNumber" },
    { title: "Email Address", dataIndex: "emailAddress", key: "emailAddress" },
    {
    title: "Home Address",
    key: "fullAddress",
    render: (_, record) => `${record.addressLine1 || ""} ${record.addressLine2 || ""}`.trim(),
    },
    { title: "Location ID", dataIndex: "locationId", key: "locationId" },
  ];

  return (
    <div style={{ padding: "20px" }}>
      {/* Search Bar */}
      <div style={{ marginBottom: "16px", display: "flex", gap: "8px" }}>
        <Input
          placeholder="Search customer..."
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          style={{ width: 300 }}
        />
        <Button type="primary" onClick={handleSearch}>
          Search
        </Button>
      </div>

      {/* Ant Design Table */}
      <Table
        dataSource={customers}
        columns={columns}
        rowKey="customerId"
        pagination={false}
        locale={{
          emptyText: (
            <Empty
              image="/image.png" 
              imageStyle={{ height: 120 }}
              description={<span>No customers found</span>}
            />
          ),
        }}
      />
    </div>
  );
};

export default CustomerSearch;
