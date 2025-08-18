export interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  contactNumber: string;
  emailAddress: string;
  addressLine1: string;
  addressLine2: string | null;
  barangay: string;
  city: string;
  postalCode: string;
  region: string;
  country: string;
}
