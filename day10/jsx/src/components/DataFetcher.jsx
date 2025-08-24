import { useState, useEffect } from "react";

function DataFetcher(){
    const[data, setData] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() =>{
        const fetchData = async () => {
            try{
                const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
                
                const jsonData = await response.json();

                setData(jsonData);
            }catch (error){
                console.error(error);
            } finally {
                setLoading(false);
            }
        }

        fetchData();
    }, []);

    if(loading){
        return <p>
            Loading!!!!!!!!!!!!!!!!!!!!!! teluk mo ah!?
        </p>
    }
    return (
        <div>
            <h4> fetched Data:</h4>
            <h5>{data.title}</h5>
            <h5>{data.body}</h5>
        </div>
    )
}
export default DataFetcher;