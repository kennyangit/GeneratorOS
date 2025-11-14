package app.view;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroOS extends JDialog {

    private JTextField descricao;
    private JTextField data;
    private JTextField hora;
    private JTextField valor;

    private boolean confirmado = false;

    public TelaCadastroOS() {
        setTitle("Cadastro da Ordem de Serviço");
        setSize(500, 480); // AUMENTEI A ALTURA
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1.0;

        descricao = new JTextField();
        data = new JTextField();
        hora = new JTextField();
        valor = new JTextField();

        //int linha = 0;

        // DESCRIÇÃO
        //gbc.gridy = linha++;
        painel.add(new JLabel("Descrição:"), gbc);
        //gbc.gridy = linha++;
        painel.add(descricao, gbc);

        // DATA
        //gbc.gridy = linha++;
        painel.add(new JLabel("Data (DD/MM/AAAA):"), gbc);
        //gbc.gridy = linha++;
        painel.add(data, gbc);

        // HORA
        //gbc.gridy = linha++;
        painel.add(new JLabel("Hora (HH:MM):"), gbc);
        //gbc.gridy = linha++;
        painel.add(hora, gbc);

        // VALOR
        //gbc.gridy = linha++;
        painel.add(new JLabel("Valor (R$):"), gbc);
        //gbc.gridy = linha++;
        painel.add(valor, gbc);

        // BOTÕES
        //gbc.gridy = linha++;
        JPanel botoes = new JPanel(new FlowLayout());
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        btnSalvar.setPreferredSize(new Dimension(120, 30));
        btnCancelar.setPreferredSize(new Dimension(120, 30));

        botoes.add(btnSalvar);
        botoes.add(btnCancelar);
        painel.add(botoes, gbc);

        add(painel);

        // EVENTOS DOS BOTÕES
        btnSalvar.addActionListener(e -> {
            if (descricao.getText().isBlank() ||
                    data.getText().isBlank() ||
                    hora.getText().isBlank() ||
                    valor.getText().isBlank()) {

                JOptionPane.showMessageDialog(this,
                        "Preencha todos os campos.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            confirmado = true;
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    public boolean foiConfirmado() { return confirmado; }

    public String getDescricao() { return descricao.getText(); }
    public String getData() { return data.getText(); }
    public String getHora() { return hora.getText(); }
    public double getValor() {
        try { return Double.parseDouble(valor.getText()); }
        catch (Exception e) { return 0; }
    }
}
