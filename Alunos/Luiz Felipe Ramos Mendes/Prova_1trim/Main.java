import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1- Cadastrar Cliente 2-Cadastrar Quarto 3- Fazer Reserva 4- Fazer Check-in 5- Fazer Check-out 6- Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1: {
                    hotel.cadastrarCliente();
                    break;
                }
                case 2: {
                    hotel.cadastrarQuarto();
                    break;
                }
                case 3: {
                    hotel.fazerReserva();
                    break;
                }
                case 4: {
                    hotel.fazerCheckin();
                    break;
                }
                case 5: {
                    hotel.fazerCheckout();
                    break;
                }
                case 6: {
                    System.out.println("Saindo");
                    return;
                }
            }
        }
    }
}
