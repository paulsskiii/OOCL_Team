import Card from "react-bootstrap/Card";
import { useState } from "react";
import React, { Component } from "react";
import toast from "react-hot-toast";

function RegistrationForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [contactNumber, setContactNumber] = useState("");

  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [passwordMessage, setPasswordMessage] = useState("");

  const [isInvalidEmail, setIsInvalidEmail] = useState(true);
  const [isInvalidPassword, setIsInvalidPassword] = useState(true);

  const API_URL = "http://localhost:8080/api/register";

  const [newUser, setNewUser] = useState({
    username: "",
    password: "",
    email: "",
    contactNumber: "",
  });
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (isInvalidEmail) {
        toast.error("Invalid email");
        throw new Error("Failed to add user");
      }
      if (isInvalidPassword) {
        toast.error(
          "Password should contain atleast one uppercase letter and one number"
        );
        throw new Error("Failed to add user");
      }
      const response = await fetch(API_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newUser),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      console.log(newUser);
    } catch (e) {
      console.error("Failed to add user:", e);
      setError("Failed to add new user. Please check the backend.");
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    if (name === "email") {
      setIsInvalidEmail(true);
      if (/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/.test(value)) {
        setIsInvalidEmail(false);
      }
    }
    if (name === "password") {
      setIsInvalidPassword(true);
      if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/.test(value)) {
        setIsInvalidPassword(false);
      }
    }
    setNewUser((prev) => ({ ...prev, [name]: value }));
  };

  return (
    <section className="registration_form h-full bg-neutral-200 dark:bg-neutral-700 ">
      <div className="container h-full p-10 ">
        <div className="g-6 flex h-full flex-wrap items-center justify-center text-neutral-800 dark:text-neutral-200 w-full block rounded-lg bg-white shadow-lg dark:bg-neutral-800 g-0 lg:flex lg:flex-wrap">
          <div className="g-0 lg:flex lg:flex-wrap">
            {/* <!-- Left column container--> */}
            <div className="px-4 md:px-0 my:px-12 lg:w-6/12">
              <div className="md:mx-6 md:p-12 my:px-12">
                <form onSubmit={handleSubmit}>
                  {/* <!--Username input--> */}
                  <div className="text-center">
                    <h4 className="mb-12 py-4 pb-1 text-xl font-semibold">
                      Create an account
                    </h4>
                  </div>
                  <div className="mb-4">
                    <label
                      htmlFor="username"
                      className="form-label d-flex justify-content-start"
                    >
                      Username
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="username_reg"
                      placeholder="Enter your username"
                      onChange={handleInputChange}
                      name="username"
                      value={newUser.username}
                      required
                    />
                  </div>

                  {/* <!--Password input--> */}
                  <div className="mb-4">
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
                      onChange={handleInputChange}
                      name="password"
                      value={newUser.password}
                      required
                    />
                  </div>

                  {/* <!-- Email Input --> */}
                  <hr />
                  <div className="mb-4">
                    <label
                      htmlFor="email"
                      className="form-label d-flex justify-content-start"
                    >
                      Email
                    </label>
                    <input
                      type="email"
                      className="form-control"
                      id="email_reg"
                      placeholder="Enter your email"
                      onChange={handleInputChange}
                      name="email"
                      value={newUser.email}
                      required
                    />
                  </div>

                  {/* <!-- Contact Number --> */}
                  <div className="mb-3">
                    <label
                      htmlFor="contact_number"
                      className="form-label d-flex justify-content-start"
                    >
                      Contact Number
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="contact_no_reg"
                      placeholder="Enter your phone number"
                      onChange={handleInputChange}
                      name="contactNumber"
                      value={newUser.contactNumber}
                      required
                    />
                  </div>

                  {/* <!--Submit button--> */}
                  <div className="mb-12 pb-1 pt-1 text-center">
                    <button
                      id="signup_button"
                      type="submit"
                      className="btn btn-warning w-100"
                      style={{
                        background: "#F7E6CA",
                      }}
                    >
                      Sign up
                    </button>
                    <a
                      id="already_has_account"
                      className="d-flex my-4 h-12"
                      href="/"
                    >
                      Already have an account?
                    </a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default RegistrationForm;
