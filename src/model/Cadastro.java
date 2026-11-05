package model;

import java.time.LocalDate;

public class Cadastro {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String contatoEmergencia;
    private Boolean restricaoMedica;
    private String desRestricao;

    public Cadastro(String nome, String cpf, LocalDate dataNascimento, String telefone, String email, String contatoEmergencia, Boolean restricaoMedica, String desRestricao ) {
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

}