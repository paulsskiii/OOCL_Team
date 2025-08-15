// UserProvider.js
import React, { useState } from 'react';
import UserContext from './UserContext';

const UserProvider = ({ children }) => {
    
  const [loggedIn, setLoggedIn] = useState(false);
  const [name, setName] = useState("Martin James Arellano");
  const [email, setEmail] = useState("");
  const [description, setDescription] = useState("Hi! I am currently a Programmer from OOCL, focusing on full-stack development. I am proficient in ReactJs, NextJS, and TailwindCSS for frontend, then Spring Boot, NodeJS for the backend.");
  
  const loginUser = (username) => {
    setName(username);
    setEmail("martinjamesarellano@gmail.com");
    setDescription("Hi! I am currently a Programmer from OOCL, focusing on full-stack development. I am proficient in ReactJs, NextJS, and TailwindCSS for frontend, then Spring Boot, NodeJS for the backend.");
    setLoggedIn(true);
};

  const logoutUser = () => {
    setUser('Guest');
    setEmail("");
    setDescription("");
    setLoggedIn(false);
  };    

    const editProfile = ({tempEmail, tempName, tempDesc}) =>{
        alert("Details updated")
        setEmail(tempEmail);
        setName(tempName);
        setDescription(tempDesc);
    }

  return (
    <UserContext.Provider value={{ user, loginUser, logoutUser, editProfile }}>
      {children}
    </UserContext.Provider>
  );
};

export default UserProvider;