import { useState } from 'react'
import './App.css'
import Greetings from './components/Greetings'
import Counter from './components/Counter'
import NameForm from './components/NameForm'
import LoginMessage from './components/LoginMessage'
import FruitList from './components/FruitList'
import HomePage from './components/HomePage'
import AboutPage from './components/AboutPage'

import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
function App() {
  const name = "Martin James Arellano";
  const name2 = "Wiyanni Lopez";
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  type props = {
      text: string;
  };

  return ( 
    <Router>
      <Routes>

          <Route path ="/home" element={<HomePage/>} />
          <Route path ="/about" element={<AboutPage/>} />
          <Route path ="/" element={        
          <div>
              <Link to="/home">Home </Link>
              <Link to="/about">About</Link>
              <Link to="/">Hehe</Link>
              <h1>hello {name}</h1>
              <div><Greetings name={name2}/></div>
              <div><Greetings name={"Saul Goodman"}/></div>
              <Counter/>
              <NameForm/>
              <LoginMessage isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn}/>
              <FruitList/>
          </div>} />
      </Routes>
  </Router>
  )

}

export default App
