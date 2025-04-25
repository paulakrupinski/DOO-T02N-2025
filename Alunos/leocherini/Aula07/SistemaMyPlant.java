package myplant;

import java.util.Date;
import java.util.Scanner;

public class SistemaMyPlant {
    public static void main(String[] args) {
        // Clientes e vendedores fixos, pedidos fixos
        Cliente[] clientes = new Cliente[10];
        Vendedor[] vendedores = new Vendedor[10];
        Pedido[] pedidos = new Pedido[10];
        int countCliente = 0;
        int countVendedor = 0;
        int countPedido = 0;
        
        // Criação da Loja com endereço fixo
        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", 123, "Loja Principal");
        Loja loja = new Loja("My Plant", "My Plant", "25.052.520/0001-90", enderecoLoja);
        
        // Dados fixos de clientes
        clientes[countCliente++] = new Cliente("Mariana", 25, "Cascavel", "Centro", "Rua C");
        clientes[countCliente++] = new Cliente("João", 32, "Cascavel", "Centro", "Rua D");
        
        // Dados fixos de vendedores
        vendedores[countVendedor++] = new Vendedor("Ana", 30, loja.getNomeFantasia(), "Cascavel", "Centro", "Rua A", 2000.0, new double[]{2100.0, 2200.0, 2300.0});
        vendedores[countVendedor++] = new Vendedor("Carlos", 28, loja.getNomeFantasia(), "Cascavel", "Centro", "Rua B", 2000.0, new double[]{2000.0, 2100.0, 2150.0});
        
        // Pedidos fixos
        Item[] itens1 = { new Item(1, "Vaso", "Cerâmica", 50.0), new Item(2, "Terra", "Substrato", 30.0) };
        pedidos[countPedido++] = new Pedido(1, new Date(), new Date(), new Date(System.currentTimeMillis() + 86400000), clientes[0], vendedores[0], loja.getNomeFantasia(), itens1);
        
        Item[] itens2 = { new Item(3, "Adubo", "Orgânico", 25.0), new Item(4, "Semente", "Flor", 10.0) };
        pedidos[countPedido++] = new Pedido(2, new Date(), new Date(), new Date(System.currentTimeMillis() + 86400000), clientes[1], vendedores[1], loja.getNomeFantasia(), itens2);
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n===== MENU MY PLANT =====");
            System.out.println("1 - Criar Pedido (Inserir dados)");
            System.out.println("2 - Listar Pedidos");
            System.out.println("3 - Calcular Valor Total das Compras");
            System.out.println("4 - Mostrar Dados da Loja");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    if (countPedido < pedidos.length) {
                        System.out.println("Selecione o Cliente:");
                        for (int i = 0; i < countCliente; i++) {
                            System.out.println((i + 1) + " - " + clientes[i].getNome());
                        }
                        int indiceCliente = scanner.nextInt() - 1;
                        scanner.nextLine();
                        
                        System.out.println("Selecione o Vendedor:");
                        for (int i = 0; i < countVendedor; i++) {
                            System.out.println((i + 1) + " - " + vendedores[i].getNome());
                        }
                        int indiceVendedor = scanner.nextInt() - 1;
                        scanner.nextLine();
                        
                        ProcessarPedido processador = new ProcessarPedido();
                        Pedido novoPedido = processador.processarComEntradaUsuario(scanner, clientes[indiceCliente], vendedores[indiceVendedor], loja.getNomeFantasia());
                        pedidos[countPedido++] = novoPedido;
                        System.out.println("Pedido criado com sucesso!");
                    } else {
                        System.out.println("Limite de pedidos atingido!");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Lista de Pedidos ---");
                    for (int i = 0; i < countPedido; i++) {
                        pedidos[i].gerarDescricaoVenda();
                        System.out.println("---------------------");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Valor Total das Compras ---");
                    double totalGeral = 0.0;
                    for (int i = 0; i < countPedido; i++) {
                        totalGeral += pedidos[i].calcularValorTotal();
                    }
                    System.out.printf("Total Geral: R$ %.2f%n", totalGeral);
                    break;
                case 4:
                    loja.apresentarse();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        
        scanner.close();
    }
}