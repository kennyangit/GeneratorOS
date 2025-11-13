package app.model;

public class Cliente {
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

    @Override
    public String toString() {
        return "Cliente: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nUnidade: " + unidade +
                "\nEndereço: " + endereco;
    }
}
