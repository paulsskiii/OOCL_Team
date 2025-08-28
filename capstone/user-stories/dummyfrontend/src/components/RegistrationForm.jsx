import Card from "react-bootstrap/Card";
//import { useState } from "react";
import React, { Component } from "react";

function RegistrationForm() {
  return (
    <div className="d-flex justify-content-center align-items-center bg-light">
      <div className="card p-4 shadow" style={{ width: "22rem" }}>
        <h3 className="text-center mb-4">REGISTER</h3>
        <form>
          <div className="mb-3">
            <label
              htmlFor="email"
              className="form-label d-flex justify-content-start"
            >
              Username
            </label>
            <input
              type="email"
              className="form-control"
              id="email_reg"
              placeholder="Enter your username"
              required
            />
          </div>
          <div className="mb-3">
            <label
              htmlFor="password"
              className="form-label d-flex justify-content-start"
            >
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="password_reg"
              placeholder="Enter your password"
              required
            />
          </div>
          <hr />
          <div className="mb-3">
            <label
              htmlFor="password"
              className="form-label d-flex justify-content-start"
            >
              Email
            </label>
            <input
              type="password"
              className="form-control"
              id="email_reg"
              placeholder="Enter your email"
              required
            />
          </div>
          <div className="mb-3">
            <label
              htmlFor="password"
              className="form-label d-flex justify-content-start"
            >
              Contact Number
            </label>
            <input
              type="password"
              className="form-control"
              id="contact_no_reg"
              placeholder="Enter your phone number"
              required
            />
          </div>
          <button id="signup_button" type="submit" className="btn w-100">
            Sign Up
          </button>
        </form>
        <br />
        <a id="already_has_account" className="d-flex mb-2">
          Already have an account?
        </a>
      </div>
    </div>
  );
}

export default RegistrationForm;
