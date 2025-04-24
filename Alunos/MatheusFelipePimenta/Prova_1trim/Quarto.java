public abstract class Quarto {
    int numero;
    int capacidade;
    double precoPorNoite;
    boolean ocupado;

    public Quarto(int numero, int capacidade, double precoPorNoite) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
        this.ocupado = false;
    }

    public boolean isDisponivel() {
        return !ocupado;
    }
}