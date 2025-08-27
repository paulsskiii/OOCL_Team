import React from 'react';
import '../App.css'; 

const Header: React.FC = () => {
  return (
    <header className="header-custom">
      <div className="container">
        <h1 className="display-4">Princess Joy Ferrer</h1>
        <p className="lead">Programmer | Designer | Photography</p>
      </div>
    </header>
  );
};

export default Header;