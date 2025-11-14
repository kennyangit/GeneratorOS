package app.model;
import java.io.Serializable;

public class OrdemDeServico implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idOS;
    private Cliente cliente;
    private String descricao;
    private String data;
    private String horaminuto;
    private double valor;

    public OrdemDeServico(String idOS, Cliente cliente, String descricao) {
        this.idOS = idOS;
        this.cliente = cliente;
        this.descricao = descricao;
    }

    public OrdemDeServico(String descricao, String data, String horaminuto, double valor) {
        this.descricao = descricao;
        this.data = data;
        this.horaminuto = horaminuto;
        this.valor = valor;
    }

    public OrdemDeServico() {
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

    public void setIdOS(String id) { this.idOS = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHora() { return horaminuto; }
    public void setHora(String h) { this.horaminuto = h; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

}