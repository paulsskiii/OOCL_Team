import { useState, useEffect } from "react"
import LoadingSpinner from './LoadingSpinner';

function UserProfile({name, setName, email, setEmail, description, setDescription}){

    const [loading, setIsLoading] = useState(false);
    const [tempName, setTempName] = useState(name);
    const [tempEmail, setTempEmail] = useState(email);
    const [tempDesc, setTempDesc] = useState(description);

    useEffect(() => {
        const timer = setTimeout(() => {
            setIsLoading(false); 
            if(loading)
                alert("Profile details successfully updated!")
        }, 3000);

        return () => clearTimeout(timer);

    }, [loading]);

    const handleName = (e) => {
        setTempName(e.target.value)
    }

    const handleEmail = (e) => {
        setTempEmail(e.target.value)
    }

    const handleDescription = (e) => {
        setTempDesc(e.target.value)
    }

    function editProfile(){
        setEmail(tempEmail);
        setName(tempName);
        setDescription(tempDesc);
        setIsLoading(true);
    }
    
    return(
        <div className="flex flex-col w-full items-center justify-center "> 

            { loading ? (<LoadingSpinner/>) : (<></>) }

            <div className="text-3xl font-bold ">
                EDIT PROFILE
            </div>
                <aside className="flex flex-col gap-5">
                        <div className="text-left w-full">
                            <div className="text-lg mt-5" >User Name</div>
                            <input type="text" className="bg-white rounded-sm text-black text-md w-96 p-1" value={tempName} onChange={handleName}></input>
                        </div>

                        <div className="text-left w-full">
                            <div className="text-lg">Email</div>
                            <input type="text" className="bg-white rounded-sm text-black text-md w-96 p-1" value={tempEmail} onChange={handleEmail}></input>
                        </div>

                        <div className="text-left w-3/4">
                            <div className="text-lg">Description</div>
                            <textarea className="bg-white rounded-sm text-black text-md p-1 w-96 h-54" value={tempDesc} onChange={handleDescription}></textarea>
                        </div>

                        <div className="flex justify-end">
                            <button className="bg-green-300 text-black" 
                                onClick={()  => editProfile()}>
                                    Save
                            </button>
                        </div>
                </aside>
        </div>
    )
}

export default UserProfile;