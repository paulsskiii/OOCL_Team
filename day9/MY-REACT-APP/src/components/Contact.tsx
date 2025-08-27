import React from 'react';
import '../App.css'; 

const Contact: React.FC = () => {
  return (
    <footer id="contact" className="footer-custom">
      <div className="container">
        <p>Contact me at: <a href="mailto:princessferrer@gmail.com" className="text-light">princessferrer@gmail.com</a></p>
        <p className="mb-0">&copy; 2025 Cessycess</p>
      </div>
    </footer>
  );
};

export default Contact;