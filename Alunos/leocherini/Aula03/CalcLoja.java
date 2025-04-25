package calculadoraMelhorada;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class CalcLoja {
    public static void main(String[] args) {
	       calculadoraMelhor();
	        
	    }
public static void calculadoraMelhor() {
	Scanner scanner = new Scanner(System.in);
	List<String> vendas = new ArrayList<>();
	

	        while (true) {
	            System.out.println("\nCalculadora da Loja de Plantas :");
	            System.out.println("1- Calcular Preço Total");
	            System.out.println("2- Calcular Troco");
	            System.out.println("3- Ver Registro de Vendas");
	            System.out.println("4- Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = scanner.nextInt();

	            if (opcao == 1) {
	                System.out.print("Quantidade de plantas: ");
	                int quantidade = scanner.nextInt();
	                System.out.print("Preço unitário: ");
	                double preco = scanner.nextDouble();

	                double total = quantidade * preco;
	                double desconto = 0;

	                if (quantidade > 10) {
	                    desconto = total * 0.05;
	                    total -= desconto;
	                    System.out.printf("Desconto de 5%% aplicado: R$ %.2f\n", desconto);
	                }

	                System.out.printf("Preço total: R$ %.2f\n", total);
	                vendas.add("Quantidade: " + quantidade + "  Total: R$ " + total + "  Desconto: R$ " + desconto);
	            } 
	            else if (opcao == 2) {
	                System.out.print("Valor recebido: ");
	                double recebido = scanner.nextDouble();
	                System.out.print("Valor total da compra: ");
	                double total = scanner.nextDouble();
	                
	                if (recebido < total) {
	                    System.out.println("Valor informado é insuficiente");
	                } else {
	                    System.out.printf("Troco: R$ %.2f\n", recebido - total);
	                }
	            } 
	            else if (opcao == 3) {
	                System.out.println("\n Registro de Vendas ");
	                if (vendas.isEmpty()) {
	                    System.out.println("Nenhuma venda registrada.");
	                } else {
	                	for (int i = 0; i < vendas.size(); i++) {
	                	    System.out.println(vendas.get(i));
	                	}
	                }
	            } 
	            else if (opcao == 4) {
	                System.out.println("Saindo.");
	                break;
	            } 
	            else {
	                System.out.println("Opção inválida,Tente novamente.");
	            }
	        }

	        scanner.close();
	 
	}
	}


