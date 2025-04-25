package PROVA_1TRI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Quarto> quartos = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();
        int opcao;
        do {
            System.out.println("\n1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Quarto");
            System.out.println("3 - Fazer Reserva");
            System.out.println("4 - Check-in");
            System.out.println("5 - Check-out");
            System.out.println("6 - Verificar Disponibilidade");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer
            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                clientes.add(new Cliente(nome, cpf, idade));
                System.out.println("Cliente cadastrado.");
            }
            if (opcao == 2) {
                System.out.print("Número do quarto: ");
                int numero = scanner.nextInt();
                System.out.print("Tipo (1 - Simples / 2 - Duplo): ");
                int tipo = scanner.nextInt();
                quartos.add(new Quarto(numero, tipo, true));
                System.out.println("Quarto cadastrado.");
            }
            if (opcao == 3) {
                System.out.print("CPF do cliente: ");
                String cpf = scanner.nextLine();
                Cliente cliente = null;
                for (Cliente c : clientes) {
                    if (c.getCpf().equals(cpf)) {
                        cliente = c;
                        break;
                    }
                }
                System.out.print("Número do quarto: ");
                int num = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Data de check-in (AAAA-MM-DD): ");
                String dataTexto = scanner.nextLine();
                LocalDate dataCheckin = LocalDate.parse(dataTexto);
                System.out.print("Dias de estadia: ");
                int dias = scanner.nextInt();
                scanner.nextLine();
                Quarto quarto = null;
                for (Quarto q : quartos) {
                    if (q.getNumero() == num && q.isDisponivel()) {
                        quarto = q;
                        break;
                    }
                }
                if (cliente != null && quarto != null) {
                    reservas.add(new Reserva(cliente, quarto, dias, dataCheckin));
                    System.out.println("Reserva feita.");
                } else {
                    System.out.println("Cliente ou quarto inválido.");
                }
            }
            if (opcao == 4) {
                System.out.print("CPF do cliente: ");
                String cpf = scanner.nextLine();
                for (Reserva r : reservas) {
                    if (r.getCliente().getCpf().equals(cpf) && !r.isCheckinFeito()) {
                        r.fazerCheckin();
                        System.out.println("Check-in realizado.");
                        break;
                    }
                }
            }
            if (opcao == 5) {
                System.out.print("Número do quarto: ");
                int num = scanner.nextInt();
                for (Reserva r : reservas) {
                    if (r.getQuarto().getNumero() == num && r.isCheckinFeito() && !r.isCheckoutFeito()) {
                        r.fazerCheckout();
                        System.out.println("Check-out feito. Total: R$" + r.calcularTotal());
                        break;
                    }
                }
            }
            if (opcao == 6) {
                System.out.print("Número do quarto: ");
                int num = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Data a verificar (AAAA-MM-DD): ");
                String dataTexto = scanner.nextLine();
                LocalDate dataConsulta = LocalDate.parse(dataTexto);
                boolean ocupado = false;
                for (Reserva r : reservas) {
                    if (r.getQuarto().getNumero() == num) {
                        if (!dataConsulta.isBefore(r.getDataCheckin()) &&
                            !dataConsulta.isAfter(r.getDataCheckout())) {
                            ocupado = true;
                            break;
                        }
                    }
                }
                System.out.println(ocupado ? "Ocupado nessa data" : "Disponível nessa data");
            }
        } while (opcao != 0);
        scanner.close();
    }
}