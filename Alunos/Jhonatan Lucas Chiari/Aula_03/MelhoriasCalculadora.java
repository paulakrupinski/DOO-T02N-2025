import java.util.Scanner;

public class MelhoriasCalculadora  {
    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Calcular Preço Total");
            System.out.println("2 - Calcular Troco");
            System.out.println("3 - Vizualizar Relatórios");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.println("Digite o valor unitário de cada planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.printf("O preço total é: %.2f\n", precoTotal);
                    break;

                case 2:
                    System.out.println("Digite o valor recebido: ");
                    double valorRecebido = scanner.nextDouble();
                    System.out.println("Digite o valor total: ");
                    double valorTotal = scanner.nextDouble();
                    double troco = calcularTroco(valorRecebido, valorTotal);
                    System.out.printf("O valor de troco é: %.2f\n", troco);
                    break;

                case 3:
                    System.out.println("Encerrando sistema");
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (opcao != 3); 

        scanner.close();
    }
}
