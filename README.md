# SafeCrypto Architecture

> Protótipo acadêmico de uma plataforma segura para gestão de criptoativos, desenvolvido como resposta arquitetural ao colapso da FTX.

---

## Sobre o Projeto

O **SafeCrypto** é um protótipo funcional de plataforma de gestão de criptoativos, construído com o objetivo de demonstrar como uma arquitetura bem estruturada pode prevenir os tipos de falhas que levaram ao colapso da **FTX** — uma das maiores exchanges de criptomoedas do mundo.

O projeto cobre desde a análise dos problemas arquiteturais da FTX até a implementação de uma solução moderna com backend em Java/Spring Boot e frontend em React, aplicando padrões de projeto e princípios de separação de responsabilidades.

---

## Contexto Acadêmico

| Campo | Detalhe |
|---|---|
| Instituição | Universidade Católica de Brasília (UCB) |
| Disciplina | Arquitetura de Software |
| Tema | Análise Arquitetural do Colapso da FTX e Proposta de uma Solução Moderna para Gestão Segura de Criptoativos |

---

## Problema Analisado — FTX

O colapso da FTX expôs falhas críticas de arquitetura e governança:

- Forte acoplamento entre áreas e funções críticas do sistema
- Ausência de segregação de responsabilidades
- Baixa capacidade de monitoramento e rastreabilidade
- Fragilidade na segurança de autenticação e acesso
- Ausência de auditoria e histórico confiável de operações
- Requisitos de segurança ausentes ou mal priorizados

---

## Solução Proposta — SafeCrypto

O SafeCrypto responde diretamente a cada um desses problemas com uma arquitetura modular em camadas, separação clara de responsabilidades e comunicação orientada a eventos em operações críticas.

### Funcionalidades implementadas

- **Autenticação com MFA simulado** — login com e-mail, senha e código MFA
- **Consulta de saldo** — visualização do saldo e status da conta
- **Depósito** — operação de crédito com registro de transação
- **Saque** — operação de débito com validação de saldo e alerta de risco
- **Histórico de transações** — rastreabilidade completa das operações por usuário
- **Alerta de risco** — saques acima de R$ 1.000,00 geram alerta automático

---

## Arquitetura

### Estilo Arquitetural

O projeto adota **arquitetura modular em camadas**, com separação clara entre:

```
Controller  →  Service  →  Repository  →  Model
```

Cada camada tem responsabilidade única e se comunica apenas com a camada adjacente, eliminando o acoplamento identificado no caso FTX.

### Design Patterns Utilizados

| Pattern | Aplicação no projeto |
|---|---|
| **Repository** | Abstração do acesso aos dados (`UsuarioRepository`, `ContaRepository`, `TransacaoRepository`) |
| **Strategy** | Estrutura preparada para regras de validação e análise de risco |
| **Observer** | Estrutura preparada para monitoramento e geração de alertas |
| **Factory** | Estrutura preparada para criação padronizada de transações |

---

## Stack Tecnológica

### Backend
- Java 17
- Spring Boot 3.4.5
- Spring Web MVC
- Maven

### Frontend
- React 19
- Vite 8
- Tailwind CSS 4
- JavaScript (ES Modules)

---

## Estrutura do Projeto

```
safe-crypto-architecture/
├── backend/
│   └── src/
│       ├── main/java/com/safecrypto/backend/
│       │   ├── controller/
│       │   │   ├── AuthController.java
│       │   │   ├── ContaController.java
│       │   │   └── TransacaoController.java
│       │   ├── service/
│       │   │   ├── AuthService.java
│       │   │   ├── ContaService.java
│       │   │   └── TransacaoService.java
│       │   ├── repository/
│       │   │   ├── UsuarioRepository.java
│       │   │   ├── ContaRepository.java
│       │   │   └── TransacaoRepository.java
│       │   ├── model/
│       │   │   ├── Usuario.java
│       │   │   ├── Conta.java
│       │   │   └── Transacao.java
│       │   └── dto/
│       │       ├── LoginRequest.java / LoginResponse.java
│       │       ├── SaldoResponse.java
│       │       ├── DepositoRequest.java / SaqueRequest.java
│       │       ├── OperacaoResponse.java
│       │       └── HistoricoResponse.java
│       └── test/
├── frontend/
│   └── src/
│       ├── pages/
│       │   ├── LoginPage.jsx
│       │   └── DashboardPage.jsx
│       ├── components/
│       │   ├── LoginForm.jsx
│       │   ├── Header.jsx
│       │   ├── BalanceCard.jsx
│       │   ├── DepositForm.jsx
│       │   ├── WithdrawForm.jsx
│       │   ├── TransactionHistory.jsx
│       │   └── AlertMessage.jsx
│       └── services/
│           └── api.js
└── docs/
    └── diagramas/
        ├── classes/
        ├── casos_uso/
        ├── atividades/
        └── der/
```

---

## API REST — Endpoints

Base URL: `http://localhost:8080/api`

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/health` | Verifica se o backend está no ar |
| `POST` | `/login` | Autenticação com e-mail, senha e MFA |
| `GET` | `/saldo/{usuarioId}` | Consulta saldo e dados da conta |
| `GET` | `/historico/{usuarioId}` | Lista histórico de transações |
| `POST` | `/deposito` | Realiza um depósito |
| `POST` | `/saque` | Realiza um saque com validação de risco |

### Exemplos de uso

**POST /api/login**
```json
{
  "email": "luiz@safecrypto.com",
  "senha": "123456",
  "mfaCode": "999999"
}
```

**POST /api/deposito**
```json
{
  "usuarioId": 1,
  "valor": 500.00
}
```

**POST /api/saque**
```json
{
  "usuarioId": 1,
  "valor": 200.00
}
```

### Usuários disponíveis para teste

| Nome | E-mail | Senha | MFA | ID |
|---|---|---|---|---|
| Luiz Felipe | luiz@safecrypto.com | 123456 | 999999 | 1 |
| Pedro Paulo | pedro@safecrypto.com | 654321 | 888888 | 2 |

---

## Como Executar

### Pré-requisitos

- Java 17+
- Node.js 18+
- Maven (ou usar o wrapper `./mvnw`)

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

O servidor sobe em `http://localhost:8080`

### Frontend

```bash
cd frontend
npm install
npm run dev
```

O frontend sobe em `http://localhost:5173`

---

## Modelagem

A documentação de modelagem está em `docs/diagramas/` e inclui:

- **Diagrama de Classes** — estrutura das entidades e seus relacionamentos
- **Diagrama de Casos de Uso** — interações do usuário com o sistema
- **Diagrama de Atividades** — fluxo das operações principais
- **DER** — Diagrama de Entidades e Relacionamentos

---

## Variáveis de Ambiente

O frontend suporta a variável `VITE_API_URL` para apontar para um backend diferente do padrão:

```env
VITE_API_URL=http://localhost:8080/api
```

---

## Observações

Este é um protótipo acadêmico. Os dados são armazenados em memória (sem banco de dados), as senhas não são criptografadas e o MFA é simulado. Essas simplificações são intencionais para focar na demonstração da arquitetura proposta.
