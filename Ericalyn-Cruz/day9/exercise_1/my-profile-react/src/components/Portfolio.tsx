import React from "react";

const Portfolio: React.FC = () => {
  return (
    <div className="container mt-5">

      {/* Hero Section */}
      <section className="text-center mb-5">
        <h1 className="display-4 fw-bold">Ericalyn Cruz</h1>
        <h4 className="text-muted">Programmer</h4>
        <p className="lead mt-3">
          Welcome to my portfolio! I love creating clean, responsive, and efficient applications.
        </p>
        <a href="#projects" className="btn btn-primary btn-lg mt-3">
          View Projects 🚀
        </a>
      </section>

      {/* Projects Section */}
      <section id="projects">
        <h2 className="fw-bold mb-3">Projects</h2>
        <p className="text-muted">Recent Work</p>

        <div className="row g-4">
          {/* Project 1 */}
          <div className="col-md-4">
            <div className="card h-100 shadow-sm border-0">
              <img
                src="/images/image.png"
                className="card-img-top"
                alt="Portfolio Website Screenshot"
              />
              <div className="card-body">
                <h5 className="card-title fw-bold">Details</h5>
                <p className="card-text">
                  Should contains details about me.
                </p>
              </div>
              <div className="card-footer bg-transparent border-0">
                <a href="#" className="btn btn-outline-primary btn-sm">View Details</a>
              </div>
            </div>
          </div>

          {/* Project 2 */}
          <div className="col-md-4">
            <div className="card h-100 shadow-sm border-0">
              <img
                src="/images/image.png"
                className="card-img-top"
                alt="E-commerce App Screenshot"
              />
              <div className="card-body">
                <h5 className="card-title fw-bold">Details</h5>
                <p className="card-text">
                  Should contains details about me.
                </p>
              </div>
              <div className="card-footer bg-transparent border-0">
                <a href="#" className="btn btn-outline-primary btn-sm">View Details</a>
              </div>
            </div>
          </div>

          {/* Project 3 */}
          <div className="col-md-4">
            <div className="card h-100 shadow-sm border-0">
              <img
                src="/images/image.png"
                className="card-img-top"
                alt="Blog Platform Screenshot"
              />
              <div className="card-body">
                <h5 className="card-title fw-bold">Details</h5>
                <p className="card-text">
                  Should contains details about me.
                </p>
              </div>
              <div className="card-footer bg-transparent border-0">
                <a href="#" className="btn btn-outline-primary btn-sm">View Details</a>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="text-center mt-5 py-4 border-top">
        <p className="mb-0">
          &copy; {new Date().getFullYear()} Ericalyn Cruz. All rights reserved.
        </p>
      </footer>
    </div>
  );
};

export default Portfolio;
