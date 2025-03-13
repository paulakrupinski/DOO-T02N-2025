import java.util.Scanner;

public class CalculadoraPlantas {

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        double total = quantidade * precoUnitario;
        return total;
    }

    public static double calcularDesconto(int quantidade, double precoUnitario) {
        double total = quantidade * precoUnitario;
        if (quantidade > 10) {
            return total * 0.05;
        }
        return 0.0;
    }

    public static double calcularTroco(double valorPago, double totalCompra) {
        return valorPago - totalCompra;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        int totalPlantasVendidas = 0;
        double valorTotalVendas = 0.0;
        double totalDescontosAplicados = 0.0;

        do {
            System.out.println("--- Calculadora da Dona Gabrielinha ---");
            System.out.println("[1] - Registrar Venda");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Informe o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();

                    double desconto = calcularDesconto(quantidade, precoUnitario);
                    double totalCompra = calcularPrecoTotal(quantidade, precoUnitario) - desconto;
                    System.out.println("O preço total da compra é: R$ " + totalCompra);
                    if (desconto > 0) {
                        System.out.println("Um desconto de R$ " + desconto + " foi aplicado.");
                    }

                    totalPlantasVendidas += quantidade;
                    valorTotalVendas += totalCompra;
                    totalDescontosAplicados += desconto;
                    break;

                case 2:
                    System.out.print("Informe o valor pago pelo cliente: ");
                    double valorPago = scanner.nextDouble();
                    System.out.print("Informe o valor total da compra: ");
                    double totalCompraParaTroco = scanner.nextDouble();

                    double troco = calcularTroco(valorPago, totalCompraParaTroco);
                    System.out.println("O troco a ser dado ao cliente é de: R$ " + troco);
                    break;

                case 3:
                    System.out.println("--- Registro de Vendas ---");
                    System.out.println("Total de plantas vendidas: " + totalPlantasVendidas);
                    System.out.println("Valor total das vendas: R$ " + valorTotalVendas);
                    System.out.println("Total de descontos aplicados: R$ " + totalDescontosAplicados);
                    break;

                case 4:
                    System.out.println("Saindo da calculadora, até mais Dona Gabrielinha!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente:");
            }
        } while (opcao != 4);
        scanner.close();
    }
}
