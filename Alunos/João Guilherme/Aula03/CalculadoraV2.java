import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraV2 {
    private static Scanner scan = new Scanner(System.in);
    
    private static List<Integer> quantidadesVendidas = new ArrayList<>();
    private static List<Double> valoresTotais = new ArrayList<>();
    private static List<Double> descontosAplicados = new ArrayList<>();

    public static void main(String[] args) {
        exibirMenu();
        scan.close();
    }

    public static void exibirMenu() {
        int opcao;
        double total = 0;

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    total = calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco(total);
                    break;
                case 3:
                    exibirRegistroVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static double calcularPrecoTotal() {
        System.out.print("Qual o valor unitário das plantas? ");
        double valor = scan.nextDouble();  

        System.out.print("Qual a quantidade comprada? ");
        int qtd = scan.nextInt();

        double desconto = (qtd >= 10) ? 0.1 : 0.0;  
        double total = valor * qtd * (1 - desconto);

        // Adiciona os valores nas listas
        quantidadesVendidas.add(qtd);
        valoresTotais.add(total);
        descontosAplicados.add(desconto * 100);

        System.out.printf("O valor total foi de R$%.2f (Desconto aplicado: %.0f%%)\n", total, desconto * 100);

        return total;
    }

    public static void calcularTroco(double total) {
        if (total == 0) {
            System.out.println("Nenhuma compra foi feita ainda.");
            return;
        }

        System.out.print("Qual o valor que o cliente deu? ");
        double cliente = scan.nextDouble();

        double troco = cliente - total;
        if (troco > 0) {
            System.out.printf("O troco foi de R$%.2f\n", troco);
        } else if (troco == 0) {
            System.out.println("O valor entregue foi exato ao valor total da compra.");
        } else {
            System.out.println("Caloteiro! Ainda falta R$" + Math.abs(troco));
        }
    }

    public static void exibirRegistroVendas() {
        if (quantidadesVendidas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até agora.");
            return;
        }

        System.out.println("\n=== REGISTRO DE VENDAS ===");
        for (int i = 0; i < quantidadesVendidas.size(); i++) {
            System.out.printf("Venda %d: Quantidade: %d | Valor Total: R$%.2f | Desconto: %.0f%%\n",
                    (i + 1), quantidadesVendidas.get(i), valoresTotais.get(i), descontosAplicados.get(i));
        }
    }
}
