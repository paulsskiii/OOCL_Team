import React from "react";
import profileImg from "../assets/download.png"; // Place image in src/assets

export default function About() {
  return (
    <section id="about" className="py-5">
      <div className="container text-center">
        <img src={profileImg} alt="My Profile" />
        <h2 className="mt-4">About Me</h2>
        <p className="text-muted">
          Hello! I'm a programmer at OOCL Philippines, 24 years old, and from Taguig City.
        </p>
      </div>
    </section>
  );
}
