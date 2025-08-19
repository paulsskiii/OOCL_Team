import "./App.css";
import {Breadcrumb, Button, Layout, Menu, type MenuProps, theme} from "antd";
import {Content, Header} from "antd/es/layout/layout";
import Title from "antd/es/typography/Title";
import {Link, Outlet, useNavigate} from "react-router-dom";
import Sider from "antd/es/layout/Sider";
import {useState} from "react";
import {HomeOutlined, LogoutOutlined, UserOutlined} from "@ant-design/icons";

const menuItems: MenuProps['items'] = [
    {
        label: <Link to='/home'>Home</Link>,
        key: '/home',
        icon: <HomeOutlined/>
    },
    {
        label: <Link to='/customer'>Customer Search</Link>,
        key: '/customer',
        icon: <UserOutlined/>
    },
];

const siderItems: MenuProps['items'] = [
    {
        key: 1,
        label: 'Search',
    },
    {
        key: 2,
        label: 'Transactions'
    },
    {
        key: 3,
        label: 'Cargo'
    }
];

const layoutStyle = {
    overflow: 'hidden',
    minHeight: '100vh',
};
const headerStyle = {
    color: '#fff',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-between',
};


function App() {
    const navigate = useNavigate();
    const {
        token: {colorBgContainer, borderRadiusLG},
    } = theme.useToken();
    const [currMenuItem, setCurrMenuItem] = useState(location.pathname);
    const [currSiderItem, setCurrSiderItem] = useState('');

    return (
        <Layout style={layoutStyle}>
            <Header style={headerStyle}>
                <Title level={4} style={{color: 'white', margin: '0px 15px 5px 0px'}}>Cargo Shipping System</Title>
                <Menu
                    theme="dark"
                    mode="horizontal"
                    defaultSelectedKeys={['1']}
                    selectedKeys={[currMenuItem]}
                    items={menuItems}
                    style={{flex: 1, minWidth: 0}}
                    onClick={(e) => setCurrMenuItem(e.key)}
                />
                <Button type="default" icon={<LogoutOutlined/>} onClick={() => navigate('/')}>Log out</Button>
            </Header>
            <Layout hasSider>
                <Sider width={200} style={{background: colorBgContainer}}>
                    <Menu
                        mode="inline"
                        defaultSelectedKeys={['1']}
                        selectedKeys={[currSiderItem]}
                        items={siderItems}
                        style={{height: '100%', borderInlineEnd: 0}}
                        onClick={(e) => setCurrSiderItem(e.key)}
                    />
                </Sider>
                <Layout style={{padding: '0 24px 24px'}}>
                    <Breadcrumb
                        items={[{title: 'Customer'}, {title: 'Search'}]}
                        style={{margin: '16px 0'}}
                    />
                    <Content
                        style={{
                            padding: 24,
                            margin: 0,
                            minHeight: 280,
                            background: colorBgContainer,
                            borderRadius: borderRadiusLG,
                        }}
                    >
                        <Outlet/>
                    </Content>
                </Layout>
            </Layout>
        </Layout>
    );
}

export default App;
