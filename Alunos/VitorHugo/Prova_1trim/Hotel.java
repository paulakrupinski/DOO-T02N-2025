package Prova_1trim;

import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public Reserva reservarQuarto(String cpf, int numeroQuarto, LocalDate entrada, LocalDate saida) {
        Cliente cliente = buscarClientePorCpf(cpf);
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (cliente != null && quarto != null && !quarto.isOcupado()) {
            Reserva reserva = new Reserva(cliente, quarto, entrada, saida);
            reservas.add(reserva);
            quarto.setOcupado(true);
            return reserva;
        }
        return null;
    }

    public double realizarCheckout(String cpf) {
        for (Reserva r : reservas) {
            if (r.getCliente().getCpf().equals(cpf) && r.getQuarto().isOcupado()) {
                r.getQuarto().setOcupado(false);
                return r.calcularTotal();
            }
        }
        return 0;
    }

    public boolean verificarDisponibilidade(int numeroQuarto, LocalDate data) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto == null || quarto.isOcupado()) return false;
        for (Reserva r : reservas) {
            if (r.getQuarto().getNumero() == numeroQuarto && !data.isBefore(r.getDataEntrada()) && !data.isAfter(r.getDataSaida())) {
                return false;
            }
        }
        return true;
    }

    private Cliente buscarClientePorCpf(String cpf) {
        return clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    private Quarto buscarQuartoPorNumero(int numero) {
        return quartos.stream().filter(q -> q.getNumero() == numero).findFirst().orElse(null);
    }
}
