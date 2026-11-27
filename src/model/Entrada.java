package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada implements Serializable{

    private static final long serialVersionUID = 1L;

    private String cpfAluno;
    private LocalDateTime horarioEntrada;

    public Entrada(String cpfAluno, LocalDateTime horarioEntrada) {
        this.cpfAluno = cpfAluno;
        this.horarioEntrada = horarioEntrada;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public String getHorarioFormatado() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return horarioEntrada.format(formato);
    }

    public static void registrarEntrada(Scanner sc, ArrayList<Alunos> alunos,
        ArrayList<Pagamento> pagamentos, ArrayList<Entrada> entradas) {

    System.out.println("\n===== REGISTRO DE ENTRADA =====");

    if (alunos.isEmpty()) {
        System.out.println("Não existem alunos cadastrados.");
        return;
    }

    System.out.println("\nAlunos cadastrados:");
    Alunos.exibirAlunos(alunos, pagamentos);

    System.out.print("\nDigite o CPF do aluno que entrou: ");
    String cpf = sc.nextLine().trim();

    if (cpf.isEmpty()) {
        System.out.println("CPF não informado!");
        return;
    }

    // Procura o aluno pelo CPF
    Alunos alunoEncontrado = null;

    String cpfDigitado = cpf.replaceAll("[^0-9]", "");

    for (Alunos aluno : alunos) {

        String cpfCadastrado = aluno.getcpf().replaceAll("[^0-9]", "");

        if (cpfCadastrado.equals(cpfDigitado)) {
            alunoEncontrado = aluno;
            break;
        }
    }

    // Verifica se o aluno foi encontrado
    if (alunoEncontrado == null) {
        System.out.println("Aluno não encontrado!");
        return;
    }

    String situacao = alunoEncontrado.calcularSituacaoPagamento(pagamentos);

if (situacao.equalsIgnoreCase("ATRASADO")
        || situacao.equalsIgnoreCase("SEM PAGAMENTO")) {

    System.out.println("\nEntrada bloqueada!");

    if (situacao.equalsIgnoreCase("ATRASADO")) {
        System.out.println("Motivo: pagamento atrasado.");
    } else {
        System.out.println("Motivo: aluno sem pagamento registrado.");
    }

    return;
}

    // Registra a entrada
    Entrada entrada = new Entrada(cpf, LocalDateTime.now());
    entradas.add(entrada);

    System.out.println("\nEntrada registrada com sucesso!");
    System.out.println("CPF: " + cpf);
    System.out.println("Data e horário: " + entrada.getHorarioFormatado());
}
    public  static void relatorioHorariosPico(ArrayList<Entrada> entradas) {
    System.out.println("\n===== RELATÓRIO DE HORÁRIOS DE PICO =====");
    if (entradas.isEmpty()) {
        System.out.println("Nenhuma entrada foi registrada ainda.");
        return;
    }
    int manha = 0;
    int almoco = 0;
    int tarde = 0;
    int noite = 0;
    for (Entrada entrada : entradas) {

        int hora = entrada.getHorarioEntrada().getHour();

        if (hora >= 6 && hora < 12) {
            manha++;

        } else if (hora >= 12 && hora < 14) {
            almoco++;

        } else if (hora >= 14 && hora < 18) {
            tarde++;

        } else if (hora >= 18 && hora < 23) {
            noite++;
        }
    }
    System.out.println("\nEntradas por período:");
    System.out.println("Manhã (06h às 12h): " + manha);
    System.out.println("Almoço (12h às 14h): " + almoco);
    System.out.println("Tarde (14h às 18h): " + tarde);
    System.out.println("Noite (18h às 23h): " + noite);
    int maior = Math.max(manha,
            Math.max(almoco,
            Math.max(tarde, noite)));

    if (maior == 0) {
        System.out.println("\nNenhuma entrada nos horários analisados.");
        return;
    }
    System.out.println("\n===== HORÁRIO DE PICO =====");
    if (manha == maior) {
        System.out.println("Manhã (06h às 12h)");
    }
    if (almoco == maior) {
        System.out.println("Almoço (12h às 14h)");
    }
    if (tarde == maior) {
        System.out.println("Tarde (14h às 18h)");
    }
    if (noite == maior) {
        System.out.println("Noite (18h às 23h)");
    }
    System.out.println("Quantidade de entradas no pico: " + maior);
}

 @Override
    public String toString() {
        return cpfAluno;
    }

}
