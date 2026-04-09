import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Register() {
  const [user, setUser] = useState({ username: "", gmail: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/api/register", user)
      .then((res) => {
        console.log("Register response:", res);
        alert("Registered Successfully");
        navigate("/");
      })
      .catch((error) => {
        console.error("Register error:", error);
        alert("Registration failed");
      });
  };

  return (
    <main className="content">
      <section className="card">
        <h2>Register</h2>
        <p className="muted">Create an account to start using the app.</p>
        <form className="auth-form" onSubmit={handleSubmit}>
          <input className="field" name="username" placeholder="Username" onChange={handleChange} />
          <input className="field" name="gmail" placeholder="Email" onChange={handleChange} />
          <input className="field" name="password" type="password" placeholder="Password" onChange={handleChange} />
          <div className="auth-actions">
            <button className="primary-button" type="submit">Register</button>
          </div>
        </form>
      </section>
    </main>
  );
}

export default Register;