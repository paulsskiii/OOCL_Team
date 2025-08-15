function FruitList() {
    const fruits = ['Apple','Banana','Cherry','Happy Birthday Yek'];

    return (
        <div>
            <div style={{borderStyle:"solid",borderColor:"purple"}}>
            <h3>My pruts</h3>
            <ul style={{padding:"0px"}}>
                {fruits.map((fruit, index) => (
                    <p key={index}>{fruit}</p>
                ))}
            </ul>
            </div>
        </div>
    )
}

export default FruitList;