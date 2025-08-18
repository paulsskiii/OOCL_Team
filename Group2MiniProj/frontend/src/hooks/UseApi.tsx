import { useState, useEffect } from "react";
import { mockData } from "../components/mockData.js";
import type { Customer } from "../types/index.js";

interface UseApiResult {
  data: Customer[] | Customer | null;
  loading: boolean;
  error: Error | null;
  refetch: () => void;
}

export const useApi = (url: string): UseApiResult => {
  const [data, setData] = useState<Customer[] | Customer | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<Error | null>(null);

  const fetchData = async () => {
    setLoading(true);
    setError(null);
    try {
      await new Promise((resolve) => setTimeout(resolve, 1000));

      const idMatch = url.match(/\/api\/data\/(\d+)/);
      let fetchedData: Customer[] | Customer | null = null;

      if (idMatch) {
        const id = parseInt(idMatch[1], 10);
        fetchedData = mockData.find((item: { id: number; }) => item.id === id) || null;
        if (!fetchedData) throw new Error("Customer not found");
      } else {
        fetchedData = mockData;
      }

      setData(fetchedData);
    } catch (err: any) {
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
