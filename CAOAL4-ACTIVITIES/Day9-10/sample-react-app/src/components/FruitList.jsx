import '../App.css';

function FruitList(){
    const fruits = ['Apple','Banana','Cherry','Mango','Durian'];

    return (
        <>
            <div>
                <h3>My Fruits</h3>
                <ul>
                    { fruits.map((fruit,index)=>(
                        <li key={index} className="fruit-list">
                            {fruit}</li>)
                        )
                    }
                </ul>
            </div>
        </>
    )

}
export default FruitList;