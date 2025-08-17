import "bootstrap/dist/css/bootstrap.min.css";
import { useState } from "react";
import {
  BrowserRouter as secondRouter,
  Routes,
  Route,
  Link,
} from "react-router-dom";

function BioSection() {
  return (
    <div>
      <dl className="row">
        <dt className="col-sm-3">Name</dt>
        <dd className="col-sm-9">Abi</dd>

        <dt className="col-sm-3">Date of Birth</dt>
        <dd className="col-sm-9">
          <p>hapi birthday</p>
        </dd>

        <dt className="col-sm-3">Type of Person</dt>
        <dd className="col-sm-9">Inverter</dd>

        <dt className="col-sm-3 text-truncate">Additional Information</dt>
        <dd className="col-sm-9">
          Here is a nice secret about Abi that you shouldn't know. She's
          actually a...
        </dd>
      </dl>
    </div>
  );
}

export default BioSection;
