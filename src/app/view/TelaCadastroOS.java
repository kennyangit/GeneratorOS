package app.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
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
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
            data = new JFormattedTextField(mask);
        } catch (Exception e) {
            data = new JFormattedTextField();
        }
        try {
            MaskFormatter mask = new MaskFormatter("##:##");
            mask.setPlaceholderCharacter('_');
            hora = new JFormattedTextField(mask);
        } catch (Exception e) {
            hora = new JFormattedTextField();
        }
        valor  = new JTextField();

        painel.add(new JLabel("Descrição:"), gbc);
        painel.add(descricao, gbc);

        painel.add(new JLabel("Data:"), gbc);
        painel.add(data, gbc);

        painel.add(new JLabel("Hora:"), gbc);
        painel.add(hora, gbc);

        painel.add(new JLabel("Valor(R$):"), gbc);
        painel.add(valor, gbc);

        JPanel botoes = new JPanel(new FlowLayout());
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        btnSalvar.setPreferredSize(new Dimension(120, 30));
        btnCancelar.setPreferredSize(new Dimension(120, 30));

        botoes.add(btnSalvar);
        botoes.add(btnCancelar);
        painel.add(botoes, gbc);

        add(painel);

        JFormattedTextField finaldata = (JFormattedTextField) data;
        JFormattedTextField finalhora = (JFormattedTextField) hora;

        btnSalvar.addActionListener(e -> {
            if(descricao.getText().isBlank() ){
                JOptionPane.showMessageDialog(this,
                        "Preencha o campo descrição corretamente.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }else if(finaldata.getText().equals("__/__/____")){
                JOptionPane.showMessageDialog(this,
                        "Preencha o campo data corretamente.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }else if(finalhora.getText().equals("__:__")){
                JOptionPane.showMessageDialog(this,
                        "Preencha o campo hora corretamente.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }else if (valor.getText().isBlank() ) {
                JOptionPane.showMessageDialog(this,
                        "Preencha o campo valor corretamente.",
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
