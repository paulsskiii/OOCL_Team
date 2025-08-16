import { Breadcrumb, Button, Flex, Grid, Image, Layout, Menu, Modal, Space } from "antd";
import { Content, Footer, Header } from "antd/es/layout/layout";
import { useState } from "react";

export const Bio: React.FC<{}> = ({}) => {
  const [openModal, setOpenModal] = useState();
  const [modal, contextHolder] = Modal.useModal();

  const onClick = () => {
    let secondsToGo = 5;

    const instance = modal.success({
      title: "This is a notification message",
      content: `This modal will be destroyed after ${secondsToGo} second.`,
    });

    const timer = setInterval(() => {
      secondsToGo -= 1;
      instance.update({
        content: `This modal will be destroyed after ${secondsToGo} second.`,
      });
    }, 1000);

    setTimeout(() => {
      clearInterval(timer);
      instance.destroy();
    }, secondsToGo * 1000);
  };

  return (
    <>
      <Flex justify="center">
        <div id="parent" className="container-fluid">
          <Image
            width={200}
            src="src\assets\display_pic.jpg"
            style={{ borderRadius: "50%", width: "150px", height: "150px" }}
          />
          <div id="child" className="flex-container">
            <h1 id="name">Anna Patricia B. Desembrana</h1>
          </div>
        </div>
        <div>
          <Space direction="vertical">
            <h2>Hello World!</h2>
            <h3>Personal Details</h3>
            <p>Age: 24</p>
            <p>Birthday: November 11, 2000</p>
            <p>Address: Quezon City, Metro Manila, Philippines</p>
            <Button type="primary" onClick={onClick}>
              Click me for a surprise...
            </Button>
            {contextHolder}
          </Space>
        </div>
      </Flex>


    </>
  );
};
