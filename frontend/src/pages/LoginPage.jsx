import LoginForm from "../components/LoginForm";

function LoginPage({ onLoginSuccess }) {
  return (
    <div className="flex min-h-screen items-center justify-center bg-gray-100 px-4">
      <div className="w-full max-w-5xl overflow-hidden rounded-3xl bg-white shadow-2xl">
        <div className="grid min-h-[600px] md:grid-cols-2">
          <div className="flex flex-col justify-center bg-blue-700 p-10 text-white">
            <h1 className="text-4xl font-bold leading-tight">
              SafeCrypto Architecture
            </h1>
            <p className="mt-4 text-base text-blue-100">
              Protótipo acadêmico desenvolvido para representar uma plataforma
              segura de gestão de criptoativos, com foco em autenticação,
              auditoria, monitoramento e controle das operações.
            </p>

            <div className="mt-8 space-y-3 text-sm text-blue-100">
              <p>• Login com MFA simulado</p>
              <p>• Consulta de saldo e histórico</p>
              <p>• Depósito e saque</p>
              <p>• Alerta de risco em operações críticas</p>
            </div>
          </div>

          <div className="flex items-center justify-center bg-gray-100 p-8">
            <LoginForm onLoginSuccess={onLoginSuccess} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;