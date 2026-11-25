package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Alunos implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String contatoEmergencia;
    private Boolean restricaoMedica;
    private String desRestricao;
    private boolean ativo = true;
    
    public Alunos(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String contatoEmergencia, Boolean restricaoMedica, String desRestricao ) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.contatoEmergencia = contatoEmergencia;
        this.restricaoMedica = restricaoMedica;
        this.desRestricao = desRestricao;
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

    public boolean getrestricaoMedica() {
        return restricaoMedica;
    }

    public void setrestricaoMedica(boolean restricaoMedica) {
        this.restricaoMedica = restricaoMedica;
    }

    public String getdesRestricao() {
        return desRestricao;
    }

    public void setdesRestricao(String desRestricao) {
        this.desRestricao = desRestricao;
    }

    public boolean getativo() {
        return ativo;
    }

    public void setativo(boolean ativo) {
        this.ativo = ativo;
    }

    public static void cadastarAlunos(Scanner sc, ArrayList<Alunos> alunos) {
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
        System.out.println("Possui restrição médica? (sim/não): ");
        String resposta = sc.nextLine();
        boolean restricaoMedica = resposta.equalsIgnoreCase("sim");
        String desRestricao = "";

        if (restricaoMedica) {
            System.out.println("Descreva a restrição médica: ");
            desRestricao = sc.nextLine();
        }

        Alunos aluno = new Alunos(nome, cpf, dataNascimento, telefone, email, contatoEmergencia, restricaoMedica, desRestricao);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");

    }

    public static void editarAluno(Scanner sc, ArrayList<Alunos> alunos) {
        
        System.out.println("Digite o CPF do aluno(a) que deseja editar: ");
        String cpf = sc.nextLine();

        Alunos aluno = buscarAlunoPorCpf(alunos, cpf);

        if (aluno == null) {
            System.out.println("Aluno(a) não encontrado(a)!");
            return;
        }
    System.out.println("\n===== Editar cadastro =====");
    System.out.print("Novo nome: ");
    aluno.setnome(sc.nextLine());
    System.out.print("Nova data de nascimento (AAAA-MM-DD): ");
    aluno.setdataNascimento(LocalDate.parse(sc.nextLine()));
    System.out.print("Novo telefone: ");
    aluno.settelefone(sc.nextLine());
    System.out.print("Novo e-mail: ");
    aluno.setemail(sc.nextLine());
    System.out.print("Novo contato de emergência: ");
    aluno.setcontatoEmergencia(sc.nextLine());
    System.out.print("Possui restrição médica? (sim/não): ");
    String resposta = sc.nextLine();
    aluno.setrestricaoMedica(resposta.equalsIgnoreCase("sim"));

    if (aluno.getrestricaoMedica()) {
        System.out.print("Descreva a restrição médica: ");
        aluno.setdesRestricao(sc.nextLine());
    } else {
        aluno.setdesRestricao("");
    }

    System.out.println("Cadastro do aluno atualizado com sucesso!");
}

public static void exibirAlunos(ArrayList<Alunos> alunos, ArrayList<Pagamento> pagamentos) {

    if (alunos.isEmpty()) {
        System.out.println("Nenhum aluno(a) cadastrado(a)!");
        return;
    }
    System.out.println("\n===== Todos os alunos ====");
    for (Alunos aluno : alunos) {
        aluno.exibirDados(pagamentos);
    }
}

public static void consultarAluno(Scanner sc, ArrayList<Alunos> alunos, ArrayList<Pagamento> pagamentos) {
    System.out.println("Digite o CPF do aluno(a) que deseja consultar: ");
    String cpf = sc.nextLine();

    Alunos aluno = buscarAlunoPorCpf(alunos, cpf);

    if (aluno == null) {
        System.out.println("Aluno(a) não encontrado(a)!");
        return;
    }
    aluno.exibirDados(pagamentos);
}

public static void alterarStatusAluno(Scanner sc, ArrayList<Alunos> alunos) {

    System.out.print("Digite o CPF do aluno(a): ");
    String cpf = sc.nextLine();

    Alunos aluno = buscarAlunoPorCpf(alunos, cpf);

    if (aluno == null) {
        System.out.println("Aluno(a) não encontrado(a)!");
        return;
    }

    System.out.print("O aluno(a) está ativo(a)? (sim/não): ");
    String resposta = sc.nextLine();

    aluno.setativo(resposta.equalsIgnoreCase("sim"));

    System.out.println("Situação do aluno(a) atualizada com sucesso!");
}

public void exibirDados() {
        System.out.print("\n--- Dados do aluno(a) ---\n");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        System.out.println("Contato de emergência: " + contatoEmergencia);
        System.out.println("Restrição médica: " + restricaoMedica);
        System.out.println("Descrição da restrição médica: " + desRestricao);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
}
    
public void exibirDados(ArrayList<Pagamento> pagamentos) {
        System.out.print("\n--- Dados do aluno(a) ---\n");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        System.out.println("Contato de emergência: " + contatoEmergencia);
        System.out.println("Restrição médica: " + restricaoMedica);
        System.out.println("Descrição da restrição médica: " + desRestricao);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        
        //Verificar situação do pagamento
        Pagamento ultimoPagamento = null;

        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getcpfAluno().equals(cpf)
                && pagamento.getstatus().equalsIgnoreCase("PAGO")) {

            if (ultimoPagamento == null ||
                pagamento.getdataPagamento().isAfter(ultimoPagamento.getdataPagamento())) {

                ultimoPagamento = pagamento;
            }
        }
    }

            if (ultimoPagamento == null) {

        System.out.println("Situação do pagamento: SEM PAGAMENTO");

            } else {

            long dias = java.time.temporal.ChronoUnit.DAYS.between(
            ultimoPagamento.getdataPagamento(),
            LocalDate.now()
        );

            if (dias > 10) {
            System.out.println("Situação do pagamento: ATRASADO");
            System.out.println("ATENÇÃO: Pagamento pendente!");
            } else {
            System.out.println("Situação do pagamento: EM DIA");
        }
    }
}


    private static Alunos buscarAlunoPorCpf(ArrayList<Alunos> alunos, String cpf) {
        for (Alunos aluno : alunos) {
            if (aluno.getcpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return nome;
    }
}