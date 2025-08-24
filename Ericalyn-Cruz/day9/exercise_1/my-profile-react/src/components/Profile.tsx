import React from "react";

type ProfileProps = {
    name: string;
};

export const Profile: React.FC<ProfileProps> = ({name}) => {
    return(
        <div style ={{ textAlign:"center", marginTop: "50px"}}>
            <button onClick={() => alert(`Hi ${name}, still working on!`)}> Click to know more </button>
        </div>
    )

}