// import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'

// import Greeting from "./components/Greetings";

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

// export default App
import Greeting from "./components/Greetings";
import Counter from "./components/Counter";
import NameForm from "./components/NameForm";
import FruitList from "./components/FruitList";
import Homepage from "./components/Homepage";
import DataFetcher from "./components/DataFetcher";
import ProfilePage from "./components/ProfilePage";
// import { BrowserRouter };
// import {BrowserRouter as Router, Routes, Route, Link } from 


function App() {
  // const name = "Beginner Developer";
  // const year = new Date().getFullYear();

  return (
    <div style={{Width:"100vw",textAlign:"center"}}>
      {/* <h1>hello {name}!</h1>
      <p>this is something {year}</p> */}
      {/* <Greeting name="Alice"/> */}
      {/* <Homepage/>
      <Greeting name="Koki"/>
      <Counter/>
      <NameForm/>
      <FruitList/>
      <DataFetcher/> */}
      <ProfilePage/>
      
    </div>
  )
}

  // return(
  //   <Router>
  //     <div>
  //       <nav>
  //         <ul>
  //           <li>
  //             <Link to="/"></Link>
  //           </li>
  //         </ul>
  //       </nav>
  //     </div>
  //   </Router>
  // )

export default App;