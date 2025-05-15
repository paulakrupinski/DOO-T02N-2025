import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula04 {

    static class Venda {
        int quantidade;
        double precoUnitario;
        double valorTotal;
        double desconto;
        int dia;
        int mes;

        public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, int dia, int mes) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
            this.dia = dia;
            this.mes = mes;
        }

        @Override
        public String toString() {
            return "Data: " + dia + "/" + mes + " - Quantidade: " + quantidade + ", Preço Unitário: R$ " + precoUnitario +
                   ", Valor Total: R$ " + valorTotal + ", Desconto: R$ " + desconto;
        }
    }

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularDesconto(double precoTotal, int quantidade) {
        if (quantidade > 10) {
            return precoTotal * 0.05;
        }
        return 0;
    }

    public static void registrarVenda(List<Venda> vendas, int quantidade, double precoUnitario, double valorTotal, double desconto, int dia, int mes) {
        vendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto, dia, mes));
    }

    public static int buscarVendasPorMes(List<Venda> vendas, int mes) {
        int totalVendas = 0;
        for (Venda venda : vendas) {
            if (venda.mes == mes) {
                totalVendas += venda.quantidade;
            }
        }
        return totalVendas;
    }

    public static int buscarVendasPorDia(List<Venda> vendas, int dia, int mes) {
        int totalVendas = 0;
        for (Venda venda : vendas) {
            if (venda.dia == dia && venda.mes == mes) {
                totalVendas += venda.quantidade;
            }
        }
        return totalVendas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Mostrar Vendas Realizadas");
            System.out.println("[5] - Buscar Vendas por Mês");
            System.out.println("[6] - Buscar Vendas por Dia");
            System.out.println("[7] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade da planta: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    double desconto = calcularDesconto(precoTotal, quantidade);
                    double valorComDesconto = precoTotal - desconto;
                    System.out.println("Preço Total da compra: R$ " + precoTotal);
                    if (desconto > 0) {
                        System.out.println("Desconto aplicado: R$ " + desconto);
                    } else {
                        System.out.println("Sem desconto aplicado.");
                    }
                    System.out.println("Valor com desconto: R$ " + valorComDesconto);
                    break;

                case 2:
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
                    break;

                case 3:
                    System.out.print("Digite a quantidade da planta: ");
                    int qntdVenda = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitarioVenda = scanner.nextDouble();
                    System.out.print("Digite o dia da venda (1-31): ");
                    int diaVenda = scanner.nextInt();
                    System.out.print("Digite o mês da venda (1-12): ");
                    int mesVenda = scanner.nextInt();
                    double precoTotalVenda = calcularPrecoTotal(qntdVenda, precoUnitarioVenda);
                    double descontoVenda = calcularDesconto(precoTotalVenda, qntdVenda);
                    double valorComDescontoVenda = precoTotalVenda - descontoVenda;
                    registrarVenda(vendas, qntdVenda, precoUnitarioVenda, valorComDescontoVenda, descontoVenda, diaVenda, mesVenda);
                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 4:
                    System.out.println("Vendas Realizadas:");
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda venda : vendas) {
                            System.out.println(venda);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o mês para buscar o total de vendas: ");
                    int mesBusca = scanner.nextInt();
                    int totalVendasMes = buscarVendasPorMes(vendas, mesBusca);
                    System.out.println("Total de vendas no mês " + mesBusca + ": " + totalVendasMes);
                    break;

                case 6:
                    System.out.print("Digite o mês para buscar o total de vendas: ");
                    int mesDiaBusca = scanner.nextInt();
                    System.out.print("Digite o dia para buscar o total de vendas: ");
                    int diaBusca = scanner.nextInt();
                    int totalVendasDia = buscarVendasPorDia(vendas, diaBusca, mesDiaBusca);
                    System.out.println("Total de vendas no dia " + diaBusca + "/" + mesDiaBusca + ": " + totalVendasDia);
                    break;

                case 7:
                    System.out.println("Saindo... Obrigado por usar a calculadora da Dona Gabrielinha!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 7);

        scanner.close();
    }
}
