import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import mainImage from './assets/main-picture.png'
import './App.css'
import Navbar from './components/Navbar'  
import Home from './sections/Home'
import About from './sections/About'
import Interests from './sections/Interests'
import Works from './sections/Works'
import Contact from './sections/Contact'
import Footnote from './sections/Footnote'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Navbar/>

      <main id="div-section-content" className="visible">
          <Home/>
          <About/>
          <Interests/>
          <Works/>
          <Contact/>
      </main>

      <Footnote/>

      {/* <!-- INDIVIDUAL WORK POPUP / DIALOG --> */}
      
    </>
  )
}

export default App
