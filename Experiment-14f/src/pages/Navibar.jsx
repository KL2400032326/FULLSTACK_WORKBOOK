import { Link, useNavigate } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();
  const userId = localStorage.getItem("userId");

  const logout = () => {
    localStorage.removeItem("userId");
    navigate("/");
  };

  return (
    <nav className="site-nav">
      <div className="brand">Experiment 14f</div>
      <div className="nav-links">
        {userId ? (
          <>
            <Link className="nav-link" to="/home">Home</Link>
            <Link className="nav-link" to="/profile">Profile</Link>
            <button className="nav-button" type="button" onClick={logout}>Logout</button>
          </>
        ) : (
          <>
            <Link className="nav-link" to="/">Login</Link>
            <Link className="nav-link" to="/register">Register</Link>
          </>
        )}
      </div>
    </nav>
  );
}

export default Navbar;