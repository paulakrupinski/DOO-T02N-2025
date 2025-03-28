/*1. Crie uma classe Vendedor com:
- Com os atributos nome, idade, Loja, cidade, bairro, rua, salarioBase e salarioRecebido.
- Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.(Pode colocar no código os valores*)
- Métodos apresentarse calcularMedia e calcularBonus.
- Método apresentarse deve printar o nome, idade e Loja.
- calcularMedia deve trazer a média dos salários.
- calcularBonus onde a formulá é [salarioBase * 0.2]*/

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;
    private Double salarioBase;
    private List<Double> salarioRecebido;
    private Loja loja;

    public Vendedor() {
        salarioRecebido = new ArrayList<Double>();
        salarioBase = 1500.00;
        for(int i = 0; i <= 3; i++) {
            salarioRecebido.add(1500.00);
        }
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja.getNomeFantasia());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void calcularMedia() {
        Double total = 0.0;
        for(int i = 0; i < salarioRecebido.size(); i++) {
            total += salarioRecebido.get(i);
        }

        System.out.println("Media: " + total / salarioRecebido.size());
    }

    public void calcularBonus() {
        Double bonus = 0.2;

        salarioRecebido.add(salarioBase + (salarioBase * bonus));

        System.out.println("Salario recebido: " + salarioRecebido.get(salarioRecebido.size() - 1));
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

    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(List<Double> salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
