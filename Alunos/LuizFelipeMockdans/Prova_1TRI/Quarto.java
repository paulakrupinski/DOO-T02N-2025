    public class Quarto {
    private int numero;
    private String tipo;
    private int capacidade;
    private double precoPorNoite;
    
    public Quarto(int numero, String tipo, int capacidade, double precoPorNoite) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.precoPorNoite = precoPorNoite;
    }
    
    // Getters
    public int getNumero() {
        return numero;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public int getCapacidade() {
        return capacidade;
    }
    
    public double getPrecoPorNoite() {
        return precoPorNoite;
    }
}