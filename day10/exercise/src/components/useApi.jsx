const useApi = (url) => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchData = async () => {
    setLoading(true);
    setError(null);
    try {
      // Simulate API call delay
      await new Promise(resolve => setTimeout(resolve, 1000));
      
      const idMatch = url.match(/\/api\/data\/(\d+)/);
      let fetchedData = null;

      if (idMatch) {
        const id = parseInt(idMatch[1], 10);
        fetchedData = mockData.find(item => item.id === id);
        if (!fetchedData) {
          throw new Error('Customer not found');
        }
      } else {
        fetchedData = mockData;
      }
      
      setData(fetchedData);
    } catch (err) {
      setError(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, [url]);

  return { data, loading, error, refetch: fetchData };
};