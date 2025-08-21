import React from "react";

const LoginMessage = ({ isLoggedIn }) => {
  return (
    <div>{isLoggedIn ? <h2>Welcome back!</h2> : <h2>Please Log In.</h2>}</div>
  );
};

export default LoginMessage;
