import { useState, useEffect} from 'react'; //useEffect - sample of a hook

function DataFetcher(){
    const[data,setData] = useState(null);
    const[loading,setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => { //async - does not need to wait  V7 Engine
            try{
                const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
                const jsonData = await response.json();

                setData(jsonData);
            }catch(error){
                console.error('Error fetching data: ', error);
            }finally{
                setLoading(false);
            }
        };
        fetchData();
    },[]);

    if(loading){
        console.log("Loading");
        return <p>
            Loading...
        </p>
    }

    console.log("Success");
    return(
        <div>
            <h3>fetched Data: </h3>
            <h4>{data.title}</h4>
            <p>{data.body}</p>
        </div>
    )
}

export default DataFetcher;