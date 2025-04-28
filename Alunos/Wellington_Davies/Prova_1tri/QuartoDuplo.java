public class QuartoDuplo extends Quarto {

    public QuartoDuplo(int numero) {
        super(numero);
    }

    @Override
    public double getPrecoDiaria() {
        return 150.0;
    }

    @Override
    public int getCapacidade() {
        return 4;
    }
}
