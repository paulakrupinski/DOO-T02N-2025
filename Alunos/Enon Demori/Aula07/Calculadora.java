package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class Calculadora {
    
    public static Scanner scan = new Scanner(System.in);
    public static List<ListaPlantas> listaPlantas = new ArrayList<>();
    public static int[][] vendas = new int[12][31];
    public static List<Loja> lojas = new ArrayList<>();
    public static Vendedor vendedor;
    public static Cliente cliente;   
    public static Gerente gerente;

    public static void main(String[] args) {
        int op = 0;
        while (op != 11) {
            System.out.println("\nDigite de acordo com o que deseja realizar:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Calcular Preço Total");
            System.out.println("3 - Calcular Troco");
            System.out.println("4 - Checar Registro de Vendas (Plantas)");
            System.out.println("5 - Consultar Vendas por Dia específico");
            System.out.println("6 - Apresentar  Gerente, Vendedor, Cliente e Loja (última loja cadastrada)");
            System.out.println("7 - Calcular Média dos Salários do Vendedor");
            System.out.println("8 - Calcular Bônus do Vendedor (por nome) na última loja cadastrada");
            System.out.println("9 - Criar e Processar Pedido Fake");
            System.out.println("10 - Testar Confirmação de Pagamento de Pedido");
            System.out.println("11 - Sair");
            


            op = scan.nextInt();
            scan.nextLine();

            if (op == 1) {
                cadastrarDados();
            } else if (op == 2) {
                calculadoraPlantas();
            } else if (op == 3) {
                calcularTroco();
            } else if (op == 4) {
                registroPlantas();
            } else if (op == 5) {
                consultaVendas();
            } else if (op == 6) {
                if (!lojas.isEmpty()) {
                    Loja lojaAtual = lojas.get(lojas.size() - 1);
                    apresentarse();
                    System.out.println("Quantidade de clientes: " + lojaAtual.contarClientes());
                    System.out.println("Quantidade de vendedores: " + lojaAtual.contarVendedores());
                } else {
                    System.out.println("Nenhuma loja cadastrada.");
                }
            } else if (op == 7) {
                if (vendedor != null) {
                    System.out.println("Média dos salários do vendedor: " + vendedor.calcularMedia());
                } else {
                    System.out.println("Nenhum vendedor cadastrado.");
                }
            } else if (op == 8) {
                if (!lojas.isEmpty()) {
                    Loja lojaAtual = lojas.get(lojas.size() - 1);
                    System.out.println("Digite o nome do vendedor para calcular o bônus:");
                    String nomeBusca = scan.nextLine();
                    Vendedor vEncontrado = null;
                    for (Vendedor v : lojaAtual.getVendedores()) {
                        if (v.getNome().equalsIgnoreCase(nomeBusca)) {
                            vEncontrado = v;
                            break;
                        }
                    }
                    if (vEncontrado != null) {
                        System.out.println("Bônus do vendedor " + vEncontrado.getNome() + ": " + vEncontrado.calcularBonus());
                    } else {
                        System.out.println("Vendedor não encontrado na última loja cadastrada.");
                    }
                } else {
                    System.out.println("Nenhuma loja cadastrada.");
                }
            } else if (op == 9) {
                Cliente cliente = new Cliente(); 
                Vendedor vendedor = new Vendedor(); 
                Loja loja = new Loja(); 
                Item item1 = new Item(1, "Planta A", "Exótica", 1000.0);
                Item item2 = new Item(2, "Planta B", "Feia", 10.0);
                Item[] itens = {item1, item2};


                ProcessaPedido processador = new ProcessaPedido();
                Pedido novoPedido = processador.processar(1, cliente, vendedor, loja, itens, new Date(System.currentTimeMillis() + 86400000)); 
                novoPedido.gerarDescricaoVenda();
            } else if (op == 10) {
            	Cliente cliente = new Cliente(); 
            	Vendedor vendedor = new Vendedor(); 
            	Loja loja = new Loja(); 
            	Item item1 = new Item(1, "Planta Teste", "Teste", 500.0);
            	Item[] itens = {item1};

   
            	ProcessaPedido processador = new ProcessaPedido();
            	Pedido pedido = processador.processar(1, cliente, vendedor, loja, itens, new Date(System.currentTimeMillis() + 86400000)); 
            	pedido.testarConfirmacaoPagamento();

            }
            else if (op == 11) {
                System.out.println("Encerrando o programa.");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public static void cadastrarDados() {
       
        String cidadeLoja = "Santa";
        String bairroLoja = "Iza";
        String ruaLoja = "Bel";

        Endereco enderecoLoja = new Endereco("PR", "Santa", "Iza", "Bel", 99);
        Loja novaLoja = new Loja("My Plant", "My Plant Lore", "80224557", enderecoLoja);
        lojas.add(novaLoja);
        
        String nomeVendedor = "Lucas";
        int idadeVendedor = 18;
        double salarioBase = 2200.0;
        Endereco enderecoVendedor = new Endereco("PR", cidadeLoja, bairroLoja, ruaLoja, 99);
        Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, novaLoja, enderecoVendedor, salarioBase);
        novaLoja.adicionarVendedor(vendedor);
        Calculadora.vendedor = vendedor;

        Endereco enderecoGerente = new Endereco("PR", cidadeLoja, bairroLoja, ruaLoja, 99);
        Gerente gerente = new Gerente("Claudia", 42, novaLoja, enderecoGerente, 4200.0);
        Calculadora.gerente = gerente;

        
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scan.nextLine();

        System.out.println("Digite a idade do cliente:");
        int idadeCliente = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite o estado do cliente:");
        String estadoCliente = scan.nextLine();
        System.out.println("Digite a cidade do cliente:");
        String cidadeCliente = scan.nextLine();

        System.out.println("Digite o bairro do cliente:");
        String bairroCliente = scan.nextLine();

        System.out.println("Digite a rua do cliente:");
        String ruaCliente = scan.nextLine();

        Endereco enderecoCliente = new Endereco(estadoCliente, cidadeCliente, bairroCliente, ruaCliente, 120);
        Cliente cliente = new Cliente(nomeCliente, idadeCliente, enderecoCliente);
        novaLoja.adicionarCliente(cliente);
        Calculadora.cliente = cliente;

    }

    
    public static void calculadoraPlantas() {
        double valorTotalDescontos = 0;
        System.out.println("Quantas plantas você vai querer?");
        int quantidade = scan.nextInt();
        System.out.println("Qual o preço de cada uma?");
        double valor = scan.nextDouble();
        double total = quantidade * valor;
        System.out.println("Cada planta custa " + valor + " reais, totalizando " + total + " reais.");
        if (quantidade >= 10) {
            valorTotalDescontos = total * 0.05;
            total = total - valorTotalDescontos;
            System.out.println("Como você comprou 10 ou mais, você recebe 5% de desconto (" + valorTotalDescontos + " reais), totalizando " + total + " reais.");
        }
        ListaPlantas planta = new ListaPlantas(quantidade, total, valorTotalDescontos);
        listaPlantas.add(planta);
        System.out.println("Digite o número do mês em que a compra foi realizada:");
        int mes = scan.nextInt();
        System.out.println("Digite o dia da compra:");
        int dia = scan.nextInt();
        if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31) {
            vendas[mes-1][dia-1] += quantidade;
        } else {
            System.out.println("Data inválida. Registro não será salvo.");
        }
    }
    
    public static void calcularTroco() {
        System.out.println("Com quanto você vai pagar?");
        float valorEntregue = scan.nextFloat();
        System.out.println("Qual foi o total da compra?");
        float total = scan.nextFloat();
        if (valorEntregue < total) {
            System.out.println("Dinheiro insuficiente!");
        } else {
            float troco = valorEntregue - total;
            System.out.println("Seu troco é: " + troco + " reais.");
        }
    }
    
    public static void registroPlantas() {
        if (listaPlantas.isEmpty()) {
            System.out.println("Nenhum registro de vendas de plantas.");
        } else {
            System.out.println("\nRegistro de Vendas de Plantas:");
            for (ListaPlantas venda : listaPlantas) {
                System.out.println(venda);
                System.out.println("-------------------------------");
            }
        }
    }
    
    public static void consultaVendas() {
        System.out.println("Digite o mês:");
        int mes = scan.nextInt();
        System.out.println("Digite o dia:");
        int dia = scan.nextInt();
        if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31) {
            System.out.println("No dia " + dia + " do mês " + mes + " foram vendidas " + vendas[mes-1][dia-1] + " plantas.");
        } else {
            System.out.println("Data inválida!");
        }
    }
    
    public static void apresentarse() {
    	System.out.println(lojas.get(lojas.size()-1));    
    	System.out.println(gerente);
    	System.out.println(vendedor);  
        System.out.println(cliente);
          
    }
    
} 
    