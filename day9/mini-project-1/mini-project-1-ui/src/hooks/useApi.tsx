import { useEffect, useState } from 'react';
import axios from 'axios';

// };
type CustomerProps = {
  customerId: number;
  firstName: string;
  lastName: string;
  contactNumber: string;
  emailAddress: string;
  addressLine1: string;
  addressLine2: string;
  locationId: number;
};

type DataCardProps = {
  customers: CustomerProps[];
};

function useApi<T>(url: string) {
  const [data, setData] = useState<T | null>(null);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    setLoading(true);
    setError(null);

    axios.get<T>(url)
      .then((res) => setData(res.data))
      .catch((err) => {
        if (axios.isAxiosError(err)) {
          setError(err.message);
        } else {
          setError('An unknown error occurred');
        }
      })
      .finally(() => setLoading(false));
  }, [url]);

  return { data, loading, error };
}

export default useApi;