package app.model;

import javax.swing.*;
import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Cliente cliente;
    private OrdemDeServico os;

    public Funcionario(String nome, String cpf, String numeroTel, Cliente cliente, OrdemDeServico os) {
        super(nome, cpf, numeroTel);
        this.cliente = cliente;
        this.os = os;
    }

    public Funcionario() {}

    private static String nomeSelecionado;
    private static final String[] FUNCIONARIOS = {"Yan", "Isaque", "Maurício", "Daniel"};

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

    public Cliente criarCliente(String nome, String cpf, String numeroTel, String unidade, String endereco) {
        Cliente novocliente = new Cliente(nome, cpf, numeroTel, unidade, endereco);
        System.out.println("Funcionário" + getFuncionarioAtual() + " criou o cliente: " + nome);
        return novocliente;
    }

    public OrdemDeServico criarOS(String descricao, String horaminuto, String data, double valor) {
        OrdemDeServico novaOS = new OrdemDeServico(descricao, horaminuto, data, valor);
        return novaOS;
    }

    public static String getFuncionarioAtual() {
        return nomeSelecionado;
    }

    public static void setNomeSelecionado(String nomeSelecionado) {
        Funcionario.nomeSelecionado = nomeSelecionado;
    }
}