package app.controller;

import app.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorClientes {

    private static List<Cliente> listaClientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static List<Cliente> getClientes() {
        return listaClientes;
    }

    public static Cliente buscarPorNome(String nome) {
        for (Cliente c : listaClientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
