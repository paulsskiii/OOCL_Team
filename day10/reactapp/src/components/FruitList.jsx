import React from "react";
import "../App.css";

const FruitList = () => {
  const fruits = ["Apple", "Banana", "Cherry", "Durian"];

  return (
    <div>
      <h3>My Prutas</h3>
      <ul className="fruit-list">
        {fruits.map((fruit, index) => (
          <li key={index} className="fruit-item">
            {fruit}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FruitList;
