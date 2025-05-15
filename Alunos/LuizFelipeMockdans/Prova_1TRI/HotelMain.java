import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args) {
        SistemaHotel sistema = new SistemaHotel();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO HOTEL ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Listar Quartos");
            System.out.println("4. Fazer Reserva");
            System.out.println("5. Realizar Check-in");
            System.out.println("6. Realizar Check-out");
            System.out.println("7. Verificar Disponibilidade de Quarto");
            System.out.println("8. Listar Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarCliente(sistema, scanner);
                    break;
                case 2:
                    listarClientes(sistema);
                    break;
                case 3:
                    listarQuartos(sistema);
                    break;
                case 4:
                    fazerReserva(sistema, scanner, dateFormatter);
                    break;
                case 5:
                    realizarCheckin(sistema, scanner);
                    break;
                case 6:
                    realizarCheckout(sistema, scanner);
                    break;
                case 7:
                    verificarDisponibilidade(sistema, scanner, dateFormatter);
                    break;
                case 8:
                    listarReservas(sistema);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarCliente(SistemaHotel sistema, Scanner scanner) {
        System.out.println("\n--- CADASTRO DE CLIENTE ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        sistema.cadastrarCliente(nome, cpf, telefone);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes(SistemaHotel sistema) {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for (Cliente cliente : sistema.getClientes()) {
            System.out.println("ID: " + cliente.getId() + 
                             " | Nome: " + cliente.getNome() + 
                             " | CPF: " + cliente.getCpf() + 
                             " | Tel: " + cliente.getTelefone());
        }
    }

    private static void listarQuartos(SistemaHotel sistema) {
        System.out.println("\n--- LISTA DE QUARTOS ---");
        for (Quarto quarto : sistema.getQuartos()) {
            System.out.println("Número: " + quarto.getNumero() + 
                             " | Tipo: " + quarto.getTipo() + 
                             " | Capacidade: " + quarto.getCapacidade() + 
                             " | Preço/noite: R$" + quarto.getPrecoPorNoite());
        }
    }

    private static void fazerReserva(SistemaHotel sistema, Scanner scanner, DateTimeFormatter formatter) {
        System.out.println("\n--- NOVA RESERVA ---");
        
        listarClientes(sistema);
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        
        listarQuartos(sistema);
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Data de entrada (dd/MM/aaaa): ");
        LocalDate dataEntrada = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Data de saída (dd/MM/aaaa): ");
        LocalDate dataSaida = LocalDate.parse(scanner.nextLine(), formatter);
        
        System.out.print("Número de hóspedes: ");
        int numHospedes = Integer.parseInt(scanner.nextLine());
        
        Reserva reserva = sistema.reservarQuarto(numeroQuarto, cpf, dataEntrada, dataSaida, numHospedes);
        if (reserva != null) {
            System.out.println("Reserva realizada com sucesso! Número: " + reserva.getNumero());
        }
    }

    private static void realizarCheckin(SistemaHotel sistema, Scanner scanner) {
        System.out.println("\n--- CHECK-IN ---");
        listarReservas(sistema);
        System.out.print("Digite o número da reserva: ");
        int numeroReserva = Integer.parseInt(scanner.nextLine());
        
        if (sistema.realizarCheckin(numeroReserva)) {
            System.out.println("Check-in realizado com sucesso!");
        }
    }

    private static void realizarCheckout(SistemaHotel sistema, Scanner scanner) {
        System.out.println("\n--- CHECK-OUT ---");
        listarReservas(sistema);
        System.out.print("Digite o número da reserva: ");
        int numeroReserva = Integer.parseInt(scanner.nextLine());
        
        double total = sistema.realizarCheckout(numeroReserva);
        if (total > 0) {
            System.out.printf("Check-out realizado. Total: R$%.2f%n", total);
        }
    }

    private static void verificarDisponibilidade(SistemaHotel sistema, Scanner scanner, DateTimeFormatter formatter) {
        System.out.println("\n--- VERIFICAR DISPONIBILIDADE ---");
        listarQuartos(sistema);
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Data de entrada (dd/MM/aaaa): ");
        LocalDate dataEntrada = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Data de saída (dd/MM/aaaa): ");
        LocalDate dataSaida = LocalDate.parse(scanner.nextLine(), formatter);
        
        boolean disponivel = sistema.verificarDisponibilidadeQuarto(numeroQuarto, dataEntrada, dataSaida);
        System.out.println("Disponível: " + (disponivel ? "SIM" : "NÃO"));
    }

    private static void listarReservas(SistemaHotel sistema) {
        System.out.println("\n--- LISTA DE RESERVAS ---");
        for (Reserva reserva : sistema.getReservas()) {
            System.out.println(
                "Número: " + reserva.getNumero() + 
                " | Quarto: " + reserva.getQuarto().getNumero() + 
                " | Cliente: " + reserva.getCliente().getNome() +
                " | Entrada: " + reserva.getDataEntrada() + 
                " | Saída: " + reserva.getDataSaida() +
                " | Status: " + (reserva.isCheckoutRealizado() ? "CHECKOUT" : 
                               reserva.isCheckinRealizado() ? "CHECKIN" : "RESERVADO")
            );
        }
    }
}