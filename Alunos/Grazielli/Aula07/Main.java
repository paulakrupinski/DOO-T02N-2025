import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", 100, "Próximo ao terminal");
        Loja loja = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-90", enderecoLoja);

        Gerente gerente = new Gerente("Paulo", 40, loja, new Endereco("PR", "Cascavel", "Centro", 103, "Sala Gerência"),
                5000, new double[] { 5200, 5100, 5300 });
        Vendedor vendedor1 = new Vendedor("Carlos", 30, loja, new Endereco("PR", "Cascavel", "Centro", 101, "Sala 1"),
                2000, new double[] { 2200, 2300, 2100 });
        Vendedor vendedor2 = new Vendedor("Mariana", 28, loja, new Endereco("PR", "Cascavel", "Centro", 102, "Sala 2"),
                2500, new double[] { 2600, 2500, 2700 });

        Cliente cliente1 = new Cliente("Lucas", 35, new Endereco("PR", "Cascavel", "Centro", 201, "Ap 1"));
        Cliente cliente2 = new Cliente("Juliana", 27, new Endereco("PR", "Cascavel", "Centro", 202, "Ap 2"));

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);
        loja.adicionarGerente(gerente);

        System.out.println("=== Loja ===");
        loja.apresentarse();
        System.out.println("Total de Clientes: " + loja.contarClientes());
        System.out.println("Total de Vendedores: " + loja.contarVendedores());

        System.out.println("\n=== Gerente ===");
        gerente.apresentarse();
        System.out.println("Média Salarial: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        System.out.println("\n=== Vendedores ===");
        vendedor1.apresentarse();
        System.out.println("Média Salarial: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        vendedor2.apresentarse();
        System.out.println("Média Salarial: " + vendedor2.calcularMedia());
        System.out.println("Bônus: " + vendedor2.calcularBonus());

        System.out.println("\n=== Criar Pedido (dados fakes) ===");
        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(
                1,
                new Date(),
                adicionarDias(new Date(), 2),
                adicionarDias(new Date(), 5),
                cliente1,
                vendedor1,
                loja,
                new Item[] {
                        new Item(1, "Vaso Decorativo", "Decoração", 150),
                        new Item(2, "Planta Samambaia", "Planta", 60)
                });

        if (pedido != null) {
            pedido.gerarDescricaoVenda();
        }

        scanner.close();
    }

    public static Date adicionarDias(Date data, int dias) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DATE, dias);
        return c.getTime();
    }
}
