package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HotelProva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        servico hotel = new servico();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int opcao;
        do {
            System.out.println("\n====== MENU HOTEL ======");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar quarto");
            System.out.println("3 - Reservar quarto");
            System.out.println("4 - Check-in");
            System.out.println("5 - Check-out");
            System.out.println("6 - Verificar disponibilidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Documento do cliente: ");
                    String doc = sc.nextLine();
                    hotel.cadastrarCliente(new cliente(nome, doc));
                }
                case 2 -> {
                    System.out.print("Número do quarto: ");
                    int numero = Integer.parseInt(sc.nextLine());
                    System.out.print("Tipo (1 - Simples, 2 - Duplo): ");
                    int tipo = Integer.parseInt(sc.nextLine());
                    if (tipo == 1) {
                        hotel.cadastrarQuarto(new quartosimples(numero));
                    } else if (tipo == 2) {
                        hotel.cadastrarQuarto(new quartoduplo(numero));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                }
                case 3 -> {
                    System.out.print("Documento do cliente: ");
                    String doc = sc.nextLine();
                    cliente cli = hotel.getClientes().stream()
                        .filter(c -> c.getDocumento().equals(doc)).findFirst().orElse(null);
                    if (cli == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Número do quarto: ");
                    int num = Integer.parseInt(sc.nextLine());
                    quarto q = hotel.getQuartos().stream()
                        .filter(x -> x.getNumero() == num).findFirst().orElse(null);
                    if (q == null) {
                        System.out.println("Quarto não encontrado.");
                        break;
                    }
                    System.out.print("Data de entrada (dd/MM/yyyy): ");
                    LocalDate entrada = LocalDate.parse(sc.nextLine(), formatter);
                    System.out.print("Data de saída (dd/MM/yyyy): ");
                    LocalDate saida = LocalDate.parse(sc.nextLine(), formatter);
                    if (hotel.verificarDisponibilidade(q, entrada, saida)) {
                        hotel.reservarQuarto(cli, q, entrada, saida);
                        System.out.println("Reserva realizada!");
                    } else {
                        System.out.println("Quarto indisponível para o período.");
                    }
                }
                case 4 -> {
                    System.out.print("Documento do cliente: ");
                    hotel.realizarCheckin(sc.nextLine());
                }
                case 5 -> {
                    System.out.print("Documento do cliente: ");
                    hotel.realizarCheckout(sc.nextLine());
                }
                case 6 -> {
                    System.out.print("Número do quarto: ");
                    int numero = Integer.parseInt(sc.nextLine());
                    quarto q = hotel.getQuartos().stream()
                        .filter(x -> x.getNumero() == numero).findFirst().orElse(null);
                    if (q == null) {
                        System.out.println("Quarto não encontrado.");
                        break;
                    }
                    System.out.print("Data (dd/MM/yyyy): ");
                    LocalDate data = LocalDate.parse(sc.nextLine(), formatter);
                    boolean disponivel = hotel.verificarDisponibilidade(q, data, data);
                    System.out.println("Disponibilidade: " + (disponivel ? "Disponível" : "Indisponível"));
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
