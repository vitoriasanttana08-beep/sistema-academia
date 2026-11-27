package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String contatoEmergencia;
    private String endereço;
    private String cargo;
    private String login;
    private String senha;

public Usuarios(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String contatoEmergencia, String endereço, String cargo, String login, String senha ) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.telefone = telefone;
    this.email = email;
    this.contatoEmergencia = contatoEmergencia;
    this.endereço = endereço;
    this.cargo = cargo;
    this.login = login;
    this.senha = senha;
    }

    public String getnome() {
        return nome;
    } 

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getcpf(){
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String gettelefone() {
        return telefone;
    }

    public void settelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getcontatoEmergencia() {
        return contatoEmergencia;
    }

    public void setcontatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getendereço() {
        return endereço;
    }

    public void setendereço(String endereço) {
        this.endereço = endereço;
    }

    public String getcargo() {
        return cargo;
    }

    public void setcargo(String cargo) {
        this.cargo = cargo;
    }

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getsenha() {
        return senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

    public static void exibirUsuarios(ArrayList<Usuarios> usuarios) {

    System.out.println("\n===== USUÁRIOS CADASTRADOS =====");

    if (usuarios.isEmpty()) {
        System.out.println("Nenhum usuário cadastrado.");
        return;
    }

    for (Usuarios usuario : usuarios) {
        System.out.println("\n--- Dados do usuário ---");
        System.out.println("Nome: " + usuario.getnome());
        System.out.println("CPF: " + usuario.getcpf());
        System.out.println("Data de nascimento: " + usuario.getdataNascimento());
        System.out.println("Telefone: " + usuario.gettelefone());
        System.out.println("E-mail: " + usuario.getemail());
        System.out.println("Contato de emergência: " + usuario.getcontatoEmergencia());
        System.out.println("Endereço: " + usuario.getendereço());
        System.out.println("Cargo: " + usuario.getcargo());
        System.out.println("Login: " + usuario.getlogin());
    }
}

public static void criarAdministrador(ArrayList<Usuarios> usuarios) {

    if (buscarUsuarioPorLogin(usuarios, "admin") == null) {

        Usuarios administrador = new Usuarios(
            "José Alves",
            "00894538912",
            LocalDate.of(1996, 12, 5),
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
}

public static void criarRecepcionista(ArrayList<Usuarios> usuarios) {
    
    if (buscarUsuarioPorLogin(usuarios, "recep") == null) {

        Usuarios recepcionista = new Usuarios(
            "Ana Duarte",
            "11111111111",
            LocalDate.of(2000, 05, 21),
            "(75) 1234-5678",
            "ana@academia.com",
            "(75) 2456-9910",
            "Praça da Imperatriz, 15, Centro",
            "Recepcionista",
            "recep",
            "230508"
        );

        usuarios.add(recepcionista);
        System.out.println("Recepcionista criada com sucesso!");
    }
}

public static void criarTreinador(ArrayList<Usuarios> usuarios) {
    
    if (buscarUsuarioPorLogin(usuarios, "trei") == null) {

        Usuarios treinador = new Usuarios(
            "Hugo Carvalho",
            "23467298711",
            LocalDate.of(2000, 05, 12),
            "(75) 7768-9756",
            "hugoc@academia.com",
            "(75) 9987-5312",
            "Avenida Nossa Senhora da Rosa Mística, 159, João Paulo II",
            "Treinador",
            "trei",
            "121314"
        );

        usuarios.add(treinador);

        System.out.println("Treinador criado com sucesso!");
    }
}

public static void cadastrarUsuarios(Scanner sc, ArrayList<Usuarios> usuarios) {
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

public static void editarUsuario(Scanner sc, ArrayList<Usuarios> usuarios) {
        
        System.out.println("Digite o CPF do usuário(a) que deseja editar: ");
        String cpf = sc.nextLine();

        Usuarios usuario = buscarUsuariosPorCpf(usuarios, cpf);

        if (usuarios == null) {
            System.out.println("Usuário(a) não encontrado(a)!");
            return;
        }
    System.out.println("\n===== Editar cadastro =====");
    System.out.print("Novo nome: ");
    usuario.setnome(sc.nextLine());
    System.out.println("Novo CPF: ");
    usuario.setcpf(sc.nextLine());
    System.out.print("Nova data de nascimento (AAAA-MM-DD): ");
    usuario.setdataNascimento(LocalDate.parse(sc.nextLine()));
    System.out.print("Novo telefone: ");
    usuario.settelefone(sc.nextLine());
    System.out.print("Novo e-mail: ");
    usuario.setemail(sc.nextLine());
    System.out.print("Novo contato de emergência: ");
    usuario.setcontatoEmergencia(sc.nextLine());
    System.out.println("Novo endereço: ");
    usuario.setendereço(sc.nextLine());
    System.out.println("Novo cargo: ");
    usuario.setcargo(sc.nextLine());
    System.out.println("Novo login: ");
    usuario.setlogin(sc.nextLine());
    System.out.println("Nova senha: ");
    usuario.setsenha(sc.nextLine());

    System.out.println("Cadastro do usuário(a) atualizado com sucesso!");
}

public static void exibirUsuario(ArrayList<Usuarios> usuarios) {

    if (usuarios.isEmpty()) {
        System.out.println("Nenhum usuário(a) cadastrado(a)!");
        return;
    }
    System.out.println("\n===== Todos os usuários ====");
    for (Usuarios usuario : usuarios) {
        usuario.exibirDados();
    }
}

public static void consultarUsuario(Scanner sc, ArrayList<Usuarios> usuarios) {
    System.out.println("Digite o CPF do usuário(a) que deseja consultar: ");
    String cpf = sc.nextLine();

    Usuarios usuario = buscarUsuariosPorCpf(usuarios, cpf);

    if (usuarios == null) {
        System.out.println("Usuário(a) não encontrado(a)!");
        return;
    }
    usuario.exibirDados();
}

   public static void excluirUsuario(Scanner sc, ArrayList<Usuarios> usuarios) {

    System.out.println("Digite o cpf do usuário(a) que deseja excluir: ");
    String cpf = sc.nextLine();

    Usuarios usuario = buscarUsuariosPorCpf(usuarios, cpf);

    if (usuario == null) {
        System.out.println("Usuário(a) não encontrado!");
        return;
    }

    System.out.println("Usuário(a) encontrado(a): " + usuario.getnome());
    System.out.print("Deseja realmente excluir? (sim/não): ");
    String resposta = sc.nextLine();

    if (resposta.equalsIgnoreCase("sim")) {
        usuarios.remove(usuario);
        System.out.println("Usuário(a) excluído(a) com sucesso!");
    } else {
        System.out.println("Exclusão cancelada.");
    }
}


    public void exibirDados() {
        System.out.println("\n--- Dados do usuário ---");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        System.out.println("Contato de emergência: " + contatoEmergencia);
        System.out.println("Endereço: " + endereço);
        System.out.println("Cargo: " + cargo);
        System.out.println("Login: " + login);
    }

    private static Usuarios buscarUsuarioPorLogin(
        ArrayList<Usuarios> usuarios, String login) {

    for (Usuarios usuario : usuarios) {
        if (usuario.getlogin().equalsIgnoreCase(login)) {
            return usuario;
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


    @Override
    public String toString() {
        return nome;
    }
}
