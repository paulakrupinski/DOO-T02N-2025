import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraLojaPlantas3 {

    static class Venda {
        int quantidade;
        double precoUnitario;
        double valorTotal;
        double desconto;
        
        public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }
        
        @Override
        public String toString() {
            return "Quantidade: " + quantidade + ", Preço Unitário: R$ " + precoUnitario +
                   ", Valor Total: R$ " + valorTotal + ", Desconto: R$ " + desconto;
        }
    }

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularDesconto(double precoTotal, int quantidade) {
        if (quantidade > 10) {
            return precoTotal * 0.05;
        }
        return 0;
    }

    public static void registrarVenda(List<Venda> vendas, int quantidade, double precoUnitario, double valorTotal, double desconto) {
        vendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Mostrar Vendas Realizadas");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade da planta: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    double desconto = calcularDesconto(precoTotal, quantidade);
                    double valorComDesconto = precoTotal - desconto;
                    System.out.println("Preço Total da compra: R$ " + precoTotal);
                    if (desconto > 0) {
                        System.out.println("Desconto aplicado: R$ " + desconto);
                    } else {
                        System.out.println("Sem desconto aplicado.");
                    }
                    System.out.println("Valor com desconto: R$ " + valorComDesconto);
                    break;

                case 2:
                    System.out.print("Digite o valor pago pelo cliente: ");
                    double valorPago = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorTotalCompra = scanner.nextDouble();
                    double troco = calcularTroco(valorPago, valorTotalCompra);
                    if (troco < 0) {
                        System.out.println("Valor pago é insuficiente. Não há troco.");
                    } else {
                        System.out.println("Troco a ser dado: R$ " + troco);
                    }
                    break;

                case 3:
                    System.out.print("Digite a quantidade da planta: ");
                    int qntdVenda = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitarioVenda = scanner.nextDouble();
                    double precoTotalVenda = calcularPrecoTotal(qntdVenda, precoUnitarioVenda);
                    double descontoVenda = calcularDesconto(precoTotalVenda, qntdVenda);
                    double valorComDescontoVenda = precoTotalVenda - descontoVenda;
                    registrarVenda(vendas, qntdVenda, precoUnitarioVenda, valorComDescontoVenda, descontoVenda);
                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 4:
                    System.out.println("Vendas Realizadas:");
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda venda : vendas) {
                            System.out.println(venda);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saindo... Obrigado por usar a calculadora da Dona Gabrielinha!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
