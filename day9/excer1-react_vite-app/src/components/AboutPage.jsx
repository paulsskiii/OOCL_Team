import { Link } from "react-router-dom";

function AboutPage(){
    return(
        <div>
            <Link to="/home">Home </Link>
            <Link to="/about">About</Link>
            <Link to="/">Hehe</Link>
            <h1>About Page</h1>
            <p>This is about you bro!</p>
        </div>
    )
}

export default AboutPage;