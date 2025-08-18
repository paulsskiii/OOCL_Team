import React from "react";

type GreetingProps = {
    name: string
};

//to get the props from the parent, go to the App.tsx and make sure that you pass it from there
export const Greeting: React.FC<GreetingProps> = ({ name }) => {
    return(
        <div>
            <h1> Hello, {name}</h1>
            
            {/* <button onClick={() => alert(`Hi ${name}! You clicked the button!`)}>
                Click me!
            </button> */}
        </div>

    )
}