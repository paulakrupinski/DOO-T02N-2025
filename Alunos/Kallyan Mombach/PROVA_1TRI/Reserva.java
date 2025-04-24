
public class Reserva {
    private Quarto quarto;
    private Cliente cliente;
    private int dataIn;
    private int dataOut;
    private Double valor;

    public Reserva(Quarto quarto, Cliente cliente, int dataIn, int dataOut, Double valor) {
        this.quarto = quarto;
        this.cliente = cliente;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        calcularValortotal();
    }
    

    public Quarto getQuarto() {
        return quarto;
    }


    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public int getDataIn() {
        return dataIn;
    }


    public void setDataIn(int dataIn) {
        this.dataIn = dataIn;
    }


    public int getDataOut() {
        return dataOut;
    }


    public void setDataOut(int dataOut) {
        this.dataOut = dataOut;
    }


    public Double getValor() {
        return valor;
    }


    public void setValor(Double valor) {
        this.valor = valor;
    }


    private void calcularValortotal(){
       int dias = dataOut - dataIn;
       this.valor = dias *  quarto.getValorDiaria();

    }


    @Override
    public String toString() {
        return "Reserva [quarto=" + quarto + ", cliente=" + cliente + ", dataIn=" + dataIn + ", dataOut=" + dataOut
                + ", valor=" + valor + "]";
    }

    


    
}
