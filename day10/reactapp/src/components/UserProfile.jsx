import { useState } from "react";

function UserProfile() {
    const [userProfile, setUserProfile] = useState({
        firstName: "Philip Ronin",
        lastName: "Uriarte",
        age: 24
    });

    const { firstName, lastName, age } = userProfile // desctructuring?

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setUserProfile(values => ({...values, [name]: value}))
    }

    function handleFirstNameChange(e) {
        setUserProfile({
            ...UserProfile,
            firstName: e.target.value
        });
    }

    function handleLastNameChange(e) {
        setUserProfile({
            ...UserProfile,
            lastName: e.target.value
        });
    }

    function handleAgeChange(e) {
        setUserProfile({
            ...UserProfile,
            age: e.target.value
        });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        alert(userProfile);
    }

    return(
        <div>
            <h1>User Profile</h1>
            <p> 
                *insert picture* <br/>
                First Name: {firstName} <br/>
                Last Name: {lastName} <br/>
                Age: {age}
            </p>
            <h2>Edit User Profile</h2>
            <form onSubmit={handleFirstNameChange}>
                <label>Enter your first name:   
                    <input
                        type="text"
                        value={firstName}
                        onChange={handleFirstNameChange}
                    />
                </label>
                <br/>
                <label>Enter your last name:
                    <input
                        type="text"
                        value={lastName}
                        onChange={handleLastNameChange}
                    />
                </label>
                <br/>
                <label>Enter your age:
                    <input
                        type="number"
                        value={age}
                        onChange={handleAgeChange}
                    />
                </label>
                <br/>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default UserProfile