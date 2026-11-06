package model;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Cadastro> cadastros = new ArrayList<>();
        ArrayList<Pagamento> pagamentos = new ArrayList<>();
        ArrayList<Plano> planos = new ArrayList<>();
        ArrayList<Treino> treinos = new ArrayList<>();
         ArrayList<Usuarios> usuarios = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n======== Academia Corpo Em Movimento ========");
            System.out.println("1 - Cadastrar alunos" + cadastros);
            System.out.println("2 - Cadastrar plano" + planos );
            System.out.println("2 - Cadastrar pagamento" + pagamentos);
            System.out.println("4 - Cadastrar treinos" + treinos);
            System.out.println("5 - Cadastrar usuário" + usuarios);
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastarAlunos(sc, cadastros);
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

    private static void cadastarAlunos(Scanner sc, ArrayList<Cadastro> cadastros) {
        String cpf;
        boolean cpfExiste;

        do {
            System.out.println("CPF do aluno: ");
            cpf = sc.next();

            cpfExiste = buscarAlunoPorCpf(alunos, cpf) != null;

            if (cpf.length() != 11) {
                System.out.println("CPF inválido!");
            } else if (cpfExiste) {
                System.out.println("Este CPF já está cadastrado!");
            }
        } while (cpf.length() != 11 || cpfExiste);

        sc.nextLine();
    }
    
}
