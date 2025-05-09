package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class servico {
    private List<cliente> clientes = new ArrayList<>();
    private List<quarto> quartos = new ArrayList<>();
    private List<reserva> reservas = new ArrayList<>();

    public void cadastrarCliente(cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarQuarto(quarto quarto) {
        quartos.add(quarto);
    }

    public boolean verificarDisponibilidade(quarto quarto, LocalDate entrada, LocalDate saida) {
        for (reserva r : reservas) {
            if (r.getquarto().getNumero() == quarto.getNumero()) {
                if (!(saida.isBefore(r.getdataentrada()) || entrada.isAfter(r.getdatasaida()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean reservarQuarto(cliente cliente, quarto quarto, LocalDate entrada, LocalDate saida) {
        if (verificarDisponibilidade(quarto, entrada, saida)) {
            reservas.add(new reserva(cliente, quarto, entrada, saida));
            return true;
        }
        return false;
    }

    public void realizarCheckin(String documentoCliente) {
        for (reserva r : reservas) {
            if (r.getcliente().getDocumento().equals(documentoCliente) && !r.ischeckinrealizado()) {
                r.realizarcheckin();
                break;
            }
        }
    }

    public void realizarCheckout(String documentoCliente) {
        for (reserva r : reservas) {
            if (r.getcliente().getDocumento().equals(documentoCliente) && r.ischeckinrealizado() && !r.ischeckoutrealizado()) {
                r.realizarcheckout();
                System.out.println("Total a pagar: R$ " + r.calculartotal());
                break;
            }
        }
    }

    public List<quarto> getQuartos() {
        return quartos;
    }

    public List<reserva> getReservas() {
        return reservas;
    }

    public List<cliente> getClientes() {
        return clientes;
    }
}
