package model.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.Alunos;
import model.Pagamento;
import model.Plano;
import model.Treino;
import model.Usuarios;

public class MenuPrincipal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Alunos> alunos = new ArrayList<>();
        ArrayList<Pagamento> pagamentos = new ArrayList<>();
        ArrayList<Plano> planos = new ArrayList<>();
        ArrayList<Treino> treinos = new ArrayList<>();
         ArrayList<Usuarios> usuarios = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n======== Academia Corpo Em Movimento ========");
            System.out.println("1 - Cadastrar alunos");
            System.out.println("2 - Cadastrar plano");
            System.out.println("2 - Cadastrar pagamento");
            System.out.println("4 - Cadastrar treinos");
            System.out.println("5 - Cadastrar usuário");
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastarAlunos(sc, alunos);
                    break;
                case 2:
                    cadastrarPlano(sc, planos);
                    break;
                case 3:
                    cadastrarPagamento(sc, pagamentos);
                    break;
                case 4:
                    cadastrarTreinos(sc, treinos);
                    break;
                case 5:
                    cadastrarUsuario(sc, usuarios);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0); 
            
        sc.close();
    }

    private static void cadastarAlunos(Scanner sc, ArrayList<Alunos> alunos) {
        // Implementação do cadastro de alunos
        String cpf;
        boolean cpfExiste;

        do {
            System.out.println("CPF: ");
            cpf = sc.next();

            cpfExiste = buscarAlunoPorCpf(alunos, cpf) != null;

            if (cpf.length() != 11) {
                System.out.println("CPF inválido!");
            } else if (cpfExiste) {
                System.out.println("Este CPF já está cadastrado!");
            }
        } while (cpf.length() != 11 || cpfExiste);

        sc.nextLine();

        //Solicitar os outros dados.
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Data de nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.nextLine();
        System.out.println("Contato de emergência: ");
        String contatoEmergencia = sc.nextLine();
        System.out.println("Possui restrição médica? (true/false): ");
        boolean restricaoMedica = sc.nextBoolean();
        sc.nextLine();

        String desRestricao = "";

        if (restricaoMedica) {
            System.out.println("Descreva a restrição médica: ");
            desRestricao = sc.nextLine();
        }

        Alunos aluno = new Alunos(nome, cpf, dataNascimento, telefone, email, contatoEmergencia, restricaoMedica, desRestricao);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");

    }
   
    private static void cadastrarPlano(Scanner sc, ArrayList<Plano> planos) {
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
        System.out.println("O plano está: ");
        boolean ativo = sc.nextBoolean();
        sc.nextLine();

        Plano plano = new Plano(nome, descricao, duracaoMeses, valor, ativo);
        planos.add(plano);
        System.out.println("Plano cadastrado com sucesso!");
    }

    private static void cadastrarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
        int id;
        boolean idExiste;

        do {
            System.out.println("ID do pagamento: ");
            id = sc.nextInt();
            sc.nextLine();

            idExiste = buscarPagamentoPorId(pagamentos, id) != null;

            if (idExiste) {
                System.out.println("Este ID já está cadastrado!");
            }
        } while (idExiste);
            
            System.out.println("Selecione a forma de pagamento:");
            System.out.println("1- PIX");
            System.out.println("2- Dinheiro");
            System.out.println("3- Cartão de crédito");
            System.out.println("4- Cartão de débito");
            System.out.println("5- Transferência");

            int opcaoPagamento = sc.nextInt();
            sc.nextLine();

            Pagamento.FormaPagamento formaPagamento;

            switch (opcaoPagamento) {
                case 1:
                    formaPagamento = Pagamento.FormaPagamento.PIX;
                    break;
                case 2:
                    formaPagamento = Pagamento.FormaPagamento.DINHEIRO;
                    break;
                case 3:
                    formaPagamento = Pagamento.FormaPagamento.CARTAO_CREDITO;
                    break;
                case 4:
                    formaPagamento = Pagamento.FormaPagamento.CARTAO_DEBITO;
                    break;
                case 5:
                    formaPagamento = Pagamento.FormaPagamento.TRANSFERENCIA;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }

            System.out.println("Status de pagamento: ");
            String status = sc.nextLine();
            System.out.println("Descrição do pagamento: ");
            String descricao = sc.nextLine();

            Pagamento pagamento = new Pagamento(id, descricao, opcaoPagamento, null, formaPagamento, status, descricao)
        }
    

    private static Alunos buscarAlunoPorCpf(ArrayList<Alunos> alunos, String cpf) {
        for (Alunos aluno : alunos) {
            if (aluno.getcpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    private static Plano buscarPlanoPorNome(ArrayList<Plano> planos, String nome) {
        for (Plano plano : planos) {
            if (plano.getnome().equals(plano)) {
                return plano;
            }
        }
        return null;
    }
}
