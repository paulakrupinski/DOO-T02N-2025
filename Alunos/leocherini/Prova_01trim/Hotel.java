package provaBum;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Quarto> quartos = new ArrayList<>();
    private int contadorClientes = 1;

    public static void main(String[] args) {
        new Hotel().menu();
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n         Hotel          ");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar quarto simples");
            System.out.println("3. Cadastrar quarto duplo");
            System.out.println("4. Reservar quarto");
            System.out.println("5. Check-in");
            System.out.println("6. Check-out");
            System.out.println("7. Verificar disponibilidade por data");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarQuartoSimples();
                case 3 -> cadastrarQuartoDuplo();
                case 4 -> reservarQuarto();
                case 5 -> checkIn();
                case 6 -> checkOut();
                case 7 -> verificarDisponibilidade();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        clientes.add(new Cliente(contadorClientes++, nome));
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private void cadastrarQuartoSimples() {
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        quartos.add(new QuartoSimples(numero));
        System.out.println("Quarto simples cadastrado.");
    }

    private void cadastrarQuartoDuplo() {
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        quartos.add(new QuartoDuplo(numero));
        System.out.println("Quarto duplo cadastrado.");
    }

    private void reservarQuarto() {
        System.out.print("Número do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        Quarto q = encontrarQuarto(numero);
        if (q == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }
        System.out.print("Data de entrada (Ano-Mês-Dia): ");
        LocalDate entrada = LocalDate.parse(scanner.nextLine());
        System.out.print("Data de saída (AAAA-MM-DD): ");
        LocalDate saida = LocalDate.parse(scanner.nextLine());
        System.out.print("Quantidade de pessoas: ");
        int pessoas = scanner.nextInt();
        scanner.nextLine();

        if (q.capacidadeExcedida(pessoas)) {
            System.out.println("Capacidade excedida.");
            return;
        }

        try {
            q.reservar(entrada, saida.minusDays(1), pessoas);
            System.out.println("Reserva realizada com sucesso de " + entrada + " até " + saida + ".");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkIn() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null || cliente.isHospedado()) {
            System.out.println("Cliente não encontrado ou já está hospedado.");
            return;
        }
        cliente.setHospedado(true);
        System.out.println("Check-in realizado.");
    }

    private void checkOut() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null || !cliente.isHospedado()) {
            System.out.println("Cliente não está hospedado.");
            return;
        }
        System.out.print("Número do quarto para check-out: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        Quarto q = encontrarQuarto(numero);
        if (q == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }
        System.out.print("Data de entrada (Ano-Mês-Dia): ");
        LocalDate entrada = LocalDate.parse(scanner.nextLine());
        System.out.print("Data de saída (AAAA-MM-DD): ");
        LocalDate saida = LocalDate.parse(scanner.nextLine());
        long dias = ChronoUnit.DAYS.between(entrada, saida);
        if (dias <= 0) dias = 1;
        double total = dias * q.getPreco();
        q.liberar(entrada, saida.minusDays(1));
        cliente.setHospedado(false);
        System.out.printf("Check-out concluído. Total a pagar: R$ %.2f%n", total);
    }

    private void verificarDisponibilidade() {
        System.out.print("Informe a data (Ano-Mês-Dia): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        boolean disponivel = false;
        for (Quarto q : quartos) {
            if (!q.isReservadoPara(data)) {
                System.out.println("Disponível: " + q);
                disponivel = true;
            }
        }
        if (!disponivel) {
            System.out.println("Nenhum quarto disponível nessa data.");
        }
    }

    private Quarto encontrarQuarto(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }
} 
