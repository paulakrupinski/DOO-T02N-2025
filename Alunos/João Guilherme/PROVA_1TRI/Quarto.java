package PROVA_1TRI;

public class Quarto {
    private int numero;
    private int tipo;
    private double preco;
    private boolean disponibilidade;

    public Quarto(int numero, int tipo, boolean disponibilidade) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;

        if (tipo == 1) {
            this.preco = 80.00;
        } else if (tipo == 2) {
            this.preco = 200.00;
        } else {
            this.preco = 0.0;
        }
    }

    public int getNumero() {
        return numero;
    }

    public int getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponivel(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void quartoInfo() {
        String tipoTexto = (tipo == 1) ? "Simples" : "Duplo";
        System.out.println("Quarto " + numero + " - Tipo: " + tipoTexto + " - Preço: R$" + preco + " - " + 
            (disponibilidade ? "Disponível" : "Ocupado"));
    }

    public String toString() {
        return "Quarto " + numero + " (Tipo: " + tipo + ", Preço: R$" + preco + ")";
    }
}