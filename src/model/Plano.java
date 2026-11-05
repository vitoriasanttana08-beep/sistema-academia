package model;

public class Plano {
    private String nome;
    private String descricao;
    private int duracaoMeses;
    private Double valor;
    private Boolean ativo;

    public Plano(String nome, String descricao, int duracaoMeses, double valor, boolean ativo ) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMeses = duracaoMeses;
        this.valor = valor;
        this.ativo = ativo;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getduracaoMeses() {
        return duracaoMeses;
    }

    public void setduracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public double getvalor() {
        return valor;
    }

    public void setvalor(Double valor) {
        this.valor = valor;
    }

    public Boolean getativo() {
        return ativo;
    }

    public void setativo(boolean ativo) {
        this.ativo = ativo;
    }

    public void exibirDados() {
        System.out.println("\n--- Dados do plano ---");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracaoMeses + " meses");
        System.out.println("Valor: R$ " + valor);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
    }

    @Override
    public String toString() {
        return nome;
    }

}