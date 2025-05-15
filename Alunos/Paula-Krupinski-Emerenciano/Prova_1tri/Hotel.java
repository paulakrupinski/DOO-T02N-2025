import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public Quarto getQuartoPorNumero(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) return q;
        }
        return null;
    }

    public void fazerReserva(Cliente cliente, int numeroQuarto, LocalDate entrada, LocalDate saida) {
        Quarto quarto = getQuartoPorNumero(numeroQuarto);
        if (quarto != null && !quarto.isOcupado()) {
            Reserva reserva = new Reserva(cliente, quarto, entrada, saida);
            reservas.add(reserva);
            System.out.println("Reserva realizada com sucesso!");
        } else {
            System.out.println("O quarto não está disponível");
        }
    }

    public List<Reserva> listarReservasPendentes() {
        List<Reserva> pendentes = new ArrayList<>();
        for (Reserva r : reservas) {
            if (!r.getQuarto().isOcupado()) {
                pendentes.add(r);
            }
        }
        return pendentes;
    }

    public void realizarCheckIn(Reserva reserva) {
        Quarto quarto = reserva.getQuarto();
        if (!quarto.isOcupado()) {
            quarto.ocupar();
            System.out.println("Check-in realizado no quarto " + quarto.getNumero());
        } else {
            System.out.println("Quarto já está ocupado.");
        }
    }

    public void realizarCheckOut(int numero) {
        Quarto q = getQuartoPorNumero(numero);
        if (q != null && q.isOcupado()) {
            q.desocupar();
            System.out.println("Check-out realizado.");
        } else {
            System.out.println("Quarto não está ocupado.");
        }
    }

    public void calcularDiarias(int numeroQuarto) {
        for (Reserva r : reservas) {
            if (r.getQuarto().getNumero() == numeroQuarto) {
            
                long dias = r.getDataEntrada().until(r.getDataSaida()).getDays();
                double preco = r.getQuarto().calcularPrecoDiaria();
                double total = dias * preco;
                System.out.println("Total a pagar: R$" + total);
                return;
            }
        }
        System.out.println("Reserva não encontrada para esse quarto.");
    }

    public void verificarDisponibilidade(int numero, LocalDate data) {
        Quarto q = getQuartoPorNumero(numero);
        if (q == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        if (q.isOcupado()) {
            System.out.println("Quarto está ocupado nesta data.");
        } else {
            System.out.println("Quarto disponível.");
        }
    }
}
