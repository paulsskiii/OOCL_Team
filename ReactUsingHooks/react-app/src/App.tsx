import Greetings from './components/Greetings';

function App(){
  const name = "Beginner Developer";
  const year = new Date().getFullYear();

  console.log(year);

  return(
    <div>
      <h1>Hello {name}!</h1>
      <p>This is something {year}</p>
      <Greetings name={name}/>
    </div>
  )
}

export default App;