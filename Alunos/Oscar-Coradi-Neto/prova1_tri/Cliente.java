package prova1_tri;

class Cliente {

    String nome;
    
    @Override
	public String toString() {
		return "Cliente [nomeCliente=" + nome + "]";
	}

	public String getNomeCliente() {
		return nome;
	}

	public void setNomeCliente(String nome) {
		this.nome = nome;
	}



	public Cliente(String nome) {
		this.nome = nome;
	}

}
