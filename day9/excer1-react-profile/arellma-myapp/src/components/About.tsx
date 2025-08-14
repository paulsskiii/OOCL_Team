import { useState } from "react";

type AboutProps = {
    name: string;
}


export const About: React.FC<AboutProps> = ({ name }) => {

    const [current, setCurrent] = useState(0);
    const [email, setEmail] = useState(0);
    const [message, setMessage] = useState(0);
    
    const handleEmail = (e) => {
        setEmail(e.target.value)
    }

    const handleMessage = (e) => {
        setMessage(e.target.value)
    }

    return(
        <section className="flex flex-col w-1/2 gap-5">
            <div className="text-3xl font-bold text-center">
                Hi, I'm {name}!
            </div>
            <div className="flex flex-row h-fit gap-3 items-center justify-center ">
                <button className="bg-violet-900 text-black" onClick={()  => setCurrent(0)}>About</button>
                <button className="bg-violet-900 text-black" onClick={()  => setCurrent(1)}>Contact</button>
            </div>
            <div className="flex flex-col gap-2 text-white text-center">
        
                {  current == 0 ? (
                    <div className="flex flex-col w-full gap-4">
                    <div className="text-3xl font-bold ">ABOUT ME</div>
                    <div className="text-wrap text-lg">Hi! I am currently a Programmer from OOCL, focusing on full-stack development. 
                        I am proficient in ReactJs, NextJS, and TailwindCSS for frontend, then Spring Boot, NodeJS for the backend.
                    </div>
                    </div>
                    ) : (
                        <div className="flex flex-col w-full items-center justify-center "> 
                            <div className="text-3xl font-bold ">CONTACT ME</div>
                            <aside className="flex flex-col gap-5">
                                <div className="text-left w-full mt-5">
                                    <div className="text-lg">Email</div>
                                    <input type="text" className="bg-white rounded-sm text-black text-lg w-64" onChange={handleEmail}></input>
                                </div>
                                <div className="text-left w-3/4">
                                    <div className="text-lg">Message</div>
                                    <textarea className="bg-white rounded-sm text-black w-64 text-lg" onChange={handleMessage}></textarea>
                                </div>
                                <div className="flex justify-end">
                                    <button className="bg-violet-900 text-black" 
                                    
                                    onClick={()  => alert("Email:" + email + "\nMessage: " + message)}>Send</button>
                                </div>
                            </aside>
                        </div>
                    ) }
            </div>
        </section>
    )
}