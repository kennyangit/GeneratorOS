package app.model;

public class Pessoa {
    String nome;
    String cpf;
    String numeroTel;

    public Pessoa(String nome, String cpf, String numeroTel) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTel = numeroTel;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}
