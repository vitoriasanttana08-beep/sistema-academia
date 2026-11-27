package model;

public class Permissao {

public static boolean verificarPermissao(String cargo, int opcao) {

    if (cargo == null) {
        return false;
    }
    cargo = cargo.trim();
    // Todos os cargos podem sair
    if (opcao == 0) {
        return true;
    }
    // Administrador: acesso total
    if (cargo.equalsIgnoreCase("Administrador")) {
        return opcao >= 1 && opcao <= 27;
    }
    // Recepcionista
    if (cargo.equalsIgnoreCase("Recepcionista")) {
        switch (opcao) {
            case 1:  // Cadastrar aluno
            case 2:  // Editar aluno
            case 3:  // Exibir alunos
            case 4:  // Consultar aluno
            case 5:  // Alterar status aluno

            case 8:  // Exibir planos
            case 9:  // Consultar plano

            case 11: // Cadastrar pagamento
            case 12: // Editar pagamento
            case 13: // Exibir pagamentos
            case 14: // Consultar pagamento
            case 18: // Exibir todos os treinos
            case 19: // Consultar treino
            case 26: // Registrar entrada de aluno
            case 27: // Consultar horário de pico
                return true;

            default:
                return false;
        }
    }
    // Treinador
    if (cargo.equalsIgnoreCase("Treinador")) {
        switch (opcao) {
            case 4:  // Consultar aluno
            case 9: // Consultar plano

            case 16: // Cadastrar treino
            case 17: // Editar treino
            case 18: // Exibir treinos
            case 19: // Consultar treino
            case 20: // Excluir treino
                return true;

            default:
                return false;
        }
    }
    return false;
}
}