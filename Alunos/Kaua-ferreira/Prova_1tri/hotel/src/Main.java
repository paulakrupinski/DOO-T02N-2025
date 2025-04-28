import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Quartos pré-cadastrados
        hotel.cadastrarQuartoSimples(101);
        hotel.cadastrarQuartoSimples(102);
        hotel.cadastrarQuartoDuplo(201);
        hotel.cadastrarQuartoDuplo(202);

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto Simples");
            System.out.println("3. Cadastrar Quarto Duplo");
            System.out.println("4. Fazer Reserva");
            System.out.println("5. Verificar Disponibilidade");
            System.out.println("6. Listar Reservas");
            System.out.println("7. Listar Quartos Disponíveis");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Documento do cliente: ");
                    String documento = scanner.nextLine();
                    hotel.cadastrarCliente(nome, documento);
                    break;

                case 2:
                    System.out.print("Número do quarto simples: ");
                    int numSimples = scanner.nextInt();
                    hotel.cadastrarQuartoSimples(numSimples);
                    break;

                case 3:
                    System.out.print("Número do quarto duplo: ");
                    int numDuplo = scanner.nextInt();
                    hotel.cadastrarQuartoDuplo(numDuplo);
                    break;

                case 4:
                    System.out.print("Documento do cliente: ");
                    String docCliente = scanner.nextLine();
                    System.out.print("Número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data de entrada (dd/MM/yyyy): ");
                    LocalDate entrada = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Data de saída (dd/MM/yyyy): ");
                    LocalDate saida = LocalDate.parse(scanner.nextLine(), formatter);
                    hotel.fazerReserva(docCliente, numeroQuarto, entrada, saida);
                    break;

                case 5:
                    System.out.print("Número do quarto: ");
                    int numVerificar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data de entrada (dd/MM/yyyy): ");
                    LocalDate ent = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Data de saída (dd/MM/yyyy): ");
                    LocalDate sai = LocalDate.parse(scanner.nextLine(), formatter);

                    Quarto q = hotel.buscarQuartoPorNumero(numVerificar);
                    if (q != null && hotel.verificarDisponibilidade(q, ent, sai)) {
                        System.out.println("Disponível!");
                    } else {
                        System.out.println("Não disponível.");
                    }
                    break;

                case 6:
                    hotel.listarReservas();
                    break;

                case 7:
                    System.out.print("Data de entrada (dd/MM/yyyy): ");
                    LocalDate dataEntrada = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Data de saída (dd/MM/yyyy): ");
                    LocalDate dataSaida = LocalDate.parse(scanner.nextLine(), formatter);
                    hotel.listarQuartosDisponiveis(dataEntrada, dataSaida);
                    break;

                case 0:
                System.out.print("Saindo... ");    
                rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
