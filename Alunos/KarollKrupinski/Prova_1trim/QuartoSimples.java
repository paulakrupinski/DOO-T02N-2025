public class QuartoSimples extends Quarto {
    public QuartoSimples(int numero) {
        super(numero, 100.0, 2); // Ex: R$100/noite
    }

    @Override
    public String getTipo() {
        return "Simples";
    }
}
