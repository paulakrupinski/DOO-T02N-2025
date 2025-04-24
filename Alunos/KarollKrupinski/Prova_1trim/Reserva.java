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

    public long getTotalDiarias() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }

    public double getTotalAPagar() {
        return getTotalDiarias() * quarto.getPrecoPorNoite();
    }

    public boolean isDisponivel(LocalDate data) {
        return (data.isBefore(dataEntrada) || data.isAfter(dataSaida));
    }

    @Override
    public String toString() {
        return "Reserva: " + cliente + " no " + quarto + ", de " + dataEntrada + " até " + dataSaida;
    }
}
