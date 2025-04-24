package Aula03;
import java.util.Scanner;
public class Application {
	
	    public static void main(String[] args) {

	    	Calculadora2 calculadora = new Calculadora2();
	        Scanner scan = new Scanner(System.in);
	        menu();
	        System.out.println("Escolha uma opcao: ");
	        int option = scan.nextInt();

	        while (option != 4){
	            switch (option){
	                case 1:
	                {
	                    System.out.println("Digite o valor do produto:");
	                    calculadora.setCost(scan.nextDouble());
	                    System.out.println("Digite a quantidade do produto:");
	                    calculadora.setQuantity(scan.nextInt());
	                    System.out.println("Valor total da compra: " + calculadora.totalValue());
	                    Calculadora2 novaCalculadora = new Calculadora2(calculadora.getQuantity(), calculadora.getCost(), calculadora.getDiscount());
	                    calculadora.addLista(novaCalculadora);
	                    break;
	                }
	                case 2:
	                {
	                    System.out.println("Digite o valor do pagamento: ");
	                    double pagamento = scan.nextDouble();
	                    System.out.println("Troco: " + calculadora.change(calculadora.totalValue(), pagamento));
	                    break;
	                }
	                case 3:
	                {
	                    calculadora.printLista();
	                    break;
	                }
	                default:
	                {
	                    break;
	                }
	            }

	            //System.out.println(calculadora.toString());
	            menu();
	            System.out.println("Escolha uma opcao: ");
	            option = scan.nextInt();
	        }

	    }


	    public static void menu ()
	    {
	        System.out.println(
	                "[1] - Calcular Preço Total \n" + "[2] - Calcular Troco\n" + "[3] - Registro de vendas\n" + "[4] - Sair\n" );
	    }
	
}
