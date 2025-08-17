import React from "react";
import { useState } from "react";

function NameForm() {
  const [name, setName] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`Hello ${name}!`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Name:
        <input
          type="text"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default NameForm;
