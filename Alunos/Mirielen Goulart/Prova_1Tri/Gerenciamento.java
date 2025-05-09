

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gerenciamento {

	public List<CadastroQuarto> quartos = new ArrayList<>();
	public List<Reserva> reservas = new ArrayList<>();
	public List<Cliente> clientes = new ArrayList<>();
	
	public void cadastrarCliente (Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void cadastrarQuarto (CadastroQuarto cadastroQuarto) {
		quartos.add(cadastroQuarto);
	}
	
	public void realizarCheckIn(Reserva reserva) {
		reserva.realizarCheckIn();
	}
	
	
	
	public void relaizarCheckOut(Reserva reserva) {
		reserva.realizarCheckOut();
	}
	
	public boolean disponibilidade(CadastroQuarto cadastroQuarto, LocalDate checkIn, LocalDate checkOut) {
		for(Reserva cadReserva : reservas) {
			if(cadReserva.getCadastroQuarto().equals(cadastroQuarto)) {
				if(!(checkOut.isBefore(cadReserva.getCheckIn()) || checkIn.isAfter(cadReserva.getCheckOut()))) {
					return false;
				}
			}
		}
		  return true;
	}
	
	public Reserva cadastrarReserva(Cliente cliente, CadastroQuarto cadastroQuarto, LocalDate checkIn, LocalDate checkOut) {
		if(disponibilidade(cadastroQuarto, checkIn, checkOut)){
			Reserva cadastroReserva = new Reserva(cliente, cadastroQuarto, checkIn, checkOut, false);
			reservas.add(cadastroReserva);
			return cadastroReserva;
		} else {
			System.out.println("Quarta indisponível para a data escolhida!");
			return null;
		}
	}
}

