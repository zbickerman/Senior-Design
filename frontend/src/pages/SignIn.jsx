import { useNavigate } from "react-router-dom";

function SignIn() {
  const navigate = useNavigate();

  const handleLogin = (role) => {
    localStorage.setItem("role", role);
    navigate(`/${role}`);
  };

  return (
    <div className="page">
      <h1>PickFix Sign In</h1>
      <p>Temporary Sprint 1 sign-on page</p>

      <div className="button-group">
        <button onClick={() => handleLogin("student")}>
          Sign in as Student
        </button>
        <button onClick={() => handleLogin("contractor")}>
          Sign in as Contractor
        </button>
        <button onClick={() => handleLogin("management")}>
          Sign in as Management
        </button>
      </div>
    </div>
  );
}

export default SignIn;