import './App.css'
import { Greetings } from './components/Greetings'
import { useState } from 'react';
import image from './assets/image 3.png'
import background from './assets/background.png'

import { About } from './components/About';
function App() {
  const [current, setCurrent] = useState(0);

  return (
    <div className="bg-cover bg-[url(assets/background.png)] text-white mx-auto h-screen w-screen flex items-center justify-center">

      <section className="h-3/4 w-3/4 flex flex-row gap-10 rounded-xl border border-white items-center justify-center  bg-opacity-20 backdrop-blur-lg drop-shadow">
      
          <div className="h-64 w-64 w-1/2">
            <img src={image} className="rounded-lg"/>
          </div>
        <About name={"Martin James Arellano"}/>
      </section>
    </div>

  )
}

export default App
