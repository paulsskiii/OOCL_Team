// Creating form

import { useState } from "react";

function NameForm() {
  const [name, setName] = useState("");

  // event slashed means it's not yet called
  const handleSubmit = (event) => {
    // Prevents default behavior
    // since submit reloads the page, this prevents page from reloading
    // you can see input not clearing
    event.preventDefault();

    // string interpolation
    //  - putting value into pre-existing string
    //  - use tilde instead of single quotes to put special characters
    alert(`Hello, ${name}!`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>Name:</label>
      <input
        type="text"
        value={name}
        onChange={(event) => setName(event.target.value)}
      />
      <button type="submit">Submit</button>
    </form>
  );
}

export default NameForm;
