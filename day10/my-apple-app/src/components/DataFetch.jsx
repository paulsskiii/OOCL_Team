import { useState, useEffect } from "react";

function DataFetch(){
    const [data, setData] = useState(null);

    const [loading, setLoading] = useState(true);

    const fetchData = async () =>{
            try {
                const response = await fetch('https://jsonplaceholder.typicode.com/posts/2')
                const jsonData = await response.json();
                
                setData(jsonData)
               
            } catch (error) {
                console.error(('Error fetching data: ', error));
            } finally{
                setLoading(false)
            }
        }

    useEffect(() => {
        fetchData();
    }, []);

    if(loading){
        return <p>Loading. . . </p>
    }

    return(
        <div>
            <h4>fetched data: </h4>
            <h5>{data.id}</h5>
            <h5>{data.title}</h5>
            
            <h5>{data.description}</h5>
            {console.log(data.id)}
        </div>
    );
}

export default DataFetch;
