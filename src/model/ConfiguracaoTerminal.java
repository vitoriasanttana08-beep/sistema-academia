package model;

import java.util.Scanner;

public interface ConfiguracaoTerminal {
    public static Scanner entrada = new Scanner(System.in, "UTF-8");

    public static void configurar() {
        System.setProperty("file.encoding", "UTF-8");
    }
}
