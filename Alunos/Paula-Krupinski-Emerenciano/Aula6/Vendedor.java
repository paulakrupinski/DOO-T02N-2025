public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double[] salariosRecebidos) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = salariosRecebidos;
    }
    public void apresentar() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return soma / salariosRecebidos.length;
    }

    public double calcularBonus() { 
        return salarioBase * 0.2;
    }
}