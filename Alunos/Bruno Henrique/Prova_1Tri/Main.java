import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static int[][] matrizReserva = new int[12][30];
    public static ArrayList<Cliente> clienteCheck = new ArrayList<>();
    public static Cliente cliente;
    public static ArrayList<Quarto> listaQuartosSimples = new ArrayList<>();
    public static ArrayList<Quarto> listaQuartosDuplos = new ArrayList<>();
    public static QuartoDuplo quartoDuplo;
    public static QuartoSimples quartoSimples;


    public static void main(String[] args) {
        System.out.println("Seja bem - vindo!");

        boolean sair = true;

        while (sair) {
            System.out.println("Selecione a opção que deseja executar: ");
            System.out.println("""
                    1. Cadastrar cliente;
                    2. Cadastrar quarto;
                    3. Reservar quarto;
                    4. Realizar Check-In;
                    5. Realizar Check-Out;
                    6. Calcular total a pagar;
                    7. Verificar disponibilidade de quartos;
                    8. Sair;
                    """);
            int escolha = scan.nextInt();
            scan.nextLine();

            if (escolha == 1) {
                cadastrarCliente();
            }

            if (escolha == 2) {
                cadastrarQuarto();
            }

            if (escolha == 3) {
                reservarQuarto();
            }

            if (escolha == 4) {
                realizarCheckIn();
            }

            if (escolha == 5) {
                realizarCheckOut();
            }

            if (escolha == 6) {
                calcularTotalPagamento();
            }

            if (escolha == 7) {
                verificarDisponibilidadeQuarto();
            }

            if (escolha == 8) {
                sair = false;
            }
        }
    }

    public static void cadastrarCliente() {
        cliente = new Cliente();

        System.out.println("Entre com o nome: ");
        String nome = scan.nextLine();

        System.out.println("Entre com a idade: ");
        String idade = scan.nextLine();

        System.out.println("Entre com a ocupação: ");
        String ocupacao = scan.nextLine();

        cliente.setNome(nome);
        cliente.setIdade(idade);
        cliente.setOcupacao(ocupacao);

        listaClientes.add(cliente);
    }

    public static void cadastrarQuarto() {
        System.out.println("Digite o número de acordo com o quarto que deseja cadastrar");
        System.out.println("1. Quarto simples | 2. Quarto duplo");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice == 1) {
            quartoSimples = new QuartoSimples("11", 200, 2);
            System.out.println("Quarto simples cadastrado com sucesso!");

            listaQuartosSimples.add(quartoSimples);
        }

        else if (choice == 2) {
            quartoDuplo = new QuartoDuplo("13", 400, 4);
            System.out.println("Quarto duplo cadastrado com sucesso!");

            listaQuartosDuplos.add(quartoDuplo);
        }
    }

    public static void reservarQuarto() {
        System.out.println("Insira o dia do mês que deseja reservar: ");
        int dia = scan.nextInt();
        scan.nextLine();

        System.out.println("Insira o mês que deseja reservar: ");
        int mes = scan.nextInt();
        scan.nextLine();

        System.out.println("Insira o número do quarto que deseja reservar: ");
        int numQuarto = scan.nextInt();
        scan.nextLine();

        matrizReserva[mes][dia] = numQuarto;


        System.out.println("Reserva realizada!");
    }

    public static void realizarCheckIn() {
        System.out.println("Insira o nome do cliente: ");
        String nomeCliente = scan.nextLine();

        if (nomeCliente.equalsIgnoreCase(cliente.getNome())) {
            listaClientes.add(cliente);
        }
    }

    public static void realizarCheckOut() {
        System.out.println("Insira o nome do cliente: ");
        String nomeCliente = scan.nextLine();

        if (nomeCliente.equalsIgnoreCase(cliente.getNome())) {
            listaClientes.remove(cliente);
        }
    }

    public static void calcularTotalPagamento() {
        System.out.println("Insira o número do quarto que foi utilizado: ");
        String num = scan.nextLine();

        System.out.println("Insira a quantidade de dias de estadia: ");
        int tempo = scan.nextInt();
        scan.nextLine();

        if (quartoDuplo.getNumero().equalsIgnoreCase(num)) {
            int totalDuplo = tempo * quartoDuplo.getValorDiaria();
            System.out.println("O total a pagar é: " + totalDuplo);
        }

        if (quartoSimples.getNumero().equalsIgnoreCase(num)) {
            int totalSimples = tempo * quartoSimples.getValorDiaria();
            System.out.println("O total a pagar é: " + totalSimples);
        }
    }

    public static void verificarDisponibilidadeQuarto() {
        System.out.println("Insira o mês que deseja buscar: ");
        int mes = scan.nextInt();
        scan.nextLine();

        System.out.println("Insira o dia que deseja buscar: ");
        int dia = scan.nextInt();
        scan.nextLine();

        if (matrizReserva[mes][dia] != 0) {
            System.out.println("Não existem reservas disponíveis nesse dia!");
        }

        else {
            System.out.println("Reservas estão disponíveis neste dia!");
        }
    }
}