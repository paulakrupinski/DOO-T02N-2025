package domain;

public class Vendedor {
    protected String nome;
    protected int idade;
    protected Loja loja;
    protected Endereco endereco;
    protected double salarioBase;
    protected double[] salarioRecebido = {2000, 2500, 3000};

    public Vendedor(String nome, int idade, double salarioBase, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
    }

    public void apresentarse() {
        System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade + "\nLoja: ");
    }

    public double calcularMedia() {
        double media = 0;
        for (int i = 0; i < salarioRecebido.length; i++) {
            media += salarioRecebido[i];
        }
        return media / salarioRecebido.length;
    }

    public double calcularBonus() {
        return  salarioBase * 0.2;
    }

    public String getNome() {
        return this.nome;
    }
}
