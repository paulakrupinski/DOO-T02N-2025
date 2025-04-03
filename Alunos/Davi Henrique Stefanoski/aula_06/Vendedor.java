package pacote;
import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	 String nome;
	    int idade;
	    String loja;
	    String cidade;
	    String bairro;
	    String rua;
	    double salarioBase;
	    List<Double> salarioRecebido = new ArrayList<>();

	    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double... salarios) {
	        this.nome = nome;
	        this.idade = idade;
	        this.loja = loja;
	        this.cidade = cidade;
	        this.bairro = bairro;
	        this.rua = rua;
	        this.salarioBase = salarioBase;
	        for (double salario : salarios) {
	            this.salarioRecebido.add(salario);
	        }
	        
	    if (salarios.length < 3) {
            this.salarioRecebido.add(1000.0);
            this.salarioRecebido.add(1100.0);
            this.salarioRecebido.add(1200.0);
        } else {
            for (double salario : salarios) {
                this.salarioRecebido.add(salario);
                }
            }
	    }
	    public void apresentarse() {
	        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
	    }

	    public double calcularMedia() {
	        double soma = 0;
	        for (double salario : salarioRecebido) {
	            soma += salario;
	        }
	        return salarioRecebido.isEmpty() ? 0 : soma / salarioRecebido.size();
	    }

	    public double calcularBonus() {
	        return salarioBase * 0.2;
	    }
	}


