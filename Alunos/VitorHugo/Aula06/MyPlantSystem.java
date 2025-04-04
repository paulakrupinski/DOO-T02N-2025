package Aula06;

import java.util.*;

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, List<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>(salarioRecebido);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public String getNome() {
        return nome;
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
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private Map<String, Integer> vendasDiarias;
    private Map<String, Double> valoresDiarios;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendasDiarias = new HashMap<>();
        this.valoresDiarios = new HashMap<>();
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarVendedores() {
        for (Vendedor vendedor : vendedores) {
            vendedor.apresentarse();
        }
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            cliente.apresentarse();
        }
    }

    public Vendedor buscarVendedor(String nome) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equalsIgnoreCase(nome)) {
                return vendedor;
            }
        }
        return null;
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class MyPlantSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja("My Plant", "My Plant LTDA", "1234567890001", "Cidade X", "Bairro Y", "Rua Z");
        int opcao;

        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Cadastrar Vendedor");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Listar Vendedores");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Calcular Média Salarial");
            System.out.println("6. Calcular Bônus de Vendedor");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeV = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeV = scanner.nextInt();
                    scanner.nextLine();
                    List<Double> salarios = Arrays.asList(2000.0, 2100.0, 2200.0);
                    loja.adicionarVendedor(new Vendedor(nomeV, idadeV, "My Plant", "Cidade X", "Bairro Y", "Rua Z", 2000.0, salarios));
                    System.out.println("Vendedor cadastrado!");
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeC = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeC = scanner.nextInt();
                    scanner.nextLine();
                    loja.adicionarCliente(new Cliente(nomeC, idadeC, "Cidade X", "Bairro Y", "Rua Z"));
                    System.out.println("Cliente cadastrado!");
                    break;
                case 3:
                    loja.listarVendedores();
                    break;
                case 4:
                    loja.listarClientes();
                    break;
                case 5:
                    System.out.print("Nome do vendedor: ");
                    String nomeMedia = scanner.nextLine();
                    Vendedor vendedorMedia = loja.buscarVendedor(nomeMedia);
                    if (vendedorMedia != null) {
                        System.out.println("Média salarial: " + vendedorMedia.calcularMedia());
                    } else {
                        System.out.println("Vendedor não encontrado!");
                    }
                    break;
                case 6:
                    System.out.print("Nome do vendedor: ");
                    String nomeBonus = scanner.nextLine();
                    Vendedor vendedorBonus = loja.buscarVendedor(nomeBonus);
                    if (vendedorBonus != null) {
                        System.out.println("Bônus: " + vendedorBonus.calcularBonus());
                    } else {
                        System.out.println("Vendedor não encontrado!");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
