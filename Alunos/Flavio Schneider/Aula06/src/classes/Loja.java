package classes;

import java.util.ArrayList;
import java.util.List;
import classes.Cliente;
import classes.Vendedor;

public class Loja {
	
	public static List<Cliente> listaClientes = new ArrayList<>();
	public static List<Vendedor> listaVendedores = new ArrayList<>();
	
	private String nome;
	private String razaoSocial;
	private int cnpj;
	private String cidade;
	private String bairro;
	private String rua;
	
	

	public Loja(String nome, String razaoSocial, int cnpj, String cidade, String bairro, String rua) {
		super();
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getRazaoSocial() {
		return razaoSocial;
	}



	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}



	public int getCnpj() {
		return cnpj;
	}



	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
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


	public static void adicionarPersonagens() {
		
		
		Cliente cliente01 = new Cliente("Eduarda", 20, "Cascavel", "Santo Inacio", "Ernesto Barnabe");
		Cliente cliente02= new Cliente("Marcus", 20, "Cascavel", "Santo inacio", "Ernesto barnabe");
		listaClientes.add(cliente01);
		listaClientes.add(cliente02);
		
		
		
		Vendedor vendedor01 = new Vendedor("Fabio", 25, 01, "cascavel", "centro", "sla", 2500, null);
		Vendedor vendedor02 = new Vendedor("Jane", 28, 02, "cascavel", "centro", "sla", 2500, null);
		Vendedor vendedor03 = new Vendedor("Laila", 20, 03, "cascavel", "centro", "sla", 2500, null);
		listaVendedores.add(vendedor01);
		listaVendedores.add(vendedor02);
		listaVendedores.add(vendedor03);
		
	}
	
	public static void contarVendedores() {
		
		
		
		int contadorVendedores = 0;
		
		for(int i = 0; i < listaVendedores.size(); i++ ) {
			
			contadorVendedores++;
			
		}
		
		System.out.println("Tem " + contadorVendedores + " vendedores na sua loja." );
		
	}
	
	public static void contarClientes() {
		
		
		
		 int contadorClientes = 0;
			
			for(int i = 0; i < listaClientes.size(); i++ ) {
				
				contadorClientes++;
				
			}
			
			System.out.println("Tem " + contadorClientes + " clientes na sua loja." );
		
	}
	
	
	public static void apresentarse() {
		
		Loja loja01 = new Loja("My Plant", "Dona Gabrielinha LTDA", 0001, "Cascavel", "Cataratas", "sla");
		
		System.out.println("Nome: " + loja01.getNome() + "\nCNPJ: " + loja01.getCnpj() + "\nEndereço: " + loja01.getCidade() + " - " + loja01.getBairro() + " - " + loja01.getRua());
		
	}

	public static void main(String[] args) {
		
		adicionarPersonagens();
		contarClientes();
		System.out.println("  ");
		contarVendedores();
		System.out.println("  ");
		apresentarse();
		

	}

} 