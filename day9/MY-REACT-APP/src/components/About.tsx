import React from 'react';
import '../App.css'; 

const About: React.FC = () => {
  return (
    <section id="about" className="py-5">
      <div className="container text-center">
        <img src="download.png" alt="My Profile Picture" className="profile-img"/>
        <h2 className="mt-4">About Me</h2>
        <p className="text-muted">Hello! I'm a programmer at OOCL Philippines, 24 years old, and from Taguig City.</p>
      </div>
    </section>
  );
};

export default About;