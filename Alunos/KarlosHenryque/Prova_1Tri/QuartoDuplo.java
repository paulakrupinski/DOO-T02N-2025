public class QuartoDuplo extends Quarto{
    
    public QuartoDuplo(int valor){
        super(valor, 200.00);
    }

    @Override
    public String getTipo(){
        return "Quarto duplo";
    }
}
