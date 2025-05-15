package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Reserva {

    private Quarto quarto;
    private Cliente cliente;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Reserva(Quarto quarto, Cliente cliente) {
        this.quarto = quarto;
        this.cliente = cliente;
    }

    public static boolean verificaClienteHospedado(ArrayList<Reserva> listaReservas, String cpfCliente) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getCliente().getCpf().equals(cpfCliente) && Objects.isNull(reserva.checkOut)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificaQuartoReservado(ArrayList<Reserva> listaReservas, int numeroQuarto) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                return reserva.getQuarto().getReservado();
            }
        }
        return false;
    }

    public static void realizarCheckIn(ArrayList<Reserva> listaReservas, String cpfCliente) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getCliente().getCpf().equals(cpfCliente)) {
                reserva.setCheckIn(LocalDateTime.now());
            }
        }
    }

    public static boolean verificaClienteRealizonCheckIn(ArrayList<Reserva> listaReservas, String cpfCliente) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getCliente().getCpf().equals(cpfCliente) && !Objects.isNull(reserva.checkIn)) {
                return true;
            }
        }
        return false;
    }

    public static void realizarCheckOut(ArrayList<Reserva> listaReservas, String cpfCliente, ArrayList<Quarto> listaQuartos) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getCliente().getCpf().equals(cpfCliente)) {
                reserva.setCheckOut(LocalDateTime.now());
                reserva.getQuarto().setReservado(false);
            }
        }
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "quarto=" + quarto +
                ", cliente=" + cliente +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
