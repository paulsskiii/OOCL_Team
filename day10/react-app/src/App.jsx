import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom';
import FruitList from './components/FruitList';
import HomePage from './components/HomePage';
import AboutPage from './components/About';
import LoginMessage from './components/LoginMessage';

function App(){
  const name = "Begginer";
  const year = new Date().getFullYear;

  // return(
  // <><div>
  //     <h1>hello {name}!</h1>
  //     <p>this is something </p>
  //     <Greetings/>
  //   </div>
  // </>
  // )  

  // return(
  //   <h1>My Awseome App
  //     {/* <Greetings name="Alice"/>
  //     <Greetings name={name}></Greetings> */}
  //     <Counter></Counter>
  //   </h1>
  // )

  // return(
  //   // <div>
  //   //   <h1>My awsesom app</h1>
  //   //   <LoginMessage 

  //   // </div>
  // )

  // return(
  //   <div>
  //   <h1>My awesome app</h1>
  //   <FruitList/>
  //   </div>
  // )
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
        <Route path='/' element={<HomePage />} />
        <Route path='/about' element={<AboutPage />} />
      </Routes>
    </Router>
  )
} 

export default App;