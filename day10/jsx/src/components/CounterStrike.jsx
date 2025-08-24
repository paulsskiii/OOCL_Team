import React from "react";
import { useState } from "react";


function Counter(){
    const [count, setCount] = useState(1);

    return(
        <div>
            <p>
                You lost {count} times! 
            </p>
            <button onClick={()=> setCount(count * 2 * 9)}>
                Click to 1v1 me
            </button>
        </div>
    )
}

export default Counter;