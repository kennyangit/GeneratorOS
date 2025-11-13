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

    // Novo método para gerar o ID no formato "OSXX"
    public static String gerarProximoIdOS() {
        // Formata o número para ter sempre pelo menos 2 dígitos (ex: 1 -> 01, 10 -> 10)
        String idFormatado = String.format("OS%02d", proximoId);
        proximoId++; // Incrementa para o próximo
        return idFormatado;
    }

    public static boolean existeOS() {
        return !ordens.isEmpty();
    }
}