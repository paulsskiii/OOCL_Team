import React from "react";

const HelloWorld = ({ sahur, setSahur }) => {
  return (
    <>
      <div>{sahur.name}</div>
      <button onClick={() => setSahur({ ...sahur, name: "sahur" })}>he</button>
    </>
  );
};

export default HelloWorld;
