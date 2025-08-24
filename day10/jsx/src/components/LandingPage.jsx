import { BrowserRouter as Router, Routes, Route, Link, BrowserRouter } from 'react-router-dom';
import HomePage from './HomePage';
import AboutPage from './AboutPage';
import Playground from './Playground';

function LandingPage(){
    return (
        <div>
            <div>
                <ul>
                    <li><Link to='/home'>Home</Link></li>
                    <li><Link to='/about'>About</Link></li>
                    <li><Link to='/playground'>Playground</Link></li>
                </ul>
            </div>
 
       </div>
    )
}

export default LandingPage;