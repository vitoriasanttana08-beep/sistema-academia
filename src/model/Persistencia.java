package model;

import java.io.*;

public class Persistencia {

    private static final String ARQUIVO = "academia.dat";

    // Salvar todos os dados
    public static void salvar(Object... dados) {

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO))) {

            out.writeObject(dados);

        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Carregar todos os dados
    public static Object[] carregar() {

        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(ARQUIVO))) {

            return (Object[]) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }
}