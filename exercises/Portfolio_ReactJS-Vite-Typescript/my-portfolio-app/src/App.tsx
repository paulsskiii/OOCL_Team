import Header from "./components/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import ProfilePicture from "./components/ProfilePicture";
import { useState } from "react";

const imagePath = "./public/cat.jpg";

function App() {
  return (
    <div>
      <Header />
    </div>
  );
}

export default App;
