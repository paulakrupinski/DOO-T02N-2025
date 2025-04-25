public abstract class Quarto {
    protected int numero;
    protected double precoPorNoite;
    protected int capacidade;
    protected boolean ocupado;

    public Quarto(int numero, double precoPorNoite, int capacidade) {
        this.numero = numero;
        this.precoPorNoite = precoPorNoite;
        this.capacidade = capacidade;
        this.ocupado = false;
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

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }

    public void desocupar() {
        ocupado = false;
    }

    @Override
    public String toString() {
        return "Quarto [" + "número = " + numero + ", preço por noite = " + precoPorNoite + ", capacidade = " + capacidade + ", ocupado = " + ocupado + ']';
    }
}
