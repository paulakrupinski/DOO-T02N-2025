package provaEnon;

import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private Date dataReserva;
    private Date dataCheckIn;
    private Date dataCheckOut;

    public Reserva(Cliente cliente, Quarto quarto, Date dataReserva) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataReserva = dataReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
}
