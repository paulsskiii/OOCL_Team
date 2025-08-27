import DataFetcher from "./DataFetcher";
import NameForm from "../components/NameForm";
import Greeting from "../components/Greetings";
import Counter from "../components/counter";
import LoginMessage from "../components/LoginMessage";
import FruitList from "../components/FruitList";

function HomePage() {
  return (
    <div>
      <h1>Home Page</h1>
      <p> Welcome home</p>
      {/* <DataFetcher /> */}      

      <div>
        <h2>My Awesome App</h2>
        <Counter />
        <NameForm />
        <LoginMessage isLoggedIn={false} />
        <FruitList />
      </div>
    </div>
  );
}

export default HomePage;
