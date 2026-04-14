function Header({ usuario, onLogout }) {
  return (
    <header className="bg-white shadow-sm">
      <div className="mx-auto flex max-w-6xl items-center justify-between px-4 py-4">
        <div>
          <h1 className="text-2xl font-bold text-gray-800">
            SafeCrypto Dashboard
          </h1>
          <p className="text-sm text-gray-500">
            Bem-vindo, {usuario?.nome}
          </p>
        </div>

        <button
          onClick={onLogout}
          className="rounded-xl bg-red-500 px-4 py-2 font-medium text-white transition hover:bg-red-600"
        >
          Sair
        </button>
      </div>
    </header>
  );
}

export default Header;