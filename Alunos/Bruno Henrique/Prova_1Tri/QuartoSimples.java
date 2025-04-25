public class QuartoSimples extends Quarto{
    private int capacidade;

    public QuartoSimples(String numero, int valorDiaria, int capacidade) {
        super(numero, valorDiaria);
        this.capacidade = capacidade;
    }

    public QuartoSimples(int capacidade) {
        this.capacidade = capacidade;
    }

    public QuartoSimples() {
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
