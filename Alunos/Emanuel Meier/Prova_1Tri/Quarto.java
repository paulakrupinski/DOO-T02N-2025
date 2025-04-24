package fag.objeto;

public abstract class Quarto {
    private int numero;
    private boolean ocupado;
    private int capacidade;
    private double preco;

    public Quarto(int numero, int capacidade, double preco) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.preco = preco;
        this.ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPreco() {
        return preco; 
    }

    public abstract String tipo();
}
