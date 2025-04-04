import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //lista para enviar 3 salarios ao objeto vendedor.
        ArrayList<Double> salariosBruno = new ArrayList<>();
        salariosBruno.add(1000.0);
        salariosBruno.add(1500.0);
        salariosBruno.add(2000.0);

        // cria as listas de clientes e vendedores
        ArrayList listaClientes = new ArrayList<>();
        ArrayList listaVendedores = new ArrayList<>();

        //lista de clientes e vendedores  
        Cliente cliente1 = new Cliente("João", 15, "Ceu Azul", "Centro", "Esperança");
        listaClientes.add(cliente1);
        
        Vendedor vendedor1 = new Vendedor("Bruno", 18, "My Plant", "cidade", "bairro", "rua", 1500.0, salariosBruno);
        listaVendedores.add(vendedor1);
        //cria uma loja com tudo.
        Loja loja1 = new Loja("loja01", "My Plant", 01 , "Cascavel  ", "teste  ", "rua", listaClientes, listaVendedores);  
        
        loja1.apresentarse();
        cliente1.apresentarse();
        vendedor1.apresentarse();
        
        double salarioComBonus = vendedor1.calcularBonus(vendedor1.getSalarioBase());
        System.out.println(" o salario de "+vendedor1.getNome()+ " com bonus é: "+ salarioComBonus+"\n");

        loja1.listarVendedores();
        loja1.listarClientes();
        System.out.println("Média salarial de " + vendedor1.getNome() + ": " + vendedor1.calcularMedia()+"\n");


    }
}