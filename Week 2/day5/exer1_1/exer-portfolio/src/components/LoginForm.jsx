import { useState } from "react";

function LoginForm(){
    const [name, setName] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`Hello, ${name}!`)
    };

    return(
        <form onSubmit={handleSubmit}>
            <label>
                Name:
            <input
            type="text"
            value={name}
            onChange={(event)=>setName(event.target.value)}/>
            </label>
            <br></br>

            <button type="submit">Log In</button>
        </form>
    )
}

export default LoginForm;