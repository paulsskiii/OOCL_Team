// import { AppBar, Avatar, Box, Button, Container, IconButton, Toolbar, Typography } from "@mui/material";
// import MenuIcon from '@mui/icons-material/Menu';
import { useState } from "react";

function AboutMe() {
    const [name,setName] = useState("Koki")

    
    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`The name you entered was: ${name}`);
    }

    const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs(values => ({...values, [name]: value}))
  }

  return (
    <div>
        <h1>{name}</h1>
        <form onSubmit={handleSubmit}>
            <label>Change Name?</label>
            <br/>
            <input 
            type="text" 
            value={name || ""}
            // onChange={(e) => setName(e.target.value)}
            onChange={(e) => setName(e.target.value)}
            onSubmit={""}
            />
        <input type="submit" />
        </form>
        {/* <p>Change name?</p> */}
    </div>
  );
};

export default AboutMe;