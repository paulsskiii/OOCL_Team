import React from "react";
import proj1 from "../assets/image (7).png";
import proj2 from "../assets/image (2).png";
import proj3 from "../assets/image (6).png";

export default function Projects() {
  const projects = [
    { img: proj1, title: "Barangay Web Application", text: "A showcase of my work and achievements." },
    { img: proj2, title: "E-commerce Store", text: "An online store with secure payment integration." },
    { img: proj3, title: "MedExpress Online shop", text: "An online store for medicine." }
  ];

  return (
    <section id="projects" className="py-5">
      <div className="container">
        <h2 className="text-center mb-4">Projects</h2>
        <div className="row g-4">
          {projects.map((proj, index) => (
            <div className="col-md-4" key={index}>
              <div className="card shadow-sm">
                <img src={proj.img} className="card-img-top" alt={proj.title} />
                <div className="card-body">
                  <h5 className="card-title">{proj.title}</h5>
                  <p className="card-text">{proj.text}</p>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
