import java.util.ArrayList;
import java.util.Date;

public class Loja {
    private static ArrayList<Vendedor> vendedores = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Gerente> gerentes = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void cadastrarVendedor() {
        Vendedor vendedor = new Vendedor("Carlos", 30, 1500.00);
        vendedores.add(vendedor);
    }

    public static void apresentarVendedores() {
        for (Vendedor vendedor : vendedores) {
            vendedor.apresentarse();
        }
    }

    public static void calcularMediaPeloNome() {
        for (Vendedor vendedor : vendedores) {
            System.out.println("Média Salarial: " + vendedor.calcularMedia());
        }
    }

    public static void calcularBonusPeloNome() {
        for (Vendedor vendedor : vendedores) {
            System.out.println("Bônus: " + vendedor.calcularBonus());
        }
    }

    public static void cadastrarCliente() {
        Cliente cliente = new Cliente("João", "Rua A, 123");
        clientes.add(cliente);
    }

    public static void apresentarClientes() {
        for (Cliente cliente : clientes) {
            cliente.apresentarse();
        }
    }

    public static void apresentarse() {
        System.out.println("Loja XYZ");
    }

    public static int contarVendedores() {
        return vendedores.size();
    }

    public static int contarClientes() {
        return clientes.size();
    }

    public static void cadastrarGerente() {
        Gerente gerente = new Gerente("Luciana", 40, "Loja XYZ", "São Paulo", "Centro", "Rua das Flores", 5000);
        gerentes.add(gerente);
    }

    public static void criarPedido() {
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Produto A", "Categoria 1", 100.0));
        itens.add(new Item(2, "Produto B", "Categoria 2", 150.0));
        Pedido pedido = new Pedido(1, new Date(), new Date(), new Date(), new Cliente("João", "Rua A, 123"), new Vendedor("Carlos", 30, 1500.00), new Loja(), itens);
        pedidos.add(pedido);
    }
}
