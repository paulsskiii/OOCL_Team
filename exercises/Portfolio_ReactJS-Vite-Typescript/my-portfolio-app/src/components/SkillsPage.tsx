import React from "react";
import ProgressBar from "react-bootstrap/ProgressBar";

function SkillsPage() {
  return (
    <div>
      <ul className="list-group">
        <li className="list-group-item">An item</li>
        <ProgressBar now={60} />
        <li className="list-group-item">A second item</li>
        <li className="list-group-item">A third item</li>
        <li className="list-group-item">A fourth item</li>
        <li className="list-group-item">And a fifth one</li>
      </ul>
    </div>
  );
}

export default SkillsPage;
