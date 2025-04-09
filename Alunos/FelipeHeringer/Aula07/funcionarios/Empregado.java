package Alunos.FelipeHeringer.Aula07.funcionarios;

import java.util.ArrayList;

import Alunos.FelipeHeringer.Aula07.Endereco;
import Alunos.FelipeHeringer.Aula07.Loja;

public class Empregado {
    protected String nome;
    protected Integer idade;
    protected Loja loja;
    protected Endereco endereco;
    protected Double bonus;
    protected Double salarioBase;
    protected ArrayList<Double> salarioRecebido;

    
    public Empregado(String nome, Integer idade, Loja loja, Endereco endereco, Double salarioBase,
        ArrayList<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.bonus = 0.0;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
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
        Double salarioComBonus = salarioBase + (salarioBase * this.bonus);

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
