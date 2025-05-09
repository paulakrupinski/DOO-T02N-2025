package fag;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objeto.Cliente;
import fag.objeto.Quarto;
import fag.objeto.QuartoDuplo;
import fag.objeto.QuartoSimples;
import fag.objeto.Reserva;

public class Main {

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Quarto> quartos = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 1; i <= 9; i += 2) {
            quartos.add(new QuartoSimples(i));
        }
        for (int i = 2; i <= 10; i += 2) {
            quartos.add(new QuartoDuplo(i));
        }
        
        while (true) {
            System.out.println("\n1. Cadastrar Cliente\n" + 
                "2. Fazer Reserva\n" + 
                "3. Verificar Disponibilidade\n" + 
                "4. Check-out\n" + 
                "5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    clientes.add(new Cliente(nome, cpf));
                    System.out.println("Cliente cadastrado.");
                    break;

                case 2:
                    System.out.print("CPF do cliente: ");
                    cpf = scanner.nextLine().trim();

                    Cliente cliente = clientes.stream()
                        .filter(c -> c.getCpf().equals(cpf))
                        .findFirst()
                        .orElse(null);

                    if (cliente == null) {
                        System.out.println("CPF não cadastrado. Por favor, cadastre o cliente antes de fazer a reserva.");
                        break;
                    }

                    System.out.print("Tipo de quarto (1 - Simples, 2 - Duplo): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    List<Quarto> quartosDisponiveis = quartos.stream()
                        .filter(q -> !q.isOcupado() &&
                                    ((tipo == 1 && q instanceof QuartoSimples) ||
                                     (tipo == 2 && q instanceof QuartoDuplo)))
                        .toList();

                    if (quartosDisponiveis.isEmpty()) {
                        System.out.println("Nenhum quarto disponível desse tipo.");
                        break;
                    }

                    System.out.println("Quartos disponíveis:");
                    for (Quarto q : quartosDisponiveis) {
                        System.out.println("Quarto " + q.getNumero() + " - Tipo: " + q.tipo());
                    }

                    System.out.print("Escolha o número do quarto: ");
                    int numQuarto = scanner.nextInt();
                    scanner.nextLine();
                    Quarto quarto = quartosDisponiveis.stream()
                        .filter(q -> q.getNumero() == numQuarto)
                        .findFirst()
                        .orElse(null);

                    if (quarto == null) {
                        System.out.println("Quarto inválido.");
                        break;
                    }

                    System.out.print("Número de pessoas: ");
                    int numPessoas = scanner.nextInt();
                    scanner.nextLine();

                    if (numPessoas > quarto.getCapacidade()) {
                        System.out.println("Número de pessoas excede a capacidade do quarto. Escolha outro quarto ou ajuste o número de pessoas.");
                        break;
                    }

                    System.out.print("Data Check-in (dd/MM/yyyy): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine(), formatter);
                    if (checkIn.isBefore(LocalDate.now())) {
                        System.out.println("Data de check-in inválida. Não pode ser anterior à data atual.");
                        break;
                    }

                    System.out.print("Data Check-out (dd/MM/yyyy): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine(), formatter);
                    if (checkOut.isBefore(checkIn)) {
                        System.out.println("Data de check-out inválida. Deve ser depois do check-in.");
                        break;
                    }

                    Reserva reserva = new Reserva(cliente, quarto, checkIn, checkOut);
                    reservas.add(reserva);
                    quarto.setOcupado(true);
                    System.out.println("Reserva feita com sucesso.");
                    break;

                case 3:
                    System.out.print("Número do quarto: ");
                    numQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data para verificar (dd/MM/yyyy): ");
                    LocalDate data = LocalDate.parse(scanner.nextLine(), formatter);

                    Quarto quartoExistente = quartos.stream()
                        .filter(q -> q.getNumero() == numQuarto)
                        .findFirst()
                        .orElse(null);

                    if (quartoExistente == null) {
                        System.out.println("Quarto não encontrado.");
                        break;
                    }

                    boolean disponivel = true;
                    for (Reserva r : reservas) {
                        if (r.getQuarto().getNumero() == numQuarto && !r.estaDisponivel(data)) {
                            disponivel = false;
                            break;
                        }
                    }

                    System.out.println(disponivel ? "Quarto disponível." : "Quarto ocupado.");
                    break;

                case 4:
                    System.out.print("CPF do cliente: ");
                    cpf = scanner.nextLine();
                    boolean encontrou = false;

                    for (int i = 0; i < reservas.size(); i++) {
                        Reserva r = reservas.get(i);
                        if (r.getCliente().getCpf().equals(cpf)) {
                            r.getQuarto().setOcupado(false);
                            System.out.println("Check-out realizado. Total a pagar: R$" + r.calcularTotal());
                            reservas.remove(i);
                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("CPF não encontrado ou sem reservas.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
