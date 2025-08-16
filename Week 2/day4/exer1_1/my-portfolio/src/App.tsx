// import { useState } from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.css';
import { Header} from './components/Header'
import { AboutMe } from './components/AboutMe'
import { PictureSection } from './components/PictureSection';

function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
      <Header name={'Guest'}/>
      <AboutMe/>
      <PictureSection />
    </>
  )
}

export default App
