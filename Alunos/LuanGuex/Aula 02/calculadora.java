import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int op = 0;
        float total = 0;

        while (op != 3) {     
            System.out.println("\n\n[Menu]\n[1] Calcular o preço total\n[2] Calcular troco\n[3] Sair");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    total = calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    public static float calcularPrecoTotal(Scanner scanner) {
        System.out.println("Insira o valor da planta: ");
        float valorP = scanner.nextFloat();

        System.out.println("Insira a quantidade de plantas: ");
        int quantP = scanner.nextInt();

        float total = 0;
                   
        total = valorP * quantP;
        System.out.printf("\nO total é de: R$%.2f", total);          

        return total;  
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.println("Insira o dinheiro dado pelo cliente: ");
        float dinheiroC = scanner.nextFloat();

        System.out.println("Insira o total da compra: ");
        float totalCompra = scanner.nextFloat();

        if (dinheiroC < totalCompra){
            System.out.printf("\nCliente está devendo: R$%.2f", dinheiroC - totalCompra);
        }
        
        else{
            System.out.printf("\nO troco do cliente deve ser de: %.2f\n", dinheiroC - totalCompra);
        }
    }
}
