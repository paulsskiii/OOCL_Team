import { useState, useEffect } from "react";

function DataFetcher(){
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(true);

    const fetchData = async () => {
        try {
                const response = await fetch('https://jsonplaceholder.typicode.com/posts/1')
                const jsonData = await response.json();
                setData(jsonData)
            } catch(error){
                console.error('Error fetching data:', error)
            } finally {
                setLoading(false);
            }
        }

    useEffect(() => {
        fetchData();
    }, []);

    if (loading){
        return <p>Loading...</p>
    }

    return (
        <div>
            <h3>Fetched Data:</h3>
            <h4>{data.title}</h4>
            <h4>{data.body}</h4>
        </div>
    )

}

export default DataFetcher;