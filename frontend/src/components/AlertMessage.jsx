function AlertMessage({ tipo, mensagem }) {
  const estilos = {
    sucesso: "bg-green-100 text-green-800 border-green-300",
    erro: "bg-red-100 text-red-800 border-red-300",
    alerta: "bg-yellow-100 text-yellow-800 border-yellow-300",
  };

  const classe = estilos[tipo] || "bg-gray-100 text-gray-800 border-gray-300";

  return (
    <div className={`rounded-2xl border px-4 py-4 ${classe}`}>
      <p className="font-medium">{mensagem}</p>
    </div>
  );
}

export default AlertMessage;