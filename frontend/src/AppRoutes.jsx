import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignIn from "./pages/SignIn";
import StudentDashboard from "./src/pages/StudentDashboard";
import ContractorDashboard from "./src/pages/ContractorDashboard";
import ManagementDashboard from "./src/pages/ManagementDashboard";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<SignIn />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/student" element={<StudentDashboard />} />
        <Route path="/contractor" element={<ContractorDashboard />} />
        <Route path="/management" element={<ManagementDashboard />} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;