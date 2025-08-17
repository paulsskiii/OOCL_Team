import React from "react";
import { useState } from "react";

type GreetingProps = {
  name: string;
};

export const Greeting: React.FC<GreetingProps> = ({ name }) => {
  const [age, setAge] = useState(24);
  const [likeFrontEnd, setLikeFrontEnd] = useState("still bad at it...");

  return (
    <div>
      <div className="jumbotron text-center">
        <h1>Hello, {name}</h1>
      </div>
      <hr />
      <div className="row">
        <div className="d-flex align-items-center gap-4 bio">
          <img
            src="./src/assets/sahur-tung-tung-tung-sahur.gif"
            alt="me"
            width="400"
            height="300"
            className="rounded-circle"
          />
          <div>
            Hi, my name is Brian Christian L. Villanueva, {age} years old{" "}
            <button className=".btn-xs" onClick={() => setAge(age + 1)}>
              +1
            </button>
            . My friends call me <em>Biran</em>, I don't know why but I like it.
            I like to build Gundam plastic models during my free time and I also
            do boxing. Initially, I'm bad at front-end, and lately, I realized
            that I am {likeFrontEnd}{" "}
            <a
              href="#"
              className="pe-auto"
              onClick={() => setLikeFrontEnd("actually quite enjoying it now")}
            >
              :D
            </a>
            . Joking aside, I am an avid back-end enjoyer. So far my tech stack
            are of the following:
          </div>
        </div>

        <h1>Technical Skills</h1>
        <hr />
        <ul>
          <li>
            <button className=".btn-primary .btn-xs">Edit</button>
            Languages: Python, Java (and Java EE), MySQL, OracleSQL
          </li>
          <li>Frameworks: Django, DjangoREST, </li>
          <li>Libraries: TesseractOCR, ARIMA, NumPy, Pandas</li>
          <li>
            Tools: Git, IntelliJ, Jupyter Notebook, Render, CISCO Packet Tracer,
            OracleSQL Developer, MySQL Workbench
          </li>
        </ul>
      </div>
    </div>
  );
};
