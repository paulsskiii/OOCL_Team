function FruitList() {
    const fruits = ['Apple', 'Banana', 'Cherry', 'Durian'];
    const [apple, banana, cherry, durian] = ['Apple', 'Banana', 'Cherry', 'Durian'];

    return (
        <>
            <h3>My Prutas</h3>
            <ul className="fruit-list">
                {fruits.map((fruit, index) => (
                    <li className='fruit-item' key={index}>{fruit}</li>
                ))}
            </ul>
        </>
    )
}

export default FruitList;