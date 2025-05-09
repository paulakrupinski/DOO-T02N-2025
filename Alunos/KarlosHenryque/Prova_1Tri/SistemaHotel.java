import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SistemaHotel {
    private List<Clientes> clientes = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void cadastrarCliente(String nome, int cpf) {
        clientes.add(new Clientes(nome, cpf));
    }

    public void cadastrarQuarto(int numero, boolean isDuplo) {
        Quarto quarto = isDuplo ? new QuartoDuplo(numero) : new QuartoSimples(numero);
        quartos.add(quarto);
    }

    public boolean reservarQuarto(String cpfCliente, int numeroQuarto, LocalDate entrada, LocalDate saida) {
        Clientes cliente = buscarCliente(cpfCliente);
        Quarto quarto = buscarQuarto(numeroQuarto);

        if (cliente != null && quarto != null && !quarto.isOcupado()) {
            reservas.add(new Reserva(cliente, quarto, entrada, saida));
            return true;
        }
        return false;
    }

    public boolean realizarCheckIn(int numeroQuarto) {
        for (Reserva r : reservas) {
            if (r.getQuartos().getNumeroQuarto() == numeroQuarto && !r.getQuartos().isOcupado()) {
                r.getQuartos().setOcupado(true);
                return true;
            }
        }
        return false;
    }

    public boolean realizarCheckOut(int numeroQuarto) {
        for (Reserva r : reservas) {
            if (r.getQuartos().getNumeroQuarto() == numeroQuarto && r.getQuartos().isOcupado()) {
                r.getQuartos().setOcupado(false);
                return true;
            }
        }
        return false;
    }

    public void exibirReservas() {
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getClientes().getNome() +
                    ", Quarto: " + reserva.getQuartos().getNumeroQuarto() + " (" + reserva.getQuartos().getTipo() +
                    "), Entrada: " + reserva.getDataEntrada().format(formatarData) + ", Saída: " + reserva.getDataSaida().format(formatarData) +
                    ", Total: R$" + reserva.calcularTotal());
        }
    }

    public void exibirStatusQuartos() {
        System.out.println("--- Quartos Ocupados ---");
        for (Quarto quarto : quartos) {
            if (quarto.isOcupado()) {
                System.out.println("Quarto " + quarto.getNumeroQuarto() + " (" + quarto.getTipo() + ")");
            }
        }
        System.out.println("--- Quartos Desocupados ---");
        for (Quarto quarto : quartos) {
            if (!quarto.isOcupado()) {
                System.out.println("Quarto " + quarto.getNumeroQuarto() + " (" + quarto.getTipo() + ")");
            }
        }
    }

    private Clientes buscarCliente(String cpfCliente) {
        for (Clientes cliente : clientes) {
            if (String.valueOf(cliente.getCpf()).equals(cpfCliente)) {
                return cliente;
            }
        }
        return null;
    }

    private Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numero) {
                return quarto;
            }
        }
        return null;
    }
} 
