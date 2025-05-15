import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int opcao;
        do {
            System.out.println("\n---------- HOTEL ----------");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar quarto");
            System.out.println("3 - Reservar quarto");
            System.out.println("4 - Realizar check-in");
            System.out.println("5 - Realizar check-out");
            System.out.println("6 - Verificar disponibilidade por data");
            System.out.println("7 - Listar clientes");
            System.out.println("8 - Listar quartos");
            System.out.println("9 - Listar reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
               
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Documento: ");
                    String doc = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String tel = scanner.nextLine();
                    hotel.adicionarCliente(new Cliente(nome, doc, tel));
                    break;

                case 2:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    System.out.print("Tipo (1 - Para Simples | 2 - Para Duplo): ");
                    int tipo = scanner.nextInt();
                    if (tipo == 1) {
                        hotel.adicionarQuarto(new QuartoSimples(numero));
                    } else if (tipo == 2) {
                        hotel.adicionarQuarto(new QuartoDuplo(numero));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 3:
                    System.out.print("Documento do cliente: ");
                    String docReserva = scanner.nextLine();
                    Cliente cliente = hotel.buscarClientePorDocumento(docReserva);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                
                    System.out.print("Tipo de quarto desejado (1 - Simples / 2 - Duplo): ");
                    int tipoQuarto = scanner.nextInt();
                    scanner.nextLine(); 
                
                    if (tipoQuarto != 1 && tipoQuarto != 2) {
                        System.out.println("Tipo de quarto inválido.");
                        break;
                    }
                
                    System.out.print("Data da reserva (ex: AAAA-MM-DD): ");
                    String data = scanner.nextLine();
                
                    Quarto quartoDisponivel = hotel.buscarQuartoDisponivelPorTipoEData(tipoQuarto, data);
                    if (quartoDisponivel == null) {
                        System.out.println("Nenhum quarto do tipo escolhido está disponível nesta data.");
                    } else {
                        System.out.print("Número de dias: ");
                        int dias = scanner.nextInt();
                        scanner.nextLine();
                        hotel.reservarQuarto(cliente, quartoDisponivel, data, dias);
                    }
                    break;
                
                case 4:
                    System.out.print("Documento do cliente: ");
                    String docIn = scanner.nextLine();
                    System.out.print("Data da reserva: ");
                    String dataIn = scanner.nextLine();
                    hotel.checkIn(docIn, dataIn);
                    break;

                case 5:
                    System.out.print("Documento do cliente: ");
                    String docOut = scanner.nextLine();
                    System.out.print("Data da reserva: ");
                    String dataOut = scanner.nextLine();
                    hotel.checkOut(docOut, dataOut);
                    break;

                case 6:
                    System.out.print("Data a verificar (ex: AAAA-MM-DD): ");
                    String dataVerif = scanner.nextLine();
                    Quarto q = hotel.buscarQuartoDisponivelPorData(dataVerif);
                    if (q != null) {
                        System.out.println("Quarto disponível: " + q);
                    } else {
                        System.out.println("Nenhum quarto disponível nesta data.");
                    }
                    break;
                    
                case 7:
                    hotel.listarClientes();
                    break;

                case 8:
                    hotel.listarQuartos();
                    break;

                case 9:
                    hotel.listarReservas();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
