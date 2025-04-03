package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
    
    public static Scanner scan = new Scanner(System.in);
    public static List<ListaPlantas> listaPlantas = new ArrayList<>();
    public static int[][] vendas = new int[12][31];
    public static List<Loja> lojas = new ArrayList<>();
    public static Vendedor vendedor;
    public static Cliente cliente;   
    
    public static void main(String[] args) {
        int op = 0;
        while (op != 9) {
            System.out.println("\nDigite de acordo com o que deseja realizar:");
            System.out.println("1 - Cadastrar Loja, Vendedor e Cliente");
            System.out.println("2 - Calcular Preço Total");
            System.out.println("3 - Calcular Troco");
            System.out.println("4 - Checar Registro de Vendas (Plantas)");
            System.out.println("5 - Consultar Vendas por Dia específico");
            System.out.println("6 - Apresentar Vendedor, Cliente e Loja (última loja cadastrada)");
            System.out.println("7 - Calcular Média dos Salários do Vendedor");
            System.out.println("8 - Calcular Bônus do Vendedor (por nome) na última loja cadastrada");
            System.out.println("9 - Sair");
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
                System.out.println("Encerrando o programa.");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void cadastrarDados() {
      
        System.out.println("Digite o nome fantasia da loja:");
        String nomeFantasia = scan.nextLine();
        System.out.println("Digite a razão social da loja:");
        String razaoSocial = scan.nextLine();
        System.out.println("Digite o CNPJ da loja:");
        String cnpj = scan.nextLine();
        System.out.println("Digite a cidade da loja:");
        String cidadeLoja = scan.nextLine();
        System.out.println("Digite o bairro da loja:");
        String bairroLoja = scan.nextLine();
        System.out.println("Digite a rua da loja:");
        String ruaLoja = scan.nextLine();
        Loja novaLoja = new Loja(nomeFantasia, razaoSocial, cnpj, cidadeLoja, bairroLoja, ruaLoja);
        lojas.add(novaLoja);
        
 
        System.out.println("Digite o nome do vendedor:");
        String nomeVendedor = scan.nextLine();
        System.out.println("Digite a idade do vendedor:");
        int idadeVendedor = scan.nextInt();
        scan.nextLine(); 
        System.out.println("Digite o salário base do vendedor:");
        double salarioBase = scan.nextDouble();
        scan.nextLine();
       
        vendedor = new Vendedor(nomeVendedor, idadeVendedor, novaLoja, cidadeLoja, bairroLoja, ruaLoja, salarioBase);
        novaLoja.adicionarVendedor(vendedor);
        
  
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scan.nextLine();
        System.out.println("Digite a idade do cliente:");
        int idadeCliente = scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a cidade do cliente:");
        String cidadeCliente = scan.nextLine();
        System.out.println("Digite o bairro do cliente:");
        String bairroCliente = scan.nextLine();
        System.out.println("Digite a rua do cliente:");
        String ruaCliente = scan.nextLine();
        cliente = new Cliente(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente);
        novaLoja.adicionarCliente(cliente);
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
        System.out.println(vendedor);  
        System.out.println(cliente);   
        System.out.println(lojas.get(lojas.size()-1));      
    }
}
