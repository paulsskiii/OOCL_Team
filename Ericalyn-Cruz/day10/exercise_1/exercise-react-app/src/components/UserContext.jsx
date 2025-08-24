import React, { createContext, useState } from "react";

// Create Context
export const UserContext = createContext();

// Provider Component
export const UserProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const login = () => setIsLoggedIn(true);
  const logout = () => setIsLoggedIn(false);

  return (
    <UserContext.Provider value={{ isLoggedIn, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};
