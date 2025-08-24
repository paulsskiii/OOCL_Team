import './App.css';
import Greeting from './components/Greeting';
import CounterStrike from "./components/CounterStrike"
import NameForm from "./components/NameForm";
import LoginMessage from "./components/LoginMessage";
import FruitList from "./components/FruitLlist";
import HomePage from './components/HomePage';
import AboutPage from './components/AboutPage';
import Playground from './components/Playground';
import LandingPage from './components/LandingPage';
import { BrowserRouter as Router, Routes, Route, Link, BrowserRouter } from 'react-router-dom';

import Login from './components/LoginPage';

function App(){
  const name = "TAMBA";
  const year = new Date().getFullYear();

  console.log(name +" "+ year)
  return (
    <>
      <Router>
        <nav>
        <Login/>
        </nav>
            
        <Routes>
          <Route path="/landingPage" component={<LandingPage/>}/>
          <Route path='/home' element = {<HomePage/>}/>
          <Route path='/about' element = {<AboutPage/>}/>
          <Route path='/playground' element = {<Playground name={name}/>}/>
      </Routes>
      </Router>
   
    </>

  );
}
export default App;