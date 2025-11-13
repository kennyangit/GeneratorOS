package app.controller;

import app.model.OrdemDeServico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorOS {
    private static final String ARQUIVO = "ordens.dat";
    private static List<OrdemDeServico> ordens = carregarOrdens();
    private static int proximoId = 1;

    public static void adicionarOS(OrdemDeServico os) {
        ordens.add(os);
        salvarOrdens();
    }

    public static List<OrdemDeServico> getOrdens() {
        return ordens;
    }

    public static String gerarProximoIdOS() {
        String idFormatado = String.format("OS%02d", proximoId);
        proximoId++;
        return idFormatado;
    }

    public static boolean existeOS() {
        return !ordens.isEmpty();
    }

    public static void salvarOrdens() {
        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream("ordens.dat"))) {
            oos.writeObject(ordens);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static List<OrdemDeServico> carregarOrdens() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<OrdemDeServico>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
