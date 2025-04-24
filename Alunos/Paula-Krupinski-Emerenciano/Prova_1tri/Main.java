import java.time.LocalDate;
import java.time.format.DateTimeFormatter;//formatar para tip. brasileiro
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Cliente> clientes = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Cadastro de clientes");
            System.out.println("2 - Cadastro de quarto");
            System.out.println("3 - Reserva de quarto");
            System.out.println("4 - Realizar check-in dos hóspedes");
            System.out.println("5 - Realizar check-out dos hóspedes");
            System.out.println("6 - Calcular o total de diárias a pagar");
            System.out.println("7 - Verificar a disponibilidade de um quarto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    clientes.add(new Cliente(nome, cpf));
                    System.out.println("Cliente cadastrado com sucesso!!");
                    break;

                case 2:
                    
                    System.out.print("Quantos quartos deseja cadastrar? ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Digite o número do quarto: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); 

                        
                        System.out.println("Escolha o tipo do quarto:");
                        System.out.println("1 - Simples");
                        System.out.println("2 - Duplo");
                        int tipoEscolha = scanner.nextInt();
                        scanner.nextLine();

                        String tipo = (tipoEscolha == 1) ? "Simples" : "Duplo";
                        hotel.adicionarQuarto(new Quarto(numero, tipo));
                    }
                    break;

                case 3:
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    }

                    System.out.println("Clientes disponíveis:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + " - " + clientes.get(i).getNome());
                    }

                    System.out.print("Escolha o cliente (Informe o N°): ");
                    int indice = scanner.nextInt();
                    Cliente cliente = clientes.get(indice);

                    System.out.print("Número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    System.out.print("Data de entrada (dd/MM/yyyy): ");
                    LocalDate entrada = LocalDate.parse(scanner.next(), formatter);
                    System.out.print("Data de saída (dd/MM/yyyy): ");
                    LocalDate saida = LocalDate.parse(scanner.next(), formatter);

                    hotel.fazerReserva(cliente, numeroQuarto, entrada, saida);
                    break;

                case 4:
                    List<Reserva> pendentes = hotel.listarReservasPendentes();
                    if (pendentes.isEmpty()) {
                        System.out.println("Não tem reservas pendentes.");
                        break;
                    }

                    System.out.println("Reservas pendentes:");
                    for (int i = 0; i < pendentes.size(); i++) {
                        Reserva r = pendentes.get(i);
                        System.out.println(i + " - Cliente: " + r.getCliente().getNome()
                            + ", Quarto: " + r.getQuarto().getNumero()
                            + ", Tipo: " + r.getQuarto().getTipo() 
                            + ", Entrada: " + r.getDataEntrada()
                            + ", Saída: " + r.getDataSaida());

                            //colocar tipo de quarto igual no exer.
                    }

                    System.out.print("Escolha o número da reserva: ");
                    int escolha = scanner.nextInt();
                    hotel.realizarCheckIn(pendentes.get(escolha));
                    break;

                case 5:
                    System.out.print("Digite o número do quarto para check-out: ");
                    hotel.realizarCheckOut(scanner.nextInt());
                    break;

                case 6:
                    System.out.print("Digite o número do quarto: ");
                    hotel.calcularDiarias(scanner.nextInt());
                    break;

                case 7:
                    System.out.print("Digite o número do quarto: ");
                    int n = scanner.nextInt();
                    System.out.print("Digite a data (dd/MM/yyyy): ");
                    LocalDate data = LocalDate.parse(scanner.next(), formatter);
                    hotel.verificarDisponibilidade(n, data); 
                    break;

                case 0:
                   
                    System.out.println("Finalizando");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
