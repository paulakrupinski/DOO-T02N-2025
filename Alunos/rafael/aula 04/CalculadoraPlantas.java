import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double valorTotal;
    double desconto;
    String data;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, String data) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.data = data;
    }
}

public class CalculadoraDonaGabrielinha {
    static List<Venda> registroVendas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Consultar Vendas por Data");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    registrarVenda();
                    break;
                case 4:
                    consultarVendas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    public static void calcularPrecoTotal() {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double preco = scanner.nextDouble();
        double total = quantidade * preco;
        if (quantidade > 10) {
            total *= 0.95; // Aplicando 5% de desconto
            System.out.println("Desconto de 5% aplicado!");
        }
        System.out.println("Preço total: R$ " + total);
    }

    public static void calcularTroco() {
        System.out.print("Digite o valor recebido: ");
        double recebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double total = scanner.nextDouble();
        double troco = recebido - total;
        System.out.println("Troco: R$ " + troco);
    }

    public static void registrarVenda() {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a data da venda (DD/MM/AAAA): ");
        String data = scanner.next();
        
        double total = quantidade * preco;
        double desconto = 0;
        if (quantidade > 10) {
            desconto = total * 0.05;
            total *= 0.95;
        }
        
        registroVendas.add(new Venda(quantidade, preco, total, desconto, data));
        System.out.println("Venda registrada com sucesso!");
    }

    public static void consultarVendas() {
        System.out.print("Digite a data para consulta (DD/MM/AAAA): ");
        String dataConsulta = scanner.next();
        double totalVendas = 0;
        int totalPlantas = 0;
        for (Venda venda : registroVendas) {
            if (venda.data.equals(dataConsulta)) {
                System.out.println("Quantidade: " + venda.quantidade + ", Total: R$ " + venda.valorTotal + ", Desconto: R$ " + venda.desconto);
                totalVendas += venda.valorTotal;
                totalPlantas += venda.quantidade;
            }
        }
        System.out.println("Total de plantas vendidas no dia: " + totalPlantas);
        System.out.println("Total arrecadado no dia: R$ " + totalVendas);
    }
}
