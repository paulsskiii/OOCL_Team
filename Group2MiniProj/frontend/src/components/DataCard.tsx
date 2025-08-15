import React from 'react';

export type ItemData = {
  firstName: String;
  lastName: String;
};

export const DataCard: React.FC<ItemData> = ({ firstName, lastName }) => {
  return (
    <div className="card">
      
      <div className="meta"><strong>First Name:</strong> {firstName}</div>
      <div className="meta"><strong>Last Name:</strong> {lastName}</div>
      <br />
    </div>
  );
};
