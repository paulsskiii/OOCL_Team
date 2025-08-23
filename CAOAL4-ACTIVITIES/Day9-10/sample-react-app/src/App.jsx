import Greeting from "./components/Greetings";
import Counter from "./components/Counter";
import NameForm from "./components/NameForm";
import LoginMessage from "./components/LoginMessaage";
import FruitList from "./components/FruitList";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";

function App() {

  const name = "Beginner Devs";
  const year = new Date().getFullYear();
  return (
    <>
      <div>
        <h1>My Awesome App</h1>
        <h1>Hello, {name}!</h1>
        <p>year today is.. {year}.</p>
        <Greeting name="Alex"/>
        <Counter/>
        <NameForm/>
        <LoginMessage isLoggedIn={false}/>
        <FruitList/>
      </div>
      
    </>
  )

    // return (
    //   <>
    //     <Router>
    //       <div>
    //         <nav>
    //           <ul>
    //             <li>
    //               <Link to="/Home">Home</Link>
    //             </li>
    //             <li>
    //               <Link to="/About">About</Link>
    //             </li>
    //           </ul>
    //         </nav>
    //       </div>

    //       <Routes>
    //         <Route path="/Home" element={<HomePage/>} />
    //         <Route path="/About" element={<AboutPage/>} />
    //       </Routes>

    //     </Router>
    //   </>

    // )
}

export default App;
