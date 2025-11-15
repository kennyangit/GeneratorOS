# 📋 Sistema de Gerenciamento de Ordens de Serviço (Java + Swing)

Este é um sistema desktop desenvolvido em **Java** utilizando **Swing** para gerenciamento completo de clientes e ordens de serviço (OS).  
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

<p align="center"><img width="600" height="800" alt="telacadastrocliente" src="https://github.com/user-attachments/assets/7345c10e-648f-404c-9d32-ff0323706d29"/></p>


##

<p align="center">📌 Tela de Cadastro de Ordem de Serviço</p>

<p align="center"><img width="484" height="470" alt="telacadastroOS" src="https://github.com/user-attachments/assets/c1132c9e-4bf5-46b9-a339-28d0552cf104"/></p>


##

<p align="center">📌 Tela OS Gerada</p>

<p align="center"><img width="600" height="403" alt="OSgerada" src="https://github.com/user-attachments/assets/a2368c0b-7f5c-43c6-a7b8-bcb859d6f53e" /></p>


##

<p align="center">📌 Tela de Visualização das OS</p>
<p align="center"><img width="600" height="594" alt="telaOSregistradas" src="https://github.com/user-attachments/assets/d9a421fd-b8b9-45ff-9b1f-341443165fb7"/></p>

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
