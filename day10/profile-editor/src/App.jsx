import { Route, Routes } from "react-router";
import "./App.css";
import Home from "./component/Home";
import ProfileEditor from "./component/ProfileEditor";
import Navbar from "./component/Navbar";
import { useContext } from "react";
import { AppContext } from "./context/AppContext";
import Skills from "./component/Skills";
import About from "./component/About";

function App() {
  const { user } = useContext(AppContext);

  return (
    <div className="app">
      <Navbar />
      <Routes>
        <Route
          index
          path="/home"
          element={
            <Home
              name={user?.name || "Guests"}
              profile={
                "https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExaGRkOXdjbWF3enpidWtqOWpsa3VldHpsaDl4ejFvYTkzaXc4Z3B2bSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/v5LGVtcBFTV5K/giphy.gif"
              }
              bio={
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum quas quis cumque nisi nostrum, molestiae aspernatur optio, voluptates accusantium maxime, beatae quasi sequi distinctio dolore fugiat sit culpa unde quos!"
              }
            />
          }
        />
        <Route path="/skill" element={<Skills />} />
        <Route path="/about" element={<About />} />
        <Route path="/editor" element={<ProfileEditor />} />
      </Routes>
    </div>
  );
}

export default App;
