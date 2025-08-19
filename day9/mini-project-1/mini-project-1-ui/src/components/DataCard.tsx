import { Card } from "antd";

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

export const DataCard: React.FC<CustomerProps> = (customerData) => {
  const { firstName, lastName, ...otherData } = customerData;

  return (
    <Card title={`${firstName} ${lastName}`} variant="borderless">
      {Object.entries(otherData).map(([key, value]) => (
        <p key={key}>
          <strong>{key}:</strong> {String(value)}
        </p>
      ))}
    </Card>
  );
};
