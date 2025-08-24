import React, { createContext, useState, useContext, useEffect } from 'react';

const LoginContext = createContext();

export const useLogin = () => useContext(LoginContext);

export const LoginProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const userLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    setIsLoggedIn(userLoggedIn);
  }, []);

  const login = () => {
    setIsLoggedIn(true);
    try {
      localStorage.setItem('isLoggedIn', 'true');
    } catch (error) {
      console.log('Could not save to localStorage:', error);
    }
  };

const logout = () => {
    setIsLoggedIn(false);
    try {
      localStorage.setItem('isLoggedIn', 'false');
    } catch (error) {
      console.log('Error clearing localStorage:', error);
    }
  };
  const value = {
    isLoggedIn,
    login,
    logout
  };


  return (
    <LoginContext.Provider value={{
      isLoggedIn,
      login,
      logout}}>
      {children}
    </LoginContext.Provider>
  );
};
