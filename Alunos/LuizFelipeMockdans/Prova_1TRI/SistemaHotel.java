import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class SistemaHotel {
    private List<Cliente> clientes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    
    public SistemaHotel() {
        this.clientes = new ArrayList<>();
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        inicializarQuartos();
    }
    
    private void inicializarQuartos() {
        
        for (int i = 1; i <= 10; i++) {
            quartos.add(new Quarto(i, "Simples", 2, 100.0));
        }
        
        for (int i = 11; i <= 20; i++) {
            quartos.add(new Quarto(i, "Duplo", 4, 180.0));
        }
    }
    
    public void cadastrarCliente(String nome, String cpf, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, telefone);
        clientes.add(cliente);
    }
    
    public Reserva reservarQuarto(int numeroQuarto, String cpfCliente, 
                                LocalDate dataEntrada, LocalDate dataSaida, 
                                int numHospedes) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        Cliente cliente = buscarClientePorCPF(cpfCliente);
        
        if (quarto == null || cliente == null) {
            return null;
        }
        
        if (numHospedes > quarto.getCapacidade()) {
            System.out.println("Número de hóspedes excede a capacidade do quarto.");
            return null;
        }
        
        if (!verificarDisponibilidadeQuarto(numeroQuarto, dataEntrada, dataSaida)) {
            System.out.println("Quarto não disponível para as datas selecionadas.");
            return null;
        }
        
        Reserva reserva = new Reserva(quarto, cliente, dataEntrada, dataSaida, numHospedes);
        reservas.add(reserva);
        return reserva;
    }
    
    public boolean realizarCheckin(int numeroReserva) {
        Reserva reserva = buscarReservaPorNumero(numeroReserva);
        if (reserva != null && !reserva.isCheckinRealizado()) {
            reserva.setCheckinRealizado(true);
            return true;
        }
        return false;
    }
    
    public double realizarCheckout(int numeroReserva) {
        Reserva reserva = buscarReservaPorNumero(numeroReserva);
        if (reserva != null && reserva.isCheckinRealizado() && !reserva.isCheckoutRealizado()) {
            reserva.setCheckoutRealizado(true);
            return calcularTotalDiarias(reserva);
        }
        return -1;
    }
    
    public double calcularTotalDiarias(Reserva reserva) {
        long dias = ChronoUnit.DAYS.between(reserva.getDataEntrada(), reserva.getDataSaida());
        return dias * reserva.getQuarto().getPrecoPorNoite();
    }
    
    public boolean verificarDisponibilidadeQuarto(int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                if (dataEntrada.isBefore(reserva.getDataSaida()) && 
                    dataSaida.isAfter(reserva.getDataEntrada())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }
    
    private Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    
    private Reserva buscarReservaPorNumero(int numero) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumero() == numero) {
                return reserva;
            }
        }
        return null;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public List<Quarto> getQuartos() {
        return quartos;
    }
    
    public List<Reserva> getReservas() {
        return reservas;
    }
}