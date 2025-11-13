package app.model;

import javax.swing.*;
import java.io.Serializable;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;


    private static String nomeSelecionado;
    private static final String[] FUNCIONARIOS = {"Yan", "Isaque", "Maurício"};

    public static void selecionarFuncionario() {
        nomeSelecionado = (String) JOptionPane.showInputDialog(
                null,
                "Selecione o funcionário:",
                "Funcionário",
                JOptionPane.PLAIN_MESSAGE,
                null,
                FUNCIONARIOS,
                FUNCIONARIOS[0]
        );

        if (nomeSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado. Encerrando o programa.");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nomeSelecionado + "!");
    }

    public static String getFuncionarioAtual() {
        return nomeSelecionado;
    }

    public static void setNomeSelecionado(String nomeSelecionado) {
        Funcionario.nomeSelecionado = nomeSelecionado;
    }
}