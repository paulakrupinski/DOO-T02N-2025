package Alunos.FelipeHeringer.Prova_1trim;

public class QuartoDuplo extends Quarto{
    private double valorDiaria;
    private int[] capacidadeMaxima;

    public QuartoDuplo(int numeroQuarto){
        super(numeroQuarto, 400.0); 
        this.valorDiaria = 400.0;
        this.capacidadeMaxima = new int[4];
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public int[] getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    
    
}
