import React from 'react';

export type ItemData = {
  id: number;
  item: string;
  description: string;
  deliveryDate: string;
};

export const DataCard: React.FC<ItemData> = ({ id, item, description, deliveryDate }) => {
  return (
    <div className="card">
      <h3>{item}</h3>
      <div className="meta"><strong>ID:</strong> {id}</div>
      <div className="meta"><strong>Description:</strong> {description}</div>
      <div className="meta"><strong>Delivery Date:</strong> {deliveryDate}</div>
    </div>
  );
};
