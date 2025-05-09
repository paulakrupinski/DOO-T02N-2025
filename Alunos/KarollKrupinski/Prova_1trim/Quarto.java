public abstract class Quarto {
    protected int numero;
    protected double precoPorNoite;
    protected int capacidade;

    public Quarto(int numero, double precoPorNoite, int capacidade) {
        this.numero = numero;
        this.precoPorNoite = precoPorNoite;
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Quarto " + numero + " - Tipo: " + getTipo() + ", Capacidade: " + capacidade + ", R$" + precoPorNoite + "/noite";
    }
}
