import { useState } from "react";
import { login } from "../services/api";

function LoginForm({ onLoginSuccess }) {
  const [formData, setFormData] = useState({
    email: "",
    senha: "",
    mfaCode: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  function handleChange(event) {
    const { name, value } = event.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setError("");
    setLoading(true);

    try {
      const response = await login(formData);

      const usuarioMockado = {
        id: formData.email === "pedro@safecrypto.com" ? 2 : 1,
        nome: response.nomeUsuario,
        email: formData.email,
      };

      onLoginSuccess(usuarioMockado);
    } catch (err) {
      setError(err.message || "Falha ao realizar login");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="w-full max-w-md rounded-2xl bg-white p-8 shadow-lg">
      <div className="mb-6 text-center">
        <h2 className="text-2xl font-bold text-gray-800">Entrar no SafeCrypto</h2>
        <p className="mt-2 text-sm text-gray-500">
          Acesse a plataforma segura de gestão de criptoativos
        </p>
      </div>

      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="mb-1 block text-sm font-medium text-gray-700">
            E-mail
          </label>
          <input
            type="email"
            name="email"
            placeholder="Digite seu e-mail"
            value={formData.email}
            onChange={handleChange}
            required
            className="w-full rounded-xl border border-gray-300 px-4 py-3 outline-none transition focus:border-blue-500"
          />
        </div>

        <div>
          <label className="mb-1 block text-sm font-medium text-gray-700">
            Senha
          </label>
          <input
            type="password"
            name="senha"
            placeholder="Digite sua senha"
            value={formData.senha}
            onChange={handleChange}
            required
            className="w-full rounded-xl border border-gray-300 px-4 py-3 outline-none transition focus:border-blue-500"
          />
        </div>

        <div>
          <label className="mb-1 block text-sm font-medium text-gray-700">
            Código MFA
          </label>
          <input
            type="text"
            name="mfaCode"
            placeholder="Digite o código MFA"
            value={formData.mfaCode}
            onChange={handleChange}
            required
            className="w-full rounded-xl border border-gray-300 px-4 py-3 outline-none transition focus:border-blue-500"
          />
        </div>

        {error && (
          <div className="rounded-xl bg-red-100 px-4 py-3 text-sm text-red-700">
            {error}
          </div>
        )}

        <button
          type="submit"
          disabled={loading}
          className="w-full rounded-xl bg-blue-600 px-4 py-3 font-semibold text-white transition hover:bg-blue-700 disabled:cursor-not-allowed disabled:opacity-60"
        >
          {loading ? "Entrando..." : "Entrar"}
        </button>
      </form>

      <div className="mt-6 rounded-xl bg-gray-50 p-4 text-sm text-gray-600">
        <p className="font-semibold text-gray-700">Usuários para teste:</p>
        <p className="mt-2">luiz@safecrypto.com / 123456 / 999999</p>
        <p>pedro@safecrypto.com / 654321 / 888888</p>
      </div>
    </div>
  );
}

export default LoginForm;