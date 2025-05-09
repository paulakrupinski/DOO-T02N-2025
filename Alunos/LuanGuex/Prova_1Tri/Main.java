package Alunos.LuanGuex.Prova_1Tri;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Quarto> quartos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        quartos.add(new Quarto(0, "Nenhum", 1, true, false, false));
        quartos.add(new Quarto(0, "Nenhum", 2, true, false, false));

        int op = 0;
        boolean[][] data = new boolean[12][30];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 30; j++) {
                data[i][j] = false;
            }
        }
        


        while (op != 5){

            System.out.println("\n=== Menu do Hotel ===");
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Reservar quarto");
            System.out.println("[3] Realizar Check-in");
            System.out.println("[4] Realizar Check-out");
            System.out.println("[5] Sair");
            System.out.print("Digite uma opção: ");
            op = scan.nextInt();
            scan.nextLine();

            switch (op) {

                case 1:
                    System.out.print("\nNome: ");
                    String nome = scan.nextLine();

                    clientes.add(new Cliente(nome));

                    break;
                
                case 2:

                    System.out.println("\n=== Lista de Clientes ===");

                    for (int i = 0; i < clientes.size(); i++){
                        System.out.println("[ID " + (i+1) + "]");
                        clientes.get(i).info();
                    }

                    System.out.print("\nDigite o ID para fazer uma reserva: ");
                    int idCliente = scan.nextInt();

                    System.out.println("Digite o mês (1 a 12): ");
                    int mes = scan.nextInt() - 1;
                    if (mes < 0 || mes > 12) {
                        System.out.println("Mês inválido!");
                        break;
                    }

                    System.out.println("Digite o dia (1 a 30): ");
                    int dia = scan.nextInt() - 1;
                    if (dia < 0 || dia > 30) {
                        System.out.println("Dia inválido!");
                        break;
                    }


                    if (data[mes][dia] == false){
                        System.out.println("\n=== Lista de Quartos ===");

                        for (int i = 0; i < quartos.size(); i++){

                            if(quartos.get(i).disp == true && quartos.get(i).checkin == false){
                            System.out.println();
                            System.out.println("[ID " + (i+1) + " ]");
                            quartos.get(i).infoQuarto();
                            }
                        }

                        System.out.print("\nDigite o ID do quarto: ");
                        int idQuarto = scan.nextInt();
                        quartos.get(idQuarto - 1). disp = false;

                        quartos.get(idQuarto - 1).nome = clientes.get(idCliente - 1).nome;

                        System.out.print("\nDiarias: ");
                        int diaria = scan.nextInt();

                        quartos.get(idQuarto - 1).diaria = diaria;
                        data[mes][dia] = true;

                        break;

                    } else {

                        System.out.println("Dia reservado!");
                        break;
                    }

                case 3:
                    System.out.println("=== Lista de Checkin ===");

                    for (int i = 0; i < quartos.size(); i++){

                        if (quartos.get(i).checkin == false && quartos.get(i).checkout == false){

                        System.out.println();
                        System.out.println("[ID " + (i+1) + " ]");
                        quartos.get(i).infoCliente();

                        }
                    }

                    System.out.print("\nDigite o ID para fazer checkin: ");
                    int idCheckin = scan.nextInt();

                    quartos.get(idCheckin - 1).checkin = true;
                    
                    break;

                case 4:

                    System.out.println("\n=== Lista de Checkout ===");

                    for (int i = 0; i < quartos.size(); i++){

                        if (quartos.get(i).checkout == false && quartos.get(i).checkin == true){

                        System.out.println();
                        System.out.println("[ID " + (i+1) + " ]");
                        quartos.get(i).infoCliente();

                        }
                    }

                    System.out.print("\nDigite o ID para fazer checkout: ");
                    int idCheckout = scan.nextInt();

                    quartos.get(idCheckout - 1).checkin = false;
                    quartos.get(idCheckout - 1).disp = true;
                    quartos.get(idCheckout - 1).nome = "Nenhum";

                    if (quartos.get(idCheckout - 1).tipo == 1){

                        System.out.println("\nA diaria ficou: R$" + (quartos.get(idCheckout - 1).diaria * 100));
                    
                    } else {

                        System.out.println("\nA diaria ficou: R$" + (quartos.get(idCheckout - 1).diaria * 200));
                    }

                    break;

                default:
                    break;
            }

        }
    }
    
}
