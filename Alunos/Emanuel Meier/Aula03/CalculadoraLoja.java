package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraLoja {
    private static final List<String> REGISTROS_DE_VENDAS = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int opcao;
        do {
            System.out.println("\n--- Calculadora da Dona Gabrielinha ---");
            System.out.println("[1] - Calcular Valor Total da Venda");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Mostrar Histórico de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    calcularValorTotalVenda(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    mostrarHistoricoVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void calcularValorTotalVenda(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        scanner.nextLine();

        double total = quantidade * precoUnitario;
        double desconto = (quantidade > 10) ? total * 0.05 : 0.00;
        double totalComDesconto = total - desconto;

        System.out.printf("Preço total: R$ %.2f (Desconto: R$ %.2f)%n", totalComDesconto, desconto);

        String registro = String.format("Quantidade: %d | Preço Unitário: R$ %.2f | Total: R$ %.2f | Desconto: R$ %.2f",
                quantidade, precoUnitario, totalComDesconto, desconto);
        REGISTROS_DE_VENDAS.add(registro);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();
        scanner.nextLine();

        if (valorRecebido < valorCompra) {
            System.out.println("O valor recebido é insuficiente!");
        } else {
            double troco = valorRecebido - valorCompra;
            System.out.printf("Troco a ser devolvido: R$ %.2f%n", troco);
        }
    }

    private static void mostrarHistoricoVendas() {
        if (REGISTROS_DE_VENDAS.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            System.out.println("\n--- Histórico de Vendas ---");
            for (String registro : REGISTROS_DE_VENDAS) {
                System.out.println(registro);
            }
        }
    }
}
