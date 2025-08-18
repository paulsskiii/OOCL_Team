import React, { useState } from 'react'

const Form = () => {

    const [name, setName] = useState('');

    const handleSubmit = (e: React.SyntheticEvent): void => {
        e.preventDefault();
        console.info(name);
        alert(`Your name is ${name}`);
        console.info("Submitted!")
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
                <button type='submit'>Submit</button>
            </form>
        </div>
    )
}

export default Form