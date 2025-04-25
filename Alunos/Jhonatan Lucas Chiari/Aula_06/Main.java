public class Main {
    public static void main(String[] args) {
        // criando a loja
        Loja loja = new Loja("My Plant", "My Plant LTDA", "00.001.002.0001-22", "Centro", "Bairro Fag",
                "Avenida das Torres");

        // criando vendedor
        Vendedor vendedor1 = new Vendedor("Carlos", 30, loja, "Centro", "Bairro Azul", "Rua das Árvores", 3000.0);
        Vendedor vendedor2 = new Vendedor("Ana", 25, loja, "Centro", "Bairro Amarelo", "Avenida das Rosas", 3200.0);

        // criando clientes
        Cliente cliente1 = new Cliente("Mariana", 28, "Centro", "Bairro Verde", "Rua das Palmeiras");
        Cliente cliente2 = new Cliente("João", 35, "Centro", "Bairro Roxo", "Rua das Hortênsias");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);


        loja.apresentarse();
        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente1.apresentarse();
        cliente2.apresentarse();
        
        System.out.println("======================================");
        System.out.println("Total de vendedores: " + loja.contarVendedores());
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("======================================\n");
    }
}