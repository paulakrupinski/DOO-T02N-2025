package hotel;

public abstract class quarto {
    protected int numero;
    protected int capacidade;
    protected double precoDiaria;

    public quarto(int numero, int capacidade, double precoDiaria) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.precoDiaria = precoDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }
}
