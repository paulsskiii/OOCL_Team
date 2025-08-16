import { useState } from "react";
import "./App.css";
import Counter from "./components/Counter";
import Greetings from "./components/Greetings";
import LogInMessage from "./components/LogInMessage";
import NameForm from "./components/NameForm";
import FruitList from "./components/FruitList";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import AboutPage from "./components/AboutPage";
import HomePage from "./components/HomePage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState();
  const name = "This is real. This is me";

  return (
    <>
      <Router>
        <div>
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/about">About Page</Link>
              </li>
            </ul>
          </nav>
        </div>
        <hr />
        <Routes>
          <Route path="/" element={<HomePage />}></Route>
          <Route path="/about" element={<AboutPage />}></Route>
        </Routes>
      </Router>

      {/* <div>
        <h1>hello {name}</h1>
        <p>this is something</p>
        <Greetings name={name}/>
        <Counter />
        <NameForm />
        <LogInMessage isLoggedIn={false}/>
        <FruitList />
      </div> */}
    </>
  );
}

export default App;
