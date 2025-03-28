import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    public static int[][] vendasPorDia = new int[12][31];

    public static List<Venda>listaDeVenda = new ArrayList<Venda>();

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        do{
            System.out.println(" [1] - Calcular Preço Total \n " +
                    "[2] - Calcular Troco \n " +
                    "[3] - Listar vendas \n " +
                    "[4] - Filtrar vendas \n " +
                    "[5] - Sair \n");
            op = scan.nextInt();

            switch(op){
                case 1:
                    logica.precoTotal();break;
                case 2:
                    logica.calcularTroco();break;
                case 3:
                    logica.listarVendas();break;
                case 4:
                    logica.buscarVendasPorDia();break;
                case 5:
                    break;
            }
        }while(op != 5);



        System.out.println("Sistema finalizado!!!");
    }



}


