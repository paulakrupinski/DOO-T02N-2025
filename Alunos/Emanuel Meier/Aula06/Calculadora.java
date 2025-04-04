package fag;

import java.util.Arrays;
import java.util.List;

import fag.objeto.Cliente;
import fag.objeto.Loja;
import fag.objeto.Vendedor;

public class Calculadora {

	public static void main(String[] args) {
		Vendedor vendedor1 = new Vendedor("Carlos", 32, "MyPlant", "Cascavel", "Centro", "Av Brasil", 3000.0, new double[]{3200, 3100, 3300});
		Vendedor vendedor2 = new Vendedor("Ana Paula", 30, "MyPlant","Cascavel", "Centro", "Av Brasil", 3000.0, new double[]{3100, 3450, 3230});
		
		Cliente cliente1 = new Cliente("João Dias", 20, "Cascavel", "Neva", "Pio XII");
		Cliente cliente2 = new Cliente("Maria Helena", 26, "Cascavel", "Parque São Paulo", "Rua Carlos de Carvalho");
		
		Loja Loja = new Loja("My Plant", "My Plat LTDA", "12.345.678/0001-99", "Cascavel", "Centro", "Av Paulista",  Arrays.asList(vendedor1, vendedor2),  Arrays.asList(cliente1, cliente2));
		
		Loja.apresentarSe();
		
		System.out.println("\n --- Vendedores ---");
		vendedor1.apresentarSe();
		System.out.println("Média Salarial: R$ " + String.format("%.2f", vendedor1.calcularMedia()));
		System.out.println("Bônus: R$ " + String.format("%.2f", vendedor1.calcularBonus()));
		
		vendedor2.apresentarSe();
		System.out.println("Média Salarial: R$ " + String.format("%.2f", vendedor2.calcularMedia()));
		System.out.println("Bônus: R$ " + String.format("%.2f", vendedor2.calcularBonus()));
		
		System.out.println("\n --- Clientes ---");
		cliente1.apresentarSe();
		cliente2.apresentarSe();
		
		System.out.println("\nTotal de vendedores: " + Loja.contarVendedores());
		System.out.println("Total de clientes: " + Loja.contarClientes());
	}
}
