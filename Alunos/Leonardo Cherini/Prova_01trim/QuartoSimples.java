package provaBum;

class QuartoSimples extends Quarto {
    public QuartoSimples(int numero) {
        super(numero, 100.00);
    }

    @Override
    public boolean capacidadeExcedida(int pessoas) {
        return pessoas > 2;
    }
}