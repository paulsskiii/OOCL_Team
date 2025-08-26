import Home from '../components/Home';
import Skills from '../components/Skills';

import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";


function Nav() {
  return (
    <>

    <Router>
        <header className="fixed top-0 left-0 w-full px-9 py-4 flex justify-between items-center z-50 bg-transparent">
          <a
            href="#"
            className="text-3xl font-extrabold text-[#ECDFCC] transition-transform duration-300 hover:scale-110"
          >
            RhCali
          </a>

          <nav className="space-x-8">
            <Link to="/" className="text-lg font-medium text-[#ECDFCC] border-b-2 border-transparent hover:border-[#3C3D37] transition"> Home </Link>
            <Link to="/skills" className="text-lg font-medium text-[#ECDFCC] border-b-2 border-transparent hover:border-[#3C3D37] transition"> Skills </Link>
          </nav>

        </header>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/skills" element={<Skills />} />
        </Routes>

      </Router>


      {/* 
      <header className="fixed top-0 left-0 w-full px-9 py-4 flex justify-between items-center z-50 bg-transparent">
        <a
          href="#"
          className="text-3xl font-extrabold text-[#ECDFCC] transition-transform duration-300 hover:scale-110"
        >
          Rhandel
        </a>
        <nav className="space-x-8">
          <a
            href="#"
            className="text-lg font-medium text-[#ECDFCC] border-b-2 border-transparent hover:border-[#3C3D37] transition"
          >
            Home
          </a>
          <a
            href="#about"
            className="text-lg font-medium text-[#ECDFCC] border-b-2 border-transparent hover:border-[#3C3D37] transition"
          >
            Skills
          </a>
        </nav>
      </header> 
      */}
    </>
  );
}

export default Nav;
    