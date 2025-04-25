package fag.objeto;

import java.util.List;

public class Loja {
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String cidade;
	private String bairro;
	private String rua;
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	
	public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, 
	List<Vendedor> vendedores, List<Cliente> clientes) {
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.vendedores = vendedores;
		this.clientes = clientes;
	}
	
	public int contarClientes() {
		return clientes.size();
	}
	
	public int contarVendedores() {
		return vendedores.size();
	}
	
	public void apresentarSe() {
		System.out.println("Nome fantasia: " + nomeFantasia + " | CNPJ: " + cnpj);
		System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
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

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
