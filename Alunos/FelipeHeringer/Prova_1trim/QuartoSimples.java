package Alunos.FelipeHeringer.Prova_1trim;

public class QuartoSimples extends Quarto {
    private double valorDiaria;
    private int[] capacidadeMaxima;

    public QuartoSimples(int numeroQuarto){
        super(numeroQuarto, 150.0); 
        this.valorDiaria = 150.0;
        this.capacidadeMaxima = new int[2];
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public int[] getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    
    
}
