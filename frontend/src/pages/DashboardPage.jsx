import { useEffect, useState } from "react";
import Header from "../components/Header";
import BalanceCard from "../components/BalanceCard";
import TransactionHistory from "../components/TransactionHistory";
import DepositForm from "../components/DepositForm";
import WithdrawForm from "../components/WithdrawForm";
import AlertMessage from "../components/AlertMessage";
import {
  buscarSaldo,
  buscarHistorico,
  realizarDeposito,
  realizarSaque,
} from "../services/api";

function DashboardPage({ usuario, onLogout }) {
  const [saldoData, setSaldoData] = useState(null);
  const [historico, setHistorico] = useState([]);
  const [alerta, setAlerta] = useState(null);
  const [loading, setLoading] = useState(true);

  async function carregarDados() {
    try {
      setLoading(true);

      const saldoResponse = await buscarSaldo(usuario.id);
      const historicoResponse = await buscarHistorico(usuario.id);

      setSaldoData(saldoResponse);
      setHistorico(historicoResponse);
    } catch (error) {
      setAlerta({
        tipo: "erro",
        mensagem: error.message || "Erro ao carregar dados do dashboard.",
      });
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    carregarDados();
  }, [usuario.id]);

  async function handleDeposito(valor) {
    try {
      const response = await realizarDeposito({
        usuarioId: usuario.id,
        valor: Number(valor),
      });

      setAlerta({
        tipo: "sucesso",
        mensagem: response.message,
      });

      await carregarDados();
    } catch (error) {
      setAlerta({
        tipo: "erro",
        mensagem: error.message || "Erro ao realizar depósito.",
      });
    }
  }

  async function handleSaque(valor) {
    try {
      const response = await realizarSaque({
        usuarioId: usuario.id,
        valor: Number(valor),
      });

      setAlerta({
        tipo: response.alertaGerado ? "alerta" : "sucesso",
        mensagem: response.message,
      });

      await carregarDados();
    } catch (error) {
      setAlerta({
        tipo: "erro",
        mensagem: error.message || "Erro ao realizar saque.",
      });
    }
  }

  return (
    <div className="min-h-screen bg-gray-100">
      <Header usuario={usuario} onLogout={onLogout} />

      <main className="mx-auto max-w-6xl px-4 py-8">
        {alerta && (
          <div className="mb-6">
            <AlertMessage tipo={alerta.tipo} mensagem={alerta.mensagem} />
          </div>
        )}

        {loading ? (
          <div className="rounded-2xl bg-white p-8 text-center shadow-md">
            <p className="text-gray-600">Carregando dashboard...</p>
          </div>
        ) : (
          <div className="space-y-6">
            <BalanceCard saldoData={saldoData} />

            <div className="grid gap-6 lg:grid-cols-2">
              <DepositForm onDeposito={handleDeposito} />
              <WithdrawForm onSaque={handleSaque} />
            </div>

            <TransactionHistory historico={historico} />
          </div>
        )}
      </main>
    </div>
  );
}

export default DashboardPage;