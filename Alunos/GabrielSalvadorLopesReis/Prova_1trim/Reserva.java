package Prova_1trim;

import java.time.LocalDate;
import java.util.List;

public class Reserva {
    private Integer id;
    private LocalDate checkin;
    private LocalDate checkout;
    private Cliente cliente;

    static private Integer proximoId = 0;

    public Reserva() {
        this.id = proximoId++;
    }

    public static void adcionarReserva(LocalDate checkin, LocalDate checkout, Cliente cliente) {
        Reserva reserva = new Reserva();

        reserva.setCheckin(checkin);
        reserva.setCheckout(checkout);
        reserva.setCliente(cliente);
    }


    public boolean conflitaCom(LocalDate dataInicio, LocalDate dataFim) {
        return !(dataFim.isBefore(checkin) || dataInicio.isAfter(checkout.minusDays(1)));
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
