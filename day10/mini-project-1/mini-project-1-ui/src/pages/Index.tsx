import autumn from "../assets/fall-autumn-red-season.jpg";
import SignUp from "../components/Signup.tsx";
import "../components/Login.css";
import {useState} from "react";

function Index() {
    const [showSignUp, setShowSignUp] = useState(false);

    if (showSignUp) {
        return (
            <div style={{
                minHeight: '100vh',
                width: '100vw',
                position: 'fixed',
                top: 0,
                left: 0,
                backgroundImage: `url(${autumn})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                zIndex: 0,
                alignContent: 'center',
                fontFamily: 'Poppins, sans-serif',
            }}>
                <SignUp />
                <button style={{
                    position: 'absolute',
                    top: 20,
                    right: 20,
                    padding: '8px 16px',
                    borderRadius: '8px',
                    color: '#fff',
                    border: 'none',
                    cursor: 'pointer',
                    fontFamily: 'Poppins, sans-serif',
                    background: '#1976d2',
                }} onClick={() => setShowSignUp(false)}>
                    Back to Login
                </button>
            </div>
        );
    }

    return (
        <div style={{
            minHeight: '100vh',
            width: '100vw',
            position: 'fixed',
            top: 0,
            left: 0,
            backgroundImage: `url(${autumn})`,
            backgroundSize: 'cover',
            backgroundPosition: 'center',
            zIndex: 0,
            alignContent: 'center',
            fontFamily: 'Poppins, sans-serif',
        }}>
            <div
                className="login-form"
                style={{
                    position: 'relative',
                    flexDirection: 'column',
                    alignItems: 'center',
                    minHeight: '300px',
                    maxWidth: '400px',
                    width: '90vw',
                    borderStyle: 'solid',
                    borderWidth: '3px',
                    borderColor: '#ccc',
                    margin: '60px auto',
                    display: 'flex',
                    padding: '20px',
                    boxSizing: 'border-box',
                    background: 'rgba(68, 68, 68, 0.4)',
                    backdropFilter: 'blur(3px)',
                    WebkitBackdropFilter: 'blur(15px)',
                    zIndex: 1,
                    fontFamily: 'Poppins, sans-serif',
                    color: 'white'
                }}
            >
                <h1 style={{ margin: '0px', padding: '20px', textAlign: 'center', width: '100%' }}>Login</h1>
                <form style={{ width: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                    <input
                        type='text'
                        placeholder='Username'
                        style={{
                            width: '100%',
                            maxWidth: '300px',
                            padding: '8px',
                            marginBottom: '10px',
                            boxSizing: 'border-box',
                            borderRadius: '20px',
                            background: 'transparent',
                            borderColor: '#ffffffff',
                            color: '#fff',
                        }}
                        required
                    />
                    <input
                        type='password'
                        placeholder='Password'
                        style={{
                            width: '100%',
                            maxWidth: '300px',
                            padding: '8px',
                            marginBottom: '10px',
                            boxSizing: 'border-box',
                            borderRadius: '20px',
                            background: 'transparent',
                            borderColor: '#ffffff',
                            color: '#fff',
                        }}
                        required
                    />
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', width: '100%', maxWidth: '300px', marginBottom: '16px' }}>
                        <label style={{ display: 'flex', alignItems: 'center', fontSize: '0.95rem' }}>
                            <input type='checkbox' style={{ marginRight: '6px' }} /> Remember me
                        </label>
                        <a href="#" style={{ color: '#ffffffff', textDecoration: 'underline', fontSize: '0.95rem' }}>Forgot password?</a>
                    </div>
                    <button type="submit" style={{
                        width: '50%',
                        maxWidth: '300px',
                        padding: '8px',
                        marginTop: '10px',
                        borderRadius: '8px',
                        border: 'none',
                        background: '#ffffffff',
                        color: 'black',
                        cursor: 'pointer',
                        fontFamily: 'Poppins, sans-serif',
                    }}>Login</button>
                    <div>
                        <p>Dont have an account? <button type="button" onClick={() => setShowSignUp(true)} style={{ color: '#1976d2', background: 'none', border: 'none', textDecoration: 'underline', cursor: 'pointer', fontSize: '1rem' }}>Sign up</button></p>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default Index;