import React, { useState } from "react";

function NameForm () {
    const [name, setName] = useState ("jaonath");

    const handleSubmit = (event) => {
        event.preventDefault ();
        alert (`AAAAAAAAAAAAAAAAAAAAA, ${name}`);
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Name: 
            </label>
            <input
                type="text"
                defaultValue={name}
                onChange={(event) => setName (event.target.value)}/>
            <button
            type="submit">Submit</button>
        </form>
    )
}

export default NameForm