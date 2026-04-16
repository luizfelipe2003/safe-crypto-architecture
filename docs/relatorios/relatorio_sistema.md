# SafeCrypto Architecture

Protótipo arquitetural de uma plataforma segura para gestão de criptoativos, desenvolvido como solução proposta a partir da análise do colapso da FTX na disciplina de Arquitetura de Software da Universidade Católica de Brasília.

---

## Sobre o projeto

O **SafeCrypto** é uma proposta de solução arquitetural criada a partir do estudo crítico do colapso da FTX. O objetivo do projeto é demonstrar, de forma acadêmica e prática, como uma plataforma de criptoativos pode ser estruturada de maneira mais segura, rastreável, controlável e auditável.

O sistema foi concebido para representar uma alternativa arquitetural moderna, com foco em:
- autenticação com MFA simulado;
- controle de acesso;
- consulta de saldo;
- consulta de histórico de transações;
- realização de depósito;
- realização de saque;
- geração de alerta de risco em operações críticas.

Este repositório contém a **implementação simulada** da solução proposta, com foco na organização arquitetural, separação de responsabilidades e integração entre frontend e backend.

---

## Contexto acadêmico

Este projeto foi desenvolvido como trabalho da disciplina de **Arquitetura de Software** da **Universidade Católica de Brasília (UCB)**.

### Tema do trabalho
**Análise Arquitetural do Colapso da FTX e Proposta de uma Solução Moderna para Gestão Segura de Criptoativos**

### Grupo
**Group 8 - FTX**

### Integrantes
- Luiz Felipe Ferraz de Carvalho
- Pedro Paulo Costa

---

## Problema analisado

O projeto parte da análise do colapso da FTX, entendendo o desastre não apenas como uma falha financeira e de governança, mas também como consequência de decisões arquiteturais inadequadas, requisitos ausentes ou mal priorizados e baixa capacidade de controle, auditoria, monitoramento e segurança. A partir dessa leitura, o SafeCrypto foi modelado como uma solução mais segura e organizada para o mesmo domínio. :contentReference[oaicite:2]{index=2}

---

## Objetivo do sistema

O SafeCrypto tem como objetivo representar uma plataforma digital segura para gestão de criptoativos, estruturada com foco em:
- segurança;
- transparência;
- rastreabilidade;
- monitoramento;
- auditabilidade;
- separação de responsabilidades.

O protótipo foi construído para demonstrar esses princípios de forma simples, mas coerente com a proposta arquitetural do trabalho. :contentReference[oaicite:3]{index=3}

---

## Funcionalidades implementadas

O protótipo contempla os principais fluxos definidos na modelagem do sistema:

- Login com MFA simulado
- Consulta de saldo
- Consulta de histórico de transações
- Realização de depósito
- Realização de saque
- Geração de alerta visível em operações consideradas de risco

Essas funcionalidades correspondem aos fluxos principais modelados nos diagramas e descritos na análise essencial e na proposta arquitetural do projeto. :contentReference[oaicite:4]{index=4} :contentReference[oaicite:5]{index=5}

---

## Arquitetura da solução

O projeto adota uma **arquitetura modular em camadas**, com organização entre frontend, backend, regras de negócio e acesso a dados simulados. Em operações críticas, a proposta considera também o uso de comunicação orientada a eventos como apoio à rastreabilidade, geração de alertas e monitoramento. :contentReference[oaicite:6]{index=6}

### Camadas principais

#### 1. Camada de apresentação
Responsável pela interface com o usuário, implementada em React. Nela estão:
- tela de login;
- tela principal do sistema;
- exibição de saldo;
- exibição de histórico;
- formulários de depósito e saque;
- exibição de alertas.

#### 2. Camada de aplicação
Responsável por coordenar os fluxos do sistema e intermediar a comunicação entre a interface e a lógica de negócio.

#### 3. Camada de negócio
Responsável pelas regras centrais do sistema, como:
- autenticação;
- validação de operações;
- controle de saldo;
- registro de transações;
- geração de alertas.

#### 4. Camada de dados
Responsável pela persistência simulada do sistema, utilizando dados mockados em memória, sem banco de dados real, com foco acadêmico e demonstrativo.

---

## Design Patterns considerados

A proposta do projeto considera o uso dos seguintes padrões de projeto, de acordo com a modelagem arquitetural definida no trabalho: :contentReference[oaicite:7]{index=7}

- **Strategy**: aplicado nas regras de validação das operações;
- **Observer**: associado ao comportamento de monitoramento e alertas;
- **Factory**: relacionado à criação padronizada de transações;
- **Repository**: utilizado na organização do acesso aos dados simulados.

---

## Stack utilizada

### Frontend
- React
- Vite
- Tailwind CSS

### Backend
- Java 17
- Spring Boot
- Maven

### Comunicação
- API REST
- JSON
- Integração HTTP entre frontend e backend

---

## Estrutura do repositório

```bash
safecrypto-architecture/
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── mvnw
├── frontend/
│   ├── src/
│   ├── package.json
│   └── vite.config.js
├── docs/
│   ├── diagramas/
│   └── relatorio/
└── README.md