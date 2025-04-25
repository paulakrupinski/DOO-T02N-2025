public class SistemaMyPlant {
    public static void main(String[] args) {

        Loja loja = new Loja(
                "My Plant",
                "My Plant LTDA",
                "12.345.678/0001-90",
                "Cascavel",
                "Centro",
                "Rua das Flores");

        Vendedor vendedor1 = new Vendedor(
                "Carlos",
                30,
                loja,
                "Cascavel",
                "Centro",
                "Rua das Flores",
                2000,
                new double[] { 2200, 2300, 2100 });

        Vendedor vendedor2 = new Vendedor(
                "Mariana",
                28,
                loja,
                "Cascavel",
                "Centro",
                "Rua das Rosas",
                2500,
                new double[] { 2600, 2500, 2700 });

        Cliente cliente1 = new Cliente("Lucas", 35, "Cascavel", "Centro", "Rua A");
        Cliente cliente2 = new Cliente("Juliana", 27, "Cascavel", "Centro", "Rua B");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        System.out.println("=== Loja ===");
        loja.apresentarse();
        System.out.println("Total de Clientes: " + loja.contarClientes());
        System.out.println("Total de Vendedores: " + loja.contarVendedores());

        System.out.println("\n=== Vendedores ===");
        vendedor1.apresentarse();
        System.out.println("Média Salarial: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        System.out.println();
        vendedor2.apresentarse();
        System.out.println("Média Salarial: " + vendedor2.calcularMedia());
        System.out.println("Bônus: " + vendedor2.calcularBonus());

        System.out.println("\n=== Clientes ===");
        cliente1.apresentarse();
        cliente2.apresentarse();
    }
}
