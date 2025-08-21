import React from "react";

const Navbar = () => {
  return (
    <section id="nav" className="flex items-center justify-center shadow-md">
      <nav className="fixed bottom-6 border rounded-4xl px-4 py-2 bg-white">
        <ul className="flex gap-4">
          <li>
            <a href="#home">Home</a>
          </li>
          <li>
            <a href="#about">About</a>
          </li>
          <li>
            <a href="#skills">Skills</a>
          </li>
          <li>
            <a href="#project">Project</a>
          </li>
        </ul>
      </nav>
    </section>
  );
};

export default Navbar;
