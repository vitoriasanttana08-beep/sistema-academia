package model;

import java.time.LocalDate;

public class Pagamento {
    
    public enum FormaPagamento {
    PIX,
    DINHEIRO,
    CARTAO_CREDITO,
    CARTAO_DEBITO,
    TRANSFERENCIA
}

    private int id;
    private String cpfAluno;
    private double valor;
    private LocalDate dataPagamento;
    private FormaPagamento formaPagamento;
    private String status;
    private String descricao;

    public Pagamento(int id, String cpfAluno, double valor, LocalDate dataPagamento, FormaPagamento formaPagamento, String status, String descricao ) {
        this.id = id;
        this.cpfAluno = cpfAluno;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.descricao = descricao;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getcpfAluno() {
        return cpfAluno;
    }

    public void setcpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public double getvalor() {
        return valor;
    }

    public void setvalor(double valor) {
        this.valor = valor;
    }

    public LocalDate getdataPagamento() {
        return dataPagamento;
    }

    public void setdataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FormaPagamento getformaPagamento() {
        return formaPagamento;
    }

    public void setformaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public void exibirDados() {
        System.out.println("\n--- Dados do pagamento ---");
        System.out.println("ID: " + id);
        System.out.println("CPF do aluno: " + cpfAluno);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data do pagamento: " + dataPagamento);
        System.out.println("Forma de pagamento: " + formaPagamento);
        System.out.println("Status: " + status);
        System.out.println("Descrição: " + descricao);
    }

    @Override
    public String toString() {
        return "Pagamento " + id + " - " + cpfAluno;
    }

}