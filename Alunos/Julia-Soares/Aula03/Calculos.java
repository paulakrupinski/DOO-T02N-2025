import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Calculos {

    private int quantidadeProduto;
    private double precoUnitario;
    private double precoTotal;
    private double valorRecebido;
    private double troco;
    private double descontosAplicados;
    private double desconto;
    private double precoFinalDesconto;

    private List<String> vendas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void calcularPrecoTotal() {

        System.out.println("Informe o valor do preço unitário:");
        precoUnitario = scanner.nextDouble();

        System.out.println("Informe a quantidade do produto:");
        quantidadeProduto = scanner.nextInt();

        if (quantidadeProduto > 10) {

            precoTotal = precoUnitario * quantidadeProduto;

            descontosAplicados = quantidadeProduto / 10;

            desconto = 0.05 * precoTotal * descontosAplicados;

            precoFinalDesconto = precoTotal - desconto;

            System.out.printf("O preço total com desconto de 5%% é: R$ %.2f%n", precoFinalDesconto);

        } else {

            precoTotal = precoUnitario * quantidadeProduto;

            System.out.printf("O preço total é: R$ %.2f%n", precoTotal);
        }

        String registro = "Quantidade: " + quantidadeProduto +
                ", Valor Bruto: R$" + String.format("%.2f", precoTotal) +
                ", Desconto: R$" + String.format("%.2f", desconto) +
                ", Valor Final: R$" + String.format("%.2f", precoFinalDesconto);

        vendas.add(registro);

    }

    public void calcularTroco() {

        System.out.println("Informe o valor pago pelo cliente: ");
        valorRecebido = scanner.nextDouble();

        if (valorRecebido < precoTotal) {
            System.out.println("Erro: Valor insuficiente para a compra!");
        } else if (quantidadeProduto > 10) {
            troco = valorRecebido - precoFinalDesconto;
            System.out.printf("Troco do cliente: R$ %.2f%n", troco);
        } else {
            troco = valorRecebido - precoTotal;
            System.out.printf("Troco do cliente: R$ %.2f%n", troco);
        }
    }

    public void mostrarVendas() {
        System.out.println("\n--- Registro de Vendas ---");
        System.out.println("");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (String venda : vendas) {
                System.out.println(venda);
            }
        }
    }

}