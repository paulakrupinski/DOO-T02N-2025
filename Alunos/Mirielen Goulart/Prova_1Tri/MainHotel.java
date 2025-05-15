

import java.time.LocalDate;
import java.util.Scanner;

public class MainHotel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerenciamento hotel = new Gerenciamento();
        int opcao;

        do {
            System.out.println("\n--- Menu do Hotel ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto Simples");
            System.out.println("3. Cadastrar Quarto Duplo");
            System.out.println("4. Fazer Reserva");
            System.out.println("5. Realizar Check-in");
            System.out.println("6. Realizar Check-out");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf, telefone);
                    hotel.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Número do quarto: ");
                    int numeroSimples = scanner.nextInt();
                    System.out.print("Preço diário: ");
                    double precoSimples = scanner.nextDouble();
                    hotel.cadastrarQuarto(new QuartoSimples(numeroSimples, precoSimples, true, 2));
                    System.out.println("Quarto simples cadastrado!");
                    break;

                case 3:
                    System.out.print("Número do quarto: ");
                    int numeroDuplo = scanner.nextInt();
                    System.out.print("Preço diário: ");
                    double precoDuplo = scanner.nextDouble();
                    hotel.cadastrarQuarto(new QuartoDuplo(numeroDuplo, precoDuplo, true, 4));
                    System.out.println("Quarto duplo cadastrado!");
                    break;

                case 4:
                    scanner.nextLine(); 
                    System.out.print("CPF do cliente: ");
                    String cpfBusca = scanner.nextLine();
                    Cliente clienteReserva = hotel.clientes.stream()
                            .filter(c -> c.getCpf().equals(cpfBusca))
                            .findFirst().orElse(null);

                    if (clienteReserva == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Número do quarto: ");
                    int numQuarto = scanner.nextInt();
                    CadastroQuarto quartoReserva = hotel.quartos.stream()
                            .filter(q -> q.getNumeroQuarto() == numQuarto)
                            .findFirst().orElse(null);

                    if (quartoReserva == null) {
                        System.out.println("Quarto não encontrado.");
                        break;
                    }

                    System.out.print("Data check-in (AAAA-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.next());
                    System.out.print("Data check-out (AAAA-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.next());

                    Reserva novaReserva = hotel.cadastrarReserva(clienteReserva, quartoReserva, checkIn, checkOut);
                    if (novaReserva != null) {
                        System.out.println("Reserva realizada com sucesso!");
                    }
                    break;

                case 5:
                    System.out.print("Número do quarto para check-in: ");
                    int numeroCheckIn = scanner.nextInt();
                    Reserva reservaCheckIn = hotel.reservas.stream()
                            .filter(r -> r.getCadastroQuarto().getNumeroQuarto() == numeroCheckIn && !r.isAtiva())
                            .findFirst().orElse(null);
                    if (reservaCheckIn != null) {
                        hotel.realizarCheckIn(reservaCheckIn);
                        System.out.println("Check-in realizado com sucesso!");
                    } else {
                        System.out.println("Reserva não encontrada ou já ativa.");
                    }
                    break;

                case 6:
                    System.out.print("Número do quarto para check-out: ");
                    int numeroCheckOut = scanner.nextInt();
                    Reserva reservaCheckOut = hotel.reservas.stream()
                            .filter(r -> r.getCadastroQuarto().getNumeroQuarto() == numeroCheckOut && r.isAtiva())
                            .findFirst().orElse(null);
                    if (reservaCheckOut != null) {
                        reservaCheckOut.calcularTotalDiarias();
                        hotel.relaizarCheckOut(reservaCheckOut);
                        System.out.println("\nCheck-out realizado com sucesso!");
                    } else {
                        System.out.println("Reserva não encontrada ou já finalizada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
