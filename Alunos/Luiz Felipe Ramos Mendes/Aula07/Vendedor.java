public class Vendedor {
    private String nome;
    private int idade;
    private double salarioBase;

    public Vendedor(String nome, int idade, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

    public double calcularMedia() {
        return salarioBase;
    }

    public double calcularBonus() {
        return salarioBase * 0.10;
    }
}
