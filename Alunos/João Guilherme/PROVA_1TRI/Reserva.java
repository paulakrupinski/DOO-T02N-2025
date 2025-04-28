package PROVA_1TRI;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private int dias;
    private boolean checkinFeito;
    private boolean checkoutFeito;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;

    public Reserva(Cliente cliente, Quarto quarto, int dias, LocalDate dataCheckin) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dias = dias;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckin.plusDays(dias);
        this.checkinFeito = false;
        this.checkoutFeito = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public boolean isCheckinFeito() {
        return checkinFeito;
    }

    public boolean isCheckoutFeito() {
        return checkoutFeito;
    }

    public void fazerCheckin() {
        this.checkinFeito = true;
        this.quarto.setDisponivel(false);
    }

    public void fazerCheckout() {
        this.checkoutFeito = true;
        this.quarto.setDisponivel(true);
    }

    public double calcularTotal() {
        return dias * quarto.getPreco();
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }
}
