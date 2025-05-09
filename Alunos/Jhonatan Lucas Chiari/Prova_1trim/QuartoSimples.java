public class QuartoSimples extends Quarto {

    public QuartoSimples(int numero) {
        super (numero, 100.0, 2); // valores diferenciados entre os tipos de quartos
    }
    @Override
    public String toString() {
        return "Quarto Simples - " + super.toString();
    }
}

