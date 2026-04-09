import { Navigate, Outlet } from "react-router-dom";

function RequireAuth() {
  const userId = localStorage.getItem("userId");

  if (!userId) {
    return <Navigate to="/" replace />;
  }

  return <Outlet />;
}

export default RequireAuth;