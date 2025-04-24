import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void cadastrarCliente(String nome, String documento) {
        clientes.add(new Cliente(nome, documento));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarQuartoSimples(int numero) {
        quartos.add(new QuartoSimples(numero));
        System.out.println("Quarto simples cadastrado com sucesso!");
    }

    public void cadastrarQuartoDuplo(int numero) {
        quartos.add(new QuartoDuplo(numero));
        System.out.println("Quarto duplo cadastrado com sucesso!");
    }

    public Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }

    public void fazerReserva(String documentoCliente, int numeroQuarto, LocalDate entrada, LocalDate saida) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(documentoCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto == null) {
            System.out.println("Quarto não encontrado.");
            return;
        }

        if (!verificarDisponibilidade(quarto, entrada, saida)) {
            System.out.println("Quarto indisponível neste período.");
            return;
        }

        reservas.add(new Reserva(cliente, quarto, entrada, saida));
        System.out.println("Reserva realizada com sucesso!");
    }

    public boolean verificarDisponibilidade(Quarto quarto, LocalDate entrada, LocalDate saida) {
        for (Reserva r : reservas) {
            if (r.getQuarto().equals(quarto)) {
                if (!(saida.isBefore(r.getDataEntrada()) || entrada.isAfter(r.getDataSaida().minusDays(1)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void listarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }public void listarQuartosDisponiveis(LocalDate entrada, LocalDate saida) {
        System.out.println("Quartos disponíveis de " + entrada + " até " + saida + ":");
        boolean encontrou = false;
        for (Quarto q : quartos) {
            if (verificarDisponibilidade(q, entrada, saida)) {
                System.out.println(" - " + q);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum quarto disponível nesse período.");
        }
    }
    
}
