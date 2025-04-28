package prova1_tri;
import java.util.ArrayList;

import java.time.LocalDate;
import java.util.List;

class Reserva {

    Cliente cliente;
    Quarto quarto;
    int diasReservados;
    double valorTotal;
    LocalDate checkIn;
    LocalDate checkOut;

    public Reserva(Cliente cliente, Quarto quarto, int diasReservados, double valorTotal, LocalDate checkIn, LocalDate checkOut) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.diasReservados = diasReservados;
        this.valorTotal = valorTotal;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        quarto.setDisponibilidadeQuarto(false);
    }

    public void checkOut() {
        quarto.setDisponibilidadeQuarto(true); // Libera o quarto
    }

    @Override
    public String toString() {
        return "Reserva [Cliente: " + cliente.nome + ", Quarto: " + quarto.codQuarto
                + ", Check-in: " + checkIn + ", Check-out: " + checkOut
                + ", Dias Reservados: " + diasReservados + ", Valor Total: R$" + valorTotal + "]";
    }

    public Cliente getHospede() {
        return cliente;
    }

    public void setHospede(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
