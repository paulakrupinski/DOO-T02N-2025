import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = null;

        while (opcao != 4) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Exibir Pedido");
            System.out.println("3. Exibir Descrição da Venda");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Idade do Cliente: ");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Estado do Endereço: ");
                    String estadoEndereco = scanner.nextLine();
                    System.out.print("Cidade do Endereço: ");
                    String cidadeEndereco = scanner.nextLine();
                    System.out.print("Bairro do Endereço: ");
                    String bairroEndereco = scanner.nextLine();
                    System.out.print("Rua do Endereço: ");
                    String ruaEndereco = scanner.nextLine();
                    System.out.print("Número do Endereço: ");
                    int numeroEndereco = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Detalhes do Endereço: ");
                    String detalhesEndereco = scanner.nextLine();

                    Endereco endereco = new Endereco(estadoEndereco, cidadeEndereco, bairroEndereco, ruaEndereco, numeroEndereco, detalhesEndereco);
                    Cliente cliente = new Cliente(nomeCliente, idadeCliente, endereco);

                    System.out.print("Nome do Vendedor: ");
                    String nomeVendedor = scanner.nextLine();
                    System.out.print("Loja do Vendedor: ");
                    String lojaVendedor = scanner.nextLine();
                    Vendedor vendedor = new Vendedor(nomeVendedor, idadeCliente, lojaVendedor, endereco);

                    List<Item> itens = new ArrayList<>();
                    boolean adicionarMaisItens = true;

                    while (adicionarMaisItens) {
                        System.out.print("ID do Item: ");
                        int idItem = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome do Item: ");
                        String nomeItem = scanner.nextLine();
                        System.out.print("Categoria do Item: ");
                        String categoriaItem = scanner.nextLine();
                        System.out.print("Preço do Item: ");
                        double precoItem = scanner.nextDouble();
                        scanner.nextLine();

                        Item item = new Item(idItem, nomeItem, categoriaItem, precoItem);
                        itens.add(item);

                        System.out.print("Deseja adicionar mais itens? (sim/não): ");
                        String resposta = scanner.nextLine();
                        if (resposta.equalsIgnoreCase("não")) {
                            adicionarMaisItens = false;
                        }
                    }

                    pedido = processador.processar(
                            101,
                            LocalDate.now(),
                            LocalDate.now(),
                            LocalDate.now().plusDays(2),
                            cliente,
                            vendedor,
                            lojaVendedor,
                            itens
                    );
                    System.out.println("Pedido criado com sucesso!");
                    break;

                case 2:
                    if (pedido != null) {
                        System.out.println("ID do Pedido: " + pedido.id);
                        System.out.println("Data do Pedido: " + pedido.dataCriacao);
                        System.out.println("Cliente: " + pedido.cliente.nome);
                        System.out.println("Vendedor: " + pedido.vendedor.nome);
                    } else {
                        System.out.println("Nenhum pedido foi criado ainda.");
                    }
                    break;

                case 3:
                    if (pedido != null) {
                        pedido.gerarDescricaoVenda();
                    } else {
                        System.out.println("Nenhum pedido foi criado ainda.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}