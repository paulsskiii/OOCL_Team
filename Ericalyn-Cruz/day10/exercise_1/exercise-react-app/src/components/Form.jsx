import { useState } from "react";
import React from "react";
import { CLoadingButton } from '@coreui/react-pro'
import "../App.css";
import LoadingButton from "./LoadingButton";
// import { useState, useEffect } from "react";



function Form(){
    const[firstName, setFirstName] = useState('');
    const[lastName, setLastName] = useState('');
    const[emailAddress, setEmailAddress] = useState('');
    const[address, setAddress] = useState('');
    const[contact, setContact] = useState('');
    const [gender, setGender] = useState("male");

    localStorage.setItem("firstName", JSON.stringify(firstName));
    localStorage.setItem("lastName", JSON.stringify(lastName));
    localStorage.setItem("emailAddress", JSON.stringify(emailAddress));
    localStorage.setItem("address", JSON.stringify(address));
    localStorage.setItem("contact", JSON.stringify(contact));
    localStorage.setItem("gender", JSON.stringify(gender));
    
    const [name, setName] = useState(() => {
        const saved = localStorage.getItem("name");
        const initialValue = JSON.parse(saved);
        return initialValue || "";
    });
  

    const handleReset = () => {
        setFirstName("");
        setLastName("");
        setEmailAddress("");
        setAddress("");
        setContact("");
        setGender("male");
    }

    const handleSumbit = (event) => {
        event.preventDefault();
        alert(`Hello, ${firstName} you account has been saveed successfully!`)
    };

    return(
        <div>
            <h1> Login </h1>
            <form onSubmit={handleSumbit}>
            <label> First Name: <br></br>
                <input
                    type="text" 
                    name="firstName"
                    id="firstName"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                    placeholder="Enter your first name"
                    required
                />
            </label>
            <br></br>
            <label> Last Name: <br></br>
                <input
                    type="text" 
                    name="lastName"
                    id="lastName"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                    placeholder="Enter your last name"
                    required
                />
            </label>
            <br></br>
            <label> Email Adddress: <br></br>  
                <input
                    type="email" 
                    name="email"
                    id="email"
                    value={emailAddress}
                    onChange={(e) => setEmailAddress(e.target.value)}
                    placeholder="Enter your email address"
                    required
                />
            </label>
            <br></br>
            <label> Contact: <br></br>
                <input
                    type="tel" 
                    name="contact"
                    id="contact"
                    value={contact}
                    onChange={(e) => setContact(e.target.value)}
                    placeholder="Enter your contact number"
                    required
                />
            </label>            
            <br></br>
            <label> Gender: <br></br>  
                <input
                    type="radio"
                    name="gender"
                    value="male"
                    id="male"
                    checked={gender === "male"}
                    onChange={(e) => setGender(e.target.value)}
                /> Male
                <input
                    type="radio"
                    name="gender"
                    value="female"
                    id="female"
                    checked={gender === "female"}
                    onChange={(e) => setGender(e.target.value)}
                /> Female
                <input
                    type="radio"
                    name="gender"
                    value="other"
                    id="other"
                    checked={gender === "other"}
                    onChange={(e) => setGender(e.target.value)}
                /> Other
            </label>           
            <br></br>
            <label> Home address: <br></br>  
                <textarea
                    type="text" 
                    name="address"
                    id="address"
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                    placeholder="Enter your home address"
                    required
                />
            </label>   
            <br></br> 
                <button
                    type="reset"
                    value="reset"
                    onClick={() => handleReset()}
                >
                Reset
                </button>
                
                
            {/* <LoadingButton /> */}

            </form>
        </div>
    )
}

export default Form;

