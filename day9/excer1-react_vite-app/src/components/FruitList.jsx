import { useState } from "react";

function FruitList(){

    const testData = [
                {
                    id: 1,
                    first_name : "Caleb",
                    last_name : "Xia"
                },
                {
                    id: 2,
                    first_name : "Zayne",
                    last_name : "Li"
                },
                {
                    id: 3,
                    first_name : "Sylus",
                    last_name : "Qin"
                }
            ]

    const fruits = ['Apple', 'Banana', 'Cherry', 'Durian'];

    const [apple, banana, cherry, durian ] = ['Apple', 'Banana', 'Cherry', 'Durian'];
    
    return (<div>
                <h3 class="fruit-list">My Prutas List </h3>
                {testData.map((data) => (
                    <li class="fruit-item" key={data.id}>
                        {data.first_name + " " + data.last_name}
                    </li>
                ))}
                <li>{apple}!</li>
                <li>{banana}!</li>
                <li>{cherry}!</li>
                <li>{durian}!</li>
                
            </div>)
}

export default FruitList;