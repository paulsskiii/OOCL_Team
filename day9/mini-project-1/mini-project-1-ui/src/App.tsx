import { useEffect, useState } from "react";
import { DataCard } from "./components/DataCard";
import "./App.css";
import axios from "axios";
import { Button, Flex, Form, Input, Space, Spin, Typography } from "antd";
import { ErrorMessage } from "./components/ErrorMessage";
import CustomerModal from "./components/CustomerModal.tsx";

type CustomerProps = {
  customerId: number;
  firstName: string;
  lastName: string;
  contactNumber: string;
  emailAddress: string;
  addressLine1: string;
  addressLine2: string;
  locationId: number;
};

function App() {
  const [data, setData] = useState<CustomerProps[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [isError, setIsError] = useState(false);
  const [recordCount, setRecordCount] = useState(0);
  const [customer, setCustomer] = useState(null);
  const [openModal, setOpenModal] = useState(false);
  const getAllCustomers = "api/customer/all";
  const findCustomerCount = "api/customer/data/count";

  const [form] = Form.useForm();

  const onFinish = (value: { inputCusId: string }) => {
    const findCustomerById = "api/customer/" + value.inputCusId;
    axios
      .get(findCustomerById)
      .then((response) => {
        setCustomer(response.data);
        setIsLoading(false);
        setOpenModal(true);
        console.log("SUCCESS");
        console.log("openModal: " + open);
      })
      .catch((err) => {
        setIsError(err.message);
        setIsLoading(false);
        console.log("ERROR");
      });
    console.log(customer);
  };

  useEffect(() => {
    axios
      .get(getAllCustomers)
      .then((response) => {
        setData(response.data);
        setIsLoading(false);
        console.log("SUCCESS");
      })
      .catch((err) => {
        setIsError(err.message);
        setIsLoading(false);
        console.log("ERROR");
      });
    axios
      .get(findCustomerCount)
      .then((response) => {
        setRecordCount(response.data);
        setIsLoading(false);
        console.log("SUCCESS");
      })
      .catch((err) => {
        setIsError(err.message);
        setIsLoading(false);
        console.log("ERROR");
      });
  }, []);

  return (
    <>
      <Form
        form={form}
        name="control-hooks"
        onFinish={onFinish}
        style={{ maxWidth: 600 }}
      >
        <Space direction="horizontal">
          <Form.Item name="inputCusId" label="Find Customer">
            <Input />
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Submit
            </Button>
          </Form.Item>
        </Space>
      </Form>

      <Typography.Text>Total Customers: {recordCount}</Typography.Text>
      {openModal && <CustomerModal openModal={openModal} customer={customer} />}
      <Spin spinning={isLoading} tip="Loading...">
        <Flex wrap gap="small" justify="space-evenly">
          {!isError && data.map((customer) => <DataCard {...customer} />)}
        </Flex>
        {isError && (
          <Typography.Paragraph>
            <ErrorMessage openModal={isError} />
          </Typography.Paragraph>
        )}
      </Spin>
    </>
  );
}

export default App;
