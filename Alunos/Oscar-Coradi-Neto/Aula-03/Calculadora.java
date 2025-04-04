import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {

    public static Scanner scanner = new Scanner(System.in);

    // Classe para registrar os dados de cada venda
    static class Venda {
        int quantidade;
        double valorPlanta;
        double precoTotal;
        double descontoAplicado;

        public Venda(int quantidade, double valorPlanta, double precoTotal, double descontoAplicado) {
            this.quantidade = quantidade;
            this.valorPlanta = valorPlanta;
            this.precoTotal = precoTotal;
            this.descontoAplicado = descontoAplicado;
        }

        @Override
        public String toString() {
            return "Venda: " + quantidade + " plantas, Preço Unitário: R$ " + valorPlanta 
                    + ", Total: R$ " + precoTotal + ", Desconto: R$ " + descontoAplicado;
        }
    }

    // Lista para armazenar todas as vendas realizadas
    static ArrayList<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {

        boolean menu = true;

        while(menu){
            System.out.println("Informe a operação desejada:");
            System.out.println("1 - Cadastrar nova venda");
            System.out.println("2 - Mostrar vendas registradas");
            System.out.println("3 - Calcular troco");
            System.out.println("4 - Sair");

            int op = scanner.nextInt();

            switch(op){
                case 1:
                    // Cadastrar nova venda
                    System.out.println("Informe a quantidade de plantas");
                    int quantidadePlanta = scanner.nextInt();

                    System.out.println("Informe o valor da planta");
                    double valorPlanta = scanner.nextDouble();

                    // Calcular preço total
                    double precoTotal = PrecoTotal(quantidadePlanta, valorPlanta);
                    double descontoAplicado = 0;

                    // Verifica se o desconto é aplicável
                    if(quantidadePlanta > 10){
                        descontoAplicado = precoTotal * 0.05;
                        precoTotal = precoTotal - descontoAplicado;
                        System.out.println("O desconto de 5% foi aplicado!");
                    }

                    // Registra a venda no sistema
                    Venda venda = new Venda(quantidadePlanta, valorPlanta, precoTotal, descontoAplicado);
                    vendas.add(venda);
                    System.out.println("Venda registrada com sucesso!");
                    break;

                case 2:
                    // Exibe todas as vendas registradas
                    System.out.println("Vendas registradas:");
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda v : vendas) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 3:
                    // Calcular o troco
                    if (!vendas.isEmpty()) {
                        System.out.println("Informe o valor recebido:");
                        double valorRecebido = scanner.nextDouble();
                        // Pega o preço total da última venda registrada
                        double ultimoPrecoTotal = vendas.get(vendas.size() - 1).precoTotal;
                        double troco = Troco(valorRecebido, ultimoPrecoTotal);
                        System.out.println("O troco é de: R$ " + troco);
                    } else {
                        System.out.println("Nenhuma venda registrada para calcular o troco.");
                    }
                    break;

                case 4:
                    // Sair do sistema
                    System.out.println("Saindo do sistema...");
                    menu = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        }
    }

    // Função para calcular o preço total da compra
    public static double PrecoTotal(int quantidadePlanta, double valorPlanta){
        return quantidadePlanta * valorPlanta;
    }

    // Função para calcular o troco
    public static double Troco(double valorRecebido, double precoTotal){
        return valorRecebido - precoTotal;
    }
}
