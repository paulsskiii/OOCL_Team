const DataCard = ({ data }) => {
  return (
    <div className="data-card">
      <div className="data-card-header">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6 package-icon">
          <path strokeLinecap="round" strokeLinejoin="round" d="M3.75 21V12m0 0V7.5M3.75 12h16.5m-16.5 0h-3.75M20.25 12v9m0-9H3.75M3.75 21h16.5M12 3v9m-1.5 0h3M12 3h8.25m-8.25 0h-3.75m4.5 0h-3.75" />
        </svg>
        <span className="data-card-title">Customer Details</span>
      </div>
      <div className="p-4">
        {Object.entries(data).map(([key, value]) => (
          <p key={key} className="text-sm text-gray-700">
            <strong>{key}:</strong> {value}
          </p>
        ))}
      </div>
    </div>
  );
};