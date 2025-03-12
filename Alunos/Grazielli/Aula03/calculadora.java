import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atividade03 {

    static class Venda {
        private int quantidade;
        private double precoUnitario;
        private double valorTotal;
        private double desconto;

        public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }

        @Override
        public String toString() {
            return "Quantidade: " + quantidade + ", Preço Unitário: R$ " + precoUnitario +
                   ", Total: R$ " + valorTotal + ", Desconto: R$ " + desconto;
        }
    }

    public static class CalculadoraVendas {
        private List<Venda> registroVendas = new ArrayList<>();
        private Scanner entrada = new Scanner(System.in);
        private double valorTotal;

        public void calcularValorTotal() {
            System.out.print("Informe o preço unitário da planta: ");
            double precoUnitario = entrada.nextDouble();

            System.out.print("Informe a quantidade de plantas compradas: ");
            int quantidade = entrada.nextInt();

            double desconto = (quantidade > 10) ? (precoUnitario * quantidade * 0.05) : 0;
            valorTotal = (precoUnitario * quantidade) - desconto;

            System.out.printf("O preço total com desconto (se aplicável) é: R$ %.2f%n", valorTotal);
            
            registroVendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
        }

        public void calcularTroco() {
            System.out.print("Informe o valor pago pelo cliente: ");
            double pagamentoRecebido = entrada.nextDouble();

            if (pagamentoRecebido < valorTotal) {
                System.out.println("Erro: Valor insuficiente para a compra!");
            } else {
                double troco = pagamentoRecebido - valorTotal;
                System.out.printf("Troco do cliente: R$ %.2f%n", troco);
            }
        }

        public void exibirRegistroVendas() {
            if (registroVendas.isEmpty()) {
                System.out.println("Nenhuma venda registrada até o momento.");
            } else {
                System.out.println("\nRegistro de Vendas:");
                for (Venda venda : registroVendas) {
                    System.out.println(venda);
                }
            }
        }

        public static void main(String[] args) {
            executarCalculadora();
        }

        public static void executarCalculadora() {
            CalculadoraVendas operacoes = new CalculadoraVendas();
            Scanner entrada = new Scanner(System.in);
            boolean rodando = true;

            while (rodando) {
                System.out.println("\n-- Menu Calculadora --");
                System.out.println("1 - Calcular valor total da compra");
                System.out.println("2 - Calcular troco");
                System.out.println("3 - Exibir registro de vendas");
                System.out.println("4 - Sair");
                System.out.print("Escolha uma opção: ");
                
                int escolha = entrada.nextInt();
                entrada.nextLine();
                
                switch (escolha) {
                    case 1:
                        operacoes.calcularValorTotal();
                        break;
                    case 2:
                        operacoes.calcularTroco();
                        break;
                    case 3:
                        operacoes.exibirRegistroVendas();
                        break;
                    case 4:
                        rodando = false;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        break;
                }
            }
            entrada.close();
        }
    }
}