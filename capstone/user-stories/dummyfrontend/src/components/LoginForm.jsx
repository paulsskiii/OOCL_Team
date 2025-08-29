import { useState } from "react";
import Card from "react-bootstrap/Card";
import toast from "react-hot-toast";

function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [userLogin, setUserLogin] = useState({
    username: "",
    password: "",
  });
  const API_URL = "http://localhost:8080/api/login";
  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch(API_URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userLogin),
    });
    const returnedUser = await response.json();
    if (!response.ok) {
      console.log(returnedUser);
      toast.alert("Invalid login credentials");
      throw new Error(`HTTP error! status: ${response.status}`);
    } else {
      console.log(returnedUser);
      localStorage.setItem("user", response.data);
      console.log(response.data);
    }
    console.log(userLogin);
  };
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUserLogin((prev) => ({ ...prev, [name]: value }));
    console.log("hi");
  };

  return (
    <section className="login_form h-full bg-neutral-200 dark:bg-neutral-700 ">
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
                      Login
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
                      value={userLogin.username}
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
                      value={userLogin.password}
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
                      id="create_an_account"
                      className="d-flex my-4 h-12"
                      href="/register"
                    >
                      Create an account now.
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
export default LoginForm;
