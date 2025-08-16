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
import MessageHolder from './sections/MessageHolder'

function App() {
  var defaultName = "Vincent"
  var defaultMessage = "Hi I'm " + defaultName;
  const [message, setMessage] = useState (defaultMessage);
  const [isLoggedIn, setLoggedIn] = useState (false);

  return (
    <>
      <Navbar/>

      <main id="div-section-content" className="visible">
          <Home message={message}/>
          <MessageHolder isLoggedIn={false} message={message}/>
          <About/>
          <Interests/>
          <Works/>
          <Contact setMessage={setMessage}/>  
          <Footnote isLoggedIn={isLoggedIn} setLoggedIn={setLoggedIn}/>
      </main>
    </>
  )
}

export default App
