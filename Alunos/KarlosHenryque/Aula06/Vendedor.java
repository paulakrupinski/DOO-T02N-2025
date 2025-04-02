public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
<<<<<<< HEAD

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
=======
    private double[] salarioRecebido = new double[3];

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double[] salarioRecebido) {
>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
<<<<<<< HEAD
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
        System.out.println("Salario Base: R$ " + salarioBase);
    }
=======
        System.arraycopy(salarioRecebido, 0, this.salarioRecebido, 0, salarioRecebido.length);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getLoja() { return loja; }
    public double getSalarioBase() { return salarioBase; }
>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
}
