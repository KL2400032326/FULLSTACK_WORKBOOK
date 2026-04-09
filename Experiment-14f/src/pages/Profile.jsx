import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Profile() {
  const [user, setUser] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    const id = localStorage.getItem("userId");

    if (!id) {
      navigate("/");
    } else {
      axios.get(`http://localhost:8080/api/user/${id}`)
        .then((res) => {
          console.log("Profile response:", res);
          setUser(res.data);
        })
        .catch((error) => {
          console.error("Profile error:", error);
          alert("Failed to load profile");
        });
    }
  }, []);

  return (
    <main className="content">
      <section className="card">
        <h2 className="hero-title">Profile</h2>
        <p className="muted">Your account details are shown below.</p>
        <div className="profile-list">
          <div className="profile-item">Username: {user.username}</div>
          <div className="profile-item">Email: {user.gmail}</div>
        </div>
      </section>
    </main>
  );
}

export default Profile;