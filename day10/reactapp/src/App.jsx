import React from "react";

import { BrowserRouter as Router, Link, Route, Routes } from "react-router-dom";

import Greetings from "./components/Greetings";
import Counter from "./components/Counter";
import NameForm from "./components/NameForm";
import LoginMessage from "./components/LoginMessage";
import FruitList from "./components/FruitList";

import HomePage from "./pages/HomePage";
import AboutPage from "./pages/AboutPage";

const App = () => {
  const name = "Beginner Developer";
  const year = new Date().getFullYear;
  const isLoggedIn = true;

  return (
    <div>
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
          <Route path="/" element={<AboutPage />} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;
