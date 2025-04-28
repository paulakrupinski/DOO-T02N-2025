package fag.objeto;

import java.time.LocalDate;

public class Reserva {
	private Cliente cliente;
	private Quarto quarto;
	private LocalDate dataCheckIn;
	private LocalDate dataCheckOut;
	
	public Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
		this.cliente = cliente;
		this.quarto = quarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}
	
    public double calcularTotal() {
    	return quarto.getPreco() * (dataCheckOut.toEpochDay() - dataCheckIn.toEpochDay());
    }

    public boolean estaDisponivel(LocalDate data) {
        return !(data.isAfter(dataCheckIn.minusDays(1)) && data.isBefore(dataCheckOut));
    }

	public Cliente getCliente() {
		return cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}

	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}
	
	
}
