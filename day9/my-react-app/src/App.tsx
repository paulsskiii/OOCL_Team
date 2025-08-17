import { Greeting } from "./components/Greeting";
import { Project } from "./components/Project";
import Audio from "./components/Audio";

import React from "react";

function App() {
  return (
    <React.Fragment>
      <Greeting name="VILLA<BR/>" />
      <Project
        techStack1="DjangoREST, TesseractOCR, ARIMA, PostgreSQL, ReactJS"
        techStack2="Python, Google Analytics API (Universal Analytics)"
        techStack3="Java Server Pages (JSP), Java Servlets, HTML5, CSS3, MySQL"
      />
      <Audio />
    </React.Fragment>
  );
}

export default App;
