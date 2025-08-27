import React from "react";



function Header({name}){
    return (
        <header className="bg-gray-800 text-white p-4 text-center">
            <h1>{name} - PORTFOLIO</h1>
            <div className="flex flex-row justify-center items-center">
                <img src="https://i.pinimg.com/originals/ab/d0/0f/abd00f7078c46f1f596516c26635e631.gif" alt="profile"></img>
            </div>
            
        </header>         
    )
}

export default Header;

