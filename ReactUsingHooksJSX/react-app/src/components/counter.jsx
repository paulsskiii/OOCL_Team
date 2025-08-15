import { useState } from "react"; //import useState from react

function Counter(){ //Creating function Counter
    const [count,setCount] = useState(0);

    return(
        <div>
            <p>
                You clicked {count} times!
            </p>
            <button onClick={() => setCount (count + 1)}> {/* create onClick action  */}
                Click Me!
            </button>
        </div>
    )
}

export default Counter;