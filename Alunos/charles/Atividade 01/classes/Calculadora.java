package classes;

import java.util.Scanner;

public class Calculadora {
    public Scanner sc = new Scanner(System.in);

    public double calcularPrecoTotal(int quantidade, double preco) {
        return quantidade * preco;
    }

    public double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public void menu() {
        System.out.println("[1] - Calcular Preço Total");        
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Sair");
        sc.nextInt();
    }
}
