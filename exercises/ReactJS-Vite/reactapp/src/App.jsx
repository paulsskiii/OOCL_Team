import Greeting from "./Components/Greetings";
import Counter from "./Components/Counter";
import NameForm from "./Components/NameForm";
import LoginMessage from "./Components/LoginMessage";
import FruitList from "./Components/FruitList";
// install mo to sa directory ahhh
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomePage from "./Components/HomePage";
import AboutPage from "./Components/AboutPage";

function App() {
  // const name = "Beginner Developer";
  // const year = new Date().getFullYear();
  // console.log(year);
  // // return (
  // //   <div>
  // //     <h1>hello world, {name}!</h1>
  // //     <p>this is {year}.</p>
  // //     // Passing a variable to a function
  // //     <Greeting name={name} />
  // //   </div>
  // // );
  // return (
  //   <div>
  //     <h1>My Awesome App!</h1>
  //     {/* <Greeting name="Alice" /> */}
  //     <Greeting name={name} />
  //     {/* Commenting */}
  //     {/*<Greeting name="hello" />*/}
  //     <Counter />
  //     <NameForm />
  //     <LoginMessage isLoggedIn={true} />
  //     <LoginMessage isLoggedIn={false} />
  //     <FruitList />
  //   </div>
  // );
  // Creating a SPA - Single Page Application
  return (
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
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
      </Routes>
    </Router>
  );
}

export default App;
