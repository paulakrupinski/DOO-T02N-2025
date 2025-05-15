package sistemahotel;

public class Quarto {
    private int numero;
    private String tipo;
    private double capacidade;
    private boolean disponivel;
    
    public Quarto(int numero, String tipo, double capacidade, 
            boolean disponivel){
    
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        
        if(this.tipo.equals("simples")){
            this.capacidade = 2;
        } else {
        
            this.capacidade = 4;}
    }
    
    public double getValorDiaria(){
        if(tipo.equals("simples")){
            return 50.0;
        } else {
            return 100.0;
        }
    }
    
    public double getCapacidade(){
        return capacidade;
    }
    
    public boolean isDisponivel(){
        return disponivel;
    }
    
    public void Reservar(){
        disponivel = false;
    }
    
    public void Liberar(){
        disponivel = true;
    }   
}
