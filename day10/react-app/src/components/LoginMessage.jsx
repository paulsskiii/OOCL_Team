function LoginMessage({isLoggeIn}){
    return(
        <div>
            {
                isLoggeIn ? <h2>Welcome back!</h2>: 
                <h2>Please log In.</h2>
            }
        </div>
    )
} export default LoginMessage;