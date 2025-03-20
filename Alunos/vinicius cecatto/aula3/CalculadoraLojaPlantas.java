package aula3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculadoraLojaPlantas {
    private static final double DESCONTO_ESPECIAL = 0.05;
    private static final List<String> registroVendas = new ArrayList<>();

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        double precoTotal = quantidade * precoUnitario;
        double desconto = (quantidade > 10) ? precoTotal * DESCONTO_ESPECIAL : 0;
        double precoFinal = precoTotal - desconto;

        // Armazena a venda no registro
        String venda = String.format("Quantidade: %d | Preço Total: R$ %.2f | Desconto: R$ %.2f",
                quantidade, precoFinal, desconto);
        registroVendas.add(venda);

        return precoFinal;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static void processarVenda(Scanner scanner) {
        try {
            System.out.print("Digite a quantidade de plantas: ");
            int quantidade = scanner.nextInt();

            System.out.print("Digite o preço unitário da planta: ");
            double precoUnitario = scanner.nextDouble();

            double precoFinal = calcularPrecoTotal(quantidade, precoUnitario);
            System.out.printf("Preço final da compra (aplicado desconto, se houver): R$ %.2f%n", precoFinal);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Tente novamente.");
            scanner.next(); // Limpa o buffer
        }
    }

    public static void processarTroco(Scanner scanner) {
        try {
            System.out.print("Digite o valor recebido do cliente: ");
            double valorRecebido = scanner.nextDouble();

            System.out.print("Digite o valor total da compra: ");
            double valorTotal = scanner.nextDouble();

            double troco = calcularTroco(valorRecebido, valorTotal);

            if (troco >= 0) {
                System.out.printf("Troco a ser devolvido: R$ %.2f%n", troco);
            } else {
                System.out.printf("Valor insuficiente! Faltam: R$ %.2f%n", Math.abs(troco));
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Tente novamente.");
            scanner.next(); // Limpa o buffer
        }
    }

    public static void exibirRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            System.out.println("\n===== Registro de Vendas =====");
            for (String venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }

    public static int obterOpcao(Scanner scanner) {
        int opcao;
        while (true) {
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 4) {
                    return opcao;
                }
                System.out.println("Opção inválida! Digite um número entre 1 e 4.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Calculadora da Loja de Plantas =====");
            System.out.println("[1] - Realizar Venda");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");

            opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1 -> processarVenda(scanner);
                case 2 -> processarTroco(scanner);
                case 3 -> exibirRegistroVendas();
                case 4 -> System.out.println("Saindo... Obrigado por utilizar a calculadora!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}