import { useState } from "react";

function Counter(){
    const [count, setCOunt] = useState(0);

    return (
        <>
        <div>
            <p>
                You clicked {count} times.
            </p>
            <button onClick={() => setCOunt(count+1)}>
            Click Me! </button>
        </div>
        </>
    )
}

export default Counter;