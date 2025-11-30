# 📋 Sistema de Gerenciamento de Ordens de Serviço (Java + Swing)

Este é um sistema desktop desenvolvido em **Java** utilizando elementos **Swing** para gerenciamento completo de clientes e ordens de serviço (OS).  
O programa permite cadastro de clientes, criação de ordens de serviço, edição, exclusão e visualização de todas as OS registradas.  
Os dados são **persistidos em arquivos binários (.dat)** via serialização.

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

##

<h3 align="center">🖥️ Demonstração da Interface</h3>

##

<p align="center">📌 Tela de Cadastro de Cliente</p>

<p align="center"><img width="784" height="592" alt="cadastrocliente" src="https://github.com/user-attachments/assets/7c770638-b4f2-4d16-aa8d-76e7c23062e2"/> </p>

##

<p align="center">📌 Tela de Cadastro de Ordem de Serviço</p>

<p align="center"><img width="486" height="470" alt="cadastroos" src="https://github.com/user-attachments/assets/0d9ef5d2-a158-4202-bb3f-eac5da83f91b" /></p>


##

<p align="center">📌 Janelinha de informações após a OS ser gerada</p>

<p align="center"><img width="275" height="292" alt="osgerada" src="https://github.com/user-attachments/assets/b9f6c3c4-27d6-49ff-b435-9853e7509655"/></p>


##

<p align="center">📌 Tela de Visualização das OS</p>

<p align="center"><img width="784" height="592" alt="veros" src="https://github.com/user-attachments/assets/da427dfc-94a3-485b-8bfa-9850896b4d7a" /></p>

##

<h3>🏗️ Tecnologias Utilizadas</h3>

- **Java 21**
- **Swing**
- **Serialização com ObjectOutputStream**
- **IntelliJ IDEA**

##

<h3>▶️ Como Executar</h3>

<h4>1. Baixe o projeto</h4>
https://github.com/kennyangit/GeneratorOS.git

<h4>2. Abra no IntelliJ IDEA (recomendado)</h4>

<h4>3. Compile e execute a classe:</h4>
Main.java

##

<h3>📦 Funcionalidades Futuras</h3>
<ul>
  <li>Exportar OS em PDF</li>
  <li>Login de funcionários</li>
  <li>Sistema de busca e filtros por cliente</li>
  <li>Integração com banco de dados (MySQL ou PostgreSQL)</li>
</ul>


##

<h3>👥 Grupo</h3>
<ul>
  <li><b>Yan Kenny</b></li>
  <li><b>Isaque Pereira</b></li>
  <li><b>Maurício Alves</b></li>
</ul>

##
