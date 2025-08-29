import { Modal, Button } from "antd";
import { useEffect, useState } from "react";
import { Container as LucideContainer } from "lucide-react";
import { Input } from "antd";

function CreateCargoModal({ open, handleOk, setIsCreateModalOpen }) {
  const [loading, setLoading] = useState(false);

  function handleCancel() {
    setIsCreateModalOpen(false);
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
        <Button key="back" onClick={handleCancel}>
          Return
        </Button>,
        <Button
          key="submit"
          type="primary"
          loading={loading}
          onClick={handleOk}
        >
          Submit
        </Button>,
      ]}
    >
      <div className="flex flex-col w-full gap-4">
        <article className="flex flex-col gap-2 w-full">
          <span className=" font-semibold">Cargo Name:</span>
          <Input size="large" placeholder="Input container name" />
        </article>
        <article className="flex flex-col gap-2 w-full">
          <span className=" font-semibold">Origin:</span>
          <Input size="large" placeholder="Input container name" />
        </article>
        <article className="flex flex-col gap-2 w-full">
          <span className=" font-semibold">Destination:</span>
          <Input size="large" placeholder="Input container name" />
        </article>
        <article className="flex flex-col gap-2 w-full">
          <span className=" font-semibold">Weight:</span>
          <Input size="large" type="number" placeholder="Input weight" />
        </article>
        <article className="flex flex-col gap-2 w-full">
          <span
            className=" font-semibold"
            autoSize={{ minRows: 3, maxRows: 3 }}
          >
            Description:
          </span>
          <Input.TextArea size="large" placeholder="Input description" />
        </article>
      </div>
    </Modal>
  );
}

export default CreateCargoModal;
