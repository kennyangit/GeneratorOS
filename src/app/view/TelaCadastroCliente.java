package app.view;

import app.controller.GerenciadorClientes;
import app.model.Cliente;
import app.model.Funcionario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
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

        JLabel titulo = new JLabel("Cadastro de Cliente", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

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

        panel.add(new JLabel("Nome:"), gbc);
        gbc.gridy++;
        nomeField = new JTextField();
        nomeField.setFont(new Font("Arial", Font.PLAIN, 17));
        nomeField.setPreferredSize(fieldSize);
        panel.add(nomeField, gbc);


        gbc.gridy++;
        panel.add(new JLabel("CPF:"), gbc);
        gbc.gridy++;
        JFormattedTextField cpfField;
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(mask);
        } catch (Exception e) {
            cpfField = new JFormattedTextField();
        }
        cpfField.setFont(new Font("Arial", Font.PLAIN, 17));
        cpfField.setPreferredSize(fieldSize);
        panel.add(cpfField, gbc);


        gbc.gridy++;
        panel.add(new JLabel("Telefone:"), gbc);
        gbc.gridy++;
        try {
            MaskFormatter mask = new MaskFormatter("(##) 9####-####");
            mask.setPlaceholderCharacter('_');
            telefoneField = new JFormattedTextField(mask);
        } catch (Exception e) {
            telefoneField = new JFormattedTextField();
        }
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
        JFormattedTextField finalCpfField = cpfField;
        JFormattedTextField finalTelefoneField = (JFormattedTextField) telefoneField;
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nomeField.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Nome corretamente.", "Atenção",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }else if(finalCpfField.getText().equals("___.___.___-__")) {
                    JOptionPane.showMessageDialog(null, "Preencha o campo CPF corretamente.", "Atenção",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }else if(finalTelefoneField.getText().equals("(__) 9____-____")) {
                    JOptionPane.showMessageDialog(null, "Preencha o campo Telefone corretamente.", "Atenção",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }else if(unidadeField.getText().isBlank() ){
                    JOptionPane.showMessageDialog(null, "Preencha o campo Unidade corretamente.", "Atenção",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }else if (enderecoField.getText().isBlank()) {
                        JOptionPane.showMessageDialog(null, "Preencha o campo Endereço corretamente.", "Atenção",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                }


                Funcionario funcinario = new Funcionario();
                Cliente cliente = funcinario.criarCliente(nomeField.getText(),
                        finalCpfField.getText(),
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
