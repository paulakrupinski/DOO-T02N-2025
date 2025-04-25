package Aula07;

import java.util.Arrays;

public class Gerente extends Pessoa{
    private String loja;
    private String salarioBase;
    private String[] salarioRecebido = {"5300,00", "5400,00", "5500,00"};

    public Gerente(){

    }

    public Gerente(String nome, int idade, String loja, Endereco endereco, String salarioBase,
                   String[] salarioRecebido) {
        this.setNome(nome);
        this.setIdade(idade);
        this.loja = loja;
        this.setEndereco(endereco);
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public String getNome() {
        return getNome();
    }

    public void setNome(String nome) {
        this.setNome(nome);
    }

    public int getIdade() {
        return getIdade();
    }

    public void setIdade(int idade) {
        this.setIdade(idade);
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(String salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(String[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    public Endereco getEndereco() {
        return getEndereco();
    }

    public void setEndereco(Endereco endereco) {
        this.setEndereco(endereco);
    }

    @Override
    public void apresentarse() {
        System.out.println("Gerente{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", loja='" + loja + '\'' +
                ", salarioBase='" + salarioBase + '\'' +
                ", salarioRecebido=" + Arrays.toString(salarioRecebido) +
                '}');
    }

    //Classe Gerente 👇

    public void calcularMediaGerente(){
        if(this.salarioRecebido.length == 0){
            System.out.println("Nenhum salário registrado");
        }
        double soma = 0;
        for (String salario: this.salarioRecebido){
            soma += Double.parseDouble(salario.replace(",", "."));
        }
        double media = soma / this.salarioRecebido.length;
        System.out.println("Média salarial: " + media);

    }

    public void calcularBonusGerente(){
        double bonus = Double.parseDouble(this.salarioBase.replace(",",".")) * 0.35;
        System.out.println("Cálculo do Bônus: %.2f%n " + bonus);

    }



}
