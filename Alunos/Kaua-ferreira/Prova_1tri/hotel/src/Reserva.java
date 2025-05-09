import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public long getTotalDias() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }

    public double getTotalAPagar() {
        return getTotalDias() * quarto.getPrecoPorNoite();
    }

    @Override
    public String toString() {
        return cliente + " - Quarto " + quarto.getNumero() +
               " de " + dataEntrada + " até " + dataSaida +
               " - Total: R$ " + getTotalAPagar();
    }
}
