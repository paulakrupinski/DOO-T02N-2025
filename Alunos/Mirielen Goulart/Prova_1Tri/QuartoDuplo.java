
public class QuartoDuplo extends CadastroQuarto {

	public QuartoDuplo(int numeroQuarto, double precoDiario, boolean disponivel, int capacidade) {
		super(numeroQuarto, precoDiario, true, 4);
	}

	@Override
	public String toString() {
		return "QuartoDuplo - " + super.toString();
	}
}
