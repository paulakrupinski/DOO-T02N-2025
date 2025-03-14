package Aula04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aula04 {

    private static List<String> registroVendas = new ArrayList<>();
    private static Map<String, Double> vendasPorDia = new HashMap<>();
    private static Map<String, Double> vendasPorMes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Ver Registro de Vendas");
            System.out.println("[4] - Consultar Vendas por Mês");
            System.out.println("[5] - Consultar Vendas por Dia");
            System.out.println("[6] - Sair");
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
                    mostrarRegistroVendas();
                    break;
                case 4:
                    consultarVendasPorMes(scanner);
                    break;
                case 5:
                    consultarVendasPorDia(scanner);
                    break;
                case 6:
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("\nDigite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();
        
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = precoTotal * 0.05;
            precoTotal -= desconto;
        }

        System.out.println("O preço total da venda é: R$ " + precoTotal);
        if (desconto > 0) {
            System.out.println("Desconto aplicado: R$ " + desconto);
        }

        String registro = "Qtd: " + quantidade + ", Valor: R$ " + precoTotal + ", Desconto: R$ " + desconto;
        registroVendas.add(registro);

        String dia = "Dia " + System.currentTimeMillis();
        String mes = "Mês " + System.currentTimeMillis();

        vendasPorDia.put(dia, vendasPorDia.getOrDefault(dia, 0.0) + precoTotal);
        vendasPorMes.put(mes, vendasPorMes.getOrDefault(mes, 0.0) + precoTotal);
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("\nDigite o valor recebido pelo cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        double troco = valorRecebido - valorTotal;
        if (troco >= 0) {
            System.out.println("O troco a ser dado é: R$ " + troco);
        } else {
            System.out.println("Valor insuficiente. Faltam: R$ " + Math.abs(troco));
        }
    }

    public static void mostrarRegistroVendas() {
        System.out.println("\n=== Registro de Vendas ===");
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            for (String venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }

    public static void consultarVendasPorMes(Scanner scanner) {
        System.out.print("\nDigite o mês para consultar as vendas (Exemplo: Mês 3): ");
        String mes = scanner.next();
        
        if (vendasPorMes.containsKey(mes)) {
            System.out.println("Total de vendas no " + mes + ": R$ " + vendasPorMes.get(mes));
        } else {
            System.out.println("Nenhuma venda registrada para o mês informado.");
        }
    }

    public static void consultarVendasPorDia(Scanner scanner) {
        System.out.print("\nDigite o dia para consultar as vendas (Exemplo: Dia 15): ");
        String dia = scanner.next();
        
        if (vendasPorDia.containsKey(dia)) {
            System.out.println("Total de vendas no " + dia + ": R$ " + vendasPorDia.get(dia));
        } else {
            System.out.println("Nenhuma venda registrada para o dia informado.");
        }
    }
}
