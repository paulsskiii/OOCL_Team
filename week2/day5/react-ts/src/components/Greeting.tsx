import React from 'react'

type GreetingProps = {
    name: string;
}

const Greeting: React.FC<GreetingProps> = ({ name }) => {
    return (
        <>
            <div>{name}</div>
            <button onClick={() => alert(`I am ${name}`)}>Click</button>
        </>
    )
}

export default Greeting