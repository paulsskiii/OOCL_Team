import React from 'react';
import { LoginProvider } from './LogInContext';
import ProfileEditor from './ProfileEditor';
import LoginButton from './LogInButton';
import './App.css'; 

const App = () => {
  return (
    <LoginProvider>
      <div>
        <h1>Welcome to My Portfolio</h1>
        <LoginButton />
        <ProfileEditor />
      </div>
    </LoginProvider>
  );
};

export default App;
