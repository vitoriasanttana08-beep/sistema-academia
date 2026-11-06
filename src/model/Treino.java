package model;

import java.time.LocalDate;

public class Treino {
        private String nome;
        private String descricao;
        private String grupoMuscular;
        private int series;
        private int repeticoes;
        private double carga;
        private int descanso;
        private boolean ativo;
        private LocalDate dataInicio;
        private LocalDate dataRenovacao;

        public Treino(String nome, String descricao, String grupoMuscular, int series, int repeticoes, double carga, int descanso, boolean ativo ) {
            this.nome = nome;
            this.descricao = descricao;
            this.grupoMuscular = grupoMuscular;
            this.series = series;
            this.repeticoes = repeticoes;
            this.carga = carga;
            this.descanso = descanso;
            this.ativo = ativo;

            this.dataInicio = LocalDate.now();
            this.dataRenovacao = dataInicio.plusDays(60);
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

         public String getgrupoMuscular() {
            return grupoMuscular;
        }

        public void setgrupoMuscular(String grupoMuscular) {
            this.grupoMuscular = grupoMuscular;
        }

        public int getseries() {
            return series;
        }

        public void setseries(int series) {
            this.series = series;
        }

        public int getrepeticoes() {
            return repeticoes;
        }

        public void setrepeticoes(int repeticoes) {
            this.repeticoes = repeticoes;
        }

        public double getcarga() {
            return carga;
        }

        public void setcarga(double carga) {
            this.carga = carga;
        }

        public int getdescanso() {
            return descanso;
        }

        public void setdescanso(int descanso) {
            this.descanso = descanso;
        }

        public boolean getativo() {
            return ativo;
        }

        public void setativo(boolean ativo) {
            this.ativo = ativo;
        }

        public LocalDate getdataInicio() {
            return dataInicio;
        }


        public LocalDate getdataRenovacao() {
            return dataRenovacao;
        }
        
       public boolean precisaRenovar() {
        return !LocalDate.now().isBefore(dataRenovacao);
       }

       public void renovarTreino() {
        this.dataInicio = LocalDate.now();
        this.dataRenovacao = dataInicio.plusDays(60);
       }

        public void exibirDados() {
        System.out.println("\n--- Dados do Treino ---");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Grupo muscular: " + grupoMuscular);
        System.out.println("Séries: " + series);
        System.out.println("Repetições: " + repeticoes);
        System.out.println("Carga: " + carga + " kg");
        System.out.println("Descanso: " + descanso + " segundos");
        System.out.println("Data de início: " + dataInicio);
        System.out.println("Data de renovação: " + dataRenovacao);
        System.out.println("Status: " + (ativo ? "Ativo" : "Inativo"));
        System.out.println("Precisa renovar: " + (precisaRenovar() ? "Sim" : "Não"));
    }

    @Override
    public String toString() {
        return nome;
    }


    }