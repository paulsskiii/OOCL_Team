import { useState } from "react";
import DataCard from "./components/DataCard.js";
import ErrorMessage from "./components/ErrorMessage.js";
import { useApi } from "./hooks/useApi.js";
import "./App.css";

const App = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const [apiEndpoint, setApiEndpoint] = useState('/api/data');
  const { data, loading, error, refetch } = useApi(apiEndpoint);

  const handleSearch = () => {
    if (searchQuery.trim()) {
      setApiEndpoint(`/api/data/${searchQuery.trim()}`);
    } else {
      setApiEndpoint('/api/data');
    }
  };

  const handleRefresh = () => {
    setApiEndpoint('/api/data');
    setSearchQuery('');
    refetch();
  };

  const handleKeyPress = (e: React.KeyboardEvent) => {
    if (e.key === 'Enter') {
      handleSearch();
    }
  };

  return (
    <div className="app-container">
      {/* Header and Navigation */}
      <header className="app-header">
        <div className="logo">DIVA Shipping</div>
        <nav className="nav-menu">
          <a href="#home">HOME</a>
          <a href="#packages">PACKAGES</a>
          <a href="#courier">COURIER</a>
          <a href="#about" className="about-us">ABOUT US</a>
        </nav>
      </header>

      {/* Hero and Search Section */}
      <section className="search-section">
        <div className="hero-section">
          <h1 className="hero-title">Customer Management System</h1>
          <p className="hero-subtitle">
            Efficiently manage and search through your customer database. 
            Find customer details quickly and easily with our advanced search capabilities.
          </p>
        </div>
        
        <div className="search-container">
          <div className="search-box">
            <input
              type="text"
              placeholder="🔍 Search customers by ID (e.g., 1, 2, 3, 4)"
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              onKeyPress={handleKeyPress}
            />
            <button onClick={handleSearch} title="Search">
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor">
                <path strokeLinecap="round" strokeLinejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
              </svg>
            </button>
          </div>
        </div>
      </section>

      {/* Main Content */}
      <main className="main-content">
        <div className="content-header">
          <h2 className="content-title">Customer Directory</h2>
          <button className="refresh-button" onClick={handleRefresh} title="Refresh Data">
            Refresh Data
          </button>
        </div>
        
        <div className="data-grid">
          {loading && (
            <div className="loading-spinner">
              <div className="spinner"></div>
              <p className="loading-text">Loading customer data...</p>
            </div>
          )}
          
          {error && (
            <ErrorMessage message="Failed to fetch customer data. Please try again later." />
          )}
          
          {data && Array.isArray(data) && data.length > 0 ? (
            data.map((item) => (
              <DataCard key={item.id} data={item} />
            ))
          ) : (
            data && !Array.isArray(data) ? (
              <DataCard data={data} />
            ) : (
              !loading && !error && (
                <div className="no-data-message">
                  <p>🔍 No customers found. Try searching with a different ID or refresh the data.</p>
                </div>
              )
            )
          )}
        </div>
      </main>
      
      {/* Footer */}
      <footer className="app-footer">
        <div className="footer-content">
          <h3>DIVA Shipping</h3>
          <p>
            Your trusted partner in customer management and logistics solutions. 
            We provide comprehensive tools to help you manage your customer relationships effectively.
          </p>
          <p className="copyright">© 2025 DIVA Shipping. All rights reserved.</p>
        </div>
      </footer>
    </div>
  );
};

export default App;
