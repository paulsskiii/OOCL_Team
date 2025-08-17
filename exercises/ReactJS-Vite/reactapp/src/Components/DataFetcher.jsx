import { useState, useEffect } from "react";

function DataFetcher() {
  const [data, setData] = useState(null);
  // set spinner
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // async = skips lines if loading too long
    // downside of doing async - creates uncontrolled behavior
    const fetchData = async () => {
      try {
        // dapat single quotes ito but prettier keeps on making it double quotes f
        const response = await fetch(
          "https://jsonplaceholder.typicode.com/posts/1"
        );
        const jsonData = await response.json();

        setData(jsonData);
      } catch (error) {
        console.error("Error fetching data: ", error);
      } finally {
        // turn off spinner
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  // display spinner
  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div>
      <h3>Fetched Data:</h3>
      <h4>{data.title}</h4>
      <p>{data.body}</p>
    </div>
  );
}

export default DataFetcher;
