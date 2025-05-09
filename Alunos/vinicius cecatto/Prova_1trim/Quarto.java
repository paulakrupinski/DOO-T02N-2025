package Prova_1trim;

public class Quarto {
    int numero;
    double precoDiaria;
    String tipo;
    boolean disponivel;

    public Quarto(int numero, double precoDiaria, String tipo) {
        this.numero = numero;
        this.precoDiaria = precoDiaria;
        this.tipo = tipo;
        this.disponivel = true;
    }

    public int getMaxPessoas() {
        if (tipo.equals("simples")) {
            return 2;
        } else if (tipo.equals("duplo")) {
            return 4;
        }
        return 0;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}