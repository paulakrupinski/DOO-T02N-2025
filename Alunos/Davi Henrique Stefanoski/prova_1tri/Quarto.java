package pacote;

public abstract class Quarto {
int numero;

int capacidade;
boolean disponivel;


public Quarto(int numero) {
    this.numero = numero;
    this.disponivel = true;
}


public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public int getCapacidade() {
	return capacidade;
}
public void setCapacidade(int capacidade) {
	this.capacidade = capacidade;
}
public boolean isDisponivel() {
	return disponivel;
}
public void setDisponivel(boolean disponivel) {
	this.disponivel = disponivel;
}

void ocupar() {
	this.setDisponivel(false);
	System.out.println("Status do quarto definido para ocupado.");
}
void liberar() {
	this.setDisponivel(true);
	System.out.println("Status do quarto definido para liberado.");
}

boolean verificarDisponibilidade(Quarto quarto) {
	if (quarto.isDisponivel()) {
		return true;
	}
	else {
		return false;
	}
}


public abstract void calcularPreco(int quantidadeDeDiarias);

@Override
public String toString() {
	if (disponivel) {
	return "Número: " + numero +  "| Capacidade: " + capacidade + "| Disponível";

}
	else {
		return "Número: " + numero +  "| Capacidade: " + capacidade + "| Indisponível";
	}
}



}
