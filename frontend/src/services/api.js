const BASE_URL = import.meta.env.VITE_API_URL || "http://localhost:8080/api";

async function handleResponse(response) {
  const contentType = response.headers.get("content-type");

  let data = null;

  if (contentType && contentType.includes("application/json")) {
    data = await response.json();
  } else {
    data = await response.text();
  }

  if (!response.ok) {
    const message =
      data?.message ||
      data?.error ||
      "Erro na comunicação com o servidor";
    throw new Error(message);
  }

  return data;
}

export async function login(loginData) {
  const response = await fetch(`${BASE_URL}/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(loginData),
  });

  return handleResponse(response);
}

export async function buscarSaldo(usuarioId) {
  const response = await fetch(`${BASE_URL}/saldo/${usuarioId}`, {
    method: "GET",
  });

  return handleResponse(response);
}

export async function buscarHistorico(usuarioId) {
  const response = await fetch(`${BASE_URL}/historico/${usuarioId}`, {
    method: "GET",
  });

  return handleResponse(response);
}

export async function realizarDeposito(depositoData) {
  const response = await fetch(`${BASE_URL}/deposito`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(depositoData),
  });

  return handleResponse(response);
}

export async function realizarSaque(saqueData) {
  const response = await fetch(`${BASE_URL}/saque`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(saqueData),
  });

  return handleResponse(response);
}