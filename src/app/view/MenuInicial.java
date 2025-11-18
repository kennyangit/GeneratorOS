package app.view;

import app.controller.GerenciadorClientes;
import app.controller.GerenciadorOS;
import app.model.Cliente;
import app.model.Funcionario;
import app.model.OrdemDeServico;

import javax.swing.*;
import java.util.List;

public class MenuInicial{

    public static void exibirMenu() {
        Funcionario.selecionarFuncionario();

        while (true) {
            String[] opcoes = {"Cadastrar Cliente", "Gerar OS", "Ver Ordens Registradas", "Encerrar Programa"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione uma opção:",
                    "Menu Inicial",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (escolha == 0) {
                TelaCadastroCliente telaCadastro = new TelaCadastroCliente();
                JDialog dialog = new JDialog();
                dialog.setModal(true);
                dialog.setContentPane(telaCadastro.getContentPane());
                dialog.setTitle("Cadastro de Cliente");
                dialog.setSize(1000, 700);
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);

            } else if (escolha == 1) { // Gerar OS
                gerarOS();

            } else if (escolha == 2) {
                TelaVerOS telaVerOS = new TelaVerOS();
                JDialog dialog = new JDialog();
                dialog.setModal(true);
                dialog.setContentPane(telaVerOS.getContentPane());
                dialog.setTitle("Ordens de Serviço Registradas");
                dialog.setSize(900, 600);
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } else {
                if (escolha == 3) {
                    System.exit(0);
                }
                return;
            }
        }
    }

    private static void gerarOS() {
        String[] opcoes = {"Cadastrar novo cliente", "Selecionar cliente existente"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Deseja gerar OS com:",
                "Gerar OS",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha == 0) {
            TelaCadastroCliente telaCadastro = new TelaCadastroCliente();
            JDialog dialog = new JDialog();
            dialog.setModal(true);
            dialog.setContentPane(telaCadastro.getContentPane());
            dialog.setTitle("Cadastro de Cliente");
            dialog.setSize(1000, 700);
            dialog.setResizable(false);
            dialog.setLocationRelativeTo(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);

        } else if (escolha == 1) {
            List<Cliente> clientes = GerenciadorClientes.getClientes();

            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!");
                return;
            }

            String[] nomes = clientes.stream().map(Cliente::getNome).toArray(String[]::new);
            String nomeEscolhido = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione o cliente:",
                    "Clientes Cadastrados",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nomes,
                    nomes[0]
            );

            if (nomeEscolhido != null) {
                Cliente clienteSelecionado = GerenciadorClientes.buscarPorNome(nomeEscolhido);
                TelaCadastroOS telaOS = new TelaCadastroOS();
                telaOS.setVisible(true);

                if (!telaOS.foiConfirmado()) {
                    JOptionPane.showMessageDialog(null, "Cadastro de OS cancelado.");
                    return;
                }

                String descricao = telaOS.getDescricao();
                String data = telaOS.getData();
                String hora = telaOS.getHora();
                double valor = telaOS.getValor();

                if (descricao == null || descricao.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Descrição da OS não pode ser vazia.", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Funcionario func = new Funcionario();
                OrdemDeServico novaOS = func.criarOS(clienteSelecionado, descricao, data, hora, valor);
                GerenciadorOS.adicionarOS(novaOS);
                JOptionPane.showMessageDialog(null,
                        "ORDEM DE SERVIÇO GERADA\n" +
                                "Funcionário Responsável: " + func.getFuncionarioAtual() + "\n\n" +
                                "Cliente: " + novaOS.getCliente().getNome() + "\n" +
                                "CPF: " + novaOS.getCliente().getCpf() + "\n" +
                                "Telefone: " + novaOS.getCliente().getTelefone() + "\n" +
                                "Unidade: " + novaOS.getCliente().getUnidade() + "\n" +
                                "Descrição: " + novaOS.getDescricao() + "\n" +
                                "Data: " + novaOS.getData() + "\n" +
                                "Hora: " + novaOS.getHora() + "\n" +
                                "Valor: R$ " + novaOS.getValor(),
                        "OS Registrada",
                        JOptionPane.INFORMATION_MESSAGE
                );

            }

        } else {
            return;
        }
    }
}