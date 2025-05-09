public class Quarto {
    
    private int numeroQuarto;
    private double precoPorNoite;
    private boolean ocupado;

    public Quarto(int numeroQuarto, double precoPorNoite) {
        this.numeroQuarto = numeroQuarto;
        this.precoPorNoite = precoPorNoite;
        this.ocupado = false;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public boolean isOcupado(){
        return ocupado;
    }

    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }

    public String getTipo(){
        return "Generico";
    }

    
}
