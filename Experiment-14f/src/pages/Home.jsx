import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("userId");
    if (!user) {
      navigate("/");
      return;
    }

    console.log("Home access granted for userId:", user);
  }, []);

  return (
    <main className="content">
      <section className="card">
        <h2 className="hero-title">Welcome to Home Page</h2>
        <p className="hero-copy">You are signed in and ready to explore the app.</p>
      </section>
    </main>
  );
}

export default Home;