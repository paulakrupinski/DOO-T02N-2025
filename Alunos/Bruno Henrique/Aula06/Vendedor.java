import java.nio.DoubleBuffer;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List <Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase,
                    List<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public Vendedor() {
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(List<Double> salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarse() {
        System.out.println("\nNome: " + this.nome + "\nIdade: " + this.idade + "\nLoja: " + this.loja);
    }

    public void calcularMedia() {
        double soma = 0;

        for (Double iterator : salarioRecebido) {
            soma = soma + iterator;
        }

        double media = soma / salarioRecebido.size();
        System.out.print("\nA média é: \n" + media);
    }

    public void calcularBonus() {
        double bonus = this.salarioBase * 0.2;
        System.out.println("\nBônus: \n" + bonus);
    }
}
