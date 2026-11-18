package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
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

    public static void cadastrarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
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

    public static void editarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
        
        System.out.println("Digite o Id do pagamento que deseja editar: ");
        int id = sc.nextInt();

        Pagamento pagamento = buscarPagamentoPorId(pagamentos, id);

        if (pagamento == null) {
            System.out.println("Pagamento não encontrado!");
            return;
        }
    System.out.println("\n===== Editar cadastro =====");
    System.out.print("Novo id: ");
    pagamento.setid(sc.nextInt());
    System.out.println("Novo CPF do aluno: ");
    pagamento.setcpfAluno(sc.nextLine());
    System.out.print("Nova data de pagamento (AAAA-MM-DD): ");
    pagamento.setdataPagamento(LocalDate.parse(sc.nextLine()));
    //Forma de pagamento
    System.out.print("Nova forma de pagamento: ");
    System.out.println("1 - PIX");
    System.out.println("2 - Dinheiro");
    System.out.println("3 - Cartão de crédito");
    System.out.println("4 - Cartão de débito");
    System.out.println("5 - Transferência");
    int opcaoPagamento = Integer.parseInt(sc.nextLine());
    switch (opcaoPagamento) {
        case 1:
            pagamento.setformaPagamento(FormaPagamento.PIX);
            break;
        case 2:
            pagamento.setformaPagamento(FormaPagamento.DINHEIRO);
            break;
        case 3:
            pagamento.setformaPagamento(FormaPagamento.CARTAO_CREDITO);
            break;
        case 4:
            pagamento.setformaPagamento(FormaPagamento.CARTAO_DEBITO);
            break;
        case 5:
            pagamento.setformaPagamento(FormaPagamento.TRANSFERENCIA);
            break;
        default:
            System.out.println("Opção inválida!");
            return;
    }

    System.out.print("Novo status: ");
    pagamento.setstatus(sc.nextLine());
    System.out.print("Nova descrição: ");
    pagamento.setdescricao(sc.nextLine());

    System.out.println("Cadastro do pagamento atualizado com sucesso!");
}

public static void exibirPagamento(ArrayList<Pagamento> pagamentos) {

    if (pagamentos.isEmpty()) {
        System.out.println("Nenhum pagamento cadastrado!");
        return;
    }
    System.out.println("\n===== Todos os usuários ====");
    for (Pagamento pagamento : pagamentos) {
        pagamento.exibirDados();
    }
}

public static void consultarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
    System.out.println("Digite o Id do pagamento que deseja consultar: ");
    int id = sc.nextInt();

    Pagamento pagamento = buscarPagamentoPorId(pagamentos, id);

    if (pagamento == null) {
        System.out.println("Pagamento não encontrado!");
        return;
    }
    pagamento.exibirDados();
}

   public static void excluirPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {

    System.out.println("Digite o Id do pagamento que deseja excluir: ");
    int id = sc.nextInt();

    Pagamento pagamento = buscarPagamentoPorId(pagamentos, id);

    if (pagamento == null) {
        System.out.println("Pagamento não encontrado!");
        return;
    }

    System.out.println("Pagamento encontrado: " + pagamento.getid());
    System.out.print("Deseja realmente excluir? (sim/não): ");
    String resposta = sc.nextLine();

    if (resposta.equalsIgnoreCase("sim")) {
        pagamentos.remove(pagamento);
        System.out.println("Pagamento excluído com sucesso!");
    } else {
        System.out.println("Exclusão cancelada.");
    }
}

    private static Pagamento buscarPagamentoPorId(ArrayList<Pagamento> pagamentos, int id) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getid() == id) {
                return pagamento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pagamento " + id + " - " + cpfAluno;
    }

}