import React from "react";
import { Link, useLocation } from "react-router-dom";
function Navigation() {
  const location = useLocation();
  return (
    <nav style={{ padding: "20px", borderBottom: "1px solid #ccc" }}>
      <Link
        to="/"
        style={{
          marginRight: "20px",
          fontWeight: location.pathname === "/" ? "bold" : "normal",
        }}
      >
        All Tasks
      </Link>
      <Link
        to="/create"
        style={{
          fontWeight: location.pathname === "/create" ? "bold" : "normal",
        }}
      >
        Create Task
      </Link>
    </nav>
  );
}
export default Navigation;
