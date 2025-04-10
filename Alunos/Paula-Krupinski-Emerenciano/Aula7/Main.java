import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itens = new ArrayList<>();
        ProcessaPedido processador = new ProcessaPedido();

        while (true) {
            System.out.println("--- MENU ---");
            System.out.println("1. Criar novo pedido");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();     

            if (opcao == 1) {
                System.out.print("ID do pedido: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nome do cliente: ");
                String cliente = scanner.nextLine();

                System.out.print("Nome do vendedor: ");
                String vendedor = scanner.nextLine();

                System.out.print("Loja: ");
                String loja = scanner.nextLine();


                System.out.print("Quantos itens deseja adicionar? ");
                int qtdItens = scanner.nextInt();
                scanner.nextLine();

                itens.clear();
                for (int i = 0; i < qtdItens; i++) {
                    System.out.println("Item " + (i + 1));
                    System.out.print("ID: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    itens.add(new Item(itemId, nome, tipo, valor));
                }

                Pedido pedido = processador.processar(id, cliente, vendedor, loja, itens);
                pedido.gerarDescricaoVenda();

            } else if (opcao == 2) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}