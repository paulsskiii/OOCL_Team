import React from "react";

export default function Skills() {
  const skills = [
    { title: "HTML & CSS", text: "Building responsive and modern layouts using HTML and CSS." },
    { title: "JavaScript", text: "Creating dynamic and interactive web experiences." },
    { title: "Responsive Web Design", text: "Ensuring websites work seamlessly across devices." }
  ];

  return (
    <section id="skills" className="py-5" style={{ backgroundColor: "#fffafc" }}>
      <div className="container">
        <h2 className="text-center mb-4">Skills</h2>
        <div className="row g-4">
          {skills.map((skill, index) => (
            <div className="col-md-4" key={index}>
              <div className="card text-center shadow-sm">
                <div className="card-body">
                  <h5 className="card-title">{skill.title}</h5>
                  <p className="card-text">{skill.text}</p>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
