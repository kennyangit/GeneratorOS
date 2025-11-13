package app.model;
import java.io.Serializable;

public class OrdemDeServico implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}