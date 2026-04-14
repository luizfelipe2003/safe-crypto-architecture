import { useState } from "react";

function WithdrawForm({ onSaque }) {
  const [valor, setValor] = useState("");
  const [loading, setLoading] = useState(false);

  async function handleSubmit(event) {
    event.preventDefault();

    if (!valor) return;

    try {
      setLoading(true);
      await onSaque(valor);
      setValor("");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="rounded-2xl bg-white p-6 shadow-md">
      <div className="mb-4">
        <h2 className="text-xl font-bold text-gray-800">Realizar Saque</h2>
        <p className="text-sm text-gray-500">
          Informe um valor para retirar da conta
        </p>
      </div>

      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="mb-1 block text-sm font-medium text-gray-700">
            Valor do saque
          </label>
          <input
            type="number"
            step="0.01"
            min="0"
            value={valor}
            onChange={(e) => setValor(e.target.value)}
            placeholder="Digite o valor"
            required
            className="w-full rounded-xl border border-gray-300 px-4 py-3 outline-none transition focus:border-blue-500"
          />
        </div>

        <button
          type="submit"
          disabled={loading}
          className="w-full rounded-xl bg-yellow-500 px-4 py-3 font-semibold text-white transition hover:bg-yellow-600 disabled:cursor-not-allowed disabled:opacity-60"
        >
          {loading ? "Processando..." : "Sacar"}
        </button>
      </form>
    </div>
  );
}

export default WithdrawForm;