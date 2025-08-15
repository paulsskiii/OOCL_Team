import { useState } from "react";

function NameForm() {
    const [name,setName] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`Hello ${ name }!`)
    };

    return (
        <div style={{padding:"10px"}}>
        <form style={{padding:"5px"}} onSubmit={handleSubmit}>
            <label style={{padding:"10px"}}>
                Name:
            <div style={{paddingBottom:"20px"}}>
                <input 
                type="text"
                value={name}
                onChange={(event) => setName 
                    (event.target.value)}
                />
            </div>
            </label>
            <button  
            type="submit">Submit
            </button>
        </form>
        </div>
    )
}

export default NameForm;