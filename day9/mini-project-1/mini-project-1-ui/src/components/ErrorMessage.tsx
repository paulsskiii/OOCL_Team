import { Typography } from "antd";
import Modal from "antd/es/modal/Modal";
import { useState } from "react";

type ErrorMessageProps = {
  openModal: boolean;
};



export const ErrorMessage: React.FC<ErrorMessageProps> = ({ openModal }) => {
  const [isModalOpen, setIsModalOpen] = useState(openModal);
  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  return (
    <>
      <Modal title="Error" open={isModalOpen} onCancel={handleCancel} onOk={handleOk}>
        <Typography.Text>Data could not be loaded!</Typography.Text>
      </Modal>
    </>
  );
};
