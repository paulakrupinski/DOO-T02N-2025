public class QuartoSimples extends Quarto{
    
    public QuartoSimples(int valor){
        super(valor, 100.00);
    }

    @Override
    public String getTipo(){
        return "Quarto simples";
    }
}
