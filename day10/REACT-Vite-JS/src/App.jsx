// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'



// function App() {
//   const [count, setCount] = useState(0)

//   return (
//     <>
//       <div>
//         <a href="https://vite.dev" target="_blank">
//           <img src={viteLogo} className="logo" alt="Vite logo" />
//         </a>
//         <a href="https://react.dev" target="_blank">
//           <img src={reactLogo} className="logo react" alt="React logo" />
//         </a>
//       </div>
//       <h1>Vite + React</h1>
//       <div className="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/App.jsx</code> and save to test HMR
//         </p>
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//     </>
//   )
// }


import Counter from "./components/Counter";
import FruitList from "./components/FruitList";
import Greeting from "./components/Greeting";
import LoginMessage from "./components/LoginMessage";
import NameForm from "./components/NameForm";

// function App () {
//   const name = "Beginner Developer";
//   const year = new Date ().getFullYear ();

//   return (
//     <div>
//       <h1>Application</h1>
//       <h2>Harro {name}</h2>
//       <p>sumn year is {year}.</p>

//       <h1>Greetings ======</h1>
//       <Greeting name={name} />
//       <Greeting name="Jonathan" />
//       <br/>

//       <h1>Counter ======</h1>
//       <Counter />
//       <br/>

//       <h1>NameForm ======</h1>
//       <NameForm />
//       <br/>

//       <h1>LoginMessage ======</h1>
//       <LoginMessage isLoggedIn={false} />
//       <br/>

//       <h1>FruitList ======</h1>
//       <FruitList/>
//     </div>
//   )
// }

import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import HomePage from "./components/HomePage";
import AboutPage from "./components/AboutPage";

function App () {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/about">About</Link></li>
          </ul>
        </nav>
      </div>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="about" element={<AboutPage />} />
      </Routes>
    </Router>
  )
}

export default App
