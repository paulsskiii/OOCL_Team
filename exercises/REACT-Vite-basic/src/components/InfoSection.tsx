import { useState } from "react";
import { InfoSectionText } from "./InfoSectionText";

function InfoSection () {
    // const [text, setText] = useState ()
    const infos = {
        bio: `Hi! My name is Vincent Avila. Have good day. Thank you. Good bye`,
        interests: `Some of my interests include programming, shipping and vessels, containers, and pop music (particularly the Sourh Korean variety)`,
        skills: `My skills include skills1, skills2, skills3`
    }

    const [zinfo, setZinfo] = useState ("bio");
    let text: string = infos.bio;

    if (zinfo.toLocaleLowerCase () == "interests".toLocaleLowerCase ())
        text=infos.interests;
    else if (zinfo.toLocaleLowerCase () == "bio".toLocaleLowerCase ())
        text=infos.bio;
    else if (zinfo.toLocaleLowerCase () == "skills".toLocaleLowerCase ())
        text=infos.bio;

    
    return (
        <>
            <section style={{display: "flex", flexDirection: "row", width: "100%" }}>
                <InfoSectionText text={text}/>
                <article style={{width: "100%"}}>
                    <ul style={{listStyle: "none"}}>
                        <li onClick={() => setZinfo ("bio")}>Bio</li>
                        <li onClick={() => setZinfo ("interests")}>Interests</li>
                        <li onClick={() => setZinfo ("skills")}>Skills</li>
                    </ul>
                </article>
            </section>
        </>
    )
};

export default InfoSection;