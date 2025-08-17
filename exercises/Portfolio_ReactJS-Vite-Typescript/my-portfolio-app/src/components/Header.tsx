import React from "react";
import { useState } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  NavLink,
} from "react-router-dom";
import Home from "./HomePage";
import AboutMePage from "./AboutMePage";
import SkillsPage from "./SkillsPage";

function Header() {
  return (
    <Router>
      <div
        className="myHeader"
        style={{
          padding: " 40px 20px 0px 20px",
          backgroundColor: "#FF9F8A",
        }}
      >
        <nav className=".container-fluid position-sticky justify-content-end ">
          <ul className="nav nav-tabs">
            <li
              className="nav-item"
              style={{
                color: "white",
              }}
            >
              <NavLink
                to="/"
                className={({ isActive }) =>
                  "nav-link" + (isActive ? " active-tab" : "")
                }
              >
                Home
              </NavLink>
            </li>
            <li>
              <NavLink
                to="/about"
                className={({ isActive }) =>
                  "nav-link" + (isActive ? " active-tab" : "")
                }
              >
                About
              </NavLink>
            </li>
            <li>
              <NavLink
                to="/skillSet"
                className={({ isActive }) =>
                  "nav-link" + (isActive ? " active-tab" : "")
                }
              >
                Skills
              </NavLink>
            </li>
          </ul>
        </nav>
      </div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<AboutMePage />} />
        <Route path="/skillSet" element={<SkillsPage />} />
      </Routes>
    </Router>
  );
}

export default Header;
