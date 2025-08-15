import { useState, useEffect} from 'react';
import App from '../App';

function Loading(){
    const[loading,setLoading] = useState(true);

    useEffect(() => {
        const fetchData = async () => { //async - does not need to wait  V7 Engine
            setLoading(false);
        };
        fetchData();
    },[]);

    if(loading){
        return <p>
            Loading...
        </p>
    }

    return(
        <App />
    )
}

export default Loading;