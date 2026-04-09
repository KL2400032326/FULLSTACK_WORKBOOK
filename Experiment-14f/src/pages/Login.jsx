import { useState } from "react";
import axios from "axios";
import { Navigate, useNavigate, Link } from "react-router-dom";

function Login() {
  const [data, setData] = useState({ gmail: "", password: "" });
  const navigate = useNavigate();

  if (localStorage.getItem("userId")) {
    return <Navigate to="/home" replace />;
  }

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/api/login", data)
      .then((res) => {
        console.log("Login response:", res);
        if (res?.data?.id) {
          localStorage.setItem("userId", res.data.id);
          navigate("/home");
        } else {
          alert("Invalid credentials");
        }
      })
      .catch((error) => {
        console.error("Login error:", error);
        alert("Invalid credentials");
      });
  };

  return (
    <main className="content">
      <section className="card">
        <h2>Login</h2>
        <p className="muted">Sign in to continue to your dashboard.</p>
        <form className="auth-form" onSubmit={handleSubmit}>
          <input className="field" name="gmail" placeholder="Email" onChange={handleChange} />
          <input className="field" name="password" type="password" placeholder="Password" onChange={handleChange} />
          <div className="auth-actions">
            <button className="primary-button" type="submit">Login</button>
            <p className="muted">New user? <Link className="auth-link" to="/register">Register</Link></p>
          </div>
        </form>
      </section>
    </main>
  );
}

export default Login;