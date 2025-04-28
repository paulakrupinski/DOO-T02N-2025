
public class Quarto {
    private int num;
    private int capacidade;
    private double valorDiaria;
    private boolean ocupado;

    public Quarto(int num, int capacidade, double valorDiaria) {
        this.num = num;
        this.capacidade = capacidade;
        this.valorDiaria = valorDiaria;
        this.ocupado = false;
    }

    public int getNum() {
        return num;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Quarto " + num + " | Capacidade: " + capacidade + " | Valor: R$" + valorDiaria + " | Ocupado: " + ocupado;
    }
}
