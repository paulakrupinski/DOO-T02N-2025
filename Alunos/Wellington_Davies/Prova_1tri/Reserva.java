import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private Clientes cliente;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(Clientes cliente, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    // peguei esse trecho "ChronoUnit.DAYS.between" para calcular a diferença entre data de entrada e data de saida...
    public double calcularTotal() {
        long dias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        return dias * quarto.getPrecoDiaria();
    }

    public Clientes getCliente() {
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
}
