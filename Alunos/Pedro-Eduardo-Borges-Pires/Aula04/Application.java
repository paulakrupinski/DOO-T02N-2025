package Aula04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Calculadora calculadora = new Calculadora();
        Scanner scan = new Scanner(System.in);
        menu();
        System.out.println("Escolha uma opcao: ");
        int option = scan.nextInt();

        while (option != 5){
            switch (option){
                case 1:
                {
                    System.out.println("Digite o valor do produto:");
                    calculadora.setCost(scan.nextDouble());
                    System.out.println("Digite a quantidade do produto:");
                    calculadora.setQuantity(scan.nextInt());
                    System.out.println("Valor total da compra: " + calculadora.totalValue());
                    Calculadora novaCalculadora = new Calculadora(calculadora.getQuantity(), calculadora.getCost(), calculadora.getDiscount(), LocalDate.now());
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
                case 4:
                {
                    System.out.println("Digite uma data (dd/MM/yyyy): ");
                    LocalDate data = LocalDate.parse(scan.next(), dtf);
                    calculadora.searchPerDate(data);
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
                "[1] - Calcular Preço Total\n" + "[2] - Calcular Troco\n" + "[3] - Registro de vendas\n" + "[4] - Buscar por Data\n" + "[5] - Sair\n" );
    }
}
