import { useState } from "react";
import ProfileSavedPage from "./ProfileSavedPage";
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";

function ProfileEditor(){
    const[name, setName] = useState('');
    const[age, setAge] = useState('');
    const[birthday, setBirthday] = useState('');
    const[position, setPosition] = useState('');

    const handleSubmit = (event: { preventDefault: () => void; }) => {
        event.preventDefault();
        <ProfileSavedPage />
    }

    return(
        <Router>
        <form onSubmit={handleSubmit}>
            <label>
                Name:
            </label>
            <input type="text" value={name} onChange={(event) => setName(event.target.value)} /><br></br>
            <br></br>
            <label>
                Age:
            </label>
            <input type="text" value={age} onChange={(event) => setAge(event.target.value)} /><br></br>
            <br></br>
            <label>
                Birthday:
            </label>
            <input type="text" value={birthday} onChange={(event) => setBirthday(event.target.value)} /><br></br>
            <br></br>
            <label>
                Position:
            </label>
            <input type="text" value={position} onChange={(event) => setPosition(event.target.value)} /><br></br>
            <br></br>

            <button type="submit">
                Submit
            </button>
        </form>
        </Router>
    )
}

export default ProfileEditor;