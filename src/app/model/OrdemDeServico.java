package app.model;

public class OrdemDeServico {
    // Novo campo para o ID da Ordem de Serviço
    private String idOS;
    private Cliente cliente;
    private String descricao;

    public OrdemDeServico(String idOS, Cliente cliente, String descricao) {
        this.idOS = idOS; // Inicializa o ID
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