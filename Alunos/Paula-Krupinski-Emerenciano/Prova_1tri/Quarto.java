public class Quarto {
    private int numero;
    private boolean ocupado;
    private String tipo; 
    private int capacidade; 

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        if (tipo.equalsIgnoreCase("duplo")) {
            this.capacidade = 4; 
        } else {
            this.capacidade = 2;
        }
        this.ocupado = false; 
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public void desocupar() {
        this.ocupado = false;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double calcularPrecoDiaria() {
        if (tipo.equalsIgnoreCase("duplo")) {
            return 170.0;  
        } else {
            return 120.0; 
        }
    }
}
