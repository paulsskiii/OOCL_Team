import React, { useState } from "react";

const NameForm = () => {
  const [name, setName] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`Hello ${name}!`);
    setName("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>Name:</label>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <button type="submit">Alert</button>
    </form>
  );
};

export default NameForm;
