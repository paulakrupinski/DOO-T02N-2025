package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Entities.Clientes;
import Entities.Quartos;

public class Application {
	
	public static void main(String[] args) {
		
		Clientes clientes = new Clientes();
		Quartos quartos = new Quartos();
		DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner scan = new Scanner (System.in);
		System.out.println(
			 "\nEscolha uma opcao: \n"
				+ " 1- Cadastrar cliente\n"
				+ " 2- Cadastrar quarto\n"
				+ " 3- Mostrar clientes e quartos\n"
				+ " 4- Verificar disponibilidade de reserva por data\n"
				+ " 5- Fazer reserva\n"
				+ " 6- CheckIn\n"
				+ " 7- CheckOut\n");
		int option = scan.nextInt();
		while (option != 10) {
			
			switch(option) {
			case 1:
			{
				System.out.println("Digite a idade: ");
				int idade = scan.nextInt();
				System.out.println("Digite o nome: ");
				String nome = scan.next();
				clientes.addCliente(new Clientes(nome, idade));
				break;
			}
			case 2:
			{
				System.out.println("Digite o tipo do quarto (1 = Simples/ 2= Duplo) ");
				int tipo = scan.nextInt();
				System.out.println("Digite o numero do quarto: ");
				int numero = scan.nextInt();
				quartos.cadastrarQuarto(new Quartos(tipo, numero));
				break;
			}
			case 3:
			{
				clientes.printaClientes();
				quartos.printaQuartos();
				break;
			}
			case 4:
			{
				System.out.println("Digite a data para verificar disponibilidade de reserva: ");
				LocalDate data = LocalDate.parse(scan.next(), dtf);
				System.out.println("Digite o numero do quarto: ");
				int numero = scan.nextInt();
				quartos.reservaPorData(data, numero);
				break;
			}
			case 5:
			{

				System.out.println("Digite a data pra reserva: ");
				LocalDate data = LocalDate.parse(scan.next(), dtf);
				System.out.println("Digite o quarto desejado");
				Integer numero = scan.nextInt();
				 quartos.fazerReserva(data, numero);
				 break;
			}
			case 6:
			{
				System.out.println("Digite o numero do quarto para CheckIn: ");
				int numero = scan.nextInt();
				quartos.checkIn(LocalDate.now(), numero);
				break;
			}
			case 7:
			{
				System.out.println("Digite o numero do quarto para CheckOut: ");
				int numero = scan.nextInt();
				quartos.checkOut(LocalDate.now(), numero);
				break;
			}
				
			}
			
			System.out.println( "\nEscolha uma opcao: \n"
					+ " 1- Cadastrar cliente\n"
					+ " 2- Cadastrar quarto\n"
					+ " 3- Mostrar clientes e quartos\n"
					+ " 4- Verificar disponibilidade de reserva por data\n"
					+ " 5- Fazer reserva\n"
					+ " 6- CheckIn\n"
					+ " 7- CheckOut\n");
			option = scan.nextInt();
			
		}
		
		scan.close();
	}

}
