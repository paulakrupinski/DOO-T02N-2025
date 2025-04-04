import java.util.Scanner;

public class gabicontinhas{
    public static void main(String[] args) {
    int op=0, quantPlanta=0;
    float valorPlanta=0, total=0, dinheiroCliente=0;

    while(op != 3){
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n\nMENU DE CONTAS \n[1]Calcular preço total \n[2]Calcular troco \n[3]Sair");
    op = scanner.nextInt();
    
    if (op == 1){
        System.out.println("Insira o valor da planta");
        valorPlanta = scanner.nextFloat();

        System.out.println("Insira a quantidade de plantas");
        quantPlanta = scanner.nextInt();

        total = valorPlanta * quantPlanta;
        System.out.printf("O total é de: %.2f", total );
    }

    if (op==2){
        System.out.println("Insira o valor dado pelo cliente");
        dinheiroCliente = scanner.nextFloat();

        System.out.printf("O troco do cliente deve ser de : %.2f", dinheiroCliente - total);
    }
    }
    }
}