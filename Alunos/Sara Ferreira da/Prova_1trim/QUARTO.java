public abstract class QUARTO{
    protected int numero;
    protected double precoDiaria;
    protected boolean ocupado;

    public abstract int getCapacidade();
    public boolean isDisponivel() { 
        return !ocupado; 
    }
}
