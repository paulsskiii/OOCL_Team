import React from "react";

type InfoProps = {
    detail: string
}

export const Info: React.FC<InfoProps> = () => {
    return (
        <div>
            <section id="schools">
                <h2>SCHOOLS</h2>
                <ul>
                    <li>PUP</li>
                    <li>EAC</li>
                </ul>
            </section>

            <section id="skills">
                <h2>SKILLS</h2>
                <ul>
                    <li>JavaScript, Java, HTML, CSS</li>
                    <li>Database Management MySQL</li>
                    <li>Git</li>
                </ul>
            </section>

            <section id="hobbies">
                <h2>HOBBIES</h2>
                <ul>
                    <li>Playing Basketball</li>
                    <li>Lorem ipsum</li>
                    <li>Listening to Music</li>
                </ul>
            </section>

            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
        </div>
        
        
    )
}



