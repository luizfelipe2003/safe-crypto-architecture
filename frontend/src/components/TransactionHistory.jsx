function TransactionHistory({ historico }) {
  return (
    <div className="rounded-2xl bg-white p-6 shadow-md">
      <div className="mb-4">
        <h2 className="text-xl font-bold text-gray-800">
          Histórico de Transações
        </h2>
        <p className="text-sm text-gray-500">
          Movimentações registradas no sistema
        </p>
      </div>

      {!historico || historico.length === 0 ? (
        <div className="rounded-xl bg-gray-50 p-4 text-gray-500">
          Nenhuma transação encontrada.
        </div>
      ) : (
        <div className="overflow-x-auto">
          <table className="min-w-full border-separate border-spacing-y-2">
            <thead>
              <tr className="text-left text-sm text-gray-500">
                <th className="px-4 py-2">ID</th>
                <th className="px-4 py-2">Tipo</th>
                <th className="px-4 py-2">Valor</th>
                <th className="px-4 py-2">Data</th>
                <th className="px-4 py-2">Status</th>
              </tr>
            </thead>
            <tbody>
              {historico.map((item) => (
                <tr key={item.idTransacao} className="rounded-xl bg-gray-50">
                  <td className="px-4 py-3 font-medium text-gray-800">
                    {item.idTransacao}
                  </td>
                  <td className="px-4 py-3 text-gray-700">{item.tipo}</td>
                  <td className="px-4 py-3 text-gray-700">
                    R$ {item.valor?.toFixed(2)}
                  </td>
                  <td className="px-4 py-3 text-gray-700">{item.dataHora}</td>
                  <td className="px-4 py-3 font-medium text-green-600">
                    {item.status}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default TransactionHistory;