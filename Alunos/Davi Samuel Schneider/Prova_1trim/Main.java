import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        executar();
    }

    public static void menu() {
        System.out.print("1- Cadastrar Cliente");
        System.out.println("         2- Cadastrar Quarto");
        System.out.print("3- Reservar Quarto");
        System.out.println("           4- Realizar check-in");
        System.out.print("5- Realizar check-out");
        System.out.println("        0- Sair");
    }

    public static void executar() {
        int opc = 0;
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            menu();
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    hotel.cadastrarCliente();
                    break;
                case 2:
                    hotel.cadastarQuarto();
                    break;
                case 3:
                    hotel.reservarQuarto();
                    break;
                case 4:
                    hotel.realizarCheckIn();
                    break;
                case 5:
                    hotel.realizarCheckOut();
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
