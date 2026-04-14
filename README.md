# SafeCrypto Architecture

Análise arquitetural do colapso da FTX e proposta de uma solução moderna para gestão segura de criptoativos.

## Sobre o projeto

Este repositório contém o desenvolvimento do projeto **SafeCrypto**, elaborado como trabalho acadêmico da disciplina de **Arquitetura de Software** da **Universidade Católica de Brasília (UCB)**.

O projeto parte da análise do colapso da **FTX**, buscando compreender como falhas arquiteturais, ausência de requisitos essenciais e decisões de projeto inadequadas contribuíram para o agravamento do desastre. A partir dessa análise, é proposta uma solução arquitetural moderna, chamada **SafeCrypto**, voltada à segurança, rastreabilidade, auditabilidade e controle de operações com criptoativos.

## Objetivo

O objetivo do projeto é propor uma arquitetura de software mais segura e controlável para uma plataforma de gestão de criptoativos, tomando como base os problemas observados no caso FTX.

O SafeCrypto foi concebido para:
- reforçar a segurança das operações;
- aumentar a transparência para o usuário;
- garantir rastreabilidade e auditoria das transações;
- melhorar o monitoramento de eventos críticos;
- reduzir acoplamento entre responsabilidades sensíveis do sistema.

## Contexto acadêmico

- **Instituição:** Universidade Católica de Brasília
- **Disciplina:** Arquitetura de Software
- **Tema:** Análise Arquitetural do Colapso da FTX e Proposta de uma Solução Moderna para Gestão Segura de Criptoativos

## Problema analisado

A FTX foi uma das maiores exchanges de criptomoedas do mundo, mas seu colapso revelou problemas graves relacionados à arquitetura, governança, segurança e controle operacional. Entre os principais pontos analisados no trabalho estão:
- forte acoplamento entre áreas e funções críticas;
- baixa capacidade de monitoramento;
- fragilidade de segurança;
- ausência de segregação adequada de responsabilidades;
- falhas de rastreabilidade e auditoria;
- requisitos importantes ausentes ou mal priorizados.

## Solução proposta

A solução proposta neste projeto é o **SafeCrypto**, uma plataforma segura para gestão de criptoativos, modelada a partir de uma **arquitetura modular em camadas**, com uso de **eventos nas operações críticas**.

A proposta busca organizar o sistema em partes bem definidas, separando responsabilidades como:
- autenticação;
- gestão de conta e carteira;
- transações;
- auditoria;
- alertas e monitoramento.

## Estilo arquitetural

O projeto adota uma abordagem baseada em:
- **arquitetura modular em camadas**;
- **separação de responsabilidades**;
- **comunicação orientada a eventos** em operações críticas.

Essa escolha foi feita para responder diretamente aos problemas identificados no caso FTX, principalmente em relação a segurança, monitoramento, rastreabilidade e controle das operações.

## Design patterns utilizados

O projeto considera os seguintes padrões de projeto:
- **Strategy** — para regras de validação e análise de risco;
- **Observer** — para monitoramento e geração de alertas;
- **Factory** — para criação padronizada de transações;
- **Repository** — para organização do acesso aos dados.

## Modelagem

A modelagem do SafeCrypto inclui:
- Diagrama de Entidades e Relacionamentos (DER)
- Diagrama de Casos de Uso
- Diagrama de Classes
- Diagrama de Atividades