import java.time.LocalDate;

public class Reserva {
    
    private Clientes clientes;
    private Quarto quartos;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(Clientes clientes, Quarto quartos, LocalDate dataEntrada, LocalDate dataSaida) {
        this.clientes = clientes;
        this.quartos = quartos;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public Quarto getQuartos() {
        return quartos;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public int calcularDiaria(){
        return dataSaida.getDayOfYear() - dataEntrada.getDayOfYear();
    }

    public double calcularTotal(){
        return calcularDiaria() * quartos.getPrecoPorNoite();
    }

    
}
