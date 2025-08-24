function LoginMessage({ isLoggedIn }){
    return (
        <div>
            {
                isLoggedIn ? <h2>Welcome</h2> : <h2>Are you blind?</h2>
            }
        </div>
    );
}

export default LoginMessage;