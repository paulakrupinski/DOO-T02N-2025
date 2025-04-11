package Superclasses;

import Principal.Endereco;

import java.util.List;

public class Funcionario {
    protected String nome;
    protected int idade;
    protected String loja;
    protected Endereco endereco;
    protected double salarioBase;
    protected List <Double> salarioRecebido;

    public Funcionario(String nome, int idade, String loja, Endereco endereco, double salarioBase, List<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public Funcionario(){
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
        idade = idade;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public void apresentar() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Main.Loja: " + this.loja);
        System.out.println("Endereço: " + this.endereco.apresentarLogradouro());
    }

    public void calcularMedia() {
        double soma = 0;

        for (Double iterator : salarioRecebido) {
            soma = soma + iterator;
        }

        double media = soma / salarioRecebido.size();
        System.out.print("A média é: " + media);
    }

    public void calcularBonus() {
        double bonus = this.salarioBase * 0.1;
        System.out.println("Bônus: " + bonus);
    }
}
