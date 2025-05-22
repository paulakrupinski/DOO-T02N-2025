public class QuartoDuplo extends Quarto{
    private int capacidade;

    public QuartoDuplo(String numero, int valorDiaria, int capacidade) {
        super(numero, valorDiaria);
        this.capacidade = capacidade;
    }

    public QuartoDuplo(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
