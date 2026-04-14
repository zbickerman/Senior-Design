import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import SignIn from "./pages/SignIn";
import AuthForm from "./pages/AuthForm";
import StudentDashboard from "./pages/StudentDashboard";
import ContractorDashboard from "./pages/ContractorDashboard";
import ManagementDashboard from "./pages/ManagementDashboard";

const ProtectedRoute = ({ role, children }) => {
  const storedRole = localStorage.getItem("role");
  if (storedRole !== role) return <Navigate to="/signin" replace />;
  return children;
};

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<SignIn />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signin/:role" element={<AuthForm />} />
        <Route
          path="/student"
          element={<ProtectedRoute role="student"><StudentDashboard /></ProtectedRoute>}
        />
        <Route
          path="/contractor"
          element={<ProtectedRoute role="contractor"><ContractorDashboard /></ProtectedRoute>}
        />
        <Route
          path="/management"
          element={<ProtectedRoute role="management"><ManagementDashboard /></ProtectedRoute>}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;