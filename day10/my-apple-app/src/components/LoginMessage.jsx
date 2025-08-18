function LoginMessage({ isLoggedIn }){
    return(
        <div>
            {isLoggedIn ?
            <h1>You are logged in!</h1> :
            <h1>Please log in D:</h1>
            }
        </div>

    )
}

export default LoginMessage;