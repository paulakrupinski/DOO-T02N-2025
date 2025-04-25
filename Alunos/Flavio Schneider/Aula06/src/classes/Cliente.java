package classes;

public class Cliente {
	
	private String nome;
	private int idade;
	private String cidade;
	private String bairro;
	private String rua;
	

	

	public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
		super();
		this.nome = nome;
		this.idade = idade;
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




	public int getIdade() {
		return idade;
	}




	public void setIdade(int idade) {
		this.idade = idade;
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

public static void apresentarse() {
	
	Cliente cliente01 = new Cliente("Eduarda", 20, "Cascavel", "Santo Inacio", "Ernesto Barnabe");
	
	System.out.println("Nome: " + cliente01.getNome() + "\nIdade: " + cliente01.getIdade());
	
}


	public static void main(String[] args) {

		
		apresentarse();
		
	}

}