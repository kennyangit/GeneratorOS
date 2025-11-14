package app.view;

import app.controller.GerenciadorOS;
import app.model.Cliente;
import app.model.OrdemDeServico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaVerOS extends JFrame {

    public TelaVerOS() {
        setTitle("Ordens de Serviço Registradas");
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titulo = new JLabel("Ordens de Serviço Registradas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titulo, BorderLayout.NORTH);

        List<OrdemDeServico> ordens = GerenciadorOS.getOrdens();

        String[] colunas = {"ID da OS", "Cliente", "CPF", "Telefone", "Unidade", "Endereço","Descrição"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (ordens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma Ordem de Serviço registrada.", "Sem Registros", JOptionPane.INFORMATION_MESSAGE);
        }

        for (OrdemDeServico os : ordens) {
            Cliente c = os.getCliente();
            model.addRow(new Object[]{
                    os.getIdOS(),
                    c.getNome(),
                    c.getCpf(),
                    c.getTelefone(),
                    c.getUnidade(),
                    c.getEndereco(),
                    os.getDescricao()
            });
        }

        JTable tabela = new JTable(model);
        tabela.setRowHeight(28);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setResizingAllowed(false);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(300);

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // Botões
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVoltar = new JButton("Voltar");

        btnEditar.setPreferredSize(new Dimension(120, 30));
        btnExcluir.setPreferredSize(new Dimension(120, 30));
        btnVoltar.setPreferredSize(new Dimension(120, 30));

        JPanel painelBtn = new JPanel();
        painelBtn.add(btnEditar);
        painelBtn.add(btnExcluir);
        painelBtn.add(btnVoltar);
        add(painelBtn, BorderLayout.SOUTH);

        // Botão Voltar
        btnVoltar.addActionListener(e -> {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            if (window != null) window.dispose();
        });

        // Botão Editar
        btnEditar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma OS para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            OrdemDeServico osSelecionada = ordens.get(linha);
            Cliente cliente = osSelecionada.getCliente();

            JTextField nomeField = new JTextField(cliente.getNome(), 20);
            JTextField cpfField = new JTextField(cliente.getCpf(), 20);
            JTextField telefoneField = new JTextField(cliente.getTelefone(), 20);
            JTextField unidadeField = new JTextField(cliente.getUnidade(), 20);
            JTextField enderecoField = new JTextField(cliente.getEndereco(), 20);
            JTextArea descricaoArea = new JTextArea(osSelecionada.getDescricao(), 4, 20);

            JTextField dataField = new JTextField(osSelecionada.getData(), 20);
            JTextField horaField = new JTextField(osSelecionada.getHora(), 20);
            JTextField valorField = new JTextField(String.valueOf(osSelecionada.getValor()), 20);

            JPanel panelEdit = new JPanel(new GridLayout(0, 1, 5, 5));

            panelEdit.add(new JLabel("Nome:"));
            panelEdit.add(nomeField);
            panelEdit.add(new JLabel("CPF:"));
            panelEdit.add(cpfField);
            panelEdit.add(new JLabel("Telefone:"));
            panelEdit.add(telefoneField);
            panelEdit.add(new JLabel("Unidade:"));
            panelEdit.add(unidadeField);
            panelEdit.add(new JLabel("Endereço:"));
            panelEdit.add(enderecoField);

            panelEdit.add(new JLabel("Descrição da OS:"));
            panelEdit.add(new JScrollPane(descricaoArea));

            panelEdit.add(new JLabel("Data (DD/MM/AAAA):"));
            panelEdit.add(dataField);

            panelEdit.add(new JLabel("Hora (HH:MM):"));
            panelEdit.add(horaField);

            panelEdit.add(new JLabel("Valor (R$):"));
            panelEdit.add(valorField);

            JScrollPane scrollPane = new JScrollPane(panelEdit);
            scrollPane.setPreferredSize(new Dimension(500, 450));

            int resultado = JOptionPane.showConfirmDialog(
                    null,
                    scrollPane,
                    "Editar Ordem de Serviço",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (resultado == JOptionPane.OK_OPTION) {

                cliente.setNome(nomeField.getText().trim());
                cliente.setCpf(cpfField.getText().trim());
                cliente.setTelefone(telefoneField.getText().trim());
                cliente.setUnidade(unidadeField.getText().trim());
                cliente.setEndereco(enderecoField.getText().trim());

                osSelecionada.setDescricao(descricaoArea.getText().trim());
                osSelecionada.setData(dataField.getText().trim());
                osSelecionada.setHora(horaField.getText().trim());
                osSelecionada.setValor(Double.parseDouble(valorField.getText().trim()));

                model.setValueAt(cliente.getNome(), linha, 1);
                model.setValueAt(cliente.getCpf(), linha, 2);
                model.setValueAt(cliente.getTelefone(), linha, 3);
                model.setValueAt(cliente.getUnidade(), linha, 4);
                model.setValueAt(cliente.getEndereco(), linha, 5);
                model.setValueAt(osSelecionada.getDescricao(), linha, 6);

                GerenciadorOS.salvarOrdens();

                JOptionPane.showMessageDialog(null, "Ordem de Serviço atualizada com sucesso!");
            }
        });

        // Botão Excluir
        btnExcluir.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma OS para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            OrdemDeServico osSelecionada = ordens.get(linha);
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Tem certeza que deseja excluir a OS " + osSelecionada.getIdOS() + "?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                ordens.remove(osSelecionada);
                model.removeRow(linha);
                GerenciadorOS.salvarOrdens();
                JOptionPane.showMessageDialog(null, "Ordem de Serviço excluída com sucesso!");
            }
        });
    }
}