import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {



    public static List<Venda>listaDeVenda = new ArrayList<Venda>();

    static Scanner scan = new Scanner(System.in);
        public static void main(String[] args) {
            int op;
            do{
                System.out.println(" [1] - Calcular Preço Total / [2] - Calcular Troco / [3] - Listar vendas / [4] - Sair ");
                op = scan.nextInt();

                switch(op){
                    case 1:
                        logica.precoTotal();break;
                    case 2:
                        logica.calcularTroco();break;
                    case 3:
                        logica.listarVendas();break;
                    case 4:
                        break;
                }
            }while(op != 4);



            System.out.println("Sistema finalizado!!!");
        }



    }


