// import { useState } from "react";
import "./App.css";
import "./index.css";
import LoginForm from "./components/LoginForm";
import RegistrationForm from "./components/RegistrationForm";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <div>
      <h1>----- MONIQUE -----</h1>
      <LoginForm />
      <h1>----- ABI -----</h1>
      <RegistrationForm />
    </div>
  );
}

export default App;
