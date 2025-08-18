import React from "react";
import  School  from "./School";
import  Skills  from "./Skills";
import  Hobbies  from "./Hobbies";
import  AboutMe  from "./AboutMe";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";


function Nav(){
    return (        
        <Router>
            <nav className="bg-gray-800 sticky top-0 z-[1000]">
                <ul className="list-none m-0 p-0 flex justify-center">
                    <li className="m-10">
                        <Link className="hover: bg-[#666] rounded-[5px]" to="/">About Me</Link>
                    </li>
                    <li className="m-10">
                        <Link  to="/schools">Schools</Link>
                    </li>
                    <li className="m-10">
                        <Link to="/skills">Skills</Link>
                    </li>
                    <li className="m-10">
                        <Link to="/hobbies">Hobbies</Link>
                    </li>
                </ul>
            </nav>

            <Routes>
                <Route path="/" element={<AboutMe/>} />
                <Route path="/schools" element={<School/>} />
                <Route path="/skills" element={<Skills/>} />
                <Route path="/hobbies" element={<Hobbies/>} />
            </Routes>
        </Router>
        


    )
}


export default Nav;