package app.view;

import app.controller.GerenciadorClientes;
import app.controller.GerenciadorOS;
import app.model.Cliente;
import app.model.OrdemDeServico;

import javax.swing.*;
import java.util.List;

public class MenuInicial {

    public static void exibirMenu() {
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

            if (escolha == 0) { // Cadastrar Cliente
                // ... código existente ...
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
                dialog.setModal(true); // Faz com que o usuário tenha que fechar esta tela antes de interagir com outras.
                dialog.setContentPane(telaVerOS.getContentPane());
                dialog.setTitle("Ordens de Serviço Registradas");
                dialog.setSize(900, 600);
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(null);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } else { // Fechar ou cancelar / Encerrar Programa (índice 3 é Encerrar)
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
                // ... código existente para seleção de opção ...
                null,
                "Deseja gerar OS com:",
                "Gerar OS",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha == 0) { // Cadastrar novo cliente
            // ... código existente ...
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

        } else if (escolha == 1) { // Selecionar cliente existente
            List<Cliente> clientes = GerenciadorClientes.getClientes();

            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!");
                return;
            }

            String[] nomes = clientes.stream().map(Cliente::getNome).toArray(String[]::new);
            String nomeEscolhido = (String) JOptionPane.showInputDialog(
                    // ... código existente para seleção de cliente ...
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
                String descricao = JOptionPane.showInputDialog("Digite a descrição da OS:");

                // Verificação de descrição
                if (descricao == null || descricao.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Descrição da OS não pode ser vazia.", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // ------------------------------------------------
                // --- MODIFICAÇÕES CRUCIAIS A PARTIR DAQUI ---
                // ------------------------------------------------

                // 1. Gerar o ID da OS
                String idOS = GerenciadorOS.gerarProximoIdOS();

                // 2. Criar a nova OrdemDeServico com o ID
                OrdemDeServico novaOS = new OrdemDeServico(idOS, clienteSelecionado, descricao);

                // 3. Registrar a nova OS no GerenciadorOS
                GerenciadorOS.adicionarOS(novaOS);

                // 4. Exibir a mensagem de sucesso (com o ID)
                JOptionPane.showMessageDialog(
                        null,
                        "OS registrada com sucesso!\n" +
                                "ID da OS: " + idOS + "\n\n" +
                                clienteSelecionado.toString() + "\n\nDescrição da OS:\n" + descricao,
                        "Ordem de Serviço Gerada",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else { // Fechar ou cancelar
            return;
        }
    }
}