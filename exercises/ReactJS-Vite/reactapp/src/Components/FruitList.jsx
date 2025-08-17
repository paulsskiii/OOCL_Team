// import "../App.css";

function FruitList() {
  // this is an array
  const fruits = ["Apple", "Banana", "Cherry", "Durian"];
  // no longer an array, this is an instance of multiple variable declaration
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
        {/* <li>{apple}</li>
        <li>{banana}</li>
        <li>{durian}</li>
        <li>{cherry}</li> */}

        {/* best practice si index */}
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
