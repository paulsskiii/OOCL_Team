import './App.css'
import { useState, useContext, createContext } from 'react';
import image from './assets/image 3.png'
import UserProfile from './components/UserProfile';
import { About } from './components/About';
import UserProvider from './components/UserProvider';

function App() {

  debugger
  
  const [name, setName] = useState("Martin James Arellano");
  const [email, setEmail] = useState("martinjamesarellano@gmail.com");
  const [description, setDescription] = useState("Hi! I am currently a Programmer from OOCL, focusing on full-stack development. I am proficient in ReactJs, NextJS, and TailwindCSS for frontend, then Spring Boot, NodeJS for the backend.");

  return (

    <div className="bg-cover bg-[url(assets/background.png)] text-white mx-auto h-screen w-screen flex items-center justify-center">

      <section className="h-3/4 w-3/4 flex flex-row gap-10 rounded-xl border border-white items-center justify-center backdrop-blur-lg drop-shadow">
          <div className="h-64 w-64 w-1/2">
            <img src={image} className="rounded-lg"/>
          </div>
        <About name={name} setName={setName} email={email} setEmail={setEmail} description={description} setDescription={setDescription}/>
      </section>
      

    </div>

  )
}

export default App
