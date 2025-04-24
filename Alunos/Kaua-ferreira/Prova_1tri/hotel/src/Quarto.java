public abstract class Quarto {
    private int numero;
    private double precoPorNoite;

    public Quarto(int numero, double precoPorNoite) {
        this.numero = numero;
        this.precoPorNoite = precoPorNoite;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public abstract int getCapacidade();

    @Override
    public String toString() {
        return "Quarto " + numero + " - R$ " + precoPorNoite + " por noite";
    }
}
