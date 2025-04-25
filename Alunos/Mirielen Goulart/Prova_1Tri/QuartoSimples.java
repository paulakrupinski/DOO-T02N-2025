
public class QuartoSimples extends CadastroQuarto{

	public QuartoSimples(int numeroQuarto, double precoDiario, boolean disponivel, int capacidade) {
		super(numeroQuarto, precoDiario, true, 2);
	}

	@Override
	public String toString() {
		return "QuartoSimples - " + super.toString();
	}
}
