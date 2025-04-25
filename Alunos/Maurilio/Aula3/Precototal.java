import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Precototal {

    private int quantidadevendas;
    private double valorvenda;
    private double valordesconto;

    public static List<Precototal> listavendas = new ArrayList<>();

    public Precototal(int quantidadevendas, double valorvenda, double valordesconto) {
        this.quantidadevendas = quantidadevendas;
        this.valorvenda = valorvenda;
        this.valordesconto = valordesconto;
    }

    public static void calcularPrecototal() {


        Scanner sc = new Scanner(System.in);

        double valortotal = 0;
        double valordesconto = 0;

        System.out.println("Quantas plantas foram vendidas?");
        int vendas = sc.nextInt();


        System.out.println("Qual o valor de cada planta?");
        double valor = sc.nextDouble();

        valortotal = valor * vendas;

        if (vendas > 10) {

            valordesconto = valortotal * 0.05;
            valortotal = valortotal - valordesconto;
        }

        Precototal venda = new Precototal(vendas, valortotal, valordesconto);
    listavendas.add(venda);


        System.out.println(venda);

        CalcularTroco();
    }
    public static void CalcularTroco() {
Scanner sc = new Scanner(System.in);


        if(listavendas.isEmpty()) {
            System.out.printf(".Nenhuma venda registrada. Lista vazia\n");
        }

        for (Precototal venda : listavendas) {
            System.out.println("O valor total da venda é:" + venda.getValorvenda());
            System.out.println("Digite o valor que o cliente pagou:");
            double valorpagocliente = sc.nextDouble();

            double troco = valorpagocliente - venda.getValorvenda();

            if (troco < 0) {
                System.out.println("O valor não é suficiente, restam" + "R$" + troco);
            } else {
                System.out.println("Valor do troco: " + "R$" + troco);
            }
        }


        Main.Menu.mostrarMenu();
    }

    @Override
    public String toString() {
        return "Precototal{" +
                "Quantidade de Plantas=" + quantidadevendas +
                ", Valor Total=" + valorvenda +
                ", Valor do Desconto=" + valordesconto +
                '}';
    }

    public int getQuantidadevendas() {
        return quantidadevendas;
    }

    public void setQuantidadevendas(int quantidadevendas) {
        this.quantidadevendas = quantidadevendas;
    }

    public double getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(double valorvenda) {
        this.valorvenda = valorvenda;
    }

    public double getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(double valordesconto) {
        this.valordesconto = valordesconto;
    }

    public static List<Precototal> getListavendas() {
        return listavendas;
    }

    public void setListavendas(List<Precototal> listavendas) {
        Precototal.listavendas = listavendas;
    }
}
