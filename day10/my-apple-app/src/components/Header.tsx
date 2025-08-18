import Nav from 'react-bootstrap/Nav';
import { useState, createContext } from "react";

import Home from './Home';
import Projects from './Projects';
import UpdateProfile from './UpdateProfile';

function Header() {
    

    const [page, setPage] = useState("Home");

    const currentInfo = {
        name: 'Hikaru Aquino',
        description: 'OOCL Inc. Programmer 2025',
        email: 'hikarutaquino@gmail.com'
    }

    const [profile, setProfile] = useState(currentInfo);

    
    return(
        <div>
            <div style={{zIndex:"100", padding:"5px", marginBottom:"10px"}}>
                <Nav variant="underline" className="justify-content-end nav-style">
                    <Nav.Item className="px-4">
                        <Nav.Link href="#" eventKey="home" className="nav-link" onClick={() => setPage("Home")}>Home</Nav.Link>
                    </Nav.Item>
                    
                    <Nav.Item className="px-4">
                        <Nav.Link href="#" eventKey="projects" className="nav-link" onClick={() => setPage("Projects")}>Projects</Nav.Link>
                    </Nav.Item>

                    <Nav.Item className="px-4">
                        <Nav.Link href="#" eventKey="contact" className="nav-link" onClick={() => setPage("Contact")}>Contact</Nav.Link>
                    </Nav.Item>

                    <Nav.Item className="px-4">
                        <Nav.Link href="#" eventKey="blog" className="nav-link" onClick={() => setPage("Blog")}>Blog</Nav.Link>
                    </Nav.Item>
                </Nav>
            </div>
            
            <div>
                {(() => {
                    switch (page) {
                    case 'Projects':
                        return <Projects />;
                    case 'Contact':
                        return <UpdateProfile setProfile = { setProfile } profile = { profile } />;
                    case 'Blog':
                        return <p>Status: Active</p>;
                    default:
                        return <Home profile = { profile } />;
                    }
                })()}
            </div>
        </div>

    )
}

export default Header;