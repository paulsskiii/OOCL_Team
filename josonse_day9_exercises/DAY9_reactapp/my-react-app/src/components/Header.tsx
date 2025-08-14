import React from "react";

type HeaderProps = {
    name: string;

}

export const Header: React.FC<HeaderProps> = ({name}) =>{
    return (
        // <div style={{textAlign: "center", margin: "50em"}}>
        //     <h1> Hello, {name} </h1>
        //     <button onClick={() => alert('Hi ${name}, you clicked the button!')}>Click me!</button>
        // </div>      
        
        // <header style={{backgroundColor: "#333", color: "white", padding: "15px", textAlign: "center"}}>
        //     <h1 className="p-10">{name} - PORTFOLIO</h1>
        // </header>

        <header>
            <h1 id="name">SEBASTIAN ICARUS JOSON - PORTFOLIO</h1>
            <div className="flex flex-row justify-center items-center ">
                <img src="https://i.pinimg.com/originals/ab/d0/0f/abd00f7078c46f1f596516c26635e631.gif" alt="profile"></img>
            </div>
            
        </header>

        // <header className="bg-gray text-white p-15 text-center">
        //     <h1>{name} - PORTFOLIO</h1>
        // </header>

          
    )
}

