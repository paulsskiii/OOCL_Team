function FruitList(){
    const fruits = ['Gomu Gomu no mi','HitoHitono mi','Moku Moku no Mi', 'durian'];
    const [gomu, hito, moku, durian] = ['Gomu Gomu no mi','HitoHitono mi','Moku Moku no Mi', 'coke'];

    return(
        <div>
            <h2> Some Indian Fruits below </h2>
            <ul className="fruit-list">
            {
                fruits.map((fruit,index) => (
                    <li
                    key = {index}
                    className="fruit-item"
                    >
                        {fruit}
                    </li>
                ))
            }
            </ul>
        </div>
    )
}
export default FruitList;