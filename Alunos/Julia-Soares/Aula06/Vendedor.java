public class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salarioRecebido = {2000.00, 2500.00, 3000.00}; // Valores de exemplo

    // Métodos set e get
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    // Método para apresentar o vendedor
    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + (loja != null ? loja.getNomeFantasia() : "Sem loja associada"));
    }

    // Método para calcular a média dos salários
    public void calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        double media = soma / salarioRecebido.length;
        System.out.println("Média dos salários: " + media);
    }

    // Método para calcular o bônus
    public void calcularBonus() {
        double bonus = salarioBase * 0.2;
        System.out.println("Bônus: " + bonus);
    }
}
