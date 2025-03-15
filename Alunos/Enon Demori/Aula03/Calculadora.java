package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculadora {
	public static Scanner scan = new Scanner(System.in); 
	
	public static List<ListaPlantas> lista = new ArrayList<>();
	public static void main(String[] args) {
		int op = 0;
		while (op!=4) {
		System.out.println("\nDigite de acordo com o quer realizar");
		System.out.println("1 - Calcular Preço Total");
		System.out.println("2 - Calcular Troco");
		System.out.println("3 - Checar Registro de Vendas");
		System.out.println("4 - Sair");
		op = scan.nextInt();
		scan.nextLine();
		if (op==1) {
			calculadora();
		}
		
		else if (op==2) {
			troco();
		}
		else if (op==3) {
			registro();
		}
	}
	}
	
	public static void calculadora() {
		double valorTotalDescontos = 0;
		System.out.println("Quantas plantas vc vai querer?");
		int quantidade = scan.nextInt();
		System.out.println("E qual o preço dela?");
		double valor = scan.nextFloat();
		double total = 0;
		total = (quantidade*valor);
		System.out.println("Cada uma custa "+valor+" reais, totalizando "+ total + " Reais.");
		if (quantidade >= 10 ) {
			valorTotalDescontos = (total*0.05);
			total =(total-valorTotalDescontos);
			System.out.println("Mas como vc comprou 10 ou mais, vc recebe 5% de desconto, que é "+valorTotalDescontos+" de desconto, totalizando " + total+" Reais.");
		}
		ListaPlantas planta = new ListaPlantas(quantidade,total,valorTotalDescontos);
		lista.add(planta);
	}
	
	public static void troco() {
		System.out.println("Vc vai pagar com quanto para eu já calcular o troco?");
		float valorEntregue = scan.nextFloat();
		System.out.println("E quanto deu o total anterior?");
		float total = scan.nextFloat();
		if (valorEntregue < total) {
			System.out.println("Essa quantia de dinheiro é insuficiente!");
			
		}
		else {
		float troco = valorEntregue - total;
		System.out.println("Vou te dar "+troco+" Reais de troco!");
	}
	}
	public static void registro() {
		if (lista.isEmpty()) {
			System.out.println("A lista está vazia");
		} else {
			System.out.println("\nRegistro de Vendas");
			for(ListaPlantas venda : lista) {
				 System.out.println(venda); 
		            System.out.println("-------------------------------");
			}
	        }
		}
		
	}