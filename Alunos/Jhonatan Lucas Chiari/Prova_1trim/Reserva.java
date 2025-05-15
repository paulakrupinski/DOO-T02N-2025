public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private String data;
    private int dias;
    private boolean checkIn;
    private boolean checkOut;

    public Reserva(Cliente cliente, Quarto quarto, String data, int dias) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.data = data;
        this.dias = dias;
        this.checkIn = false;
        this.checkOut = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reserva [" + "cliente = " + cliente.getNome() + ", quarto = " + quarto.getNumero() + ", data = '" + data + '\'' + ", dias = " + dias + ", checkIn = " + checkIn + ", checkOut = " + checkOut + ']';
    }
}
