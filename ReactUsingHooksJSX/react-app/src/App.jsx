import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";

import Greetings from './components/greeting'; // From Greetings file
import Counter from './components/counter'; //From Counter file
import NameForm from './components/nameForm'; //From nameForm file
import LoginMessage from './components/LoginMessage'; //From LoginMessage file
import FruitList from './components/FruitList'; //From FruitList file

function App(){

  return(
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
          </ul>
        </nav>
      </div>
      <Routes>
        {/* <Route path = "/" element={<HomePage />} /> */}
        <Route path = "/about" element={<AboutPage />} />
    </Routes>
    </Router>
  )




  // const name = "Beginner Developer"; // const = immutable, declaring variable
  // const year = new Date().getFullYear(); // const = immutable, declaring variable

  // console.log(year); // Printing year value, shows in console

  // return( //Always enclose on <div>
  //   <div>
  //   <h1>
  //     My Awesome App
  //   </h1>
  //   <div>
  //      <Greetings name = "Alice"></Greetings> {/*Call Greetings with parameter */}
  //     <Greetings name = {name}></Greetings>
  //     <Counter />
  //     <NameForm />
  //     <LoginMessage isLoggedIn={true} />
  //     <FruitList />
  //     {/* <Greetings name = "Alice"></Greetings> */}
  //   </div>
  //   </div>

  //   // <div>
  //   //   <h1>Hello {name}!</h1>
  //   //   <p>This is something {year}</p>
  //   //   <Greetings name={name}/>
  //   // </div>
  // )
}

export default App;