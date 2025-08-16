function LoginMessage ({ isLoggedIn }) {
    return (
        <div>
            {
                isLoggedIn ?
                    <h2>Velcome vack!</h2>
                    : <h2>Please Log in.</h2>
            }
        </div>
    )
}

export default LoginMessage;