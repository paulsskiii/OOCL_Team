import './App.css';
// import { Greeting } from './components/Greeting';
import Header from "./components/Header";
import 'bootstrap/dist/css/bootstrap.min.css';
// import Counter from './components/Counter';
import NameForm from './components/NameForm';
// import LoginMessage from './components/LoginMessage';
// import LadsList from './components/LadsList';

// import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

// import AboutPage from './components/AboutPage';
// import HomePage from './components/HomePage';




function App() {
  const username = "Aki";
  const year = new Date().getFullYear();
  console.log(username + year);

  //this is how we pass a value to your child component
  return (
    // <Router>
    //   <div>
    //     <nav>

    //       <ul>
    //         <li>
    //           <Link to="/home">Home</Link>
    //         </li>
    //         <li>
    //           <Link to="/about">About</Link>
    //         </li>
    //       </ul>

    //     </nav>
    //   </div>

    //   <Routes>
    //     <Route path ="/home" element={<HomePage />} />
    //     <Route path ="/about" element={<AboutPage />} />
    //   </Routes>
    // </Router>
    
    <div style={{textAlign:"center"}}>
      
     {/* <h1>{username} {year}</h1> */}
     {/* <Greeting name = {username}/>
     <Greeting name = "Kon"/> */}
     {/* <Counter/> */}


     {/* <NameForm />  */}
   
    {/* <LoginMessage isLoggedIn = {false}/> */}
    {/* <LadsList /> */}

    <Header /> 
    </div>
  );
}

export default App
