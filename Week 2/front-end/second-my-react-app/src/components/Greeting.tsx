import React from "react";

type GreetingProps = {
    name: String;
}

export const Greeting: React.FC<GreetingProps> = ({ name}) => {
    return (
        <div style={{textAlign: "center"}}>
            <h1>Hello, {name}</h1>
            <button onClick={() => alert(`Hi ${name}`)}>
                Click me!
            </button>
        </div>
    )
}