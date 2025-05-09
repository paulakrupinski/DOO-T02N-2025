import java.util.Scanner;
import java.util.ArrayList;


public class Hotel {
public static void main (String [] args){
ArrayList<Clientes> listaClientes = new ArrayList<>();
ArrayList<Quartos> listaQuartos = new ArrayList<>();

Scanner scanner = new Scanner(System.in);
    int op = 0;

   while (op != 7){
    System.out.println("\n--MENU--\n[1]Cadastro de clientes \n[2]Cadastro de quartos \n[3]Reservar um quarto \n[4]Valor total de diárias");
    op = scanner.nextInt();

    if (op == 1){
    System.out.println("\nDigite o nome do cliente:");
    String nome = scanner.nextLine();
    scanner.nextLine();

    System.out.println("\nDigite a idade do cliente:");
    int idade = scanner.nextInt();
    scanner.nextLine();

    Clientes cliente = new Clientes(nome, idade); 
    listaClientes.add(cliente);
    System.out.println("Cliente adicionado!");
    }

    if (op == 2){
        System.out.println("\nDigite quantas camas tem o quarto:");
        int camas = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("\nDigite o número do quarto:");
        int número = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nO quarto está disponível? s/n");
        String resp = scanner.nextLine();

        boolean disp;
        if ((resp.equalsIgnoreCase("s"))) {
            disp = true;
        } else {
            disp = false;
        }
        System.out.println("\nQuarto cadastrado!");
        Quartos quarto = new Quartos(camas, número, disp);
        listaQuartos.add(quarto);
    }
    if (op == 3){
        System.out.println("Qual quarto você quer reservar?");
                for(int i = 0; i < listaQuartos.size(); i++){
                    System.out.println("\n-----------------");
                    System.out.println("ID " + (i+1));
                    listaQuartos.get(i).info();
                }
        System.out.print("\nDigite o ID do quarto que deseja reservar: ");
        int id = scanner.nextInt() - 1;

        listaQuartos.remove(id);
    }

    if (op == 4){
        System.out.println("\nDigite o valor da diária");
        int valor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nDigite o total de diárias");
        int totalDia = scanner.nextInt();
        scanner.nextLine();

       int total = valor * totalDia;

        System.out.println("O total é de " + total);
    }

    }
}

}
    