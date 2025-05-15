
public class CadastroQuarto {
	
		private int numeroQuarto;
		private double precoDiario;
		private boolean disponivel;
		private int capacidade;
		
		public CadastroQuarto(int numeroQuarto, double precoDiario, boolean disponivel, int capacidade) {
			super();
			this.numeroQuarto = numeroQuarto;
			this.precoDiario = precoDiario;
			this.disponivel = disponivel;
			this.capacidade = capacidade;
		}
		
		
		public int getNumeroQuarto() {
			return numeroQuarto;
		}


		public void setNumeroQuarto(int numeroQuarto) {
			this.numeroQuarto = numeroQuarto;
		}


		public double getPrecoDiario() {
			return precoDiario;
		}


		public void setPrecoDiario(double precoDiario) {
			this.precoDiario = precoDiario;
		}


		public boolean isDisponivel() {
			return disponivel;
		}


		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}


		public int getCapacidade() {
			return capacidade;
		}


		public void setCapacidade(int capacidade) {
			this.capacidade = capacidade;
		}
		
		  public void ocupar() {
		        this.disponivel = false; 
		    }
		  
		  public void desocupar() {
		        this.disponivel = true;
		    }
		  
		@Override
		public String toString() {
			return "Cadastro de Quarto - Número do Quarto:" + numeroQuarto + ", Preço Diário:" + precoDiario + ", Disponivel:"
					+ disponivel + ", Capacidade:" + capacidade + "]";
		}
}

