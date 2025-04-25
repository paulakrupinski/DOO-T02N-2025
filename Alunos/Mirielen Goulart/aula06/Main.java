
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("My Plant", "My Plant Ltda", "1234567890001", "São Paulo", "Centro", "Rua das Flores");
        
        Vendedor vendedor1 = new Vendedor("Carlos", 30, "My Plant", "São Paulo", "Centro", "Rua das Flores", 3000);
        vendedor1.adicionarSalario(3200);
        vendedor1.adicionarSalario(3100);
        vendedor1.adicionarSalario(3300);

        Vendedor vendedor2 = new Vendedor("Ana", 28, "My Plant", "São Paulo", "Centro", "Rua das Flores", 2800);
        vendedor2.adicionarSalario(2900);
        vendedor2.adicionarSalario(2950);
        vendedor2.adicionarSalario(2850);

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        
        Cliente cliente1 = new Cliente("Maria", 35, "São Paulo", "Jardins", "Rua Verde");
        Cliente cliente2 = new Cliente("Pedro", 40, "São Paulo", "Vila Nova", "Rua Azul");
        
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);
        
        loja.apresentarSe();
        loja.contarVendedores();
        loja.contarClientes();
        
        vendedor1.apresentarSe();
        System.out.println("Média Salarial: " + vendedor1.calcularMedia());
        vendedor1.calcularBonus();
        
        vendedor2.apresentarSe();
        System.out.println("Média Salarial: " + vendedor2.calcularMedia());
        vendedor2.calcularBonus();
        
        cliente1.apresentarSe();
        cliente2.apresentarSe();
    }
}
