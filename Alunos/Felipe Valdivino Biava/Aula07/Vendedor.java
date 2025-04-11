package Aula07;

import java.util.Arrays;

public class Vendedor extends Pessoa{

    private String Loja;
    private Endereco endereco;
    private String salarioBase;
    private String[] salarioRecebido;

    public Vendedor() {

    }

    public Vendedor(String nome, int idade, String loja, Endereco endereco, String salarioBase, String[] salarioRecebido) {
        this.setNome(nome);
        this.setIdade(idade);
        this.Loja = loja;
        this.endereco = endereco; //aqui não está dando erro igual as outras pessoas do código, vou deixar assim msm!
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public Vendedor(String carlos, int i, String lojaA, String cidadeA, String bairroX, String s, String s1, String[] strings) {
    }

    public String getLoja() {
        return Loja;
    }

    public void setLoja(String loja) {
        Loja = loja;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome); // Corrigido: agora usa o método da superclasse, evitando recursão infinita
    }

    @Override
    public int getIdade() {
        return super.getIdade();
    }

    @Override
    public void setIdade(int idade) {
        super.setIdade(idade);
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    //Classe Vendedor 👇

    public void calcularMediaVendedor() {
        if (this.getSalarioRecebido().length == 0) {
            System.out.println("Nenhum salário registrado.");
            return;
        }

        double soma = 0;
        for (String salario : this.getSalarioRecebido()) {
            soma += Double.parseDouble(salario.replace(",", "."));
        }

        double media = soma / this.getSalarioRecebido().length;
        System.out.println("Média salarial: " + media);
    }

    public void calcularBonusVendedor() {
        double bonus = Double.parseDouble(this.getSalarioBase().replace(",",".")) * 0.2;
        System.out.println("Cálculo do Bônus: %.2f%n " + bonus);
    }

    public void apresentarVendedor() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Loja: " + this.getLoja());
    }


    public void setSalarioBase(String s, String s1, String s2) {
    }

    public void setSalarioRecebido(String s, String s1, String s2) {
    }

    @Override
    public void apresentarse() {
        System.out.println("Vendedor = [" +
                "nome: '" + getNome() + '\'' +
                ", idade: " + getIdade() +
                ", Loja: '" + Loja +
                ", salarioBase: '" + salarioBase + '\'' +
                ", salarioRecebido: " + Arrays.toString(salarioRecebido) +
                ']');
    }

}
