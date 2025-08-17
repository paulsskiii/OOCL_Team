import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";

import Greetings from "./components/Greetings";
import Counter from "./components/Counter";
import NameForm from "./components/NameForm";
import LoginMessage from "./components/LoginMessage";
import FruitList from "./components/FruitList";

function App() {
  // const name = "Beginner Developer";
  // const year = new Date().getFullYear();

  // return (
  //   <div>
  //     <h1>My awesome app</h1>
  //     {/* <Counter />
  //     <NameForm />
  //     <LoginMessage isLoggedIn={true} />
  //     <FruitList /> */}
  //   </div>
  // );

  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>

            <li>
              <Link to="/about">About</Link>
            </li>
          </ul>
        </nav>
      </div>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
      </Routes>
    </Router>
  );
}

export default App;
