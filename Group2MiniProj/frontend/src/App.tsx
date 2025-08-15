import React from 'react';

import { DataCard, type ItemData } from './components/DataCard';
import LoadingSpinner from './components/LoadingSpinner';
import ErrorMessage from './components/ErrorMessage';
import { useApi } from './hooks/UseApi';

function App() {
  // Fetch items from backend API
  const { data, loading, error } = useApi<ItemData[]>('/api/items');

  if (loading) return <LoadingSpinner />;
  if (error) return <ErrorMessage message={error} />;

  return (
    <div className="app" style={{ maxWidth: 800, margin: '2rem auto', padding: '0 1rem' }}>
      <h1>Items List</h1>
      {data && data.length > 0 ? (
        data.map((item) => <DataCard key={item.id} {...item} />)
      ) : (
        <p>No items found.</p>
      )}
    </div>
  );
}

export default App;
