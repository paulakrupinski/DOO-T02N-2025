import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("João", 30, new Endereco("PR", "Cascavel", "Centro", 123, "Apto 45"));
        Vendedor vendedor = new Vendedor("Maria", 28, new Endereco("PR", "Cascavel", "Centro", 123, "Apto 45"));
        Item[] itens = {
                new Item(1, "Vaso", "Decoração", 59.99),
                new Item(2, "Adubo", "Jardinagem", 19.99),
                new Item(3, "Terra vegetal", "Jardinagem", 25.50)
        };

        ProcessaPedido processador = new ProcessaPedido();
        boolean executando = true;

        while (executando) {
    System.out.println("\n===== MENU PRINCIPAL =====");
    System.out.println("1. Criar pedido");
    System.out.println("2. Ver itens");
    System.out.println("3. Ver cliente");
    System.out.println("4. Ver vendedor");
    System.out.println("5. Sair");
    System.out.print("Opção: ");

    int opcao = scanner.nextInt();
    System.out.println();

    switch (opcao) {
        case 1 -> {
            var agora = LocalDateTime.now();
            var dataCriacao = Date.from(agora.atZone(ZoneId.systemDefault()).toInstant());
            var vencimento = Date.from(agora.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());

            var pedido = processador.processar(1, cliente, vendedor, "Loja Central", itens, dataCriacao, vencimento);
            if (pedido != null) pedido.gerarDescricaoVenda();
        }
        case 2 -> {
            for (Item item : itens) item.gerarDescricao();
        }
        case 3 -> cliente.apresentarCliente();
        case 4 -> vendedor.apresentarVendedor();
        case 5 -> {
            System.out.println("Saindo...");
            executando = false;
        }
        default -> System.out.println("Opção inválida.");
    }
}
        scanner.close();
    }
}
