import React from "react";

type ProjectProps = {
  techStack1: string;
  techStack2: string;
  techStack3: string;
};

export const Project: React.FC<ProjectProps> = ({
  techStack1,
  techStack2,
  techStack3,
}) => {
  return (
    <div>
      <div className="row">
        <h1>Projects</h1>
        <hr />
        <div className="col-sm-4">
          <h3>Centro Secretariat</h3>
          <p>
            A web-based scholarship management system for Taguig that
            incorporates Time-series forecasting, and at the same time uses RPA
            (Robotic Processing Automation) for processing scholastic documents
            submitted by the scholars. It uses various image pre-processing
            techniques in coordination with TesseractOCR.
          </p>
        </div>

        <div className="col-sm-4">
          <h3>Fincy</h3>
          <p>
            A tell-tale like game based learning focused on providing a gamified
            medium for introducing financial literacy for students.
          </p>
        </div>

        <div className="col-sm-4">
          <h3>Nursing Home Management Information System</h3>
          <p>
            A web-based application for bridging virtual visitation for the aged
            and their families, and at the same time a portal for incoporating
            online health consulting. Developed as my year-end project during
            Senior High.
          </p>
        </div>
      </div>

      <div className="row">
        <div className="col-sm-4">
          <button
            id="btn-for-techStack1"
            onClick={() => alert(`${techStack1}`)}
            className="btn btn-primary"
          >
            Show tech stack used
          </button>
        </div>

        <div className="col-sm-4">
          <button
            id="btn-for-techStack2"
            onClick={() => alert(`${techStack2}`)}
            className="btn btn-primary"
          >
            Show tech stack used
          </button>
        </div>

        <div className="col-sm-4">
          <button
            id="btn-for-techStack3"
            onClick={() => alert(`${techStack3}`)}
            className="btn btn-primary"
          >
            Show tech stack used
          </button>
        </div>
      </div>
    </div>
  );
};
