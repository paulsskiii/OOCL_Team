import React from "react";
// type GreetingProps = {
//     name: string;
// }

// export function sendName(){
//     return(
//         <Greeting name= 'Testing'/>
//     )
// }

// export const Greetings: React.FC<GreetingProps> = ({name}) => {
//     return(
//         <Greetings name= 'Testing'/>
//         <div style={{textAlign:"center", marginTop: "50px",   margin: "auto"}}>
//             <h3>Hello, {name}</h3>
//             <button onClick={() => alert(`Hi ${name}, you clicked the button!`)} >
//                 Click me
//             </button>
//         </div>
//     )
// }


function Greeting({name}){
    return(
        <h2>HI! {name}</h2>
    )
}
export default Greeting;