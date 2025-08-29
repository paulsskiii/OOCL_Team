// import { useState } from "react";
import "./App.css";
import "./index.css";
import LoginForm from "./components/LoginForm";
import RegistrationForm from "./components/RegistrationForm";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginForm />} />
        <Route path="/register" element={<RegistrationForm />} />
      </Routes>
    </Router>
  );
}

export default App;
