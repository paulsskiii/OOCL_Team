function LoginMessage({ isLoggedIn, setIsLoggedIn }){
    return(
        <div>
            {
                isLoggedIn ? ( <h2>You are LOCKED IN!</h2>) : (<h2>Please lock in bro...</h2>)
            }
            <button onClick={() => setIsLoggedIn(!isLoggedIn)}>Log In</button>
        </div>
    )
}

export default LoginMessage;