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

    private static void criarAdministrador(ArrayList<Usuarios> usuarios) {

       Usuarios administrador = new Usuarios(
    "José Alves",
    "00894538912",
    LocalDate.of(1996, 12, 05),
    "(75) 9999-5569",
    "josealves@academia.com",
    "(75) 9854-7789",
    "Praça da Matriz, 123, Centro",
    "Administrador",
    "admin",
    "182542"
);

usuarios.add(administrador);

            System.out.println("Administrador inicial criado com sucesso!");
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
    private static boolean verificarPermissao(String cargo, int opcao) {

    if (cargo.equalsIgnoreCase("ADMINISTRADOR")) {
        return true;
    }

    if (cargo.equalsIgnoreCase("FUNCIONARIO")) {
        return opcao >= 1 && opcao <= 15;
    }

    if (cargo.equalsIgnoreCase("TREINADOR")) {
        return (opcao >= 1 && opcao <= 5) ||
               (opcao >= 16 && opcao <= 20);
    }

    return false;
}
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Alunos> alunos = new ArrayList<>();
        ArrayList<Pagamento> pagamentos = new ArrayList<>();
        ArrayList<Plano> planos = new ArrayList<>();
        ArrayList<Treino> treinos = new ArrayList<>();

        //Cria a lista de usuários do sistema
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        //Cria o administrador inicial
        criarAdministrador(usuarios);
        //Solicita login e senha ao usuário
        Usuarios usuarioLogado = realizarLogin(sc, usuarios);
        //Verifica se o login foi realizado corretamente
        if (usuarioLogado == null) {
            System.out.println("Acesso não autorizado!");
            sc.close();
            return;
        }
        //Armazena o cargo do usuário para controlar as permissões
        String cargo = usuarioLogado.getcargo();

        int opcao;

        do {
            System.out.println("\n======== Academia Corpo Em Movimento ========");
            //Aluno
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Editar cadastro de aluno");
            System.out.println("3 - Exibir todos os alunos");
            System.out.println("4 - Consultar aluno");
            System.out.println("5 - Excluir aluno");
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

            opcao = sc.nextInt();

            if (!verificarPermissao(cargo, opcao)) {
    System.out.println("Acesso negado! Você não tem permissão.");
    continue;
}

            switch (opcao) {
                case 1:
                    Alunos.cadastarAlunos(sc, alunos);
                    break;
                case 2:
                    Alunos.editarCadastro(sc, alunos);
                    break;
                case 3:
                    cadastrarPagamento(sc, pagamentos);
                    break;
                case 4:
                    cadastrarTreinos(sc, treinos);
                    break;
                case 21:
                    cadastrarUsuarios(sc, usuarios);
                    break;
                    case 23:
                    Usuarios.exibirUsuarios(usuarios);
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
        System.out.println("O plano está ativo? (sim/não): ");
        String resposta = sc.next();
        boolean ativo = resposta.equalsIgnoreCase("sim");
        sc.nextLine();

        Plano plano = new Plano(nome, descricao, duracaoMeses, valor, ativo);
        planos.add(plano);
        System.out.println("Plano cadastrado com sucesso!");
    }

    private static void cadastrarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
        int id = pagamentos.size() + 1;
 
            //Solicitar os dados do pagamento
            System.out.println("CPF do aluno: ");
            String cpfAluno = sc.nextLine();
            System.out.println("Valor: ");
            double valor = sc.nextDouble();
            sc.nextLine();

            LocalDate dataPagamento = LocalDate.now();
            
            //Selecionar a forma de pagamento
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

            //Definir o status do pagamento
                String status = "PAGO";

            //Solicitar descrição
            System.out.println("Descrição do pagamento: ");
            String descricao = sc.nextLine();

            Pagamento pagamento = new Pagamento(id, cpfAluno, valor, dataPagamento, formaPagamento, status, descricao);
            pagamentos.add(pagamento);

            System.out.println("Pagamento cadastrado com sucesso!");
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

            private static void cadastrarUsuarios(Scanner sc, ArrayList<Usuarios> usuarios) {
                String cpf;
                boolean cpfExiste;

                do {
                    System.out.println("CPF: ");
                    cpf = sc.nextLine();

                    cpfExiste = buscarUsuariosPorCpf(usuarios, cpf) != null;

                    if (cpf.length() != 11) {
                        System.out.println("CPF inválida!");
                    } else if (cpfExiste) {
                        System.out.println("Este CPF já está cadastrado!");
                    }
                } while (cpf.length() != 11 || cpfExiste);

                sc.nextLine();

                System.out.println("Nome: ");
                String nome = sc.nextLine();
                System.out.println("Data de nascimento: ");
                LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
                System.out.println("Telefone: ");
                String telefone = sc.nextLine();
                System.out.println("E-mail: ");
                String email = sc.nextLine();
                System.out.println("Contato de emergência: ");
                String contatoEmergencia = sc.nextLine();
                System.out.println("Endereço: ");
                String endereco = sc.nextLine();
                System.out.println("Cargo: ");
                String cargo = sc.nextLine();
                System.out.println("Login: ");
                String login = sc.nextLine();
                System.out.println("Senha: ");
                String senha = sc.nextLine();

                Usuarios usuario = new Usuarios(nome, cpf, dataNascimento, telefone, email, contatoEmergencia, endereco, cargo, login, senha);
                usuarios.add(usuario);
                System.out.println("Usuário cadastrado com sucesso!");
            }


    private static Plano buscarPlanoPorNome(ArrayList<Plano> planos, String nome) {
        for (Plano plano : planos) {
            if (plano.getnome().equalsIgnoreCase(nome)) {
                return plano;
            }
        }
        return null;
    }

    private static Treino buscarTreinoPorNome(ArrayList<Treino> treinos, String nome) {
        for (Treino treino : treinos) {
            if (treino.getnome().equalsIgnoreCase(nome)) {
                return treino;
            }
        }
        return null;
    }

    private static Usuarios buscarUsuariosPorCpf(ArrayList<Usuarios> usuarios, String cpf) {
        for (Usuarios usuario : usuarios) {
            if (usuario.getcpf().equalsIgnoreCase(cpf)) {
                return usuario;
            }
        }
        return null;
    }
}
