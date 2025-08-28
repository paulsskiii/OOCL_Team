import Card from "react-bootstrap/Card";

function LoginForm() {
  return (
    <div className="d-flex justify-content-center align-items-center bg-light">
      <div className="card p-4 shadow" style={{ width: "22rem" }}>
        <h3 className="text-center mb-4">LOGIN</h3>
        <form>
          <div className="mb-3">
            <label htmlFor="email" className="form-label d-flex">
              Email
            </label>
            <input
              type="email"
              className="form-control"
              id="email_login"
              placeholder="Enter your email"
              required
            />
          </div>
          <div className="">
            <label htmlFor="password" className="form-label d-flex">
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="password_login"
              placeholder="Enter your password"
              required
            />
          </div>
          <a id="forgot_pass" className="d-flex mb-3">
            Forgot your password?
          </a>
          <button
            id="login-btn"
            type="submit"
            className="btn btn-primary w-100"
          >
            Sign In
          </button>
        </form>
        <hr />
        <p className="d-flex">Create an account now</p>
        <button
          id="signup-login-btn"
          type="submit"
          className="btn btn-primary w-100"
        >
          Sign Up
        </button>
      </div>
    </div>
  );
}
export default LoginForm;
