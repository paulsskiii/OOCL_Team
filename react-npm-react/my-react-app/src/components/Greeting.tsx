import React from "react";

type GreetingProps = {
    name: string;

};

export const Greeting: React.FC<GreetingProps> = ({name}) => {
    return(
        <div style={{textAlign:"center", marginTop: "50px"}}>
            <h1>Hello, {name}</h1>
            <button onClick={() => alert(`Hi ${name}, you clicked the button!`)} >
                Click me
            </button>
        </div>
    )
}