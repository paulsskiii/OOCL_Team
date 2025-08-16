import "./App.css";
import { Bio } from "./components/Bio";
import { CustomCard } from "./components/CustomCard";
import { Breadcrumb, Layout, Menu, Space, theme } from "antd";
import { Content, Footer, Header } from "antd/es/layout/layout";

function App() {
  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();
  return (
    <>
      <Layout>
        <Header style={{ display: "flex", alignItems: "center", }}>
          <Menu
            theme="dark"
            mode="horizontal"
            defaultSelectedKeys={["2"]}
            style={{ flex: 1, minWidth: 0 }}
          />
        </Header>
        <Content style={{ padding: "0 48px" }}>
          <Breadcrumb
            style={{ margin: "16px 0" }}
            items={[{ title: "Home" }, { title: "List" }, { title: "App" }]}
          />
          <div
            style={{
              background: colorBgContainer,
              minHeight: 280,
              padding: 24,
              borderRadius: borderRadiusLG,
            }}
          >
            <Bio />
            <Space direction="vertical">
              <Space direction="horizontal" size={16}>
                <CustomCard
                  title="Patunhay: A Software to Generate Motion Capture Animated 3D Models of Philippine Folk Dances for Digital Archiving"
                  desc="A software, Patunhay, was then created using Unity, which incorporates the motion capture data into a 3D model. The 
            generated models are then added to a digital archive of different Philippine folk dances containing motion capture animated 3D models, offering a method to 
            preserve dances digitally."
                />
                <CustomCard title="Title Here" desc="Description Here" />
                <CustomCard title="Title Here" desc="Description Here" />
              </Space>
              <Footer />
            </Space>
          </div>
        </Content>
        <Footer style={{ textAlign: "center" }}>
          Ant Design ©{new Date().getFullYear()} Created by Ant UED
        </Footer>
      </Layout>
    </>
  );
}

export default App;
