package app.view;

import app.controller.GerenciadorOS;
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

        String[] colunas = {"ID da OS", "Cliente", "CPF", "Unidade", "Descrição"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        if (ordens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma Ordem de Serviço registrada.", "Sem Registros", JOptionPane.INFORMATION_MESSAGE);
        }

        for (OrdemDeServico os : ordens) {
            model.addRow(new Object[]{
                    os.getIdOS(),
                    os.getCliente().getNome(),
                    os.getCliente().getCpf(),
                    os.getCliente().getUnidade(),
                    os.getDescricao()
            });
        }

        JTable tabela = new JTable(model);
        tabela.setRowHeight(28);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(300); // Descrição

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        /*
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        JPanel painelBtn = new JPanel();
        painelBtn.add(btnFechar);
        add(painelBtn, BorderLayout.SOUTH);
         */
    }
}