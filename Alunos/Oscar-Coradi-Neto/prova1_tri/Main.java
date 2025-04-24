package prova1_tri;
// import clientes; // Removed or replace with the correct package path if needed

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();  // O hotel será responsável por gerenciar os quartos e reservas
        Scanner scanner = new Scanner(System.in);
        String nome = null; // Inicializa a variável nome
        int opcao;

        do {
            System.out.println("\n----- Sistema de Gerenciamento de Hotel -----");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Listar Quartos");
            System.out.println("6. Listar Reservas");
            System.out.println("7. Histórico de Reservas por Hóspede");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarQuarto(scanner, hotel);
                    break;
                case 2:
                    cadastrarReserva(scanner, hotel);
                    break;
                case 3:
                    realizarCheckIn(scanner, hotel);
                    break;
                case 4:
                    realizarCheckOut(scanner, hotel);
                    break;
                case 5:
                    hotel.listarQuartos();
                    break;
                case 6:
                    hotel.listarReservas();
                    break;
                case 7:
                    historicoReservasPorHospede(scanner, hotel);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 8);

        scanner.close();
    }

    // Função para cadastrar quarto
    private static void cadastrarQuarto(Scanner scanner, Hotel hotel) {
        System.out.println("\n----- Cadastro de Quarto -----");

        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();

        System.out.print("Tipo do quarto (1 - Simples / 2 - Duplo): ");
        int tipo = scanner.nextInt();

        String tipoQuarto;
        switch (tipo) {
            case 1:
                tipoQuarto = "Simples";
                break;
            case 2:
                tipoQuarto = "Duplo";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.print("Preço diário: ");
        double preco = scanner.nextDouble();

        System.out.println("Capacidade do quarto: ");
        int hospedesQuarto = scanner.nextInt();

        // Criando e cadastrando o quarto
        hotel.cadastrarQuarto(numero, tipoQuarto, preco, hospedesQuarto, true);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    // Função para cadastrar reserva
    private static void cadastrarReserva(Scanner scanner, Hotel hotel) {
        System.out.println("\n----- Cadastro de Reserva -----");
        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.next();
        Cliente cliente = new Cliente(nomeHospede);

        hotel.listarQuartos();

        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Data de check-in (YYYY-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(scanner.next());

        System.out.print("Data de check-out (YYYY-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(scanner.next());

        int diasReservados = (int) (checkOut.toEpochDay() - checkIn.toEpochDay());
        if (diasReservados <= 0) {
            System.out.println("Data de check-out deve ser posterior à data de check-in.");
            return;
        }
        double valorTotal = diasReservados * hotel.quartos.get(numeroQuarto - 1).getPrecoDiarioQuarto();

        hotel.cadastrarReserva(cliente, numeroQuarto, diasReservados, valorTotal, null, null);
    }

    // Função para realizar check-in
    private static void realizarCheckIn(Scanner scanner, Hotel hotel) {
        System.out.println("\n----- Check-in -----");
        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.next();
        Cliente cliente = new Cliente(nomeHospede);

        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        hotel.realizarCheckIn(cliente, numeroQuarto);
    }

    // Função para realizar check-out
    private static void realizarCheckOut(Scanner scanner, Hotel hotel) {
        System.out.println("\n----- Check-out -----");
        System.out.print("Número do quarto: ");
        int numeroQuarto = scanner.nextInt();

        hotel.realizarCheckOut(numeroQuarto);
    }

    // Função para exibir o histórico de reservas por hóspede
    private static void historicoReservasPorHospede(Scanner scanner, Hotel hotel) {
        System.out.println("\n----- Histórico de Reservas -----");
        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.next();
        hotel.exibirHistoricoReservas(nomeHospede);
    }


}
