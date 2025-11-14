package app.view;

import app.controller.GerenciadorClientes;
import app.model.Cliente;
import app.model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {

    private JTextField nomeField, cpfField, telefoneField, unidadeField, enderecoField;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de título
        JLabel titulo = new JLabel("Cadastro de Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // Painel principal de campos
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 250, 100, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.gridy = 0;

        Dimension fieldSize = new Dimension(250, 25);

        // Campos de texto e labels
        panel.add(new JLabel("Nome:"), gbc);
        gbc.gridy++;
        nomeField = new JTextField();
        nomeField.setFont(new Font("Arial", Font.PLAIN, 17));
        nomeField.setPreferredSize(fieldSize);
        panel.add(nomeField, gbc);

        gbc.gridy++;
        panel.add(new JLabel("CPF:"), gbc);
        gbc.gridy++;
        cpfField = new JTextField();
        cpfField.setFont(new Font("Arial", Font.PLAIN, 17));
        cpfField.setPreferredSize(fieldSize);
        panel.add(cpfField, gbc);

        gbc.gridy++;
        panel.add(new JLabel("Telefone:"), gbc);
        gbc.gridy++;
        telefoneField = new JTextField();
        telefoneField.setFont(new Font("Arial", Font.PLAIN, 17));
        telefoneField.setPreferredSize(fieldSize);
        panel.add(telefoneField, gbc);

        gbc.gridy++;
        panel.add(new JLabel("Unidade:"), gbc);
        gbc.gridy++;
        unidadeField = new JTextField();
        unidadeField.setFont(new Font("Arial", Font.PLAIN, 17));
        unidadeField.setPreferredSize(fieldSize);
        panel.add(unidadeField, gbc);

        gbc.gridy++;
        panel.add(new JLabel("Endereço:"), gbc);
        gbc.gridy++;
        enderecoField = new JTextField();
        enderecoField.setFont(new Font("Arial", Font.PLAIN, 17));
        enderecoField.setPreferredSize(fieldSize);
        panel.add(enderecoField, gbc);

        // Botões
        gbc.gridy++;
        JPanel botoesPanel = new JPanel(new FlowLayout());
        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");
        btnSalvar.setPreferredSize(new Dimension(120, 30));
        btnVoltar.setPreferredSize(new Dimension(120, 30));
        botoesPanel.add(btnSalvar);
        botoesPanel.add(btnVoltar);
        panel.add(botoesPanel, gbc);

        add(panel, BorderLayout.CENTER);

        // Botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeField.getText().isBlank() || cpfField.getText().isBlank() ||
                        telefoneField.getText().isBlank() || unidadeField.getText().isBlank() ||
                        enderecoField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Atenção",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Funcionario funcinario = new Funcionario();
                Cliente cliente = funcinario.criarCliente(nomeField.getText(),
                        cpfField.getText(),
                        telefoneField.getText(),
                        unidadeField.getText(),
                        enderecoField.getText());

                GerenciadorClientes.adicionarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

                Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
                if (window != null) window.dispose();
            }
        });

        // Botão Voltar
        btnVoltar.addActionListener(e -> {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            if (window != null) window.dispose();
        });
    }
}
