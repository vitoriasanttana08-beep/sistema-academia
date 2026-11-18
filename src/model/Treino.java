package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Treino implements Serializable {

    private static final long serialVersionUID = 1L;

        private String nome;
        private String descricao;
        private String grupoMuscular;
        private int series;
        private int repeticoes;
        private double carga;
        private int descanso;
        private boolean ativo;
        private LocalDate dataInicio;
        private LocalDate dataRenovacao;

        public Treino(String nome, String descricao, String grupoMuscular, int series, int repeticoes, double carga, int descanso, boolean ativo ) {
            this.nome = nome;
            this.descricao = descricao;
            this.grupoMuscular = grupoMuscular;
            this.series = series;
            this.repeticoes = repeticoes;
            this.carga = carga;
            this.descanso = descanso;
            this.ativo = ativo;

            this.dataInicio = LocalDate.now();
            this.dataRenovacao = dataInicio.plusDays(60);
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

         public String getgrupoMuscular() {
            return grupoMuscular;
        }

        public void setgrupoMuscular(String grupoMuscular) {
            this.grupoMuscular = grupoMuscular;
        }

        public int getseries() {
            return series;
        }

        public void setseries(int series) {
            this.series = series;
        }

        public int getrepeticoes() {
            return repeticoes;
        }

        public void setrepeticoes(int repeticoes) {
            this.repeticoes = repeticoes;
        }

        public double getcarga() {
            return carga;
        }

        public void setcarga(double carga) {
            this.carga = carga;
        }

        public int getdescanso() {
            return descanso;
        }

        public void setdescanso(int descanso) {
            this.descanso = descanso;
        }

        public boolean getativo() {
            return ativo;
        }

        public void setativo(boolean ativo) {
            this.ativo = ativo;
        }

        public LocalDate getdataInicio() {
            return dataInicio;
        }


        public LocalDate getdataRenovacao() {
            return dataRenovacao;
        }
        
       public boolean precisaRenovar() {
        return !LocalDate.now().isBefore(dataRenovacao);
       }

       public void renovarTreino() {
        this.dataInicio = LocalDate.now();
        this.dataRenovacao = dataInicio.plusDays(60);
       }

        public void exibirDados() {
        System.out.println("\n--- Dados do Treino ---");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Grupo muscular: " + grupoMuscular);
        System.out.println("Séries: " + series);
        System.out.println("Repetições: " + repeticoes);
        System.out.println("Carga: " + carga + " kg");
        System.out.println("Descanso: " + descanso + " segundos");
        System.out.println("Data de início: " + dataInicio);
        System.out.println("Data de renovação: " + dataRenovacao);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("Precisa renovar: " + (precisaRenovar() ? "Sim" : "Não"));
    }


     public static void cadastrarTreinos(Scanner sc, ArrayList<Treino> treinos) {
                //Implementação de cadastro de treinos
                String nome = "";
                boolean nomeExiste;

                do {
                    System.out.println("Nome do treino: ");
                    nomeExiste = sc.nextBoolean();

                    nomeExiste = buscarTreinoPorNome(treinos, nome) != null;

                    if (nome.trim().isEmpty()) {
                        System.out.println("Nome inválido!");
                    } else if (nomeExiste) {
                        System.out.println("Este treino já está cadastrado!");
                    }
                } while (nome.trim().isEmpty() || nomeExiste);

                System.out.println("Descrição: ");
                String descricao = sc.nextLine();
                System.out.println("Grupo muscular: ");
                String grupoMuscular = sc.nextLine();
                System.out.println("Quantidade de séries: ");
                int series = sc.nextInt();
                System.out.println("Quantidade de repetições: ");
                int repeticoes = sc.nextInt();
                System.out.println("Carga (kg): ");
                double carga = sc.nextDouble();
                System.out.println("Descanso (segundos): ");
                int descanso = sc.nextInt();
                System.out.println("Treino ativo? (ativo/inativo): ");
                boolean ativo = sc.nextBoolean();
                sc.nextLine();

                Treino treino = new Treino(nome, descricao, grupoMuscular, series, repeticoes, carga, descanso, ativo);
                treinos.add(treino);

                System.out.println("Treino cadastrado com sucesso!");
            }

     private static Treino buscarTreinoPorNome(ArrayList<Treino> treinos, String nome) {
        for (Treino treino : treinos) {
            if (treino.getnome().equalsIgnoreCase(nome)) {
                return treino;
            }
        }
        return null;
    }

    public static void editarTreino(Scanner sc, ArrayList<Treino> treinos) {

        System.out.println("Digite o nome do treino que deseja editar: ");
        String nome = sc.nextLine();

        Treino treino = buscarTreinoPorNome(treinos, nome);

        if (treino == null) {
            System.out.println("Treino não encontrado!");
            return;
        }
        System.out.println("\n==== Editar cadastro ====");
        System.out.println("Novo nome: ");
        treino.setnome(sc.nextLine());
        System.out.println("Nova descrição: ");
        treino.setdescricao(sc.nextLine());
        System.out.println("Novo grupo muscular: ");
        treino.setgrupoMuscular(sc.nextLine());
        System.out.println("Nova quantidade de séries: ");
        treino.setseries(sc.nextInt());
        System.out.println("Nova quantidade de repetições: ");
        treino.setrepeticoes(sc.nextInt());
        System.out.println("Nova carga (kg): ");
        treino.setcarga(sc.nextDouble());
        System.out.println("Novo descanso (segundos): ");
        treino.setdescanso(sc.nextInt());
        System.out.println("Novo status do treino: (ativo/inativo): ");
        String resposta = sc.nextLine();
        treino.setativo(resposta.equalsIgnoreCase("ativo"));

        System.out.println("Cadastro do treino atualizado com sucesso!");
    }

    public static void exibirTreino(ArrayList<Treino> treinos) {

    if (treinos.isEmpty()) {
        System.out.println("Nenhum treino cadastrado!");
        return;
    }
    System.out.println("\n===== Todos os treinos ====");
    for (Treino treino : treinos) {
        treino.exibirDados();
    }
}

public static void consultarTreino(Scanner sc, ArrayList<Treino> treinos) {
    System.out.println("Digite o nome do treino que deseja consultar: ");
    String nome = sc.nextLine();

    Treino treino = buscarTreinoPorNome(treinos, nome);

    if (treino == null) {
        System.out.println("Treino não encontrado!");
        return;
    }
    treino.exibirDados();
}

public static void excluirTreino(Scanner sc, ArrayList<Treino> treinos) {

    System.out.println("Digite o nome do treino que deseja excluir: ");
    String nome = sc.nextLine();

    Treino treino = buscarTreinoPorNome(treinos, nome);

    if (treino == null) {
        System.out.println("Treino não encontrado!");
        return;
    }

    System.out.println("Treino encontrado: " + treino.getnome());
    System.out.print("Deseja realmente excluir? (sim/não): ");
    String resposta = sc.nextLine();

    if (resposta.equalsIgnoreCase("sim")) {
        treinos.remove(treino);
        System.out.println("Treino excluído com sucesso!");
    } else {
        System.out.println("Exclusão cancelada.");
    }
}

    @Override
    public String toString() {
        return nome;
    }


    }