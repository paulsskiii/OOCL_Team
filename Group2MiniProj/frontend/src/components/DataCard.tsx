import React from "react";
import type { Customer } from "../types/index.js";

interface DataCardProps {
  data: Customer;
}

const DataCard: React.FC<DataCardProps> = ({ data }) => {
  // Helper function to format field names
  const formatFieldName = (key: string): string => {
    return key
      .replace(/([A-Z])/g, ' $1')
      .replace(/^./, (str) => str.toUpperCase())
      .trim();
  };

  // Helper function to format field values
  const formatFieldValue = (value: any): string => {
    if (value === null || value === undefined) return "N/A";
    return String(value);
  };

  return (
    <div className="data-card">
      <div className="data-card-header">
        <div className="header-content">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="package-icon"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z"
            />
          </svg>
          <span className="data-card-title">Customer Profile</span>
        </div>
      </div>
      
      <div className="data-card-body">
        {Object.entries(data).map(([key, value]) => (
          <div key={key} className="data-field">
            <span className="field-label">{formatFieldName(key)}</span>
            <span className="field-value">{formatFieldValue(value)}</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default DataCard;
