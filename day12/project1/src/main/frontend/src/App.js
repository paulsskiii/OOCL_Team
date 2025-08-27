import React, { useState } from 'react';
import './App.css';

function App() {
  // useState hook to manage the form data.
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    middleName: '',
    occupation: '',
    email: '',
    telNumber: ''
  });

  // useState hook to manage the form submission state.
  const [message, setMessage] = useState('');

  // Handles changes to form inputs and updates the state.
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  // Handles the form submission.
  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage('Submitting...');
    try {
      // The fetch API is used to send a POST request to the Spring backend.
      const response = await fetch('http://localhost:8080/api/personal-details/', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        setMessage('Details saved successfully!');
        // Clear the form after a successful submission.
        setFormData({
          firstName: '',
          lastName: '',
          middleName: '',
          occupation: '',
          email: '',
          telNumber: ''
        });
      } else {
        setMessage('Error saving details. Please try again.');
      }
    } catch (error) {
      console.error('Error:', error);
      setMessage('Network error. Could not connect to the server.');
    }
  };

  return (
    <div className="bg-gradient-to-r from-blue-300 to-purple-500 h-screen flex justify-center items-center">
      <header className="py-8 px-6 max-w-md bg-white bg-opacity-30 rounded-lg shadow-lg backdrop-blur-xl backdrop-filter">
        <h1 className="text-3xl font-extrabold text-center text-gray-800 mb-5">Personal Details Form</h1>
        <form onSubmit={handleSubmit} className="flex flex-col">
          <div className="mb-5">
            <label className="text-gray-700 font-semibold mb-2" >First Name:</label>
            <input className="bg-transparent border rounded-lg shadow border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 py-2 px-4 block w-full appearance-none leading-normal" 
              type="text"
              name="firstName"
              value={formData.firstName}
              onChange={handleChange}
              required
            />
          </div>
          <div className="mb-5">
            <label className="text-gray-700 font-semibold mb-2">Last Name:</label>
            <input className="bg-transparent border rounded-lg shadow border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 py-2 px-4 block w-full appearance-none leading-normal" 
              type="text"
              name="lastName"
              value={formData.lastName}
              onChange={handleChange}
              required
            />
          </div>
          <div className="mb-5">
            <label className="text-gray-700 font-semibold mb-2">Middle Name:</label>
            <input className="bg-transparent border rounded-lg shadow border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 py-2 px-4 block w-full appearance-none leading-normal" 
              type="text"
              name="middleName"
              value={formData.middleName}
              onChange={handleChange}
            />
          </div>
          <div className="mb-5">
            <label className="text-gray-700 font-semibold mb-2">Occupation:</label>
            <input className="bg-transparent border rounded-lg shadow border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 py-2 px-4 block w-full appearance-none leading-normal" 
              type="text"
              name="occupation"
              value={formData.occupation}
              onChange={handleChange}
              required
            />
          </div>
          <div className="mb-5">
            <label className="text-gray-700 font-semibold mb-2">Email:</label>
            <input className="bg-transparent border rounded-lg shadow border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 py-2 px-4 block w-full appearance-none leading-normal" 
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
            />
          </div>
          <div className="mb-5">
            <label className="text-gray-700 font-semibold mb-2">Telephone Number:</label>
            <input className="bg-transparent border rounded-lg shadow border-gray-300 focus:border-indigo-500 focus:ring-2 focus:ring-indigo-200 py-2 px-4 block w-full appearance-none leading-normal" 
              type="tel"
              name="telNumber"
              value={formData.telNumber}
              onChange={handleChange}
              required
            />
          </div>
          <button className="bg-gradient-to-r from-purple-400 to-indigo-500 text-white font-semibold py-2 rounded-lg shadow-md hover:shadow-lg transition duration-300 ease-in-out mb-5" type="submit">Save Details</button>
        </form>
        {message && <p className="message">{message}</p>}
      </header>
    </div>
  );
}

export default App;
