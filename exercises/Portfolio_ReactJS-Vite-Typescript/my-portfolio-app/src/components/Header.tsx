import React from "react";
import { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./HomePage";
import AboutMePage from "./AboutMePage";
import SkillsPage from "./SkillsPage";

function Header() {
  return (
    <Router>
      <div
        className="myHeader"
        style={{ padding: " 10px 20px", backgroundColor: "darkkhaki" }}
      >
        <nav className=".container-fluid position-sticky justify-content-end ">
          <ul className="nav nav-tabs">
            <li className="nav-item">
              <Link to="/" className="nav-link">
                Home
              </Link>
            </li>
            <li>
              <Link to="/about" className="nav-link">
                About
              </Link>
            </li>
            <li>
              <Link to="/skillSet" className="nav-link">
                Skills
              </Link>
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
