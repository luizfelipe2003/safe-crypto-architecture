import { useState } from "react";
import LoginPage from "./pages/LoginPage";
import DashboardPage from "./pages/DashboardPage";

function App() {
  const [usuarioLogado, setUsuarioLogado] = useState(null);

  function handleLoginSuccess(usuario) {
    setUsuarioLogado(usuario);
  }

  function handleLogout() {
    setUsuarioLogado(null);
  }

  return usuarioLogado ? (
    <DashboardPage usuario={usuarioLogado} onLogout={handleLogout} />
  ) : (
    <LoginPage onLoginSuccess={handleLoginSuccess} />
  );
}

export default App;