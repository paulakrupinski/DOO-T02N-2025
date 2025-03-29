import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    public static List<Venda>listaDeVenda = new ArrayList<Venda>();

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("João", 30, "Cidade A", "Bairro X", "Rua 1");
        Cliente cliente2 = new Cliente("Maria", 25, "Cidade B", "Bairro Y", "Rua 2");
        Vendedor vendedor1 = new Vendedor("Carlos", 40, "Loja A", "Cidade A", "Bairro X", "Rua 1", "2000,00", new String[]{"2200,00", "2500,00", "2800,00"});
        Vendedor vendedor2 = new Vendedor("Ana", 35, "Loja B", "Cidade B", "Bairro Y", "Rua 2", "1800,00", new String[]{"2000,00", "2200,00", "2400,00"});
        Loja loja = new Loja();
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);

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


