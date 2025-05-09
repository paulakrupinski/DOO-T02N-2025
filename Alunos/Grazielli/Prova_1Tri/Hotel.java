import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private static final double PRECO_SIMPLICE = 100.00;
    private static final double PRECO_DUPLO = 150.00;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                quartos.add(new Quarto(i, "duplo"));
            } else {
                quartos.add(new Quarto(i, "simples"));
            }
        }
    }

    public void exibirQuartos() {
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public Quarto buscarQuartoDisponivel(String tipo) {
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel() && quarto.getTipo().equals(tipo)) {
                return quarto;
            }
        }
        return null;
    }

    public boolean realizarCheckIn(Cliente cliente, String tipo, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        Quarto quarto = buscarQuartoDisponivel(tipo);
        if (quarto != null) {
            Reserva reserva = new Reserva(cliente, quarto, dataCheckIn, dataCheckOut);
            reservas.add(reserva);
            quarto.reservar();
            return true;
        }
        return false;
    }

    public boolean fazerReserva(Cliente cliente, String tipo, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        Quarto quarto = buscarQuartoDisponivel(tipo);
        if (quarto != null) {
            Reserva reserva = new Reserva(cliente, quarto, dataCheckIn, dataCheckOut);
            reservas.add(reserva);
            quarto.reservar();
            System.out.println(
                    "Reserva realizada com sucesso para " + cliente.getNome() + " no quarto " + quarto.getNumero());
            return true;
        } else {
            System.out.println("Não há quartos disponíveis do tipo " + tipo + " para reserva.");
            return false;
        }
    }

    public void realizarCheckOut(Cliente cliente) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getCliente().getNome().equals(cliente.getNome())) {
                Quarto quarto = reserva.getQuarto();

                long diasHospedagem = reserva.getDataCheckOut().toEpochDay() - reserva.getDataCheckIn().toEpochDay();

                double precoDiarias = calcularPrecoDiarias(quarto, diasHospedagem);
                quarto.liberar();
                reservas.remove(i);
                System.out.println("Check-out realizado para " + cliente.getNome());
                System.out.println("Total de diárias a pagar: R$ " + precoDiarias);
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    private double calcularPrecoDiarias(Quarto quarto, long diasHospedagem) {
        double precoPorDiaria = quarto.getTipo().equals("simples") ? PRECO_SIMPLICE : PRECO_DUPLO;
        return precoPorDiaria * diasHospedagem;
    }

    public void verificarDisponibilidade(LocalDate data) {
        boolean disponibilidadeEncontrada = false;
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                System.out.println("Quarto " + quarto.getNumero() + " está disponível para a data " + data);
                disponibilidadeEncontrada = true;
            }
        }
        if (!disponibilidadeEncontrada) {
            System.out.println("Nenhum quarto disponível para a data " + data);
        }
    }
}
