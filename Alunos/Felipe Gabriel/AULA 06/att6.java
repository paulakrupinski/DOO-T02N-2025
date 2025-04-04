package att5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class att5 {

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularPrecoComDesconto(int quantidade, double precoUnitario) {
        double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
        if (quantidade > 10) {
            double desconto = precoTotal * 0.05; 
            precoTotal -= desconto;
            return precoTotal;
        }
        return precoTotal; 
    }

    public static void registrarVenda(int quantidade, double precoUnitario, ArrayList<venda> registroVendas) {
        double valorTotal = calcularPrecoComDesconto(quantidade, precoUnitario);
        double desconto = calcularPrecoTotal(quantidade, precoUnitario) - valorTotal;

        venda novaVenda = new venda(quantidade, precoUnitario, valorTotal, desconto);
        registroVendas.add(novaVenda);

        System.out.println("Venda registrada com sucesso!");
        System.out.printf("Valor total da venda: R$%.2f\n", valorTotal);
        if (desconto > 0) {
            System.out.printf("Desconto aplicado: R$%.2f\n", desconto);
        }
    }

    public static void exibirRegistroVendas(ArrayList<venda> registroVendas) {
        if (registroVendas.isEmpty()) {
            System.out.println("Não há vendas registradas.");
        } else {
            System.out.println("Registro de Vendas:");
            for (int i = 0; i < registroVendas.size(); i++) {
                venda v = registroVendas.get(i);
                System.out.println("Venda " + (i + 1) + ":");
                System.out.println(v);
                System.out.println("-------------------------------");
            }
        }
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }

    static HashMap<Integer, HashMap<Integer, Integer>> vendasPorMesEDia = new HashMap<>();

    public static void registrarVendasPorDia(int quantidade, int mes, int dia) {
        vendasPorMesEDia.putIfAbsent(mes, new HashMap<>());
        HashMap<Integer, Integer> vendasDia = vendasPorMesEDia.get(mes);
        vendasDia.put(dia, vendasDia.getOrDefault(dia, 0) + quantidade);
    }

    public static int buscarVendasPorMes(int mes) {
        return vendasPorMesEDia.getOrDefault(mes, new HashMap<>()).values().stream().mapToInt(Integer::intValue).sum();
    }

    public static int buscarVendasPorDia(int mes, int dia) {
        return vendasPorMesEDia.getOrDefault(mes, new HashMap<>()).getOrDefault(dia, 0);
    }

    public static void registrarVendedor(ArrayList<Vendedor> vendedores, Scanner scanner) {
        System.out.println("Digite os dados do vendedor:");
        System.out.print("Nome: ");
        String nomeVendedor = scanner.nextLine();
        System.out.print("Idade: ");
        int idadeVendedor = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Loja: ");
        String lojaVendedor = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidadeVendedor = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairroVendedor = scanner.nextLine();
        System.out.print("Rua: ");
        String ruaVendedor = scanner.nextLine();
        System.out.print("Salário base: ");
        double salarioBaseVendedor = scanner.nextDouble();
        scanner.nextLine();  

        Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, lojaVendedor, cidadeVendedor, bairroVendedor, ruaVendedor, salarioBaseVendedor);

        System.out.println("Digite os salários recebidos (Digite 0 para terminar):");
        double salario;
        while (true) {
            System.out.print("Salário: ");
            salario = scanner.nextDouble();
            if (salario == 0) break;
            vendedor.addSalarioRecebido(salario);
        }

        vendedores.add(vendedor);
        System.out.println("Vendedor registrado com sucesso!");
    }

    public static void exibirVendedores(ArrayList<Vendedor> vendedores) {
        if (vendedores.isEmpty()) {
            System.out.println("Não há vendedores registrados.");
        } else {
            for (Vendedor vendedor : vendedores) {
                vendedor.apresentarse();
                System.out.println("Média de salários: " + vendedor.calcularMedia());
                System.out.println("Bônus: " + vendedor.calcularBonus());
                System.out.println("-------------------------------");
            }
        }
    }

    public static void registrarCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.println("Digite os dados do cliente:");
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Idade: ");
        int idadeCliente = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Cidade: ");
        String cidadeCliente = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairroCliente = scanner.nextLine();
        System.out.print("Rua: ");
        String ruaCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente);
        clientes.add(cliente);
        System.out.println("Cliente registrado com sucesso!");
    }

    public static void exibirClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                cliente.apresentarse();
                System.out.println("-------------------------------");
            }
        }
    }

    public static void registrarLoja(ArrayList<Loja> lojas, Scanner scanner) {
        System.out.println("Digite os dados da loja:");
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidadeLoja = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairroLoja = scanner.nextLine();
        System.out.print("Rua: ");
        String ruaLoja = scanner.nextLine();

        Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, cidadeLoja, bairroLoja, ruaLoja);
        lojas.add(loja);
        System.out.println("Loja registrada com sucesso!");
    }

    public static void exibirLojas(ArrayList<Loja> lojas) {
        if (lojas.isEmpty()) {
            System.out.println("Não há lojas registradas.");
        } else {
            for (Loja loja : lojas) {
                loja.apresentarse();
                loja.contarVendedores();
                loja.contarClientes();
                System.out.println("-------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<venda> registroVendas = new ArrayList<>();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Loja> lojas = new ArrayList<>();
        int opcao = 0;

        while (opcao != 7) {

            System.out.println("Escolha uma opção:");
            System.out.println("[1] - Registrar Venda");
            System.out.println("[2] - Exibir Registro de Vendas");
            System.out.println("[3] - Calcular Troco");
            System.out.println("[4] - Registrar Vendas por Dia");
            System.out.println("[5] - Buscar Vendas por Mês ou Dia");
            System.out.println("[6] - Gerenciar Vendedores, Clientes, e Lojas");
            System.out.println("[7] - Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a quantidade de plantas: ");
                int quantidade = scanner.nextInt();
                System.out.print("Digite o preço unitário da planta: R$ ");
                double precoUnitario = scanner.nextDouble();

                registrarVenda(quantidade, precoUnitario, registroVendas);

            } else if (opcao == 2) {
                exibirRegistroVendas(registroVendas);

            } else if (opcao == 3) {
                System.out.print("Digite o valor pago pelo cliente: R$ ");
                double valorPago = scanner.nextDouble();
                System.out.print("Digite o valor total da compra: R$ ");
                double valorTotal = scanner.nextDouble();

                if (valorPago >= valorTotal) {
                    double troco = calcularTroco(valorPago, valorTotal);
                    System.out.printf("Troco a ser devolvido: R$ %.2f\n", troco);
                } else {
                    System.out.println("Erro: O valor pago é insuficiente!");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o mês da venda (1-12): ");
                int mes = scanner.nextInt();
                System.out.print("Digite o dia da venda: ");
                int dia = scanner.nextInt();
                System.out.print("Digite a quantidade de vendas realizadas: ");
                int quantidade = scanner.nextInt();

                registrarVendasPorDia(quantidade, mes, dia);
                System.out.println("Vendas registradas com sucesso!");

            } else if (opcao == 5) {
                System.out.println("[1] Buscar Vendas por Mês");
                System.out

.println("[2] Buscar Vendas por Dia");
                System.out.print("Escolha a opção: ");
                int escolha = scanner.nextInt();

                if (escolha == 1) {
                    System.out.print("Digite o mês para buscar as vendas: ");
                    int mesBusca = scanner.nextInt();
                    int totalVendasMes = buscarVendasPorMes(mesBusca);
                    System.out.println("Total de vendas no mês " + mesBusca + ": " + totalVendasMes);
                } else if (escolha == 2) {
                    System.out.print("Digite o mês para buscar as vendas: ");
                    int mesBusca = scanner.nextInt();
                    System.out.print("Digite o dia para buscar as vendas: ");
                    int diaBusca = scanner.nextInt();
                    int totalVendasDia = buscarVendasPorDia(mesBusca, diaBusca);
                    System.out.println("Total de vendas no dia " + diaBusca + " do mês " + mesBusca + ": " + totalVendasDia);
                }

            } else if (opcao == 6) {
                System.out.println("[1] - Gerenciar Vendedores");
                System.out.println("[2] - Gerenciar Clientes");
                System.out.println("[3] - Gerenciar Lojas");
                System.out.print("Escolha a opção: ");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha == 1) {
                    System.out.println("[1] - Registrar Vendedor");
                    System.out.println("[2] - Exibir Vendedores");
                    System.out.print("Escolha a opção: ");
                    int opcaoVendedor = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoVendedor == 1) {
                        registrarVendedor(vendedores, scanner);
                    } else if (opcaoVendedor == 2) {
                        exibirVendedores(vendedores);
                    }

                } else if (escolha == 2) {
                    System.out.println("[1] - Registrar Cliente");
                    System.out.println("[2] - Exibir Clientes");
                    System.out.print("Escolha a opção: ");
                    int opcaoCliente = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoCliente == 1) {
                        registrarCliente(clientes, scanner);
                    } else if (opcaoCliente == 2) {
                        exibirClientes(clientes);
                    }

                } else if (escolha == 3) {
                    System.out.println("[1] - Registrar Loja");
                    System.out.println("[2] - Exibir Lojas");
                    System.out.print("Escolha a opção: ");
                    int opcaoLoja = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoLoja == 1) {
                        registrarLoja(lojas, scanner);
                    } else if (opcaoLoja == 2) {
                        exibirLojas(lojas);
                    }
                }

            } else if (opcao == 7) {
                System.out.println("Saindo... Até logo!");

            } else {
                System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }
}

class venda {
    private int quantidade;
    private double precoUnitario;
    private double valorTotal;
    private double desconto;

    public venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public String toString() {
        return "Quantidade: " + quantidade + ", Preço Unitário: R$" + precoUnitario + ", Total: R$" + valorTotal + ", Desconto: R$" + desconto;
    }
}

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    }

    public void addSalarioRecebido(double salario) {
        salarioRecebido.add(salario);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (Double salario : salarioRecebido) {
            soma += salario;
        }
        return salarioRecebido.isEmpty() ? 0 : soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

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

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void contarVendedores() {
        System.out.println("Número de vendedores: " + vendedores.size());
    }

    public void contarClientes() {
        System.out.println("Número de clientes: " + clientes.size());
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", Razão Social: " + razaoSocial + ", CNPJ: " + cnpj);
    }
}
