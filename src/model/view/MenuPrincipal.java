package model.view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Alunos;
import model.Pagamento;
import model.Persistencia;
import model.Plano;
import model.Treino;
import model.Usuarios;
import model.Permissao;

public class MenuPrincipal {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Carregar os dados salvos
        Object[] dados = Persistencia.carregar();

        ArrayList<Alunos> alunos;
        ArrayList<Pagamento> pagamentos;
        ArrayList<Plano> planos;
        ArrayList<Treino> treinos;
        ArrayList<Usuarios> usuarios;

        if (dados == null) {

        alunos = new ArrayList<>();
        pagamentos = new ArrayList<>();
        planos = new ArrayList<>();
        treinos = new ArrayList<>();
        usuarios = new ArrayList<>();

    } else {

        alunos = (ArrayList<Alunos>) dados[0];
        pagamentos = (ArrayList<Pagamento>) dados[1];
        planos = (ArrayList<Plano>) dados[2];
        treinos = (ArrayList<Treino>) dados[3];
        usuarios = (ArrayList<Usuarios>) dados[4];
    }

    Treino.cadastrarTreinoPadrao(treinos);

    // Cria o administrador inicial somente se não existir
    if (usuarios.isEmpty()) {
        Usuarios.criarAdministrador(usuarios);
    }

    // Solicita login e senha
    Usuarios usuarioLogado = realizarLogin(sc, usuarios);

    if (usuarioLogado == null) {
        System.out.println("Acesso não autorizado!");

        Persistencia.salvar(alunos, pagamentos, planos, treinos, usuarios);

        sc.close();
        return;
    }

    // Armazena o cargo do usuário
    String cargo = usuarioLogado.getcargo();

        if (cargo.equalsIgnoreCase("Treinador")) {
            MenuTreinador.menuTreinador(sc, alunos, planos, treinos, pagamentos);
        } else {
        int opcao;

        do {
            System.out.println("\n======== Academia Corpo Em Movimento ========");
            //Aluno
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Editar cadastro de aluno");
            System.out.println("3 - Exibir todos os alunos");
            System.out.println("4 - Consultar aluno");
            System.out.println("5 - Status do aluno");
            System.out.println("===============================");
            //Plano
            System.out.println("6 - Cadastrar plano");
            System.out.println("7 - Editar cadastro de plano");
            System.out.println("8 - Exibir todos os planos");
            System.out.println("9 - Consultar plano");
            System.out.println("10 - Excluir plano");
            System.out.println("===============================");
            //Pagamento
            System.out.println("11 - Cadastrar pagamento");
            System.out.println("12 - Editar cadastro de pagamento");
            System.out.println("13 - Exibir todos os pagamentos");
            System.out.println("14 - Consultar pagamento");
            System.out.println("15 - Excluir pagamento");
            System.out.println("===============================");
            //Treino
            System.out.println("16 - Cadastrar treino");
            System.out.println("17 - Editar cadastro de treino");
            System.out.println("18 - Exibir todos os treinos");
            System.out.println("19 - Consultar treino");
            System.out.println("20 - Excluir treino");
            System.out.println("===============================");
            //Usuário
            System.out.println("21 - Cadastrar usuário");
            System.out.println("22 - Editar cadastro de usuário");
            System.out.println("23 - Exibir todos os usuários");
            System.out.println("24 - Consultar usuário");
            System.out.println("25 - Excluir usuário");
            System.out.println("===============================");
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());
        
        try {
            if (!Permissao.verificarPermissao(cargo, opcao)) {
    System.out.println("Acesso negado! Você não tem permissão.");
    continue;
}

            switch (opcao) {
                case 1:
                    Alunos.cadastarAlunos(sc, alunos);
                    break;
                case 2:
                    Alunos.editarAluno(sc, alunos);
                    break;
                case 3:
                    Alunos.exibirAlunos(alunos, pagamentos);
                    break;
                case 4:
                    Alunos.consultarAluno(sc, alunos, pagamentos);
                    break;
                case 5:
                    Alunos.alterarStatusAluno(sc, alunos);
                    break;
                case 6:
                    Plano.cadastrarPlano(sc, planos);
                    break;
                case 7:
                    Plano.editarPlano(sc, planos);
                    break;
                case 8:
                    Plano.exibirPlanos(planos);
                    break;
                case 9: 
                    Plano.consultarPlano(sc, planos);
                    break;
                case 10:
                    Plano.excluirPlano(sc, planos);
                    break;
                case 11:
                    Pagamento.cadastrarPagamento(sc, pagamentos); 
                    break;
                case 12:
                    Pagamento.editarPagamento(sc, pagamentos);  
                    break;
                case 13:
                    Pagamento.exibirPagamento(pagamentos);
                    break;
                case 14:
                    Pagamento.consultarPagamento(sc, pagamentos); 
                    break;
                case 15:
                    Pagamento.excluirPagamento(sc, pagamentos);
                    break;
                case 16:
                    Treino.cadastrarTreinos(sc, treinos);
                    break;
                case 17:
                    Treino.editarTreino(sc, treinos);
                    break;
                case 18:
                    Treino.exibirTreino(treinos);
                    break;
                case 19:
                    Treino.consultarTreino(sc, treinos);
                    break;
                case 20:
                    Treino.excluirTreino(sc, treinos);
                    break;
                case 21:
                    Usuarios.cadastrarUsuarios(sc, usuarios);
                    break;
                case 22:
                    Usuarios.editarUsuario(sc, usuarios);
                    break;
                case 23:
                    Usuarios.exibirUsuarios(usuarios);
                    break;
                case 24:
                    Usuarios.consultarUsuario(sc, usuarios);
                    break;
                case 25: 
                    Usuarios.excluirUsuario(sc, usuarios);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
    //Salva as listas após cada operação
    Persistencia.salvar(
    alunos,
    pagamentos,
    planos,
    treinos,
    usuarios
);

    } catch (Exception e) {
        System.out.println("Ocorreu um erro: " + e.getMessage());
        System.out.println("Voltando ao menu principal...");
    }

        } while (opcao != 0); 
    }
        sc.close();
    }
       
           
    private static Usuarios realizarLogin(Scanner sc, ArrayList<Usuarios> usuarios) {

    while (true) {
        System.out.println("\n==== LOGIN ====");
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        for (Usuarios usuario : usuarios) {
            if (usuario.getlogin() != null && usuario.getsenha() != null
                    && usuario.getlogin().equals(login)
                    && usuario.getsenha().equals(senha)) {

                System.out.println("\nBem-vindo(a), " + usuario.getnome() + "!");
                return usuario;
            }
        }

        System.out.println("\nLogin ou senha incorretos! Tente novamente.\n");
    }
}
}