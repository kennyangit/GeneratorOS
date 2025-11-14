package app.model;
import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String unidade;
    private String endereco;

    public Cliente(String nome, String cpf, String numeroTel, String unidade, String endereco) {
        super(nome, cpf, numeroTel);
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
        return numeroTel;
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
        this.numeroTel = telefone;
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
                "\nTelefone: " + numeroTel +
                "\nUnidade: " + unidade +
                "\nEndereço: " + endereco;
    }
}
