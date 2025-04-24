import java.time.LocalDate;

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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
