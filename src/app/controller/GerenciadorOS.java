package app.controller;

import app.model.OrdemDeServico;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorOS {
    private static List<OrdemDeServico> ordens = new ArrayList<>();
    // Contador estático para gerar o ID sequencial
    private static int proximoId = 1;

    public static void adicionarOS(OrdemDeServico os) {
        ordens.add(os);
        // O incremento deve ocorrer após a adição se for usado fora do Gerenciador
        // Se o id for gerado aqui, o incremento ocorre após a geração.
    }

    public static List<OrdemDeServico> getOrdens() {
        return ordens;
    }

    // método para auto incrementar o id da OS
    public static String gerarProximoIdOS() {
        String idFormatado = String.format("OS%02d", proximoId);
        proximoId++;
        return idFormatado;
    }

    public static boolean existeOS() {
        return !ordens.isEmpty();
    }
}