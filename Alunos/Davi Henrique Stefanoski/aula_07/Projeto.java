package pacote;

import java.util.*;

public class Projeto {
    static List<String> vendas = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static float[][] data = new float[12][31];
    static int cont = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("[1] Calcular Preço Total");
            System.out.println("[2] Calcular Troco");
            System.out.println("[3] Ver Vendas");
            System.out.println("[4] Consultar Vendas por Data");
            System.out.println("[5] Sair");
            System.out.println("[6] Criar Pedido");
            System.out.print("Opção: ");

            int op = scan.nextInt();
            switch (op) {
                case 1 -> calcularPrecoTotal();
                case 2 -> calcularTroco();
                case 3 -> listarVendas();
                case 4 -> consultarPorData();
                case 5 -> {
                    System.out.println("Saindo...");
                    scan.close();
                    return;
                }
                case 6 -> criarPedido();
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    static void calcularPrecoTotal() {
        int qtd;
        float valor;

        while (true) {
            System.out.print("Quantas plantas? ");
            qtd = scan.nextInt();
            if (qtd > 0) break;
            System.out.println("Quantidade deve ser maior que 0.");
        }

        while (true) {
            System.out.print("Valor unitário: ");
            valor = scan.nextFloat();
            if (valor > 0) break;
            System.out.println("Valor deve ser maior que 0.");
        }

        if (qtd > 10) {
            valor *= 0.95f;
            System.out.println("Desconto de 5% aplicado.");
        }

        float total = qtd * valor;
        System.out.printf("Total: R$ %.2f\n", total);

        vendas.add("Venda " + cont++ + ": " + qtd + " plantas - R$ " + String.format("%.2f", valor));
        addMatriz(valor);
    }

    static void calcularTroco() {
        System.out.print("Valor entregue: ");
        float recebido = scan.nextFloat();
        System.out.print("Valor da compra: ");
        float valor = scan.nextFloat();

        if (recebido < valor) {
            System.out.println("Valor insuficiente.");
        } else {
            float troco = recebido - valor;
            System.out.printf("Troco: R$ %.2f\n", troco);
        }
    }

    static void listarVendas() {
        System.out.println("\n--- Vendas Registradas ---");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            vendas.forEach(System.out::println);
        }
    }

    static void addMatriz(float valor) {
        int dia, mes;

        while (true) {
            System.out.print("Dia da venda: ");
            dia = scan.nextInt();
            if (dia > 0 && dia <= 31) break;
            System.out.println("Dia inválido.");
        }

        while (true) {
            System.out.print("Mês da venda (1-12): ");
            mes = scan.nextInt();
            if (mes > 0 && mes <= 12) break;
            System.out.println("Mês inválido.");
        }

        data[mes - 1][dia - 1] += valor;
    }

    static void consultarPorData() {
        int dia, mes;

        while (true) {
            System.out.print("Dia para consultar: ");
            dia = scan.nextInt();
            if (dia > 0 && dia <= 31) break;
            System.out.println("Dia inválido.");
        }

        while (true) {
            System.out.print("Mês para consultar (1-12): ");
            mes = scan.nextInt();
            if (mes > 0 && mes <= 12) break;
            System.out.println("Mês inválido.");
        }

        float total = data[mes - 1][dia - 1];
        if (total == 0) {
            System.out.println("Nenhuma venda nesse dia.");
        } else {
            System.out.printf("Total de vendas em %d/%d: R$ %.2f\n", dia, mes, total);
        }
    }

    static void criarPedido() {
        Date agora = new Date();
        Date vencimento = new Date(agora.getTime() + 100000000L);

        Endereco endereco = new Endereco("PR", "Cascavel", "Centro", "Rua das Acácias", 321, "");
        Cliente cliente = new Cliente("João", 30, endereco);
        Vendedor vendedor = new Vendedor("Carlos", 28, "Loja A", endereco, 2000, 2200, 2100, 2300);
        Loja loja = new Loja("Loja A", "Razão Social A", "12345678000123", "Cascavel", "Centro", "Rua das Acácias");

        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Planta A", "Planta", 50));
        itens.add(new Item(2, "Planta B", "Planta", 60));

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(1, agora, agora, vencimento, cliente, vendedor, loja, itens);

        if (pedido != null) {
            pedido.gerarDescricaoVenda();
        }
    }
}
