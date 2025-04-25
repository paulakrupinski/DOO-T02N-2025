package domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Loja {
    private static String nomeFantasia = "My Plant";
    private static String razaoSocial = "My Plant";
    private static String cnpj = "0000000000";
    private static Endereco endereco;
    private static List<Vendedor> vendedores = new ArrayList<Vendedor>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Item> itens = new ArrayList<Item>();
    public static List<Gerente> gerentes = new ArrayList<Gerente>();
    static Scanner sc = new Scanner(System.in);

    public static void criarPedido() {
        //Fiz assim só para não ter que inserir cliente e vendedor na hora de testar
        Cliente cliente = new Cliente("TESTE", 18, new Endereco("teste", "teste", "teste", "teste", "teste"));
        clientes.add(cliente);

        Vendedor vendedor = new Vendedor("TESTE", 18, 2000, new Endereco("teste", "teste", "teste", "teste", "teste"));
        vendedores.add(vendedor);

        Item[] itensPedido = new Item[1];
        itensPedido[0] = new Item("1", "Planta", "Planta", 50.0);


        if (vendedores.isEmpty() || clientes.isEmpty() || itensPedido == null) {
            System.out.println("Não há vendedores, clientes ou itens suficientes.");
            return;
        }

        ProcessaPedido processaPedido = new ProcessaPedido();

        String id = "1";
        Date dataCriacao = new java.util.Date();
        Date dataPagamento = new Date();
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + 86400000);

        Pedido pedido = processaPedido.processar(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, itensPedido);

        if (pedido != null) {
            System.out.println("Pedido criado com sucesso!");
            pedido.gerarDescricaoVenda();
        } else {
            System.out.println("Erro ao criar o pedido.");
        }
    }

    public static void apresentarse() {
        System.out.println("Nome: " + nomeFantasia + "\nCNPJ: " + cnpj + "\nEndereço: ");
        endereco.apresentarLogradouro();
    }

    public static Endereco cadastrarEndereco() {
        System.out.println("Estado: ");
        String estado = sc.next();

        System.out.println("Cidade: ");
        String cidade = sc.nextLine();
        sc.next();

        System.out.println("Bairro: ");
        String bairro = sc.nextLine();
        sc.next();

        System.out.println("Número: ");
        String numero = sc.next();

        System.out.println("Complemento: ");
        String complemento = sc.next();

        return endereco = new Endereco(estado, cidade, bairro, numero, complemento);
    }

    public static void cadastrarGerente() {
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        System.out.println("Salário: ");
        double salarioBase = sc.nextDouble();

        endereco = cadastrarEndereco();

        Gerente gerente = new Gerente(nome, idade, salarioBase, endereco);
        gerentes.add(gerente);
    }

    public static void cadastrarVendedor() {
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        System.out.println("Salário: ");
        double salarioBase = sc.nextDouble();

        endereco = cadastrarEndereco();

        Vendedor vendedor = new Vendedor(nome, idade, salarioBase, endereco);

        vendedores.add(vendedor);
        System.out.println("Vendedor cadastrado com sucesso!");
    }

    public static void cadastrarCliente() {
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Idade: ");
        int idade = sc.nextInt();

        endereco = cadastrarEndereco();

        Cliente cliente = new Cliente(nome, idade, endereco);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    public static void apresentarVendedores() {
        for (Vendedor vendedor : vendedores) {
            vendedor.apresentarse();
        }
    }

    public static void apresentarClientes() {
        for (Cliente cliente : clientes) {
            cliente.apresentarse();
        }
    }

    public static void calcularMediaPeloNome() {
        System.out.println("Calcular média salarial pelo nome: ");
        String nome = sc.nextLine();

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equals(nome)) {
                System.out.println(vendedor.calcularMedia());
            } else {
                System.out.println("Vendedor não encontrado!");
            }
        }
    }

    public static void calcularBonusPeloNome() {
        System.out.println("Calcular bônus salarial");
        System.out.println("Nome: ");
        String nome = sc.nextLine();

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equals(nome)) {
                System.out.println(vendedor.calcularBonus());
            }
        }
    }

    public static int contarVendedores() {
        return vendedores.size();
    }

    public static int contarClientes() {
        return clientes.size();
    }


    public String getNomeFantasia() {
        return nomeFantasia;
    }

}
