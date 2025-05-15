package Prova_1trim;

public abstract class Quarto {
    protected int numero;
    protected double precoPorNoite;
    protected boolean ocupado;

    public Quarto(int numero, double precoPorNoite) {
        this.numero = numero;
        this.precoPorNoite = precoPorNoite;
        this.ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public abstract int getCapacidade();
}

