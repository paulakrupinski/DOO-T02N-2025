package myplant;

public abstract class Funcionario {
    protected String nome;
    protected int idade;
    protected String loja;
    protected Endereco endereco;
    protected double salarioBase;
    protected double[] salarioRecebido;
    
    public Funcionario(String nome, int idade, String loja, Endereco endereco, 
                         double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }
    
    public void apresentarse() {
        System.out.printf("Nome = %s | Idade = %d | Loja = %s%n", nome, idade, loja);
    }
    
    public double calcularMedia() {
        double soma = 0;
        for (double s : salarioRecebido) {
            soma += s;
        }
        return soma / salarioRecebido.length;
    }
    
    // O cálculo do bônus depende do tipo de funcionário
    public abstract double calcularBonus();
}
