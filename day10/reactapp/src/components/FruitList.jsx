// import "..App.css"; // go up 2 directories

function FruitList() {
  const fruits = ["Apple", "Banana", "Cherry", "Durian"];
  const [apple, banana, cherry, durian] = [
    "Apple",
    "Banana",
    "Cherry",
    "Durian",
  ];

  return (
    <div>
      <h3>My prutas</h3>
      <ul className="fruit-list">
        {fruits.map((fruit, index) => (
          <li key={index} className="fruit-item">
            {fruit}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FruitList;
