package model.view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Alunos;
import model.Pagamento;
import model.Plano;
import model.Treino;

public class MenuTreinador {
    
    public static void menuTreinador(Scanner sc, ArrayList<Alunos> alunos, ArrayList<Plano> planos, ArrayList<Treino> treinos, ArrayList<Pagamento> pagamentos) {

        int opcao;

        do {
        System.out.println("==== MENU DO TREINADOR ====\n");
        System.out.println("1 - Consultar alunos");
        System.out.println("2 - Consultar planos");
        System.out.println("3 - Cadastrar treinos");
        System.out.println("4 - Editar treinos");
        System.out.println("5 - Consultar treinos");
        System.out.println("6 - Exibir todos os treinos");
        System.out.println("7 - Atribuir treino ao aluno");
        System.out.println("8 - Sair");

        System.out.print("Escolha uma opção: ");
        
        opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                Alunos.consultarAluno(sc, alunos, pagamentos);
                break;
            case 2:
                Plano.consultarPlano(sc, planos);
                break;
            case 3:
                Treino.cadastrarTreinos(sc, treinos);
                break;
            case 4:
                Treino.editarTreino(sc, treinos);
                break;
            case 5:
                Treino.consultarTreino(sc, treinos);
                break;
            case 6:
                Treino.excluirTreino(sc, treinos);
                break;
            case 7:
                System.out.println("Atribuir treino ao aluno");
                break;
            case 8: 
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
            }
        } while (opcao != 8);
    }
}
