package app.model;

public class OrdemDeServico {
    private String idOS;
    private Cliente cliente;
    private String descricao;

    public OrdemDeServico(String idOS, Cliente cliente, String descricao) {
        this.idOS = idOS;
        this.cliente = cliente;
        this.descricao = descricao;
    }

    public String getIdOS() {
        return idOS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }
}