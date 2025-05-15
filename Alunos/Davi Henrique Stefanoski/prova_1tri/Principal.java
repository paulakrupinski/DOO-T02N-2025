package pacote;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int opcao;
        int idReserva = 1; 
        int numQuartos = 1;

        do {
            System.out.println("\n=== MENU HOTEL ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Quarto");
            System.out.println("3 - Fazer Reserva");
            System.out.println("4 - Realizar Check-in");
            System.out.println("5 - Realizar Check-out");
            System.out.println("6 - Verificar Disponibilidade");
            System.out.println("7 - Listar Clientes");
            System.out.println("8 - Listar Reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    Cliente cliente = new Cliente(nome,cpf);
                    hotel.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado.");
                    break;

                case 2:
                    System.out.print("Digite o tipo do quarto (1 - Simples | 2 - Duplo): ");
                    int tipo = sc.nextInt();

                    Quarto quarto;
                    if (tipo == 1) {
                        quarto = new QuartoSimples(numQuartos++);
                    } else {
                        quarto = new QuartoDuplo(numQuartos++); 
                    }

                    hotel.cadastrarQuarto(quarto);
                    System.out.println("Quarto " + quarto.getNumero() + " cadastrado.");
                    break;

                case 3:
                    System.out.print("Nome do cliente para reserva: ");
                    String nomeReserva = sc.nextLine();
                    Cliente clienteReserva = hotel.buscarClientePorNome(nomeReserva);
                    if (clienteReserva == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Número do quarto: ");
                    int numQuarto = sc.nextInt();
                    Quarto quartoReserva = hotel.buscarQuartoPorNumero(numQuarto);
                    if (quartoReserva == null || !quartoReserva.isDisponivel()) {
                        System.out.println("Quarto não encontrado ou indisponível.");
                        break;
                    }

                    Reserva reserva = new Reserva(idReserva++, clienteReserva, quartoReserva);
                    hotel.fazerReserva(reserva);
                    System.out.println("Reserva" + reserva.getId() + "realizada.");
                    break;

                case 4:
                    System.out.print("ID da reserva para check-in: ");
                    int idCheckIn = sc.nextInt();
                    hotel.realizarCheckIn(idCheckIn);
                    break;

                case 5:
                    System.out.print("ID da reserva para check-out: ");
                    int idCheckOut = sc.nextInt();
                    hotel.realizarCheckOut(idCheckOut);
                    break;

                case 6:
                    System.out.print("Número do quarto: ");
                    int numDisp = sc.nextInt();
                    Quarto q = hotel.buscarQuartoPorNumero(numDisp);
                    if (q == null) {
                        System.out.println("Quarto não encontrado.");
                        break;
                    }

                    System.out.print("Data (dd/mm/aaaa): ");
                    sc.nextLine(); 
                    String dataStr = sc.nextLine();
                    try {
                        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
                        boolean disponivel = hotel.verificarDisponibilidade(q, data);
                        System.out.println("Disponibilidade: " + (disponivel ? "Disponível" : "Indisponível"));
                    } catch (Exception e) {
                        System.out.println("Data inválida.");
                    }
                    break;

                case 7:
                    hotel.listarClientes();
                    break;

                case 8:
                    hotel.listarReservas();
                    break;

                case 0:
                    System.out.println("Encerrando sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

    }
}
