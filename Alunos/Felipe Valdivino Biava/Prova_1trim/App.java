import java.util.Scanner;

public class App {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("BEM VINDO AO HOTEL");

        int op;
        do{
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Cadastrar quarto");
            System.out.println("[3] Reservar quarto");
            System.out.println("[4] Realizar chekin");
            System.out.println("[5] Realizar checkout");
            System.out.println("[6] Calcular diaria");
            System.out.println("[7] Disponibilidade quarto");
            System.out.println("[0] Sair");
            op = scan.nextInt();
            App.scan.nextLine();

            switch (op){
                case 1: Logica.cadastrarCliente();break;
                case 2: Logica.cadastrarQuarto();break;
                case 3: Logica.reservaDeQuarto();break;
                case 4: Logica.realizarCheckin();break;
                case 5: Logica.realizarCheckout();break;
                case 6: Quarto.calcularDiaria();break;
                case 0: break;
            }

        }while(op != 0);

    }

}
