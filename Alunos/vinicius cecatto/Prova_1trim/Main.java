package Prova_1trim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int opcao;
        do {
            System.out.println("\n=== MENU DO HOTEL ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Quarto");
            System.out.println("3 - Fazer Reserva");
            System.out.println("4 - Realizar Check-Out");
            System.out.println("5 - Listar Reservas");
            System.out.println("6 - Verificar Disponibilidade de Quarto");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner, hotel);
                    break;
                case 2:
                    cadastrarQuarto(scanner, hotel);
                    break;
                case 3:
                    fazerReserva(scanner, hotel);
                    break;
                case 4:
                    realizarCheckOut(scanner, hotel);
                    break;
                case 5:
                    hotel.listarReservas();
                    break;
                case 6:
                    verificarDisponibilidade(scanner, hotel);
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner, Hotel hotel) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        if (!hotel.cadastrarCliente(nome, cpf)) {
            System.out.println("Cadastro de cliente cancelado.");
        }
    }

    private static void cadastrarQuarto(Scanner scanner, Hotel hotel) {
        System.out.print("Digite o número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        String tipo = "";
        double precoDiaria = 0.0;
        boolean entradaValida = false;

        do {
            System.out.println("Escolha o tipo de quarto:");
            System.out.println("1 - Simples (R$ 100,00 por diária)");
            System.out.println("2 - Duplo (R$ 200,00 por diária)");
            System.out.print("Digite o tipo de quarto: ");
            String entradaTipo = scanner.nextLine().trim().toLowerCase();

            if (entradaTipo.equals("1") || entradaTipo.equals("simples")) {
                tipo = "simples";
                precoDiaria = 100.0;
                entradaValida = true;
            } else if (entradaTipo.equals("2") || entradaTipo.equals("duplo")) {
                tipo = "duplo";
                precoDiaria = 200.0;
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Por favor, tente novamente.");
            }
        } while (!entradaValida);

        if (!hotel.cadastrarQuarto(numero, precoDiaria, tipo)) {
            System.out.println("Cadastro de quarto cancelado.");
        }
    }

    private static void fazerReserva(Scanner scanner, Hotel hotel) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        LocalDate dataCheckIn = null;
        LocalDate dataCheckOut = null;

        boolean datasValidas = false;
        do {
            try {
                System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
                String dataCheckInStr = scanner.nextLine();
                dataCheckIn = LocalDate.parse(dataCheckInStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
                String dataCheckOutStr = scanner.nextLine();
                dataCheckOut = LocalDate.parse(dataCheckOutStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                if (dataCheckIn.isAfter(dataCheckOut)) {
                    System.out.println("Erro: A data de check-in deve ser anterior à data de check-out. Tente novamente.");
                } else {
                    datasValidas = true;
                }
            } catch (Exception e) {
                System.out.println("Erro: Formato de data inválido. Use dd/MM/yyyy. Tente novamente.");
            }
        } while (!datasValidas);

        Reserva reserva = hotel.fazerReserva(cpf, numeroQuarto, dataCheckIn, dataCheckOut);

        if (reserva != null) {
            double valorTotal = reserva.calcularTotalDiarias();
            System.out.printf("Reserva realizada com sucesso! Valor total a pagar: R$ %.2f%n", valorTotal);
        }
    }

    private static void realizarCheckOut(Scanner scanner, Hotel hotel) {
        System.out.print("Digite o número do quarto para realizar o check-out: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = hotel.buscarReservaPorQuarto(numeroQuarto);

        if (reserva != null) {
            double valorTotal = reserva.calcularTotalDiarias();
            hotel.realizarCheckOut(numeroQuarto);
            System.out.printf("Check-out realizado com sucesso! Valor total pago: R$ %.2f%n", valorTotal);
        } else {
            System.out.println("Erro: Nenhuma reserva encontrada para o quarto " + numeroQuarto);
        }
    }
    private static void verificarDisponibilidade(Scanner scanner, Hotel hotel) {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();

        LocalDate dataCheckIn = null;
        LocalDate dataCheckOut = null;

        boolean datasValidas = false;
        do {
            try {
                System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
                String dataCheckInStr = scanner.nextLine();
                dataCheckIn = LocalDate.parse(dataCheckInStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
                String dataCheckOutStr = scanner.nextLine();
                dataCheckOut = LocalDate.parse(dataCheckOutStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                if (dataCheckIn.isAfter(dataCheckOut)) {
                    System.out.println("Erro: A data de check-in deve ser anterior à data de check-out. Tente novamente.");
                } else {
                    datasValidas = true;
                }
            } catch (Exception e) {
                System.out.println("Erro: Formato de data inválido. Use dd/MM/yyyy. Tente novamente.");
            }
        } while (!datasValidas);

        boolean disponivel = hotel.verificarDisponibilidade(numeroQuarto, dataCheckIn, dataCheckOut);

        if (disponivel) {
            System.out.println("O quarto " + numeroQuarto + " está disponível.");
        } else {
            System.out.println("O quarto " + numeroQuarto + " não está disponível.");
        }
    }
}