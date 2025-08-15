import React from 'react';

type Props = {
  message: string;
};

const ErrorMessage: React.FC<Props> = ({ message }) => (
  <div className="error" role="alert">
    {message}
  </div>
);

export default ErrorMessage;
