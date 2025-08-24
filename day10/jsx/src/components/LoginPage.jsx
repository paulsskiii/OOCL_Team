import React from "react";
import { Router, Routes, Route, useNavigate } from "react-router-dom";
import LandingPage from "./LandingPage";


function LoginPage() {
    const navigate = useNavigate();
    const handleSubmit =  async (e) => {
        e.preventDefault();
        console.log("hello");
        navigate('/landingPage');
    }

    return(
        <div>
            <h1>LOGIN PAGE</h1>
            <form onSubmit={handleSubmit}>
                <label> Username: 
                    <input></input>
                </label>
                <label> Password:
                    <input></input>
                </label>
            </form>
            <button type="submit" onClick={handleSubmit}></button>

            <Routes>
                <Route path="/landingPage" component={<LandingPage/>}/>
            </Routes>
        </div>

  // <>
    )

}

export default LoginPage;