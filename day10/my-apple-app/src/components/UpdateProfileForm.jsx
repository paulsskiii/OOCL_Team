import { useState } from "react";
import { useEffect } from "react";

function UpdateProfileForm({ setProfile, profile }){
    

    const [data, setData] = useState(profile);

    console.log(profile)
    console.log(data)


    const handleChange = (event) => {
        const { name, value } = event.target;
        setData(prevInfo => ({
            ...prevInfo,
            [name]: value
        }))
        
        event.preventDefault();
    }

    const handleSubmit = (event) => {
        setProfile(data);
        event.preventDefault();
        console.log(profile)
    };


    return(
        <form onSubmit={handleSubmit}>
            <label>Name:</label>
            <input type="text" name="name" value={data.name} onChange={handleChange}/><br />
            
            <label>Email:</label>
            <input type="text" name="email" value={data.email} onChange={handleChange}/><br />
            
            
            <label>Description:</label>
            <input type="textarea" name="description" value={data.description} onChange={handleChange}/><br />
            
            <button type="submit">Submit</button>
        </form>

        
    )
}

export default UpdateProfileForm;