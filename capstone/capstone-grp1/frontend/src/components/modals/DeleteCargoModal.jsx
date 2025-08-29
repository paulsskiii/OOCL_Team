import { Modal, Button } from "antd";
import { useEffect, useState } from "react";
import { Container as LucideContainer, TriangleAlert } from "lucide-react";

function DeleteCargoModal({
  open,
  setIsDeleteModalOpen,
  cargoToBeDeleted,
  setCargoToBeDeleted,
}) {
  const [loading, setLoading] = useState(false);

  function handleDelete() {
    console.log("Delete API here");
  }

  function handleCancel() {
    setIsDeleteModalOpen(false);
  }
  return (
    <Modal
      open={open}
      onOk={handleDelete}
      onCancel={handleCancel}
      footer={[
        <Button size={"large"} key="back" onClick={handleCancel}>
          Cancel
        </Button>,
        <Button
          key="submit"
          type="primary"
          className="bg-red-500 hover:bg-red-700"
          loading={loading}
          onClick={handleDelete}
          size={"large"}
        >
          Delete Field
        </Button>,
      ]}
    >
      <div className="flex flex-col items-center justify-center text-lg text-gray-600 gap-4">
        <div className="rounded-full w-16 h-16 bg-red-200 flex items-center justify-center ">
          <TriangleAlert size={40} className="text-red-500" />
        </div>
        <div className="text-2xl text-black font-semibold">
          Delete{" "}
          <span className="text-blue-700 font-semibold">
            {cargoToBeDeleted?.name}
          </span>
          ?
        </div>
        <div className="flex flex-col">
          <span className="text-center">
            This action cannot be undone. All values
          </span>
          <span className="text-center">
            associated with this field will be lost.
          </span>
        </div>
      </div>
    </Modal>
  );
}

export default DeleteCargoModal;
