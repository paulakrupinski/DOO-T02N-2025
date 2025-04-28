package fag.objeto;

public class QuartoSimples extends Quarto {

    public QuartoSimples(int numero) {
        super(numero, 2, 500.0); 
    }

    @Override
    public String tipo() {
        return "Simples";
    }
}
