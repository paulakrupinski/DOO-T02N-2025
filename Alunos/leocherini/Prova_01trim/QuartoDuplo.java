package provaBum;

class QuartoDuplo extends Quarto {
    public QuartoDuplo(int numero) {
        super(numero, 200.00);
    }

    @Override
    public boolean capacidadeExcedida(int pessoas) {
        return pessoas > 4;
    }
}