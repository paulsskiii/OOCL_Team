import { useState } from "react";

function NameForm(){
    const [name, setName] = useState('');

    const handleSubmit = (event) => {
        //prevent the default behavior of the button
        event.preventDefault();
        // we need to use `` when it is for inserting the value
        alert(`Hello, ${ name }`);
    };

    return(
        <form onSubmit={handleSubmit}>
            <label>Name:</label>
            <input type="text" value={name} 
            onChange={(event) => setName(event.target.value)}/>
            
            <button type="submit">Submit</button>
        </form>
    )
}

export default NameForm;