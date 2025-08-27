import React from "react";

type AboutmeProps = {
    detail: string
}

export const Aboutme: React.FC<AboutmeProps> = () => {
    return (
        <section id="aboutMe">
            <h2>ABOUT ME</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </section>
    )
}




{/* <section id="aboutMe">
        <h2>ABOUT ME</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    </section> */}