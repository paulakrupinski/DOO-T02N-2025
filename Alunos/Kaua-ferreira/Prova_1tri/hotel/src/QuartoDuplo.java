public class QuartoDuplo extends Quarto {
    public QuartoDuplo(int numero) {
        super(numero, 180.0);
    }

    @Override
    public int getCapacidade() {
        return 4;
    }
}
