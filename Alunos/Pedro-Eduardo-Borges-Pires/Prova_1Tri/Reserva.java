package Entities;

import java.time.LocalDate;

public class Reserva {
	
	private LocalDate data;
	private Quartos quarto;
	
	public Reserva() {
		
	}

	public Reserva(LocalDate data, Quartos quarto) {
		this.data = data;
		this.quarto = quarto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Quartos getQuarto() {
		return quarto;
	}

	public void setQuarto(Quartos quarto) {
		this.quarto = quarto;
	}
	
}
