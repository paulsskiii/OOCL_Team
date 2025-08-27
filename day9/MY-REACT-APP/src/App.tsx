import React from 'react';
import Navbar from './components/Navbar';
import Header from './components/Header';
import About from './components/About';
import Skills from './components/Skills';
import Projects from './components/Projects';
import Contact from './components/Contact';
import './App.css';

// Main App component that renders all the sections.
const App: React.FC = () => {
  return (
    <>
      <Navbar />
      <Header />
      <main>
        <About />
        <Skills />
        <Projects />
      </main>
      <Contact />
    </>
  );
};

export default App;