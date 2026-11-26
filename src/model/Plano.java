package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Plano implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String descricao;
    private int duracaoMeses;
    private Double valor;
    private Boolean ativo;

    public Plano(String nome, String descricao, int duracaoMeses, double valor, boolean ativo ) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMeses = duracaoMeses;
        this.valor = valor;
        this.ativo = ativo;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getduracaoMeses() {
        return duracaoMeses;
    }

    public void setduracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public double getvalor() {
        return valor;
    }

    public void setvalor(Double valor) {
        this.valor = valor;
    }

    public Boolean getativo() {
        return ativo;
    }

    public void setativo(boolean ativo) {
        this.ativo = ativo;
    }

    public void exibirDados() {
        System.out.println("\n--- Dados do plano ---");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracaoMeses + " meses");
        System.out.println("Valor: R$ " + valor);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
    }

    public static void cadastrarPlano(Scanner sc, ArrayList<Plano> planos) {
        // Implementação do cadastro de plano
        String nome;
        boolean nomeExiste;

        do {
            System.out.println("Nome do plano: ");
            nome = sc.next();

            nomeExiste = buscarPlanoPorNome(planos, nome) != null;

            if (nomeExiste) {
                System.out.println("Este plano já está cadastrado!");
            }
        } while (nomeExiste);

        sc.nextLine();

        //Solicitar os outros dados
        System.out.println("Descreva o plano: ");
        String descricao = sc.nextLine();
        System.out.println("Quantos meses é válido: ");
        int duracaoMeses = sc.nextInt();
        System.out.println("Valor do plano: ");
        double valor = sc.nextDouble();
        System.out.println("O plano está ativo? (sim/não): ");
        String resposta = sc.next();
        boolean ativo = resposta.equalsIgnoreCase("sim");
        sc.nextLine();

        Plano plano = new Plano(nome, descricao, duracaoMeses, valor, ativo);
        planos.add(plano);
        System.out.println("Plano cadastrado com sucesso!");
    }

    public static void editarPlano(Scanner sc, ArrayList<Plano> planos) {
        
        System.out.println("Digite o nome do plano que deseja editar: ");
        String nome = sc.nextLine();

        Plano plano = buscarPlanoPorNome(planos, nome);

        if (plano == null) {
            System.out.println("Plano não encontrado!");
            return;
        }
    System.out.println("\n===== Editar cadastro =====");
    System.out.print("Novo nome: ");
    plano.setnome(sc.nextLine());
    System.out.println("Nova descrição: ");
    plano.setdescricao(sc.nextLine());
    System.out.print("Nova duração: ");
    plano.setduracaoMeses(sc.nextInt());
    System.out.print("Novo valor: ");
    plano.setvalor(sc.nextDouble());
     System.out.println("Novo status: (sim/não): ");
    String resposta = sc.next();
    boolean ativo = resposta.equalsIgnoreCase("sim");
    sc.nextLine();

    System.out.println("Cadastro do plano atualizado com sucesso!");
}

public static void exibirPlanos(ArrayList<Plano> planos) {

    if (planos.isEmpty()) {
        System.out.println("Nenhum plano cadastrado!");
        return;
    }
    System.out.println("\n===== Todos os planos ====");
    for (Plano plano : planos) {
        plano.exibirDados();
    }
}

public static void consultarPlano(Scanner sc, ArrayList<Plano> planos) {
    System.out.println("Digite o nome do plano que deseja consultar: ");
    String nome = sc.nextLine();

    Plano plano = buscarPlanoPorNome(planos, nome);

    if (plano == null) {
        System.out.println("Plano não encontrado!");
        return;
    }
    plano.exibirDados();
}

   public static void excluirPlano(Scanner sc, ArrayList<Plano> planos) {

    System.out.println("Digite o nome do plano que deseja excluir: ");
    String nome = sc.nextLine();

    Plano plano = buscarPlanoPorNome(planos, nome);

    if (plano == null) {
        System.out.println("Plano não encontrado!");
        return;
    }

    System.out.println("Plano encontrado: " + plano.getnome());
    System.out.print("Deseja realmente excluir? (sim/não): ");
    String resposta = sc.nextLine();

    if (resposta.equalsIgnoreCase("sim")) {
        planos.remove(plano);
        System.out.println("Plano excluído com sucesso!");
    } else {
        System.out.println("Exclusão cancelada.");
    }
}

     private static Plano buscarPlanoPorNome(ArrayList<Plano> planos, String nome) {
        for (Plano plano : planos) {
            if (plano.getnome().equalsIgnoreCase(nome)) {
                return plano;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return nome;
    }

}