import { Form, Input, Button, Typography } from "antd";
import { useState } from "react";
import "./Signup.css";

export const SignUp = () => {
    const [loading, setLoading] = useState(false);

    const onFinish = (values: any) => {
        setLoading(true);
        // TODO: Replace with your API call
        setTimeout(() => {
            setLoading(false);
            alert("Sign up successful!");
        }, 1000);
    };

    return (
        <div style={{
            position: 'relative',
            flexDirection: 'column',
            alignItems: 'center',
            minHeight: '300px',
            maxWidth: '400px',
            width: '90vw',
            borderStyle: 'solid',
            borderWidth: '3px',
            borderColor: '#ccc',
            margin: '60px auto',
            display: 'flex',
            padding: '20px',
            boxSizing: 'border-box',
            background: 'rgba(68, 68, 68, 0.4)',
            backdropFilter: 'blur(3px)',
            WebkitBackdropFilter: 'blur(15px)',
            zIndex: 1,
            fontFamily: 'Poppins, sans-serif',
        }}>
            <h1 style={{ margin: '0px', padding: '20px', textAlign: 'center', width: '100%' }}>Sign Up</h1>
            <Form layout="vertical" onFinish={onFinish} className="signup-form">
                <Form.Item name="username" rules={[{ required: true }]}
                    style={{ background: 'transparent', marginBottom: 16, width: '100%', maxWidth: '300px' }}>
                    <Input placeholder="Username" style={{
                        width: '100%',
                        padding: '8px',
                        marginBottom: '10px',
                        boxSizing: 'border-box',
                        borderRadius: '20px',
                        background: 'transparent',
                        borderColor: '#ffffffff',
                        color: '#fff',
                    }} />
                </Form.Item>
                <Form.Item name="email" rules={[{ required: true, type: "email" }]}
                    style={{ background: 'transparent', marginBottom: 16, width: '100%', maxWidth: '300px' }}>
                    <Input placeholder="Email" style={{
                        width: '100%',
                        padding: '8px',
                        marginBottom: '10px',
                        boxSizing: 'border-box',
                        borderRadius: '20px',
                        background: 'transparent',
                        borderColor: '#ffffffff',
                        color: '#fff',
                    }} />
                </Form.Item>
                <Form.Item name="password" rules={[{ required: true }]}
                    style={{ background: 'transparent', marginBottom: 16, width: '100%', maxWidth: '300px' }}>
                    <Input.Password placeholder="Password" style={{
                        width: '100%',
                        padding: '8px',
                        marginBottom: '10px',
                        boxSizing: 'border-box',
                        borderRadius: '20px',
                        background: 'transparent',
                        borderColor: '#ffffffff',
                        color: '#fff',
                    }} />
                </Form.Item>
                <Form.Item style={{ width: '100%', maxWidth: '300px' }}>
                    <Button type="primary" htmlType="submit" loading={loading}
                        style={{
                            width: '50%',
                            maxWidth: '300px',
                            padding: '8px',
                            marginTop: '10px',
                            borderRadius: '8px',
                            border: 'none',
                            background: '#ffffffff',
                            color: 'black',
                            cursor: 'pointer',
                            fontFamily: 'Poppins, sans-serif',
                        }}>
                        Sign Up
                    </Button>
                </Form.Item>
            </Form>
        </div>
    );
};

export default SignUp;