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
      <h1>Items List</h1>
      {data && data.length > 0 ? (
        // data.map((customer) => <DataCard key={customer.} {...item} />)
        <ul className="fruit-list">

        {customers.map((customer, index) => (
          <li key={index} className="fruit-item">
            {customer.firstName} - {customer.lastName}
          </li>
        ))}
      </ul>
      ) : (
        <p>No items found.</p>
      )}
    </div>
  );
}

export default App;
