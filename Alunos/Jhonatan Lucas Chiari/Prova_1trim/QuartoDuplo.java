public class QuartoDuplo extends Quarto {

    public QuartoDuplo(int numero) {
        super (numero, 200.0, 4); // valores e capacidade diferenciados entre os tipos de quartos
    }
    @Override
    public String toString() {
        return "Quarto Duplo - " + super.toString();
    }
}

