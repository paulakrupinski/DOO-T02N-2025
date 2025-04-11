package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vendedor {
	public static Scanner scan = new Scanner(System.in);
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido = new ArrayList<>();
    
    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        
        
        System.out.println("Digite o primeiro salário recebido pelo vendedor:");
        double s1 = scan.nextDouble();
        System.out.println("Digite o segundo salário recebido pelo vendedor:");
        double s2 = scan.nextDouble();
        System.out.println("Digite o terceiro salário recebido pelo vendedor:");
        double s3 = scan.nextDouble();
        scan.nextLine();
        
        this.salarioRecebido.add(s1);
        this.salarioRecebido.add(s2);
        this.salarioRecebido.add(s3);
    }
    
    public double calcularMedia() {
        double soma = 0;
        for (int i = 0; i < salarioRecebido.size(); i++) {
            soma = soma + salarioRecebido.get(i);
        }
        return soma / salarioRecebido.size();
    }
    
    public double calcularBonus() {
        return salarioBase * 0.2;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public Loja getLoja() {
        return loja;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
    
    @Override
    public String toString() {
        return "Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNomeFantasia();
    }
}
