import java.util.Date;

public class Reserva {
    Cliente cliente;
    Quarto quarto;
    Date dataEntrada;
    Date dataSaida;

    public Reserva(Cliente cliente, Quarto quarto, Date dataEntrada, Date dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public long getDiarias() {
        long diff = dataSaida.getTime() - dataEntrada.getTime();
        return (diff / (1000 * 60 * 60 * 24));
    }

    public double calcularTotal() {
        return getDiarias() * quarto.precoPorNoite;
    }
}