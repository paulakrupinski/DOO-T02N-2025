public class QuartoDuplo extends Quarto {
    public QuartoDuplo(int numero) {
        super(numero, 180.0, 4); // Ex: R$180/noite
    }

    @Override
    public String getTipo() {
        return "Duplo";
    }
}
