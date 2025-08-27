import { useState } from 'react';


function CargoForm() {
  // useState hook to manage the form data.
  const [formData, setFormData] = useState({
    name: '',
    weight: 0,
    origin: '',
    destination: ''
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
    console.log(formData);
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
            name: '',
            weight: 0,
            origin: '',
            destination: ''
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
        <div className="App">
      <header className="App-header">
        <h1>Cargo Form</h1>
        <form onSubmit={handleSubmit} className="personal-details-form">
          <div className="form-group">
            <label>Name:</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
            />
            <input type="text" placeholder="Type here" className="input" />
          </div>
          <div className="form-group">
            <label>Weight:</label>
            <input
              type="number"
              name="weight"
              value={formData.weight}
              onChange={handleChange}
              required
            />
          </div>
          <div className="form-group">
            <label>Origin:</label>
            <input
              type="text"
              name="origin"
              value={formData.origin}
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <label>Destination:</label>
            <input
              type="text"
              name="destination"
              value={formData.destination}
              onChange={handleChange}
              required
            />
          </div>
          <button type="submit">Save Details</button>
        </form>
        {message && <p className="message">{message}</p>}
      </header>
    </div>
    )
}

export default CargoForm;