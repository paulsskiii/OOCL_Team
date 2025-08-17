import { useEffect, useState } from "react";
import { Banner}  from "./components/Banner";
import { Content } from "./components/Content";

function App() {
  const [page, setPage] = useState(1);
  const [name, setName] = useState("Juan Gabriel C. Semana");
  const [quote, setQuote] = useState("It is good to love many things, for therein lies the true strength, and whosoever loves much performs much, and can accomplish much, and what is done in love is well done.” ― Vincent Van Gogh");

  useEffect(() => {
    let timer = setTimeout(()=>{
      setName("Juan Gabriel C. Semana");
      setQuote("It is good to love many things, for therein lies the true strength, and whosoever loves much performs much, and can accomplish much, and what is done in love is well done.” ― Vincent Van Gogh");
    }, 15000);
  });

  function back(){
    setPage(page != 1? page - 1: 1);
  }

  function forward(){
    setPage(page != 4? page + 1: 4);
  }

  return <>
    <Banner name={name} quote={quote}/>
    <Content page={page} setName={setName} setQuote={setQuote}/>

    <div className="slider-btns">
      <button onClick={back}>
          &lt;
      </button>
      
      <button onClick={forward}>
          &gt;
      </button>
    </div>
  </>;
}

export default App
