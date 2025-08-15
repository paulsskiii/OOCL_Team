import { useState,useEffect } from "react";

function DataFetcher() {
    const [data,setData] = useState(null);
    const [loading,setLoading] = useState(true);
    
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("https://jsonplaceholder.typicode.com/posts/5");
                const jsonData = await response.json();

                setData(jsonData);
            } catch (error) {
                console.error('Error fetching data: ', error);
            } finally {
                setLoading(false);
            }
        }
        fetchData();
    },[]);

    if (loading) {
        return <p>
            Loading...
        </p>
    }

    return (
        <div>
            <h3> fetched Data: </h3>
            <h4> {data.title} </h4>
            <p> {data.body} </p>
        </div>
    )
}

export default DataFetcher;