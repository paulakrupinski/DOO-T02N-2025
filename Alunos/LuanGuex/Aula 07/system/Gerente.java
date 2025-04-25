package system;

public class Gerente extends Vendedor {
    
    public Gerente(String nome, int idade, Endereco endereco, Loja loja, double salarioBase) {
        super(nome, idade, endereco, loja, salarioBase);
    }
    
    public void apresentaSe() {
        System.out.printf("\nGerente: %s, Idade: %d, Loja: %s\n", nome, idade, loja != null ? loja.nomeFantasia : "Sem loja");
    }
    
    public void calcularMedia() {
        double soma = 0;
        for(double sal : salarioRecebido) {
            soma += sal;
        }
        System.out.printf("Média salarial do gerente: R$%.2f\n", soma / salarioRecebido.length);
    }
    
    public void calcularBonus() {
        System.out.printf("Bônus do gerente: R$%.2f\n", salarioBase * 0.35);
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}
