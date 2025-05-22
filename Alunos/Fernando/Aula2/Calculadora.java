package Aula2;;

public class Calculadora {

    public double calcularPrecoTotal(int quantidade, double preco) {
        return quantidade * preco;
    }

    public double calcularTroco(double valorRecebido, double total) {
        return valorRecebido - total;
    }
    
}