import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHotel sistema = new SistemaHotel();
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println();
            System.out.println("--- Sistema de Hotel ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Realizar Reserva");
            System.out.println("4. Exibir Reservas");
            System.out.println("5. Realizar Check-in");
            System.out.println("6. Realizar Check-out");
            System.out.println("7. Exibir Quartos Ocupados e Desocupados");
            System.out.println("8. Sair");
            System.out.println("Escolha uma opcao:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    int cpf = scanner.nextInt();
                    sistema.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o numero do quarto:");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();
                
                    System.out.println("O quarto a ser cadastrado seria simples ou duplo?");
                    System.out.println("Digite 'simples' para quarto simples ou 'duplo' para quarto duplo:");
                    String tipoQuarto = scanner.nextLine().trim().toUpperCase();
                
                    if(tipoQuarto.equals("SIMPLES") || tipoQuarto.equals("DUPLO")){
                        boolean isDuplo = tipoQuarto.equals("DUPLO");
                        sistema.cadastrarQuarto(numeroQuarto, isDuplo);
                        System.out.println("Quarto cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo de quarto inválido!");
                    }
                break;
                
                case 3:
                    System.out.println("Digite o CPF do cliente para reserva:");
                    String cpfClienteReserva = scanner.nextLine();
                    System.out.println("Digite o numero do quarto para reserva:");
                    int numeroQuartoReserva = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a data de entrada (dd/MM/yyyy):");
                    String entradaStr = scanner.nextLine();
                    LocalDate entrada = LocalDate.parse(entradaStr, formatarData);
                    System.out.println("Digite a data de saida (dd/MM/yyyy):");
                    String saidaStr = scanner.nextLine();
                    LocalDate saida = LocalDate.parse(saidaStr, formatarData);
                    boolean reservaFeita = sistema.reservarQuarto(cpfClienteReserva, numeroQuartoReserva, entrada, saida);
                    if (reservaFeita) {
                        System.out.println("Reserva realizada com sucesso!");
                    } else {
                        System.out.println("Falha na reserva. Verifique o CPF ou a disponibilidade do quarto.");
                    }
                    break;

                case 4:
                    sistema.exibirReservas();
                    break;

                case 5:
                    System.out.println("Digite o numero do quarto para check-in:");
                    int numeroQuartoCheckIn = scanner.nextInt();
                    boolean checkIn = sistema.realizarCheckIn(numeroQuartoCheckIn);
                    if (checkIn) {
                        System.out.println("Check-in realizado com sucesso!");
                    } else {
                        System.out.println("Falha no check-in. Quarto nao encontrado ou ja ocupado.");
                    }
                    break;

                case 6:
                    System.out.println("Digite o numero do quarto para check-out:");
                    int numeroQuartoCheckOut = scanner.nextInt();
                    boolean checkOut = sistema.realizarCheckOut(numeroQuartoCheckOut);
                    if (checkOut) {
                        System.out.println("Check-out realizado com sucesso!");
                    } else {
                        System.out.println("Falha no check-out. Quarto nao encontrado ou nao ocupado.");
                    }
                    break;

                case 7:
                    sistema.exibirStatusQuartos();
                    break;

                case 8:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}
