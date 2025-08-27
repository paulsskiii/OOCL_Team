import React from 'react';
import '../App.css'; 

const Skills: React.FC = () => {
  return (
    <section id="skills" className="py-5 skills-custom">
      <div className="container">
        <h2 className="text-center mb-4">Skills</h2>
        <div className="row g-4">
          <div className="col-md-4">
            <div className="card text-center shadow-sm">
              <div className="card-body">
                <h5 className="card-title">HTML & CSS</h5>
                <p className="card-text">Building responsive and modern layouts using HTML and CSS.</p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card text-center shadow-sm">
              <div className="card-body">
                <h5 className="card-title">JavaScript</h5>
                <p className="card-text">Creating dynamic and interactive web experiences.</p>
              </div>
            </div>
          </div>
          <div className="col-md-4">
            <div className="card text-center shadow-sm">
              <div className="card-body">
                <h5 className="card-title">Responsive Web Design</h5>
                <p className="card-text">Ensuring websites work seamlessly across devices.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Skills;