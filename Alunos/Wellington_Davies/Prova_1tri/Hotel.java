import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    
    private ArrayList<Clientes> clientes = new ArrayList<>();
    private ArrayList<Quarto> quartos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Hotel() {
        this.clientes = clientes;
        this.quartos = quartos;
        this.reservas = reservas;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(ArrayList<Quarto> quartos) {
        this.quartos = quartos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Clientes(nome, cpf));
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public Reserva reservarQuarto(Clientes cliente, int numeroQuarto, LocalDate entrada, LocalDate saida) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        Reserva reserva = new Reserva(cliente, quarto, entrada, saida);
        quarto.setOcupado(true);
        reservas.add(reserva);
        return reserva;
    }

    public void checkOut(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                reserva.getQuarto().setOcupado(false);
                System.out.println("Total a ser pago:" + reserva.calcularTotal());
                return;
            }
        }
    }

    public Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    public void verificarDisponibilidade(LocalDate data) {
        for (Quarto quarto : quartos) {
            if (quarto.isOcupado() == false) {
                System.out.println("O quarto esta disponivel: " + quarto.getNumero());
            }
        }
    }

    public Clientes buscarCliente(String cpf) {
        for (Clientes clientes : clientes) {
            if (clientes.getCpf().equals(cpf)) {
                return clientes;
            }
        }
        return null;
    }
}
