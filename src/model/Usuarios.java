package model;

import java.time.LocalDate;

public class Usuarios {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String contatoEmergencia;
    private String endereço;
    private String cargo;

public Usuarios(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String contatoEmergencia, String endereço, String cargo ) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.telefone = telefone;
    this.email = email;
    this.contatoEmergencia = contatoEmergencia;
    this.endereço = endereço;
    this.cargo = cargo;
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
        return telefone;
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
    }



    @Override
    public String toString() {
        return nome;
    }
}
