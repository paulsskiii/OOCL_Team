import React, { useContext } from "react";
import { AppContext } from "../context/AppContext";

const Logout = () => {
  const { dispatch } = useContext(AppContext);

  const handleLogout = () => {
    dispatch({ type: "LOGOUT" });
  };

  return (
    <button
      className="cursor-pointer hover:text-white"
      type="button"
      onClick={handleLogout}
    >
      Logout
    </button>
  );
};

export default Logout;
