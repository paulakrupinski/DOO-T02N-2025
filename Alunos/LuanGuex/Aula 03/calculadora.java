import java.util.ArrayList;
import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Integer> quantidadePlantas = new ArrayList<>();
        ArrayList <Float> totalDia = new ArrayList<>();
        ArrayList <Float> totalDesc = new ArrayList<>();
        
        int op = 0;
        float total = 0;

        while (op != 4) {     
            System.out.println("\n\n[Menu]\n[1] Calcular o preço total\n[2] Calcular troco\n[3] Relatório de vendas\n[4] Sair");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    total = calcularPrecoTotal(scanner, quantidadePlantas, totalDia, totalDesc);
                    break;
                case 2:
                    calcularTroco(scanner, total);
                    break;
                case 3:
                    visualizarRelatorio(quantidadePlantas, totalDia, totalDesc);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    public static float calcularPrecoTotal(Scanner scanner, ArrayList<Integer> quantidadePlantas, ArrayList<Float> totalDia, ArrayList<Float> totalDesc) {
        System.out.println("Insira o valor da planta: ");
        float valorP = scanner.nextFloat();

        System.out.println("Insira a quantidade de plantas: ");
        int quantP = scanner.nextInt();
        quantidadePlantas.add(quantP);

        float total = 0;

        if (quantP >= 10){
            System.out.println("\nCliente recebeu um desconto de 5%");
            total = valorP * quantP * 0.95f;
            System.out.printf("O total é de: %.2f", total);
            
            float desconto = (valorP * quantP) - (valorP * quantP * 0.95f);
            totalDesc.add(desconto);
        } 
        
        else {
            total = valorP * quantP;
            System.out.printf("\nO total é de: %.2f", total);          
        }
      
        totalDia.add(total);
        return total;
    }

    public static void calcularTroco(Scanner scanner, float total) {
        System.out.println("Insira o dinheiro dado pelo cliente: ");
        float dinheiroC = scanner.nextFloat();

        if (dinheiroC < total){
            System.out.printf("\nCliente está devendo: R$%.2f", dinheiroC - total);
        }
        
        else{
            System.out.printf("\nO troco do cliente deve ser de: %.2f\n", dinheiroC - total);
        }
    }

    public static void visualizarRelatorio(ArrayList<Integer> quantidadePlanta, ArrayList<Float> totalDia, ArrayList<Float> totalDesc) {
        int somaQuant = 0;
        float somaTotal = 0, somaDesc = 0;

        for (int num : quantidadePlanta){
            somaQuant += num;
        }
        System.out.printf("\nQuantidade de plantas adicionadas: %d ", somaQuant);
    
        for (float num : totalDia){
            somaTotal += num;
        }
        System.out.printf("\nTotal vendido: R$%.2f", somaTotal);

        for (float num : totalDesc){
            somaDesc += num;
        }
        System.out.printf("\nDesconto dado: R$%.2f", somaDesc);
    }
}
