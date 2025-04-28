package classes;

import classes.Quartos;
import classes.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static Quartos quarto = new Quartos(0,null, 0, null, null, true, null);
    public static Cliente cliente = new Cliente(null, null,0,0, null);


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean menu01 = true;

        while(menu01){

            System.out.println("escolha uma das opcoes:" +
                    "\n1-Fazer reserva" +
                    "\n2-check-in" +
                    "\n3-check-out" +
                    "\n4-calcular total das diarias" +
                    "\n5-verificar disponibilidade" +
                    "\n6-sair");

            int opcao = scan.nextInt();

            if(opcao == 1){

                Quartos.cadastroQuartos(quarto, cliente);

            } else if (opcao == 2) {

                Quartos.checkIn(quarto, cliente);

            } else if (opcao == 3) {

                Quartos.checkOut(quarto, cliente);

            } else if (opcao == 4) {

                Quartos.calcularDiarias(quarto, cliente);

            } else if (opcao == 5) {

                Quartos.verificarDisponibilidade(quarto, cliente);

            } else if (opcao == 6) {

                menu01 = false;

            }else{

                System.out.println("opcao invalida");
            }


        }
    }

}

