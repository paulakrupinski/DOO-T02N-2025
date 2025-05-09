import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    List<Reserva> listaDeReservas = new ArrayList<>();
    List<Cliente> listaDeCliente = new ArrayList<>();
    List<Quartos> listaDeQuartos = new ArrayList<>();

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do cliente");
        String nome = scanner.nextLine();
        listaDeCliente.add(new Cliente(nome));
        System.out.println("Cliente cadastrado");
    }

    public void cadastrarQuarto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número do quarto");
        String numero = scanner.nextLine();
        System.out.println("Tipo do quarto (simples ou duplo):");
        String tipo = scanner.nextLine();
        System.out.println("Valor do quarto");
        String valor = scanner.nextLine();

        Quartos quarto;
        if (tipo.equals("simples")) {
            quarto = new Simples(numero, valor);
        } else if (tipo.equals("duplo")) {
            quarto = new Duplo(numero, valor);
        } else {
            System.out.println("Tipo de quarto inválido");
            return;
        }
        listaDeQuartos.add(quarto);
        System.out.println("Quarto cadastrado");
    }

    public void fazerReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do cliente");
        String nomeCliente = scanner.nextLine();
        System.out.println("Data de Check-in (formato dd/MM/yyyy)");
        String dataCheckInString = scanner.nextLine();
        System.out.println("Data de Check-out (formato dd/MM/yyyy)");
        String dataCheckOutString = scanner.nextLine();

        LocalDate dataCheckIn = LocalDate.parse(dataCheckInString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataCheckOut = LocalDate.parse(dataCheckOutString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for (Cliente cliente : listaDeCliente) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Quartos disponíveis  " + dataCheckIn + " a " + dataCheckOut + ":");
                for (Quartos quarto : listaDeQuartos) {
                    boolean reservado = false;
                    for (Reserva reserva : listaDeReservas) {
                        if (reserva.getNumeroQuarto().equals(quarto.getNumeroQuarto()) &&
                                reserva.getDataCheckIn().equals(dataCheckIn)) {
                            reservado = true;
                            break;
                        }
                    }
                    if (!reservado) {
                        System.out.println("Quarto " + quarto.getNumeroQuarto() + " - Tipo: " + quarto.getTipoDeQuarto());
                    }
                }

                System.out.println("Número do quarto para reservar");
                String numeroEscolhido = scanner.nextLine();

                for (Quartos quarto : listaDeQuartos) {
                    if (quarto.getNumeroQuarto().equals(numeroEscolhido) && !quarto.isDisponibilidade()) {
                        listaDeReservas.add(new Reserva(nomeCliente, dataCheckIn, dataCheckOut, quarto.getTipoDeQuarto(), numeroEscolhido));
                        quarto.setDisponibilidade(true);
                        System.out.println("Reserva feita.");
                        return;
                    }
                }
                System.out.println("Quarto não disponível ou não encontrado");
                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }

    public void fazerCheckin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do cliente");
        String nomeCliente = scanner.nextLine();
        for (Reserva reserva : listaDeReservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeCliente)) {
                System.out.println("Checkin feito no quarto " + reserva.getNumeroQuarto());
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void fazerCheckout() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do cliente");
        String nomeCliente = scanner.nextLine();

        for (Reserva reserva : listaDeReservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeCliente)) {
                Quartos quarto = findQuartoByNumero(reserva.getNumeroQuarto());
                if (quarto != null) {
                    LocalDate checkIn = reserva.getDataCheckIn();
                    LocalDate checkOut = reserva.getDataCheckOut();

                    long diasHospedagem = checkOut.toEpochDay() - checkIn.toEpochDay();
                    double valorDiaria = Double.parseDouble(quarto.getValorQuarto());
                    double total = diasHospedagem * valorDiaria;

                    quarto.setDisponibilidade(false);
                    listaDeReservas.remove(reserva);
                    System.out.println("Total a pagar: R$" + total);
                    System.out.println("Check-out realizado.");
                    return;
                }
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    private Quartos findQuartoByNumero(String numeroQuarto) {
        for (Quartos quarto : listaDeQuartos) {
            if (quarto.getNumeroQuarto().equals(numeroQuarto)) {
                return quarto;
            }
        }
        return null;
    }
}
