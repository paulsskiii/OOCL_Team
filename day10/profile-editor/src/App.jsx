import {Layout, Menu, theme, Typography} from "antd";
import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom";
import HomePage from "./components/HomePage.jsx";
import EditProfilePage from "./components/EditProfilePage.jsx";
import {
    AppstoreOutlined,
    BarChartOutlined,
    CloudOutlined,
    ShopOutlined,
    TeamOutlined,
    UploadOutlined,
    UserOutlined,
    VideoCameraOutlined,
} from '@ant-design/icons';
import React from "react";

const {Header, Content, Footer, Sider} = Layout;

const siderStyle = {
    overflow: 'auto',
    height: '100vh',
    position: 'sticky',
    insetInlineStart: 0,
    top: 0,
    bottom: 0,
    scrollbarWidth: 'thin',
    scrollbarGutter: 'stable',
};


const menuItems =  [
    {
        key: 'account',
        label: 'Account',
        icon: <UserOutlined />
    },
    {
        key: 'edit-profile',
        label: 'Edit Profile',
        icon: <TeamOutlined />
    }
]

function App() {
    const {
        token: { colorBgContainer, borderRadiusLG },
    } = theme.useToken();
    return (
        <>
            {/*<Layout hasSider>*/}
            {/*    <Sider style={siderStyle} >*/}
            {/*        <div className="demo-logo-vertical"/>*/}
            {/*        <Menu theme="dark" mode="inline" defaultSelectedKeys={['4']} items={menuItems}/>*/}
            {/*    </Sider>*/}
            {/*    <Layout>*/}
            {/*        <Header style={{ padding: 0, background: colorBgContainer }} />*/}
            {/*        <Content style={{ margin: '24px 16px 0', overflow: 'initial' }}>*/}
            {/*            <div*/}
            {/*                style={{*/}
            {/*                    padding: 24,*/}
            {/*                    textAlign: 'center',*/}
            {/*                    background: colorBgContainer,*/}
            {/*                    borderRadius: borderRadiusLG,*/}
            {/*                }}*/}
            {/*            >*/}
            {/*                <p>long content</p>*/}

            {/*            </div>*/}
            {/*        </Content>*/}
            {/*        <Footer style={{ textAlign: 'center' }}>*/}
            {/*            Ant Design ©{new Date().getFullYear()} Created by Ant UED*/}
            {/*        </Footer>*/}
            {/*    </Layout>*/}

            {/*</Layout>*/}
            <Router>
                <div>
                    <nav>
                        <ul>
                            <li>
                                <Link to="/">Home</Link>
                            </li>
                            <li>
                                <Link to="/edit-profile">Edit Profile</Link>
                            </li>
                        </ul>
                    </nav>
                </div>
                <hr />
                <Routes>
                    <Route path="/" element={<HomePage/>}/>
                    <Route path="/edit-profile" element={<EditProfilePage />}/>
                </Routes>
            </Router>
        </>
    );
}

export default App;
