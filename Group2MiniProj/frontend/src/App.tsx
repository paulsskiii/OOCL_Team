import { useEffect, useState } from 'react';

import { DataCard, type ItemData } from './components/DataCard';
import LoadingSpinner from './components/LoadingSpinner';
import ErrorMessage from './components/ErrorMessage';
import { useApi } from './hooks/UseApi';
import { customerService } from './service/api';

function App() {
  // Fetch items from backend API

  type Customer = {
    firstName: String,
    lastName: String
  }
  const [customers, setCustomers]  = useState<Customer[]>([]);

  const { data, loading, error } = useApi<ItemData[]>('/api/users');

  useEffect(() => {
    const fetchCustomers = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/users');
        const customerData = await response.json();
        setCustomers(customerData);
      } catch (err) {
        // setError('Failed to fetch products');
        // setLoading(false);
        console.error(err);
      }
    };
    fetchCustomers();
  }, []);
  if (loading) return <LoadingSpinner />;
  if (error) return <ErrorMessage message={error} />;

  return (
    <div className="app" style={{ maxWidth: 800, margin: '2rem auto', padding: '0 1rem' }}>
      <h1>Names List</h1>
      {customers && customers.length > 0 ? (
        customers.map((customer) => <DataCard firstName={customer.firstName} lastName={customer.lastName} />)
      ) : (
        <p>No names found.</p>
      )}
    </div>
  );
}

export default App;
