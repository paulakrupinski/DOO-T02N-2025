import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void cadastrarQuartoSimples(int numero) {
        quartos.add(new QuartoSimples(numero));
    }

    public void cadastrarQuartoDuplo(int numero) {
        quartos.add(new QuartoDuplo(numero));
    }

    public Quarto buscarQuarto(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCPF(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCPF().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public boolean reservarQuarto(String cpf, int numero, LocalDate entrada, LocalDate saida) {
        Cliente cliente = buscarClientePorCPF(cpf);
        Quarto quarto = buscarQuarto(numero);

        if (cliente == null || quarto == null) return false;

        for (Reserva r : reservas) {
            if (r.getQuarto().getNumero() == numero && !(saida.isBefore(r.getDataEntrada()) || entrada.isAfter(r.getDataSaida()))) {
                return false; // conflito de datas
            }
        }

        reservas.add(new Reserva(cliente, quarto, entrada, saida));
        return true;
    }

    public void listarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public void verificarDisponibilidade(int numero, LocalDate data) {
        Quarto quarto = buscarQuarto(numero);
        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        for (Reserva r : reservas) {
            if (r.getQuarto().getNumero() == numero && !r.isDisponivel(data)) {
                System.out.println("Quarto " + numero + " está ocupado na data " + data);
                return;
            }
        }
        System.out.println("Quarto " + numero + " está disponível na data " + data);
    }
}
