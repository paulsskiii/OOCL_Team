import "../App.css";

function FruitList() {
  const fruits = ["apple", "banana", "cherry", "durian"];
  const [apple, banana, cherry, durian] = [
    "apple",
    "banana",
    "cherry",
    "durian",
  ];

  return (
    <div>
      <h3>My Prutas</h3>
      <ul className="fruit-list">
        {fruits.map((fruit, index) => (
          <li key={index} clasName="fruit-item">
            {fruit}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FruitList;
