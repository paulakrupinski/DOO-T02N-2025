import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente adicionado: " + cliente.getNome());
    }

    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente c : clientes) {
            if (c.getDocumento().equalsIgnoreCase(documento)) {
                return c;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
        System.out.println("Quarto adicionado: " + quarto);
    }

    public void listarQuartos() {
        for (Quarto q : quartos) {
            System.out.println(q);
        }
    }

    public Quarto buscarQuartoDisponivelPorData(String data) {
        for (Quarto q : quartos) {
            boolean reservado = false;
            for (Reserva r : reservas) {
                if (r.getData().equals(data) && r.getQuarto().getNumero() == q.getNumero()) {
                    reservado = true;
                    break;
                }
            }
            if (!reservado && !q.isOcupado()) {
                return q;
            }
        }
        return null;
    }

    public void reservarQuarto(Cliente cliente, Quarto quarto, String data, int dias) {
        Reserva novaReserva = new Reserva(cliente, quarto, data, dias);
        reservas.add(novaReserva);
        System.out.println("Reserva para o cliente " + cliente.getNome() + " no quarto " + quarto.getNumero() + " para o dia " + data);
    }

    public void checkIn(String documento, String data) {
        for (Reserva r : reservas) {
            if (r.getCliente().getDocumento().equalsIgnoreCase(documento) && r.getData().equals(data)) {
                r.getQuarto().ocupar();
                r.setCheckIn(true);
                System.out.println("Check-in realizado para " + r.getCliente().getNome());
                return;
            }
        }
        System.out.println("Reserva não localizada.");
    }

    public Quarto buscarQuartoDisponivelPorTipoEData(int tipo, String data) {
        for (Quarto q : quartos) {
            boolean reservado = false;
    
            if ((tipo == 1 && q instanceof QuartoSimples) ||
                (tipo == 2 && q instanceof QuartoDuplo)) {
    
                for (Reserva r : reservas) {
                    if (r.getData().equals(data) && r.getQuarto().getNumero() == q.getNumero()) {
                        reservado = true;
                        break;
                    }
                }
    
                if (!reservado && !q.isOcupado()) {
                    return q;
                }
            }
        }
        return null;
    }
    
    public void checkOut(String documento, String data) {
        for (Reserva r : reservas) {
            if (r.getCliente().getDocumento().equalsIgnoreCase(documento) && r.getData().equals(data) && r.isCheckIn()) {
                r.getQuarto().desocupar();
                r.setCheckOut(true);
                double total = r.getQuarto().getPrecoPorNoite() * r.getDias();
                System.out.println("Check-out realizado. Total: R$" + total);
                return;
            }
        }
        System.out.println("Reserva ativa não encontrada.");
    }

    public void listarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
}
