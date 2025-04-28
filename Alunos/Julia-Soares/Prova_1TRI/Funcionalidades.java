package Prova_1TRI;

public class Funcionalidades {

    // Método para realizar check-in do cliente
    public void checkIn(Clientes cliente, Quartos quarto) {
        if (quarto.isDisponivel()) {
            quarto.setDisponivel(false);
            System.out.println("Check-in realizado com sucesso para o cliente: " + cliente.getNome() +
                               " no quarto número: " + quarto.getNumeroQuarto());
        } else {
            System.out.println("Quarto não disponível para check-in.");
        }
    }

    // Método para realizar check-out do cliente
    public void checkOut(Clientes cliente, Quartos quarto, boolean reservaPaga) {
        if (!quarto.isDisponivel()) {
            if (reservaPaga) {
                quarto.setDisponivel(true);
                System.out.println("Check-out realizado com sucesso para o cliente: " + cliente.getNome() +
                                   " no quarto número: " + quarto.getNumeroQuarto());
            } else {
                System.out.println("Não é possível realizar o check-out. A reserva ainda não foi paga.");
            }
        } else {
            System.out.println("O quarto já está disponível.");
        }
    }

    // Método para calcular o valor total da reserva
    public void calcularValorTotal(Quartos quarto, int dias) {
        double valorTotal = quarto.getValorQuarto() * dias;
        System.out.println("Valor total da reserva para " + dias + " dias: R$ " + valorTotal);
    }

    // Método para exibir todos os quartos disponíveis
    public void mostrarQuartosDisponiveis(Quartos[] quartos) {
        System.out.println("Quartos disponiveis:");
        boolean encontrou = false;
        for (Quartos quarto : quartos) {
            if (quarto.isDisponivel()) {
                encontrou = true;
                System.out.println("Quarto " + quarto.getNumeroQuarto() + " | Tipo: " + quarto.getTipoQuarto() +
                                   " | Valor: R$ " + quarto.getValorQuarto());
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum quarto disponivel no momento.");
        }
    }
}
