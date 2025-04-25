import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva(LocalDate checkOut, LocalDate checkIn, Quarto quarto, Cliente cliente) {
        this.checkOut = checkOut;
        this.checkIn = checkIn;
        this.quarto = quarto;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
