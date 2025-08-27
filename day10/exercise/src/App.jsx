const App = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const [apiEndpoint, setApiEndpoint] = useState('/api/data');
  const { data, loading, error, refetch } = useApi(apiEndpoint);

  const handleSearch = () => {
    if (searchQuery) {
      setApiEndpoint(`/api/data/${searchQuery}`);
    } else {
      setApiEndpoint('/api/data');
    }
  };

  const handleRefresh = () => {
    setApiEndpoint('/api/data'); // Reset endpoint to fetch all data
    refetch(); // Trigger the fetch
  };

  return (
    <>
      <style>
        {`
          /* General Styles */
          @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700;800&display=swap');

          body {
            font-family: 'Inter', sans-serif;
            margin: 0;
            background-color: #f5f7fa; /* Very light gray */
          }

          .app-container {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background: linear-gradient(135deg, #e0eafc, #c8d8f0); /* Subtle gradient background */
          }

          /* Header */
          .app-header {
            background-color: #1a2a47; /* Dark navy blue */
            color: #ffffff;
            padding: 1.5rem 3rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
          }

          .logo {
            font-weight: 800;
            font-size: 2rem;
            letter-spacing: -1.5px;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.1);
          }

          .nav-menu a {
            color: #b0c4de;
            text-decoration: none;
            margin-left: 2.5rem;
            font-weight: 500;
            transition: color 0.3s ease-in-out;
          }

          .nav-menu a:hover {
            color: #ffffff;
          }

          .nav-menu .about-us {
            background: linear-gradient(90deg, #f89617, #f17a00); /* Orange gradient */
            color: #ffffff;
            padding: 0.75rem 1.5rem;
            border-radius: 999px;
            font-weight: 600;
            transition: transform 0.2s, box-shadow 0.2s;
            box-shadow: 0 4px 10px rgba(248, 150, 23, 0.4);
          }
          
          .nav-menu .about-us:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(248, 150, 23, 0.5);
          }

          /* Search Section */
          .search-section {
            padding: 3rem 2rem;
            display: flex;
            justify-content: center;
          }

          .search-box {
            display: flex;
            width: 100%;
            max-width: 700px;
            background-color: #ffffff;
            border-radius: 999px;
            overflow: hidden;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
            border: 1px solid #d0dbe9;
          }

          .search-box input {
            flex-grow: 1;
            border: none;
            padding: 1rem 2rem;
            outline: none;
            font-size: 1rem;
            color: #333;
          }

          .search-box button {
            background-color: #ffffff;
            border: none;
            padding: 0 1.5rem;
            cursor: pointer;
            transition: background-color 0.2s;
          }
          
          .search-box button:hover {
            background-color: #f0f4f8;
          }

          .search-box button svg {
            width: 24px;
            height: 24px;
            color: #1a2a47;
          }

          /* Main Content */
          .main-content {
            padding: 2rem;
          }
          
          .content-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
          }

          .content-title {
            font-size: 2rem;
            font-weight: 700;
            color: #1a2a47;
          }
          
          .refresh-button {
            background: linear-gradient(90deg, #f89617, #f17a00);
            color: white;
            border: none;
            padding: 0.75rem 1.5rem;
            border-radius: 0.5rem;
            font-weight: 600;
            cursor: pointer;
            transition: transform 0.2s, box-shadow 0.2s;
            box-shadow: 0 4px 10px rgba(248, 150, 23, 0.4);
          }
          
          .refresh-button:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(248, 150, 23, 0.5);
          }

          .data-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 2.5rem;
          }

          /* Data Card */
          .data-card {
            background-color: #ffffff;
            border-radius: 1.5rem;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s ease-in-out, box-shadow 0.3s;
            border: 1px solid #e0eafc;
          }

          .data-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
          }
          
          .data-card-header {
            background-color: #f0f4f8;
            background: linear-gradient(90deg, #f0f4f8, #e3e8ee);
            display: flex;
            align-items: center;
            gap: 1rem;
            padding: 1rem 2rem;
            border-bottom: 1px solid #d0dbe9;
          }
          
          .data-card-title {
            font-weight: 600;
            color: #1a2a47;
            font-size: 1.1rem;
          }
          
          .package-icon {
            width: 24px;
            height: 24px;
            color: #f89617;
          }
          
          .p-4 {
            padding: 1.5rem;
          }
          
          .text-sm {
            font-size: 0.95rem;
          }
          
          strong {
            color: #1a2a47;
          }

          /* Loading and Error */
          .loading-spinner, .error-message {
            grid-column: 1 / -1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 4rem;
            text-align: center;
            color: #555;
          }

          .spinner {
            border: 4px solid rgba(26, 42, 71, 0.1);
            width: 40px;
            height: 40px;
            border-radius: 50%;
            border-left-color: #f89617;
            animation: spin 1s ease infinite;
          }

          @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
          }
        `}
      </style>
      <div className="app-container">
        {/* Header and Navigation */}
        <header className="app-header">
          <div className="logo">DIVA Shipping</div>
          <nav className="nav-menu">
            <a href="#">HOME</a>
            <a href="#">PACKAGE</a>
            <a href="#">COURIER</a>
            <a href="#" className="about-us">ABOUT US</a>
          </nav>
        </header>

        {/* Search Section */}
        <div className="search-section">
          <div className="search-box">
            <input
              type="text"
              placeholder="Search by ID"
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
            <button onClick={handleSearch}>
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                <path strokeLinecap="round" strokeLinejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
              </svg>
            </button>
          </div>
        </div>

        {/* Main Content */}
        <main className="main-content">
          <div className="content-header">
            <h2 className="content-title">Customers</h2>
            <button className="refresh-button" onClick={handleRefresh}>Refresh Data</button>
          </div>
          <div className="data-grid">
            {loading && <LoadingSpinner />}
            {error && <ErrorMessage message="Failed to fetch data. Please try again later." />}
            {data && Array.isArray(data) && data.length > 0 ? (
              data.map((item) => <DataCard key={item.id} data={item} />)
            ) : (
              data && !Array.isArray(data) ? <DataCard data={data} /> : <p>No data to display.</p>
            )}
          </div>
        </main>
      </div>
    </>
  );
};

export default App;
