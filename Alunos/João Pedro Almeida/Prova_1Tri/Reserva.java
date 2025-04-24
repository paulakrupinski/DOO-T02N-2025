
public class Reserva {
    Cliente cliente;
    Quarto quarto;
    int dias;

    public Reserva(Cliente cliente, Quarto quarto, int dias) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dias = dias;
    }

    public double calcularTotal() {
        return quarto.getPreco() * dias;
    }
}
