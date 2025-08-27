import React from 'react';
import '../App.css'; 

const Projects: React.FC = () => {
  return (
    <section id="projects" className="py-5">
      <div className="container">
        <h2 className="text-center mb-4">Projects</h2>
        <div className="row g-4">
          <div className="col-md-4">
            <div className="card shadow-sm">
              <img src="image (7).png" className="card-img-top" alt="Project"/>
              <div className="card-body">
                <h5 className="card-title">Barangay Web Application</h5>
                <p className="card-text">A showcase of my work and achievements.</p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card shadow-sm">
              <img src="image (6).png" className="card-img-top" alt="Project"/>
              <div className="card-body">
                <h5 className="card-title">E-commerce Store</h5>
                <p className="card-text">An online store with secure payment integration.</p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card shadow-sm">
              <img src="image (2).png" className="card-img-top" alt="Project"/>
              <div className="card-body">
                <h5 className="card-title">MedExpress Online shop</h5>
                <p className="card-text">An online store for medicine.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Projects;