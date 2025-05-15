import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula06 {

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

    static class Vendedor {
        String nome;
        int idade;
        String loja;
        String cidade;
        String bairro;
        String rua;
        double salarioBase;
        List<Double> salariosRecebidos = new ArrayList<>();

        public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
            this.nome = nome;
            this.idade = idade;
            this.loja = loja;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.salarioBase = salarioBase;
            salariosRecebidos.add(2000.00);
            salariosRecebidos.add(2500.00);
            salariosRecebidos.add(2300.00);
        }

        public void apresentarse() {
            System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        }

        public double calcularMedia() {
            double soma = 0;
            for (double salario : salariosRecebidos) {
                soma += salario;
            }
            return soma / salariosRecebidos.size();
        }

        public double calcularBonus() {
            return salarioBase * 0.2;
        }
    }

    static class Cliente {
        String nome;
        int idade;
        String cidade;
        String bairro;
        String rua;

        public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
            this.nome = nome;
            this.idade = idade;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
        }

        public void apresentarse() {
            System.out.println("Cliente: " + nome + ", Idade: " + idade);
        }
    }

    static class Loja {
        String nomeFantasia;
        String razaoSocial;
        String cpnj;
        String cidade;
        String bairro;
        String rua;
        List<Vendedor> vendedores = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        public Loja(String nomeFantasia, String razaoSocial, String cpnj, String cidade, String bairro, String rua) {
            this.nomeFantasia = nomeFantasia;
            this.razaoSocial = razaoSocial;
            this.cpnj = cpnj;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
        }

        public void contarClientes() {
            System.out.println("Total de clientes: " + clientes.size());
        }

        public void contarVendedores() {
            System.out.println("Total de vendedores: " + vendedores.size());
        }

        public void apresentarse() {
            System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cpnj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
        }

        public void adicionarVendedor(Vendedor vendedor) {
            vendedores.add(vendedor);
        }

        public void adicionarCliente(Cliente cliente) {
            clientes.add(cliente);
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
        
        Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-90", "São Paulo", "Centro", "Rua das Flores, 100");
        
        Vendedor vendedor1 = new Vendedor("João Silva", 28, loja.nomeFantasia, "São Paulo", "Centro", "Rua das Flores", 2500.00);
        Vendedor vendedor2 = new Vendedor("Maria Oliveira", 34, loja.nomeFantasia, "São Paulo", "Centro", "Rua das Flores", 2800.00);
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        
        Cliente cliente1 = new Cliente("Carlos Almeida", 45, "São Paulo", "Centro", "Rua das Flores");
        Cliente cliente2 = new Cliente("Fernanda Souza", 29, "São Paulo", "Centro", "Rua das Flores");
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Mostrar Vendas Realizadas");
            System.out.println("[5] - Buscar Vendas por Mês");
            System.out.println("[6] - Buscar Vendas por Dia");
            System.out.println("[7] - Mostrar Vendedores e Clientes");
            System.out.println("[8] - Sair");
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
                    System.out.println("Vendas realizadas:");
                    for (Venda venda : vendas) {
                        System.out.println(venda);
                    }
                    break;

                case 5:
                    System.out.print("Digite o mês para buscar as vendas: ");
                    int mesBusca = scanner.nextInt();
                    int totalVendasMes = buscarVendasPorMes(vendas, mesBusca);
                    System.out.println("Total de vendas no mês " + mesBusca + ": " + totalVendasMes);
                    break;

                case 6:
                    System.out.print("Digite o dia e mês para buscar as vendas (formato dd mm): ");
                    int diaBusca = scanner.nextInt();
                    int mesBuscaDia = scanner.nextInt();
                    int totalVendasDia = buscarVendasPorDia(vendas, diaBusca, mesBuscaDia);
                    System.out.println("Total de vendas no dia " + diaBusca + "/" + mesBuscaDia + ": " + totalVendasDia);
                    break;

                case 7:
                    System.out.println("Vendedores:");
                    for (Vendedor vendedor : loja.vendedores) {
                        vendedor.apresentarse();
                    }
                    System.out.println("Clientes:");
                    for (Cliente cliente : loja.clientes) {
                        cliente.apresentarse();
                    }
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 8);

        scanner.close();
    }
}

