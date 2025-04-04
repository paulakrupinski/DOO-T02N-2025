public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("My Plant", "My Plant LTDA", "598.789.256", "Cascavel", "Centro", "Rua Principal");

        Vendedor vendedor1 = new Vendedor("Carlos", 50, "My Plant", "Cascavel", "Centro", "Rua Germano Sarolli ", 2000.0, new double[]{2000.0, 2100.0, 2200.0});// criado para realizar a media salarial base
        Cliente cliente1 = new Cliente("Ana Paula ", 25, "Cascavel", "Neva", "Avenida Brasil");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarCliente(cliente1);

        loja.apresentarSe();
        vendedor1.apresentar();
        cliente1.apresentar();

        System.out.println("Média Salarial: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());
        System.out.println("Total de Clientes: " + loja.contarClientes());
        System.out.println("Total de Vendedores: " + loja.contarVendedores());
    }
}
