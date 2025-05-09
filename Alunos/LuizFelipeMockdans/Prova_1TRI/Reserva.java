import java.time.LocalDate;

public class Reserva {
    private static int nextNumero = 1;
    private int numero;
    private Quarto quarto;
    private Cliente cliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int numHospedes;
    private boolean checkinRealizado;
    private boolean checkoutRealizado;
    
    public Reserva(Quarto quarto, Cliente cliente, LocalDate dataEntrada, 
                  LocalDate dataSaida, int numHospedes) {
        this.numero = nextNumero++;
        this.quarto = quarto;
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.numHospedes = numHospedes;
        this.checkinRealizado = false;
        this.checkoutRealizado = false;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public Quarto getQuarto() {
        return quarto;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    
    public int getNumHospedes() {
        return numHospedes;
    }
    
    public boolean isCheckinRealizado() {
        return checkinRealizado;
    }
    
    public void setCheckinRealizado(boolean checkinRealizado) {
        this.checkinRealizado = checkinRealizado;
    }
    
    public boolean isCheckoutRealizado() {
        return checkoutRealizado;
    }
    
    public void setCheckoutRealizado(boolean checkoutRealizado) {
        this.checkoutRealizado = checkoutRealizado;
    }
}