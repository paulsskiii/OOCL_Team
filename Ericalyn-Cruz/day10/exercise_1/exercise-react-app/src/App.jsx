import React, { useContext } from "react";
import { UserProvider, UserContext } from "./components/UserContext";
import ProfileEditor from "./components/ProfileEditor";
import { Layout, Button, Typography, Card } from "antd";

const { Title } = Typography;

function AppContent() {
  const { isLoggedIn, login, logout } = useContext(UserContext);

  return (
    <Layout
      style={{
        minHeight: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        background: "#f0f2f5",
      }}
    >
      {/* Login Box */}
      <Card style={{ width: 400, padding: "20px" }}>
        <Title level={3} style={{ textAlign: "center", marginBottom: "20px" }}>
          Profile Editor App
        </Title>
        <ProfileEditor />
         <div style={{ textAlign: "center", marginTop: "20px" }}>
          {isLoggedIn ? (
            <Button type="primary" danger onClick={logout}>
              Logout
            </Button>
          ) : (
            <Button type="primary" onClick={login}>
              Login
            </Button>
          )}
        </div>

      </Card>
    </Layout>
  );
}

export default function App() {
  return (
    <UserProvider>
      <AppContent />
    </UserProvider>
  );
}




  // const name = "Beginner Developer";
  // const year = new Date().getFullYear();

  // console.log(year);


  // return (
  //   <div>
  //     <h1>My awesome App</h1>
  //     <Counter />
  //     <NameForm />
  //     <LoginMessage isLoggedIn={true} />
  //     <FruitList />
      
  //   </div>
  // )

  // return(
  //     <div>
  //       <h1>hello, {name} </h1>
  //       <p>This is something {year}.</p>
  //       <Greeting name ={name}/>
  //     </div>
  // )

      // <Greeting name="Erica" />
      // <Greeting name="Cruz" />
      // <Greeting name={name} />

      
    // <Router>
    //   <div>
    //     <nav>
    //       <ul>
    //         <li>
    //           <Link to="/Home">Home</Link>
    //         </li>
    //         <li>
    //           <Link to="/About">About</Link>
    //         </li>
    //       </ul>
    //     </nav>
    //   </div>

    //   <Routes>
    //     <Route path = "/Home" element = {<HomePage/>} />
    //     <Route path = "/About" element = {<AboutPage/>} />
    //   </Routes>
    // </Router>
