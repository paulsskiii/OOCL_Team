import React from "react";

type NavProps = {
    details: string,
    school: string,
    skills: string,
    hobbies: string
}


export const Nav: React.FC<NavProps> = () => {
    return (
        // <nav style = {{backgroundColor: "#444", position: "sticky", top: "0", zIndex:"1000"}}>
        //     <ul style = {{listStyle: "none", margin: "0", padding: "0", display: "flex", justifyContent: "center"}}>
        //         <li style={{margin: "0 15px"}}>
        //             <a className="text-white no-underline p-1 inline-block" href="#aboutMe">Details</a>
        //         </li>
        //         <li style={{margin: "0 15px"}}>
        //             <a className="text-white no-underline p-1 inline-block" href="#schools">Schools</a>
        //         </li>
        //         <li style={{margin: "0 15px"}}>
        //             <a className="text-white no-underline p-1 inline-block" href="#skills">Skills</a>
        //         </li>
        //         <li style={{margin: "0 15px"}}>
        //             <a className="text-white no-underline p-1 inline-block" href="#hobbies">Hobbies</a>
        //         </li>
        //     </ul>
        // </nav>

        <nav>
            <ul>
                <li><a href="#aboutMe">Details</a></li>
                <li><a href="#schools">Schools</a></li>
                <li><a href="#skills">Skills</a></li>
                <li><a href="#hobbies">Hobbies</a></li>
            </ul>
        </nav>


    )
}


