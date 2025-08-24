import "../App.css"

function FruitList(){
    // const [Apple, Banana, Cherry] = ['Apple', 'Banana', 'Cherry'];
    const fruits= ['Apple', 'Banana', 'Cherry'];
    // return (
    //   <div>
    //     <h3>My fruits</h3>
    //     <ul>
    //       <li>{Apple}</li>
    //       <li>{Banana}</li>
    //       <li>{Cherry}</li>
    //     </ul>
    //   </div>
    // );

  return (
    // <ul>
    //   {fruits.map(fruit => (
    //     <li>{fruit}</li>
    //   ))}
    // </ul>
<ul className="fruit-list">
  {fruits.map((fruit, index) => (
    <li key={index}
    className="fruit-item">{fruit}</li>
  ))}
</ul>

    // <div>
    //     fruits.forEach(fruit => (
    //         <li>{fruits}</li>
    //     ))
    // </div>
  );


}export default FruitList;