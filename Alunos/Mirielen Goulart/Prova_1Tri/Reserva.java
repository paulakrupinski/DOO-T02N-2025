
import java.time.LocalDate;

public class Reserva {

	private Cliente cliente;
	private CadastroQuarto cadastroQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private boolean ativa;
	
	public Reserva(Cliente cliente, CadastroQuarto cadastroQuarto, LocalDate checkIn, LocalDate checkOut,
			boolean ativa) {
		super();
		this.cliente = cliente;
		this.cadastroQuarto = cadastroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.ativa = false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CadastroQuarto getCadastroQuarto() {
		return cadastroQuarto;
	}

	public void setCadastroQuarto(CadastroQuarto cadastroQuarto) {
		this.cadastroQuarto = cadastroQuarto;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public void realizarCheckIn() {
		if(!ativa) {
			cadastroQuarto.ocupar();
			ativa = true;
		}
	}
	
	public void realizarCheckOut() {
		if(ativa) {
			cadastroQuarto.desocupar();
			ativa = false;
		}
	}
	
	public long calcularDias() {
	    if (checkIn != null && checkOut != null) {
	        return checkIn.until(checkOut).getDays();
	    }
	    return 0;
	}
	
	public void calcularTotalDiarias() {
		System.out.println("Valor total a pagar: ");
		System.out.print(calcularDias() * cadastroQuarto.getPrecoDiario());
	}

	@Override
	public String toString() {
		return "Reserva - Cliente: " + cliente + 
				", Cadastro do Quarto:" + cadastroQuarto + 
				", CheckIn:" + checkIn + 
				", CheckOut:" + checkOut + 
				", Ativa:" + ativa ;
	}
}
