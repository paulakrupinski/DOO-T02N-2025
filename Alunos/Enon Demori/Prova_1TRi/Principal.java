package provaEnon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Cliente> clientes = new ArrayList<>();
        List<Quarto> quartos = new ArrayList<>();
       
        quartos.add(new QuartoSimples(101));
        quartos.add(new QuartoSimples(102));
        quartos.add(new QuartoDuplo(201));
        quartos.add(new QuartoDuplo(202));

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Fazer Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Calcular Total de Diárias");
            System.out.println("6. Verificar Disponibilidade para o dia específico de hoje");
            System.out.println("7. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Digite o nome do cliente: ");
                String nomeCliente = scanner.nextLine();
                Cliente novoCliente = new Cliente(nomeCliente);
                clientes.add(novoCliente);
                System.out.println("Cliente cadastrado com sucesso: " + novoCliente);

            } else if (opcao == 2) {
                System.out.print("Digite o nome do cliente para a reserva: ");
                String nomeCliente = scanner.nextLine();
                Cliente clienteReserva = null;

                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeCliente)) {
                        clienteReserva = cliente;
                        break;
                    }
                }

                if (clienteReserva != null) {
                    System.out.println("Quartos disponíveis:");
                    for (Quarto quarto : quartos) {
                        if (quarto.isDisponivel()) {
                            System.out.println(quarto.getNumero() + " (Tipo: " + (quarto instanceof QuartoSimples ? "Simples" : "Duplo") + ")");
                        }
                    }

                    System.out.print("Escolha o número do quarto: ");
                    int numeroQuartoEscolhido = scanner.nextInt();
                    Quarto quartoReserva = null;
                    
                    for (Quarto quarto : quartos) {
                        if (quarto.getNumero() == numeroQuartoEscolhido && quarto.isDisponivel()) {
                            quartoReserva = quarto;
                            break;
                        }
                    }

                    if (quartoReserva != null) {
                        Date dataReserva = new Date();  
                        Reserva reserva = new Reserva(clienteReserva, quartoReserva, dataReserva);
                        quartoReserva.realizarReserva(clienteReserva);
                        reserva.setDataCheckIn(new Date()); 
                        System.out.println("Reserva realizada com sucesso para o cliente " + clienteReserva.getNome() + " no quarto " + quartoReserva.getNumero());
                    } else {
                        System.out.println("O quarto escolhido não está disponível.");
                    }
                } else {
                    System.out.println("Cliente não encontrado.");
                }

            } else if (opcao == 3) {
                System.out.print("Digite o nome do cliente para o check-in: ");
                String nomeCheckin = scanner.nextLine();
                Cliente clienteCheckin = null;

                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeCheckin)) {
                        clienteCheckin = cliente;
                        break;
                    }
                }

                if (clienteCheckin != null) {
                    System.out.print("Escolha o número do quarto para o check-in: ");
                    int numeroQuartoCheckin = scanner.nextInt();
                    Quarto quartoCheckin = null;

                    for (Quarto quarto : quartos) {
                        if (quarto.getNumero() == numeroQuartoCheckin) {
                            quartoCheckin = quarto;
                            break;
                        }
                    }

                    if (quartoCheckin != null) {
                        quartoCheckin.realizarCheckIn();
                        System.out.println("Check-in realizado para o cliente " + clienteCheckin.getNome() + " no quarto " + quartoCheckin.getNumero());
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                } else {
                    System.out.println("Cliente não encontrado.");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o nome do cliente para o check-out: ");
                String nomeCheckout = scanner.nextLine();
                Cliente clienteCheckout = null;

                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeCheckout)) {
                        clienteCheckout = cliente;
                        break;
                    }
                }

                if (clienteCheckout != null) {
                    System.out.print("Escolha o número do quarto para o check-out: ");
                    int numeroQuartoCheckout = scanner.nextInt();
                    Quarto quartoCheckout = null;

                    for (Quarto quarto : quartos) {
                        if (quarto.getNumero() == numeroQuartoCheckout) {
                            quartoCheckout = quarto;
                            break;
                        }
                    }

                    if (quartoCheckout != null) {
                        quartoCheckout.realizarCheckOut();
                        System.out.println("Check-out realizado para o cliente " + clienteCheckout.getNome() + " no quarto " + quartoCheckout.getNumero());
                    } else {
                        System.out.println("Quarto não encontrado.");
                    }
                } else {
                    System.out.println("Cliente não encontrado.");
                }

            } else if (opcao == 5) {
                System.out.print("Digite o nome do cliente para calcular o total de diárias: ");
                String nomeCalcular = scanner.nextLine();
                Cliente clienteCalcular = null;

                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeCalcular)) {
                        clienteCalcular = cliente;
                        break;
                    }
                }

                if (clienteCalcular != null) {
                    System.out.print("O quarto do cliente é simples ou duplo? (digite 1 para simples ou 2 para duplo): ");
                    int tipoQuarto = scanner.nextInt();
            
                    double valorDiaria = 0;
                    if (tipoQuarto==1) {
                        valorDiaria = 100; 
                    } else if (tipoQuarto==2) {
                        valorDiaria = 200; 
                    } else {
                        System.out.println("Tipo de quarto inválido.");
                        return; 
                    }


                    System.out.print("Quantos dias o cliente ficou no quarto? ");
                    int dias = scanner.nextInt();

                    double totalDiarias = valorDiaria * dias;
                    System.out.println("O total de diárias para o cliente " + clienteCalcular.getNome() + " é: R$ " + totalDiarias);

                } else {
                    System.out.println("Cliente não encontrado.");
                }
            
            } else if (opcao == 6) {
                System.out.print("Digite o número do quarto para verificar a disponibilidade: ");
                System.out.println("\nHotel do Pedro tem:\n101 (Tipo: Simples) \n102 (Tipo: Simples) \n201 (Tipo: Duplo) \n202 (Tipo: Duplo)");
                int numeroQuartoDisponibilidade = scanner.nextInt();
                Quarto quartoVerificar = null;

                for (Quarto quarto : quartos) {
                    if (quarto.getNumero() == numeroQuartoDisponibilidade) {
                        quartoVerificar = quarto;
                        break;
                    }
                }

                if (quartoVerificar != null) {
                    if (quartoVerificar.isDisponivel()) {
                        System.out.println("O quarto está disponível.");
                    } else {
                        System.out.println("O quarto não está disponível.");
                    }
                } else {
                    System.out.println("Quarto não encontrado.");
                }

            } else if (opcao == 7) {
               
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
