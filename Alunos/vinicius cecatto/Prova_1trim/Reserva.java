package Prova_1trim;

import java.time.LocalDate;

public class Reserva {
    Cliente cliente;
    Quarto quarto;
    LocalDate dataCheckIn;
    LocalDate dataCheckOut;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quarto.setDisponivel(false);
    }

    public double calcularTotalDiarias() {
        long dias = dataCheckOut.toEpochDay() - dataCheckIn.toEpochDay();
        return dias * quarto.precoDiaria;
    }

    public void realizarCheckOut() {
        quarto.setDisponivel(true);
    }
}