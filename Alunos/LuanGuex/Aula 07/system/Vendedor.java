package system;

public class Vendedor {
    String nome;
    int idade;
    Endereco endereco;
    Loja loja;
    double salarioBase;
    double[] salarioRecebido;
    
    public Vendedor(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[]{salarioBase, salarioBase, salarioBase};
    }
    
    public void apresentaSe() {
        String nomeLoja = (loja != null && loja.nomeFantasia != null) ? loja.nomeFantasia : "Sem loja";
        System.out.printf("\nNome: %s\nIdade: %d\nLoja: %s\n", nome, idade, nomeLoja);
    }
    
    public void calcularMedia() {
        double soma = 0;
        for(double sal : salarioRecebido) {
            soma += sal;
        }
        System.out.printf("Média salarial: R$%.2f\n", soma / salarioRecebido.length);
    }
    
    public void calcularBonus() {
        System.out.printf("Bônus: R$%.2f\n", salarioBase * 0.20); // bônus de 20% para vendedor
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    
}