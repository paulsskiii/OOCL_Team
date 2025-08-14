import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

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
//           Edit <code>src/App.tsx</code> and save to test HMR
//         </p>
//       </div>
//       <p className="read-the-docs">
//         Click on the Vite and React logos to learn more
//       </p>
//     </>
//   )
// }

// export default App


// import { Greeting } from "./components/Greeting";
import mainPicture from './assets/main-picture.png';
import { LeftHalf } from "./sections/leftHalf";
import { RightHalf } from './sections/rightHalf';
import { MyName } from './components/MyName';

function App () {
  return <>
      <div style={{ display: "flex", flexDirection: "row", width: "100vw", backgroundColor: "azure", justifyContent: "space-between"}}>
        {/* <LeftHalf imgSrc={mainPicture}/> */}
        <LeftHalf imgSrc={reactLogo}/>
        <section style={{width: "100%", height: "100%"}}>
          <MyName name="Lorem Ipsum"/>
          {/* <RightHalf info={"Interests"}/> */}
          <RightHalf text={"bio"}/>
        </section>
      </div>
    </>
}

export default App;