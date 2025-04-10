import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("João", 30, new Endereco("SP", "São Paulo", "Centro", 123, "Apto 45"));
        Vendedor vendedor = new Vendedor("Maria", 28, new Endereco("SP", "São Paulo", "Centro", 123, "Apto 45"));
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
            System.out.println("2. Mostrar descrição de itens");
            System.out.println("3. Ver cliente");
            System.out.println("4. Ver vendedor");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    LocalDateTime agora = LocalDateTime.now();
                    Date dataCriacao = Date.from(agora.atZone(ZoneId.systemDefault()).toInstant());
                    Date vencimento = Date.from(agora.plusDays(1).atZone(ZoneId.systemDefault()).toInstant());

                    Pedido pedido = processador.processar(1, cliente, vendedor, "Loja Central", itens, dataCriacao, vencimento);
                    if (pedido != null) {
                        pedido.gerarDescricaoVenda();
                    }
                    break;
                case 2:
                    for (Item item : itens) {
                        item.gerarDescricao();
                    }
                    break;
                case 3:
                    cliente.apresentarCliente();
                    break;
                case 4:
                    vendedor.apresentarVendedor();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
