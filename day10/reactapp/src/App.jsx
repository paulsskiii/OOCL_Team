import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";
import UserProfile from "./components/UserProfile";

function App() {
  const name = "Noob Dev";
  // const year = new Date().getFullYear();
  // console.log(year);

  return (
    <>
      <Router>
        <div>
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/profile">User Profile</Link>
              </li>
            </ul>
          </nav>
        </div>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/profile" element={<UserProfile />} />
        </Routes>
      </Router>
      {/* <Greeting name={name} />
      <Greeting name="Philip" />
      <Greeting name="Ronin" /> */}
    </>
  );
}

export default App;
