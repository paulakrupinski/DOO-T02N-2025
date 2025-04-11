
import java.util.ArrayList;

public class Funcionario {
    
    private String nome;
    private int idade;
    private String loja;
    private Double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Funcionario(String nome, int idade, String loja, Double salarioBase, ArrayList<Double> salarioRecebido) {

        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public ArrayList<Double> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(ArrayList<Double> salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public double calcularMedia() {
        return 0; 
    }

    public double calcularBonus(Double valor){
        return 0;
    }

    public void apresentarse(){
        System.out.println("FUNCIONARIO");
        System.out.println("------------------");
        System.out.println("Nome "+ nome);
        System.out.println("Idade "+ idade);
        System.out.println("Loja "+ loja);
        System.out.println("------------------ \n");
    }
}