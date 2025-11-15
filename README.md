# 📋 Sistema de Gerenciamento de Ordens de Serviço (Java + Swing)

Este é um sistema desktop desenvolvido em **Java** utilizando **Swing** para gerenciamento completo de clientes e ordens de serviço (OS).  
O programa permite cadastro de clientes, criação de ordens de serviço, edição, exclusão e visualização de todas as OS registradas.  
Os dados são **persistidos em arquivos binários (.dat)** via serialização.

---

## 🚀 Funcionalidades

### 👤 **Funcionário**
- Seleção do funcionário ao iniciar o programa
- Funcionário é responsável por criar clientes e ordens de serviço

### 🧑‍💼 **Clientes**
- Cadastrar novo cliente com:
  - Nome  
  - CPF  
  - Telefone  
  - Unidade  
  - Endereço
- Edição de clientes vinculados a uma OS

### 📝 **Ordem de Serviço**
- Criar nova OS para um cliente existente ou recém-cadastrado
- Cada OS possui:
  - ID automático (OS01, OS02…)
  - Cliente vinculado
  - Descrição
  - Data
  - Hora
  - Valor
- Visualização em tabela
- Edição completa da OS (cliente + dados da OS)
- Exclusão de OS

### 💾 **Persistência**
Todos os dados são salvos nos arquivos:
- `clientes.dat`
- `ordens.dat`

Utilizando **ObjectOutputStream / ObjectInputStream**, garantindo que o usuário não perde os registros ao fechar o programa.

---

## 🖥️ Demonstração da Interface

📌 Tela de Cadastro de Cliente


📌 Tela de Cadastro de Ordem de Serviço


📌 Tela de Visualização das OS

---

## 🏗️ Tecnologias Utilizadas

- **Java 21**
- **Swing**
- **Serialização com ObjectOutputStream**
- **IntelliJ IDEA**

---

## ▶️ Como Executar

### 1. Baixe o projeto
https://github.com/kennyangit/GeneratorOS.git

### 2. Abra no IntelliJ IDEA

### 3. Compile e execute a classe:
Main.java

---

## 📦 Funcionalidades Futuras
- Exportar OS em PDF
- Login de funcionários
- Sistema de busca e filtros por cliente
- Integração com banco de dados (MySQL ou PostgreSQL)

---

## 👨‍💻 Autores
<ul>
  <li><b>Yan Kenny</b></li>
  <li><b>Isaque Pereira</b></li>
  <li><b>Maurício Alves</b></li>
</ul>

---
