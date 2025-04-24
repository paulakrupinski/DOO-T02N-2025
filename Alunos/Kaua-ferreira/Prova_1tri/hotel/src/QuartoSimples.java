public class QuartoSimples extends Quarto {
    public QuartoSimples(int numero) {
        super(numero, 100.0);
    }

    @Override
    public int getCapacidade() {
        return 2;
    }
}
