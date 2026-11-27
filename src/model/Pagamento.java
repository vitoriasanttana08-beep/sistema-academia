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
    private int duracaoMeses;

    public Pagamento(int id, String cpfAluno, double valor, LocalDate dataPagamento, FormaPagamento formaPagamento, String status, String descricao, int duracaoMeses ) {
        this.id = id;
        this.cpfAluno = cpfAluno;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.descricao = descricao;
        this.duracaoMeses = duracaoMeses;
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

    public int getduracaoMeses() {
    return duracaoMeses;
    }

    public void setduracaoMeses(int duracaoMeses) {
    this.duracaoMeses = duracaoMeses;
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

            System.out.println("Selecione a duração do plano:");
            System.out.println("1 - Mensal");
            System.out.println("2 - Trimestral");
            System.out.println("3 - Semestral");
            System.out.println("4 - Anual");

            int opcaoPlano = sc.nextInt();
            sc.nextLine();

            int duracaoMeses;

            switch (opcaoPlano) {
                case 1:
                duracaoMeses = 1;
                break;
                case 2:
                duracaoMeses = 3;
                break;
                case 3:
                duracaoMeses = 6;
                break;
                case 4:
                duracaoMeses = 12;
                break;
                default:
                System.out.println("Plano inválido!");
                return;
            }

            //Definir o status do pagamento
                String status = "PAGO";

            //Solicitar descrição
            System.out.println("Descrição do pagamento: ");
            String descricao = sc.nextLine();

            Pagamento pagamento = new Pagamento(id, cpfAluno, valor, dataPagamento, formaPagamento, status, descricao,duracaoMeses);
            pagamentos.add(pagamento);

            System.out.println("Pagamento cadastrado com sucesso!");
        }

    public static void editarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
        
        System.out.println("Digite o Id do pagamento que deseja editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pagamento pagamento = buscarPagamentoPorId(pagamentos, id);

        if (pagamento == null) {
            System.out.println("Pagamento não encontrado!");
            return;
        }
    System.out.println("\n===== Editar cadastro =====");
    System.out.print("Novo id: ");
    pagamento.setid(sc.nextInt());
    sc.nextLine();
    System.out.println("Novo CPF do aluno: ");
    pagamento.setcpfAluno(sc.nextLine());
    System.out.print("Nova data de pagamento (AAAA-MM-DD): ");
    pagamento.setdataPagamento(LocalDate.parse(sc.nextLine()));
    //Forma de pagamento
    System.out.print("Nova forma de pagamento: \n");
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

    System.out.println("Selecione a duração do plano:");                
    System.out.println("1 - Mensal");
    System.out.println("2 - Trimestral");
    System.out.println("3 - Semestral");
    System.out.println("4 - Anual");

    int opcaoPlano = sc.nextInt();
    sc.nextLine();

    switch (opcaoPlano) {
        case 1:
            pagamento.setduracaoMeses(1);
            break;
        case 2:
            pagamento.setduracaoMeses(3);
            break;
        case 3:
            pagamento.setduracaoMeses(6);
            break;
        case 4:
            pagamento.setduracaoMeses(12);
            break;
        default:
            System.out.println("Plano inválido!");
            return;
}

    System.out.print("Novo status (PAGO): ");
    String novoStatus = sc.nextLine();

    if (!novoStatus.trim().isEmpty()) {
    pagamento.setstatus(novoStatus);
}
    System.out.print("Nova descrição: ");
    pagamento.setdescricao(sc.nextLine());

    System.out.println("Cadastro do pagamento atualizado com sucesso!");
}

public static void exibirPagamento(ArrayList<Pagamento> pagamentos) {

    if (pagamentos.isEmpty()) {
        System.out.println("Nenhum pagamento cadastrado!");
        return;
    }
    System.out.println("\n===== Todos os pagamentos ====");
    for (Pagamento pagamento : pagamentos) {
        pagamento.exibirDados();
    }
}

public static void consultarPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {
    System.out.println("Digite o Id do pagamento que deseja consultar: ");
    int id = Integer.parseInt(sc.nextLine());

    Pagamento pagamento = buscarPagamentoPorId(pagamentos, id);

    if (pagamento == null) {
        System.out.println("Pagamento não encontrado!");
        return;
    }
    pagamento.exibirDados();
}

  public static void excluirPagamento(Scanner sc, ArrayList<Pagamento> pagamentos) {

    System.out.println("Digite o Id do pagamento que deseja excluir: ");
    int id = Integer.parseInt(sc.nextLine());

    Pagamento pagamento = buscarPagamentoPorId(pagamentos, id);

    if (pagamento == null) {
        System.out.println("Pagamento não encontrado!");
        return;
    }

    System.out.println("Pagamento encontrado: " + pagamento.getid());

    System.out.println("Deseja realmente excluir? (sim/não): ");
    String resposta = sc.nextLine().trim();

    if (resposta.equalsIgnoreCase("sim")) {
        pagamentos.remove(pagamento);
        System.out.println("Pagamento excluído com sucesso!");
    } else if (resposta.equalsIgnoreCase("não") ||
               resposta.equalsIgnoreCase("nao")) {
        System.out.println("Exclusão cancelada.");
    } else {
        System.out.println("Resposta inválida. Exclusão cancelada.");
    }
}

public static boolean verificarAcesso(String cpf, ArrayList<Pagamento> pagamentos) {

    Pagamento ultimoPagamento = null;

    // Encontrar o pagamento mais recente que esteja pago
    for (Pagamento pagamento : pagamentos) {

        if (pagamento.getcpfAluno().equals(cpf)
                && pagamento.getstatus() != null
                && pagamento.getstatus().equalsIgnoreCase("PAGO")) {

            if (ultimoPagamento == null ||
                    pagamento.getdataPagamento().isAfter(
                            ultimoPagamento.getdataPagamento())) {

                ultimoPagamento = pagamento;
            }
        }
    }

    // Verificar se existe pagamento
    if (ultimoPagamento == null) {
        System.out.println("ALERTA: Aluno sem pagamento registrado!");
        System.out.println("Entrada na academia BLOQUEADA!");
        return false;
    }

    // Calcular vencimento conforme duração do plano + 10 dias
    LocalDate vencimento = ultimoPagamento.getdataPagamento()
            .plusMonths(ultimoPagamento.getduracaoMeses())
            .plusDays(10);

    // Verificar se venceu
    if (LocalDate.now().isAfter(vencimento)) {

        System.out.println("\n================================");
        System.out.println("       PAGAMENTO VENCIDO!");
        System.out.println("================================");
        System.out.println("Vencimento: " + vencimento);
        System.out.println("ENTRADA NA ACADEMIA BLOQUEADA!");
        System.out.println("Regularize seu pagamento para entrar.");

        return false;
    }

    // Se ainda não venceu
    System.out.println("Pagamento em dia!");
    System.out.println("Vencimento: " + vencimento);
    System.out.println("Entrada LIBERADA!");

    return true;
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
  
