import { Modal, Button } from "antd";
import { useEffect, useState } from "react";
import { Container as LucideContainer } from "lucide-react";
import { Input, Select, Form } from "antd";

function CreateCargoModal({ open, handleOk, setIsCreateModalOpen, ports }) {
  const [loading, setLoading] = useState(false);
  const [form] = Form.useForm();
  const [name, setName] = useState("");
  const [origin, setOrigin] = useState("");
  const [destination, setDestination] = useState("");
  const [weight, setWeight] = useState(0);
  const [description, setDescription] = useState("");

  async function handleValidate() {
    try {
      await form.validateFields();
      console.log("Validation successful!");
      // Perform other actions here, like sending data to an API without a full form submission
    } catch (errorInfo) {
      console.log("Validation failed:", errorInfo);
    }
  }
  function handleCancel() {
    setIsCreateModalOpen(false);
    setName("");
    setOrigin("");
    setDescription("");
    setDestination("");
    setWeight(0);
  }
  function handleNameChange(e) {
    setName(e.target.value);
  }

  function handleOriginChange(e) {
    setOrigin(e);
  }

  function handleDestinationChange(e) {
    setDestination(e);
  }

  function handleWeightChange(e) {
    setWeight(e.target.value);
  }

  function handleDescriptionChange(e) {
    setDescription(e.target.value);
  }

  return (
    <Modal
      open={open}
      title={
        <div className="flex flex-row items-center gap-2 border-b-2 pb-3">
          <LucideContainer size={25} className="text-green-600" />
          <span className="font-semibold text-2xl">Create New Cargo</span>
        </div>
      }
      onOk={handleOk}
      onCancel={handleCancel}
      footer={[
        <Button key="back" onClick={handleCancel} size={"large"}>
          Cancel
        </Button>,
        <Button
          key="submit"
          type="primary"
          loading={loading}
          onClick={handleValidate}
          htmlType="submit"
          size={"large"}
        >
          Submit
        </Button>,
      ]}
    >
      <div className="flex flex-col w-full ">
        <Form form={form}>
          <article className="flex flex-col gap-2 w-full">
            <span className=" font-semibold">
              Cargo Name:<span className="text-red-500"> *</span>
            </span>
            <Form.Item
              name="cargoName"
              rules={[{ required: true, message: "Please input cargo name!" }]}
            >
              <Input
                size="large"
                placeholder="Input container name"
                maxLength={50}
                showCount={true}
                value={name}
                onChange={(e) => handleNameChange(e)}
                required
              />
            </Form.Item>
          </article>
          <article className="flex flex-col gap-2 w-full">
            <span className=" font-semibold">
              Origin:<span className="text-red-500"> *</span>
            </span>
            <Form.Item
              name="origin"
              rules={[
                { required: true, message: "Please select port of origin!" },
              ]}
            >
              <Select
                size="large"
                showSearch
                placeholder="Select port of origin"
                required
                value={origin}
                onChange={(e) => handleOriginChange(e)}
                options={ports}
              />
            </Form.Item>
          </article>
          <article className="flex flex-col gap-2 w-full">
            <span className=" font-semibold">
              Destination: <span className="text-red-500"> *</span>
            </span>
            <Form.Item
              name="destiination"
              rules={[
                {
                  required: true,
                  message: "Please input select final destination!",
                },
              ]}
            >
              <Select
                size="large"
                showSearch
                placeholder="Select final destination"
                required
                value={destination}
                onChange={(e) => handleDestinationChange(e)}
                options={ports}
              />
            </Form.Item>
          </article>
          <article className="flex flex-col gap-2 w-full">
            <span className=" font-semibold">
              Weight: <span className="text-red-500">*</span>
            </span>
            <Form.Item
              rules={[
                { required: true, message: "Please input cargo weight!" },
              ]}
              name="weight"
            >
              <Input
                size="large"
                type="number"
                placeholder="Input weight"
                required
                value={weight}
                onChange={(e) => handleWeightChange(e)}
                step="0.01"
              />
            </Form.Item>
          </article>
          <article className="flex flex-col gap-2 w-full ">
            <span className=" font-semibold">Description:</span>
            <Form.Item name="description">
              <Input.TextArea
                size="large"
                placeholder="Input description"
                maxLength={100}
                showCount={true}
                value={description}
                onChange={(e) => handleDescriptionChange(e)}
              />
            </Form.Item>
          </article>
        </Form>
      </div>
    </Modal>
  );
}

export default CreateCargoModal;
