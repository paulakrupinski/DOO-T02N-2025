import java.util.ArrayList;
import java.util.Arrays;

public class Vendedor {
    
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, Double salarioBase,
            ArrayList salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
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
        double soma = 0.0;
        for (Double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size(); // Média dos salários
    }

    public double calcularBonus(Double valor){
        return valor + valor*0.2;
    }

    public void apresentarse(){
        System.out.println("VENDEDOR");
        System.out.println("------------------");
        System.out.println("Nome "+ nome);
        System.out.println("Idade "+ idade);
        System.out.println("Loja "+ loja);
        System.out.println("------------------ \n");
    }
}
