function BalanceCard({ saldoData }) {
  if (!saldoData) {
    return (
      <div className="rounded-2xl bg-white p-6 shadow-md">
        <p className="text-gray-500">Nenhuma informação de saldo disponível.</p>
      </div>
    );
  }

  return (
    <div className="rounded-2xl bg-white p-6 shadow-md">
      <div className="mb-4">
        <h2 className="text-xl font-bold text-gray-800">Saldo da Conta</h2>
        <p className="text-sm text-gray-500">
          Informações principais da conta do usuário
        </p>
      </div>

      <div className="grid gap-4 md:grid-cols-3">
        <div className="rounded-xl bg-gray-50 p-4">
          <p className="text-sm text-gray-500">Usuário</p>
          <p className="mt-1 font-semibold text-gray-800">
            {saldoData.nomeUsuario}
          </p>
        </div>

        <div className="rounded-xl bg-gray-50 p-4">
          <p className="text-sm text-gray-500">Conta</p>
          <p className="mt-1 font-semibold text-gray-800">
            {saldoData.numeroConta}
          </p>
        </div>

        <div className="rounded-xl bg-gray-50 p-4">
          <p className="text-sm text-gray-500">Status</p>
          <p className="mt-1 font-semibold text-green-600">
            {saldoData.statusConta}
          </p>
        </div>
      </div>

      <div className="mt-6 rounded-2xl bg-blue-600 p-6 text-white">
        <p className="text-sm text-blue-100">Saldo atual</p>
        <h3 className="mt-2 text-3xl font-bold">
          R$ {saldoData.saldo?.toFixed(2)}
        </h3>
      </div>
    </div>
  );
}

export default BalanceCard;