import React, { useState, useEffect, useContext } from "react";
import { UserContext } from "./UserContext";
import { Form, Input, Button, Typography, message, Alert } from "antd";

const { Title } = Typography;

function ProfileEditor() {
  const { isLoggedIn } = useContext(UserContext);

  const [firstName, setFirstName] = useState("");
  const [email, setEmail] = useState("");

  // Load saved profile when component mounts
  useEffect(() => {
    const savedFirst = localStorage.getItem("firstName");
    const savedEmail = localStorage.getItem("email");

    if (savedFirst) setFirstName(savedFirst);
    if (savedEmail) setEmail(savedEmail);
  }, []);

  const handleSave = () => {
    localStorage.setItem("firstName", firstName);
    localStorage.setItem("email", email);
    message.success("Profile saved successfully!");
  };

  return (
    <div>
      <Title level={4}>User Profile</Title>

      {!isLoggedIn ? (
        <Alert
          message="Please log in to edit your profile."
          type="warning"
          showIcon
        />
      ) : (
        <Form layout="vertical">
          <Form.Item label="First Name">
            <Input
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              placeholder="Enter your first name"
            />
          </Form.Item>

          <Form.Item label="Email">
            <Input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Enter your email"
            />
          </Form.Item>

          <Form.Item>
            <Button type="primary" onClick={handleSave} block>
              Save
            </Button>
          </Form.Item>
        </Form>
      )}
    </div>
  );
}

export default ProfileEditor;
