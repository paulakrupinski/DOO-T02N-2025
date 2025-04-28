package sistemahotel;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private String dataCheckIn;
    private String dataCheckOut;
    private double totalDiarias;
    
    public Reserva(Cliente cliente, Quarto quarto, String dataCheckIn, 
            String dataCheckOut, double totalDiarias){
    
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.totalDiarias = totalDiarias;
    }
    
    public double calcularDiarias(){
        return cliente.quantidadeDias * totalDiarias;
    }
    
    public void getTotal(){
        System.out.println("Total a pagar: " + calcularDiarias());
    }
    
    public boolean verificarDisponibilidade(String dataCheckIn, 
            String dataCheckOut) {
    return this.quarto.isDisponivel();
}

}
