import { useState, useEffect } from 'react';
import axios from 'axios';

export function useApi<T>(url: string) {
  const [data, setData] = useState<T | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    setLoading(true);
    axios.get(url)
      .then(response => {
        setData(response.data);
        setError(null);
      })
      .catch(err => {
        setError(err.message || 'Error fetching data');
        setData(null);
      })
      .finally(() => {
        setLoading(false);
      });
  }, [url]);

  return { data, loading, error };
}
