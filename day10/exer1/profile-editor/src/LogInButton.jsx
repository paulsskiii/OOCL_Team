import React from 'react';
import { useLogin } from './LogInContext';

const LoginButton = () => {
  const { isLoggedIn, login, logout } = useLogin();

  return (
    <div>
      {isLoggedIn ? (
        <button onClick={logout}>Logout</button>
      ) : (
        <button onClick={login}>Login</button>
      )}
    </div>
  );
};

export default LoginButton;
