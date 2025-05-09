import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Exibir quartos");
            System.out.println("2. Realizar Check-in");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Verificar disponibilidade");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    hotel.exibirQuartos();
                    break;
                case 2:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Documento do cliente: ");
                    String documentoCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, documentoCliente);
                    System.out.print("Tipo de quarto (1 - Simples | 2 - Duplo): ");
                    int tipoNum = scanner.nextInt();
                    scanner.nextLine();
                    String tipoQuarto = (tipoNum == 1) ? "simples" : "duplo";
                    System.out.print("Data de check-in (dd/MM/yyyy): ");
                    String checkInStr = scanner.nextLine();
                    System.out.print("Data de check-out (dd/MM/yyyy): ");
                    String checkOutStr = scanner.nextLine();

                    LocalDate dataCheckIn = LocalDate.parse(checkInStr, formatter);
                    LocalDate dataCheckOut = LocalDate.parse(checkOutStr, formatter);

                    if (hotel.realizarCheckIn(cliente, tipoQuarto, dataCheckIn, dataCheckOut)) {
                        System.out.println("Check-in realizado com sucesso.");
                    } else {
                        System.out.println("Não há quartos disponíveis.");
                    }
                    break;
                case 3:
                    System.out.print("Nome do cliente: ");
                    String nomeReserva = scanner.nextLine();
                    System.out.print("Documento do cliente: ");
                    String docReserva = scanner.nextLine();
                    Cliente clienteReserva = new Cliente(nomeReserva, docReserva);

                    System.out.print("Tipo de quarto (1 - Simples | 2 - Duplo): ");
                    int tipoReserva = scanner.nextInt();
                    scanner.nextLine();
                    String tipoQuartoReserva = (tipoReserva == 1) ? "simples" : "duplo";

                    System.out.print("Data de check-in (dd/MM/yyyy): ");
                    String checkInReservaStr = scanner.nextLine();
                    System.out.print("Data de check-out (dd/MM/yyyy): ");
                    String checkOutReservaStr = scanner.nextLine();

                    LocalDate dataInReserva = LocalDate.parse(checkInReservaStr, formatter);
                    LocalDate dataOutReserva = LocalDate.parse(checkOutReservaStr, formatter);

                    hotel.fazerReserva(clienteReserva, tipoQuartoReserva, dataInReserva, dataOutReserva);
                    break;
                case 4:
                    System.out.print("Nome do cliente para Check-out: ");
                    String nomeCheckout = scanner.nextLine();
                    Cliente clienteCheckout = new Cliente(nomeCheckout, "");
                    hotel.realizarCheckOut(clienteCheckout);
                    break;
                case 5:
                    System.out.print("Data para verificar disponibilidade (dd/MM/yyyy): ");
                    String dataStr = scanner.nextLine();
                    LocalDate data = LocalDate.parse(dataStr, formatter);
                    hotel.verificarDisponibilidade(data);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
