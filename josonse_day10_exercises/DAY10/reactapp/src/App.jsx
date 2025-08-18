import Greeting from "./components/Greetings"
import Counter from "./components/Counter"
import NameForm from "./components/NameForm";
import LoginMessage from "./components/LoginMessage";
import FruitList from "./components/FruitList";
import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

function App(){
  return( 

    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/"> Home </Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
          </ul>
        </nav>
      </div>

      <Routes>
        <Route path="/" element={<HomePage/>}/>
        <Route path="/about" element={<AboutPage/>}/>
      </Routes>
    </Router>
  )
}

export default App;