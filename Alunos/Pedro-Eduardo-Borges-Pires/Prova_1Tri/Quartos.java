package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Quartos{
	
	private int tipo;
	private int numero;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private boolean disponibilidade = true;
	private List<Clientes> listaClientes;
	
	List <Quartos> listaQuartos = new ArrayList<>();
	List <Reserva> reservas = new ArrayList<>();
	DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Quartos() {
	
	}

	public Quartos(int tipo, int numero) {
		super();
		this.tipo = tipo;
		this.numero = numero;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
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

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Override
	public String toString() {
		return "Tipo: " + tipo + ", Numero: " + numero + ", Disponibilidade: " + disponibilidade + "\n"; 
	}

	
	public void cadastrarQuarto(Quartos quarto) {
		listaQuartos.add(quarto);
	}
	
	public void printaQuartos() {
		for(Quartos quartos : listaQuartos) {
			System.out.println(quartos);
		}
		
	}
	
	public void addCliente(Clientes cliente) {
		listaClientes.add(cliente);
	
	}
	
	public void printaClientes() {
		for(Clientes cliente : listaClientes) {
			System.out.println(cliente);
		}
	}

	
	public void fazerReserva(LocalDate date, Integer numero) {
		for(Quartos quarto : listaQuartos) {
			if(numero.equals(quarto.getNumero())) {
				if(disponibilidadeReserva(date, numero)) {
					reservas.add(new Reserva(date, quarto));
					System.out.println("Reserva concluida para data: " + date.format(dtf));
				}
			}
			
		}	
	}
	
	public void reservaPorData(LocalDate date, Integer numero) {
		for (Reserva reserva : reservas) {
			if(numero.equals(reserva.getQuarto().getNumero()) && reserva.getData().equals(date)) 
				System.out.println("\n!!! Data indisponivel !!!\n");
			else
				System.out.println("\n!!! Data disponivel !!!\n");
		}

	}
	
	public boolean disponibilidadeReserva (LocalDate date, Integer numero) {
		boolean disponibilidade = true;
		for (Quartos quarto : listaQuartos) {
			if(numero.equals(quarto.getNumero())) {
				if(reservas.contains(date)) {
					disponibilidade = false;
					System.out.println("\nData indisponivel!!!\n");
				}
				else
					System.out.println("Data disponivel");
			}
		}
			return disponibilidade;
	}
	
	
	public void checkIn (LocalDate date, Integer numero) {
		for(Quartos quarto : listaQuartos) {
			if(numero.equals(quarto.getNumero())) {
				quarto.setCheckIn(date);
				quarto.setDisponibilidade(false);
				System.out.println("\nCheckIn realizado");
			}
		}
	}
	
	public void checkOut (LocalDate date, Integer numero) {
		for(Quartos quarto : listaQuartos) {
			if (numero.equals(quarto.getNumero())) {
				quarto.setCheckOut(date);
				int diaria = quarto.getCheckIn().compareTo(date);
				pagamento(diaria, quarto);
				quarto.setDisponibilidade(true);
				System.out.println("\nCheckOut realizado");
			}
		}
	}
	
	//considerando quarto simples: R$80 a diaria e duplo R$180 a diaria
	public void pagamento(int diarias, Quartos quarto) {
		int total;
		if (quarto.getTipo() == 1) 
			total = diarias * 80;	
		else
			total = diarias * 180;
		
		System.out.println("\nValor da hospedagem :" + total);
		
	}

	
	
	
	
	
	

}
