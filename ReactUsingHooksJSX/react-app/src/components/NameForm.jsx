import React, { useState } from "react";
// import { useState } from "react";

function NameForm(){
    const[name, setName] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`Hello, ${name}!`)
    }

    return(
        <form onSubmit={handleSubmit}>
            <label>
                Name:
            </label>

            <input type="text" value={name} onChange={(event) => setName(event.target.value)} />

            <button type="submit">
                Submit
            </button>
        </form>
    )
}

export default NameForm;

 

// import React, {useState} from "react";

// function NameForm(){
//     const [name, setName] = useState('');

//     const handleSubmit = (event) =>{
//         event.preventDefault(); //Preventing to do default actions
//         alert(`Hello, ${name}!`);
//     } //if event has slash = not used yet

//     return(
//         <form onSubmit={handleSubmit}>
//             <label>
//                 Name:
//             </label>
//             <input>
//                 type = "text"
//                 value = {name}
//                 onChange={(event) =>setName(event.target.value)}
//             </input>

//             <button type="submit">
//                 Submit
//             </button>
//         </form>
//     )
// }

// export default NameForm;
