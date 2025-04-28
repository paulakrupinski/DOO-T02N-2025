package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        

        Endereco enderecoLoja = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", "100", "Sala 1");
        Endereco enderecoFuncionario = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", "200", "Apto 101");
        Endereco enderecoCliente = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", "300", "Apto 202");
        

        Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-90", enderecoLoja);
        

        Vendedor vendedor1 = new Vendedor("João Silva", 28, enderecoFuncionario, loja.nomeFantasia, 2500.00);
        Vendedor vendedor2 = new Vendedor("Maria Oliveira", 34, enderecoFuncionario, loja.nomeFantasia, 2800.00);
        Gerente gerente1 = new Gerente("Carlos Souza", 40, enderecoFuncionario, loja.nomeFantasia, 5000.00);
        
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarGerente(gerente1);
        

        Cliente cliente1 = new Cliente("Carlos Almeida", 45, enderecoCliente);
        Cliente cliente2 = new Cliente("Fernanda Souza", 29, enderecoCliente);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);


        List<Item> itensDisponiveis = new ArrayList<>();
        itensDisponiveis.add(new Item(1, "Rosa", "Flor", 15.90));
        itensDisponiveis.add(new Item(2, "Samambaia", "Planta", 25.50));
        itensDisponiveis.add(new Item(3, "Vaso Pequeno", "Acessório", 30.00));

        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Mostrar Vendas Realizadas");
            System.out.println("[5] - Buscar Vendas por Mês");
            System.out.println("[6] - Buscar Vendas por Dia");
            System.out.println("[7] - Mostrar Vendedores, Gerentes e Clientes");
            System.out.println("[8] - Criar Novo Pedido");
            System.out.println("[9] - Mostrar Pedidos");
            System.out.println("[10] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    registrarVenda(scanner, vendas);
                    break;
                case 4:
                    mostrarVendas(vendas);
                    break;
                case 5:
                    buscarVendasPorMes(scanner, vendas);
                    break;
                case 6:
                    buscarVendasPorDia(scanner, vendas);
                    break;
                case 7:
                    mostrarPessoas(loja);
                    break;
                case 8:
                    criarPedido(scanner, pedidos, itensDisponiveis, loja, cliente1, vendedor1);
                    break;
                case 9:
                    mostrarPedidos(pedidos);
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 10);

        scanner.close();
    }


    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        double precoTotal = quantidade * precoUnitario;
        double desconto = calcularDesconto(precoTotal, quantidade);
        double valorComDesconto = precoTotal - desconto;
        System.out.println("Preço Total da compra: R$ " + precoTotal);
        if (desconto > 0) {
            System.out.println("Desconto aplicado: R$ " + desconto);
        } else {
            System.out.println("Sem desconto aplicado.");
        }
        System.out.println("Valor com desconto: R$ " + valorComDesconto);
    }

    private static double calcularDesconto(double precoTotal, int quantidade) {
        if (quantidade > 10) {
            return precoTotal * 0.05;
        }
        return 0;
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor pago pelo cliente: ");
        double valorPago = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotalCompra = scanner.nextDouble();
        double troco = valorPago - valorTotalCompra;
        if (troco < 0) {
            System.out.println("Valor pago é insuficiente. Não há troco.");
        } else {
            System.out.println("Troco a ser dado: R$ " + troco);
        }
    }

    private static void registrarVenda(Scanner scanner, List<Venda> vendas) {
        System.out.print("Digite a quantidade da planta: ");
        int qntdVenda = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitarioVenda = scanner.nextDouble();
        System.out.print("Digite o dia da venda (1-31): ");
        int diaVenda = scanner.nextInt();
        System.out.print("Digite o mês da venda (1-12): ");
        int mesVenda = scanner.nextInt();
        double precoTotalVenda = qntdVenda * precoUnitarioVenda;
        double descontoVenda = calcularDesconto(precoTotalVenda, qntdVenda);
        double valorComDescontoVenda = precoTotalVenda - descontoVenda;
        vendas.add(new Venda(qntdVenda, precoUnitarioVenda, valorComDescontoVenda, descontoVenda, diaVenda, mesVenda));
        System.out.println("Venda registrada com sucesso!");
    }

    private static void mostrarVendas(List<Venda> vendas) {
        System.out.println("Vendas realizadas:");
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
    }

    private static void buscarVendasPorMes(Scanner scanner, List<Venda> vendas) {
        System.out.print("Digite o mês para buscar as vendas: ");
        int mesBusca = scanner.nextInt();
        int totalVendasMes = 0;
        for (Venda venda : vendas) {
            if (venda.mes == mesBusca) {
                totalVendasMes += venda.quantidade;
            }
        }
        System.out.println("Total de vendas no mês " + mesBusca + ": " + totalVendasMes);
    }

    private static void buscarVendasPorDia(Scanner scanner, List<Venda> vendas) {
        System.out.print("Digite o dia e mês para buscar as vendas (formato dd mm): ");
        int diaBusca = scanner.nextInt();
        int mesBuscaDia = scanner.nextInt();
        int totalVendasDia = 0;
        for (Venda venda : vendas) {
            if (venda.dia == diaBusca && venda.mes == mesBuscaDia) {
                totalVendasDia += venda.quantidade;
            }
        }
        System.out.println("Total de vendas no dia " + diaBusca + "/" + mesBuscaDia + ": " + totalVendasDia);
    }

    private static void mostrarPessoas(Loja loja) {
        System.out.println("\nVendedores:");
        for (Vendedor vendedor : loja.vendedores) {
            vendedor.apresentarse();
            System.out.println("Média salarial: R$ " + vendedor.calcularMedia());
            System.out.println("Bônus: R$ " + vendedor.calcularBonus());
        }
        System.out.println("\nGerentes:");
        for (Gerente gerente : loja.gerentes) {
            gerente.apresentarse();
            System.out.println("Média salarial: R$ " + gerente.calcularMedia());
            System.out.println("Bônus: R$ " + gerente.calcularBonus());
        }
        System.out.println("\nClientes:");
        for (Cliente cliente : loja.clientes) {
            cliente.apresentarse();
            cliente.endereco.apresentarLogradouro();
        }
    }

    private static void criarPedido(Scanner scanner, List<Pedido> pedidos, List<Item> itensDisponiveis, 
                                  Loja loja, Cliente cliente, Vendedor vendedor) {
        System.out.println("Itens disponíveis:");
        for (int i = 0; i < itensDisponiveis.size(); i++) {
            System.out.print("[" + (i+1) + "] ");
            itensDisponiveis.get(i).gerarDescricao();
        }
        
        List<Item> itensPedido = new ArrayList<>();
        int itemEscolhido;
        do {
            System.out.print("Escolha um item (0 para finalizar): ");
            itemEscolhido = scanner.nextInt();
            if (itemEscolhido > 0 && itemEscolhido <= itensDisponiveis.size()) {
                itensPedido.add(itensDisponiveis.get(itemEscolhido-1));
                System.out.println("Item adicionado ao pedido.");
            }
        } while (itemEscolhido != 0);
        
        if (!itensPedido.isEmpty()) {
            ProcessaPedido processador = new ProcessaPedido();
            Pedido novoPedido = processador.processar(
                pedidos.size() + 1,
                new Date(),
                cliente,
                vendedor,
                loja,
                itensPedido,
                3 
            );
            
            pedidos.add(novoPedido);
            System.out.println("Pedido criado com sucesso!");
            novoPedido.gerarDescricaoVenda();
        } else {
            System.out.println("Nenhum item selecionado. Pedido cancelado.");
        }
    }

    private static void mostrarPedidos(List<Pedido> pedidos) {
        System.out.println("Pedidos realizados:");
        for (Pedido pedido : pedidos) {
            System.out.println("\nPedido ID: " + pedido.id);
            pedido.gerarDescricaoVenda();
            System.out.println("Itens:");
            for (Item item : pedido.itens) {
                item.gerarDescricao();
            }
            System.out.println("Status: " + 
                (pedido.dataPagamento != null ? "Pago" : 
                 new Date().after(pedido.dataVencimentoReserva) ? "Vencido" : "Aguardando pagamento"));
        }
    }
}