package Prova_1trim;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar quarto");
            System.out.println("3. Reservar quarto");
            System.out.println("4. Realizar check-out");
            System.out.println("5. Verificar disponibilidade");
            System.out.println("6. Sair");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                hotel.cadastrarCliente(nome, cpf);
            } else if (opcao == 2) {
                System.out.print("Número do quarto: ");
                int numero = sc.nextInt();
                sc.nextLine();
                System.out.print("Tipo (1 - Simples, 2 - Duplo): ");
                int tipo = sc.nextInt();
                sc.nextLine();
                if (tipo == 1) hotel.cadastrarQuarto(new QuartoSimples(numero));
                else hotel.cadastrarQuarto(new QuartoDuplo(numero));
            } else if (opcao == 3) {
                System.out.print("CPF do cliente: ");
                String cpf = sc.nextLine();
                System.out.print("Número do quarto: ");
                int numero = sc.nextInt();
                System.out.print("Data entrada (YYYY-MM-DD): ");
                LocalDate entrada = LocalDate.parse(sc.next());
                System.out.print("Data saída (YYYY-MM-DD): ");
                LocalDate saida = LocalDate.parse(sc.next());
                Reserva r = hotel.reservarQuarto(cpf, numero, entrada, saida);
                if (r != null) System.out.println("Reserva realizada.");
                else System.out.println("Erro ao reservar.");
            } else if (opcao == 4) {
                System.out.print("CPF do cliente: ");
                String cpf = sc.nextLine();
                double total = hotel.realizarCheckout(cpf);
                System.out.println("Total a pagar: R$ " + total);
            } else if (opcao == 5) {
                System.out.print("Número do quarto: ");
                int numero = sc.nextInt();
                System.out.print("Data desejada (YYYY-MM-DD): ");
                LocalDate data = LocalDate.parse(sc.next());
                boolean disponivel = hotel.verificarDisponibilidade(numero, data);
                System.out.println(disponivel ? "Disponível" : "Indisponível");
            } else if (opcao == 6) {
                break;
            }
        }
        sc.close();
    }
}
