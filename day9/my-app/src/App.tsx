import React, { useState } from "react";
import { Greeting } from "./components/Greeting";

const App = () => {
  const [name, setName] = useState("");

  return (
    <div>
      <Greeting name={name} />
    </div>
  );
};

export default App;
