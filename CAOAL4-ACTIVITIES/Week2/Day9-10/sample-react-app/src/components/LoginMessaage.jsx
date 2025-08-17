function LoginMessage({isLoggedIn}){
    return(
        <>
        <div>
            {
                isLoggedIn ? <h2>Welcome!</h2> : <h2>Please Login First!</h2>
            }
        </div>
        
        </>
    )
}

export default LoginMessage;