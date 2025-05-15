package fag.objeto;

public class QuartoDuplo extends Quarto {

    public QuartoDuplo(int numero) {
        super(numero, 4, 700.0); 
    }

    @Override
    public String tipo() {
        return "Duplo";
    }
}
