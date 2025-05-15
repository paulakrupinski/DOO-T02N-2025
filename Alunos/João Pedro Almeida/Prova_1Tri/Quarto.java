public class Quarto {
    int numero;
    boolean ocupado;
    double preco;

    public Quarto(int numero, double preco) {
        this.numero = numero;
        this.preco = preco;
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }

    public void liberar() {
        ocupado = false;
    }

    public double getPreco() {
        return preco;
    }
}
