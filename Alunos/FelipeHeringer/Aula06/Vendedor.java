package Alunos.FelipeHeringer.Aula06;

import java.util.ArrayList;

public class Vendedor {
    private String nome;
    private Integer idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private Double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Vendedor() {
        salarioRecebido = new ArrayList<>();
        salarioRecebido.add(1500.0);
        salarioRecebido.add(1750.0);
        salarioRecebido.add(2000.0);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja.getNomeFantasia());
    }
    
    public Double calcularMediaSalarios() {
        Double soma = 0.0;
        for (Double salario : salarioRecebido) {
            soma += salario;
        }

        return soma / salarioRecebido.size();
    }

    public void calcularBonusSalario () {
        Double bonus = 0.2;

        Double salarioComBonus = salarioBase + (salarioBase * bonus);

        salarioRecebido.add(salarioComBonus);

        System.out.println("O salario este mês de " + nome + " com o bônus foi de: " + salarioComBonus);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
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

    
}
