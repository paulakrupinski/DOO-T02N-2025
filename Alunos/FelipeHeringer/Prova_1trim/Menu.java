package Alunos.FelipeHeringer.Prova_1trim;

import java.util.Scanner;

public class Menu {
    private Hotel hotel;
    private Scanner scanner;

    public Menu(Hotel hotel) {
        this.hotel = hotel;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Bem-vindo ao " + hotel.getNomeHotel());
        System.out.println("1. Cadastrar Quarto");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Reservar Quarto");
        System.out.println("4. Realizar Check-in");
        System.out.println("5. Realizar check-out");
        System.out.println("6. Calcular valor total da estadia");
        System.out.println("7. Sair");
        int opcao = this.scanner.nextInt();
        this.scanner.nextLine();

        executarOpcao(opcao);
    }

    public void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("Qual é o tipo do quarto? (1 - Simples, 2 - Duplo)");
                int tipoQuarto = this.scanner.nextInt();
                this.scanner.nextLine();

                if (tipoQuarto == 1) {
                    System.out.println("Número do Quarto: (final impar)");
                    int numeroQuarto = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Quarto quartoSimples = new QuartoSimples(numeroQuarto);
                    hotel.cadastrarQuarto(quartoSimples);
                } else if (tipoQuarto == 2) {
                    System.out.println("Número do Quarto: (final par)");
                    int numeroQuarto = this.scanner.nextInt();
                    this.scanner.nextLine();
                    Quarto quartoDuplo = new QuartoDuplo(numeroQuarto);
                    hotel.cadastrarQuarto(quartoDuplo);
                } else {
                    System.out.println("Tipo de quarto inválido.");
                }
                System.out.println("==================================================================");
                break;
            case 2:
                System.out.println("Nome do Cliente: ");
                String nomeCliente = this.scanner.nextLine();
                System.out.println("Idade do cliente: ");
                int idadeCliente = this.scanner.nextInt();
                this.scanner.nextLine();

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                hotel.cadastrarCliente(cliente);

                System.out.println("==================================================================");
                break;
            case 3:
                boolean QuartoNaoEstaReservado = false;

                System.out.println("Qual o número do quarto ? ");
                int numeroQuarto = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("Data de Entrada: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaEntrada = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesEntrada = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("=======================");

                System.out.println("Data de Saida: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaSaida = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesSaida = this.scanner.nextInt();
                this.scanner.nextLine();

                QuartoNaoEstaReservado = hotel.verificarDisponibilidade(numeroQuarto, diaEntrada, mesEntrada, diaSaida,
                        mesSaida);

                if (QuartoNaoEstaReservado) {
                    System.out.println("Quarto reservado com sucesso!");
                    System.out.println("==================================================================");
                } else {
                    System.out.println("Quarto não está disponível para as datas informadas.");
                    System.out.println("==================================================================");
                }
                break;

            case 4:
                System.out.println("Qual o número do quarto ? ");
                int numeroQuartoCheckin = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("Data de Entrada: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaEntradaCheckin = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesEntradaCheckin = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("=======================");

                System.out.println("Data de Saida: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaSaidaCheckin = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesSaidaCheckin = this.scanner.nextInt();
                this.scanner.nextLine();

                hotel.realizarCheckin(numeroQuartoCheckin, diaEntradaCheckin, mesEntradaCheckin, diaSaidaCheckin,
                        mesSaidaCheckin);
                System.out.println("Check-in realizado com sucesso!");
                System.out.println("==================================================================");
                break;
            case 5:
                System.out.println("Qual o número do quarto ? ");
                int numeroQuartoCheckout = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("Data de Entrada: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaEntradaCheckout = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesEntradaCheckout = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("=======================");

                System.out.println("Data de Saida: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaSaidaCheckout = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesSaidaCheckout = this.scanner.nextInt();
                this.scanner.nextLine();

                hotel.realizarCheckout(numeroQuartoCheckout, diaEntradaCheckout, mesEntradaCheckout, diaSaidaCheckout,
                        mesSaidaCheckout);
                System.out.println("Check-out realizado com sucesso!");
                System.out.println("==================================================================");
                break;
            case 6:
                System.out.println("Qual o número do quarto ? ");
                int numeroQuartoReservado = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("Data de Entrada: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaDaEntrada = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesDaEntrada = this.scanner.nextInt();
                this.scanner.nextLine();

                System.out.println("=======================");

                System.out.println("Data de Saida: ");
                System.out.println("Dia: (1,2,3,... 30)");
                int diaDaSaida = this.scanner.nextInt();
                this.scanner.nextLine();
                System.out.println("Mes: (1,2,3,... 12)");
                int mesDaSaida = this.scanner.nextInt();
                this.scanner.nextLine();

                hotel.valorTotalDaEstadia(numeroQuartoReservado, diaDaEntrada, mesDaEntrada, diaDaSaida, mesDaSaida);
                System.out.println("==================================================================");
                break;
            case 7:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }

        if (opcao != 7) {
            exibirMenu(); // Exibe o menu novamente após executar a opção
        }
    }

}
