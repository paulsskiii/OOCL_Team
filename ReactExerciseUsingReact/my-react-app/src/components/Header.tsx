import React from "react";
import {ProfilePicture} from "./ProfilePicture";

type HeaderProps = {
    name: string;
    position: string;
}

export const HeaderProps: React.FC<HeaderProps> = ({name,position}) =>{
    return(
        <header className="header1">
            <ProfilePicture />
            <h1>{name}</h1>
            <h2>{position}</h2>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        </header>
        
    )
}