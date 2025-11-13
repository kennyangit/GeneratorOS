package app.model;
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String telefone;
    private String unidade;
    private String endereco;

    public Cliente(String nome, String cpf, String telefone, String unidade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.unidade = unidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nUnidade: " + unidade +
                "\nEndereço: " + endereco;
    }
}
