package classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Vendedor {
	
	public static Scanner scan = new Scanner(System.in);
	
	private String nome;
	private int idade;
	private int loja;
	private String cidade;
	private String bairro;
	private String rua;
	private double salarioBase;
	private List<Double> salarioRecebido;
	


	public Vendedor(String nome, int idade, int loja, String cidade, String bairro, String rua, double salarioBase) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.loja = loja;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.salarioBase = salarioBase;
	}



	public Vendedor(String nome, int idade, int loja, String cidade, String bairro, String rua, double salarioBase,
			List<Double> salarioRecebido) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.loja = loja;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.salarioBase = salarioBase;
		this.salarioRecebido = new ArrayList<>();
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



	public int getLoja() {
		return loja;
	}



	public void setLoja(int loja) {
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



	public String getRua() {
		return rua;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}



	public List<Double> getSalarioRecebido() {
		return salarioRecebido;
	}



	public void setSalarioRecebido(List<Double> salarioRecebido) {
		this.salarioRecebido = salarioRecebido;
	}



	public double getSalarioBase() {
		return salarioBase;
	}



	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}


public static void apresentarse() {
		
	Vendedor vendedor01 = new Vendedor("Fabio", 25, 01, "cascavel", "centro", "sla", 2500);
		System.out.println("Nome: " + vendedor01.getNome() + "\nIdade: " + vendedor01.getIdade() + 
				"\nLoja: " + vendedor01.getLoja());
		
	}

public static void calcularBonus(){
	
	Vendedor vendedor01 = new Vendedor("Fabio", 25, 01, "cascavel", "centro", "sla", 2500, null);
	
	System.out.println("O vendedor bateu a meta mensal?");
	System.out.println("1-sim");
	System.out.println("2-Nao");
	int op = scan.nextInt();
	
	if(op == 1) {
		
		double salario = (vendedor01.getSalarioBase() * 0.2) + vendedor01.getSalarioBase();
		vendedor01.getSalarioRecebido().add(salario);
		
	}else if(op == 2) {
		
		vendedor01.getSalarioRecebido().add(vendedor01.getSalarioBase());
		
	}else {
	    System.out.println("opcao invalida");
	}
	
	 System.out.println("Salário recebido: " + vendedor01.getSalarioRecebido());
}

public static void calcularMedia() {
	
	Vendedor vendedor01 = new Vendedor("Fabio", 25, 01, "cascavel", "centro", "sla", 2500, null);
	vendedor01.getSalarioRecebido().add(2500.00);
	vendedor01.getSalarioRecebido().add(3000.00);
	vendedor01.getSalarioRecebido().add(2500.00);
	double total = 0;
	int c = 0;
	
	for(double salario : vendedor01.getSalarioRecebido()) {
		
		total = total + salario;
		
		c++;
	}
	
	double media = 0;
	media = total/c;
	
	//System.out.println(vendedor01.getSalarioRecebido());
	System.out.println(media);	
}
	

	public static void main(String[] args) {

		apresentarse();
		System.out.println(" ");
		calcularBonus();
		System.out.println(" ");
		calcularMedia();
		
	}

}