package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuarios {
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


    @Override
    public String toString() {
        return nome;
    }
}
