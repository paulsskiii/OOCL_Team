import Greeting from "./Greeting";
import CounterStrike from "./CounterStrike"
import NameForm from "./NameForm"
import FruitList from "./LoginMessage"
import LoginMessage from "./LoginMessage";


function Playground({name}){
    return(
        <div>
        <Greeting name={name}/>
        <CounterStrike/>
        <NameForm/>
        <LoginMessage isLoggedIn={true}/>
        <FruitList/>
      </div>
    )
}
export default Playground;