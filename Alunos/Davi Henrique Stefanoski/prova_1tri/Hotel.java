package pacote;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {

    private List<Cliente> clientes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        clientes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void realizarCheckIn(int idReserva) {
        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva != null) {
            reserva.realizarCheckIn();
        }
    }

    public void realizarCheckOut(int idReserva) {
        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva != null) {
            reserva.realizarCheckOut();
        }
    }

    public List<Quarto> listarQuartosDisponiveis(Date data) {
        List<Quarto> disponiveis = new ArrayList<>();

        for (Quarto q : quartos) {
            if (verificarDisponibilidade(q, data)) {
                disponiveis.add(q);
            }
        }

        return disponiveis;
    }

    public boolean verificarDisponibilidade(Quarto quarto, Date data) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().equals(quarto)) {
                if (!data.before(reserva.getDataInicio()) && !data.after(reserva.getDataFim())) {
                    return false; 
                }
            }
        }
        return true;
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
    Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
          }
		return null;
        }
    
    Quarto buscarQuartoPorNumero(int num) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == num) {
                return quarto;
            }
        }
		return null;
      }

    private Reserva buscarReservaPorId(int id) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }
}
