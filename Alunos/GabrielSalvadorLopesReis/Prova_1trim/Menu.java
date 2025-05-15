package Prova_1trim;

import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    static private boolean flag = true;
    static private boolean flag2 = true;

    public static void menu() {

        while (flag) {
            flag2 = true;
            System.out.println("\nHotel");
            System.out.println("1 - Cliente");
            System.out.println("2 - Quarto");
            System.out.println("3 - Reserva\n");

            menuPrincipal(sc.nextInt());
        }

    }

    public static void menuPrincipal(int i) {
        switch (i) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuQuarto();
                break;
            case 3:
                menuReserva();
                break;
            default:
                flag = false;
        }
    }

    public static void menuCliente() {
        int opc;
        while (flag2) {
            System.out.println("\n1. adicionar cliente");
            System.out.println("2. listar clientes");
            System.out.println("0. voltar\n");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            opc = sc.nextInt();
            sc.nextLine();
            opcCliente(opc);
        }
    }

    public static void opcCliente(Integer opc) {
        switch (opc) {
            case 1:
                Cliente.adicionarCliente();
                break;
            case 2:
                Cliente.listarClientes();
                break;
            default:
                flag2 = false;
                break;
        }
    }

    public static void menuQuarto() {
        int opc;
        while (flag2) {
            System.out.println("\n1. adicionar quarto");
            System.out.println("2. listar quartos");
            System.out.println("0. voltar\n");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            opc = sc.nextInt();
            sc.nextLine();
            opcQuarto(opc);
        }
    }

    public static void opcQuarto(Integer opc) {
        switch (opc) {
            case 1:
                Quarto.adicionarQuarto();
                break;
            case 2:
                Quarto.listarQuartos();
                break;
            default:
                flag2 = false;
        }
    }

    public static void menuReserva() {
        int opc;
        while (flag2) {
            System.out.println("\n1. adicionar reserva");
            System.out.println("2. verificar disponibilidade");
            System.out.println("0. voltar\n");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            opc = sc.nextInt();
            sc.nextLine();
            opcReserva(opc);
        }
    }

    public static void opcReserva(Integer opc) {
        switch (opc) {
            case 1:
                Quarto.novaReserva();
                break;
            case 2:
                Quarto.verificarDisponiblidade();
                break;
            default:
                flag2 = false;
        }
    }
}
