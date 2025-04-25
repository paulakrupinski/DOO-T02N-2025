package Aula07;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cliente
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Bairro do cliente: ");
        String bairroCliente = scanner.nextLine();

        System.out.print("Cidade do cliente: ");
        String cidadeCliente = scanner.nextLine();

        System.out.print("Estado do cliente: ");
        String estadoCliente = scanner.nextLine();

        System.out.print("Número: ");
        int numeroCliente = scanner.nextInt();
        scanner.nextLine(); // limpa buffer

        System.out.print("Complemento: ");
        String complementoCliente = scanner.nextLine();

        Endereco enderecoCliente = new Endereco(bairroCliente, cidadeCliente, estadoCliente, numeroCliente, complementoCliente);
        Pessoa cliente = new Pessoa(nomeCliente, enderecoCliente);

        // Vendedor
        System.out.print("Nome do vendedor: ");
        String nomeVendedor = scanner.nextLine();

        Endereco enderecoVendedor = new Endereco("Centro", "Cidade V", "UF", 1, "Loja");
        Pessoa vendedor = new Pessoa(nomeVendedor, enderecoVendedor);

        // Itens
        List<Item> itens = new ArrayList<>();
        System.out.print("Quantos itens deseja adicionar? ");
        int qtdItens = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdItens; i++) {
            System.out.print("Nome do item " + (i + 1) + ": ");
            String nomeItem = scanner.nextLine();

            System.out.print("Preço do item " + (i + 1) + ": ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine();

            itens.add(new Item(nomeItem, precoItem));
        }

        // Criação do pedido
        ProcessaPedido pp = new ProcessaPedido();
        Date dataVencimento = new Date(System.currentTimeMillis() + 86400000); // 1 dia a mais
        Pedido pedido = pp.processar(1001, cliente, vendedor, "Loja XPTO", itens, dataVencimento);

        // Exibição
        System.out.println("\n--- Pedido Processado ---");
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("Vendedor: " + vendedor.nome);
        System.out.println("Loja: " + pedido.loja);
        System.out.println("Itens:");
        for (Item item : pedido.itens) {
            System.out.println("- " + item.nome + ": R$" + item.preco);
        }

        if (pedido.dataPagamento != null) {
            System.out.println("Pagamento confirmado em: " + pedido.dataPagamento);
        } else {
            System.out.println("Pagamento ainda não confirmado.");
        }

        scanner.close();
    }
}
