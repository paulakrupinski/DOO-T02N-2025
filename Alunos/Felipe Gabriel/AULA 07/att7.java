import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Endereco {
    private String estado, cidade, bairro, rua, complemento;
    private int numero;

    public Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(rua + ", " + numero + " - " + bairro + ", " + cidade + " - " + estado + ". " + complemento);
    }
}

class Gerente extends Pessoa {
    private String loja;
    private Endereco endereco;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido = new ArrayList<>();

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade);
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        salarioRecebido.add(5000.0);
        salarioRecebido.add(5100.0);
        salarioRecebido.add(5200.0);
    }

    @Override
    public void apresentarse() {
        super.apresentarse();
        System.out.println("Gerente da Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Vendedor extends Pessoa {
    private String loja;
    private Endereco endereco;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade);
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
    }

    public void addSalarioRecebido(double salario) {
        salarioRecebido.add(salario);
    }

    @Override
    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente extends Pessoa {
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade);
        this.endereco = endereco;
    }

    @Override
    public void apresentarse() {
        super.apresentarse();
        System.out.print("Endereço: ");
        endereco.apresentarLogradouro();
    }
}

class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void gerarDescricao() {
        System.out.println("Item " + id + ": " + nome + " - " + tipo + " - R$" + valor);
    }
}

class Pedido {
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<Item> itens;

    public Pedido(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    public void imprimirResumo() {
        System.out.println("Pedido de " + cliente.nome + " com " + vendedor.nome);
        for (Item item : itens) item.gerarDescricao();
        System.out.println("Total: R$" + calcularTotal());
    }
}

class ProcessaPedido {
    public void processar(Pedido pedido) {
        System.out.println("Processando pedido...");
        pedido.imprimirResumo();
        System.out.println("Pedido finalizado.\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Endereco end1 = new Endereco("SP", "São Paulo", "Centro", "Rua A", 123, "Apto 101");
        Endereco end2 = new Endereco("RJ", "Rio de Janeiro", "Copacabana", "Rua B", 456, "Casa");

        Gerente gerente = new Gerente("Carlos", 45, "Loja Central", end1, 6000);
        Vendedor vendedor = new Vendedor("Ana", 30, "Loja Central", end1, 3000);
        Cliente cliente = new Cliente("João", 25, end2);

        Item item1 = new Item(1, "Camisa", "Roupas", 79.90);
        Item item2 = new Item(2, "Tênis", "Calçados", 199.90);

        Pedido pedido = new Pedido(cliente, vendedor);
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        ProcessaPedido processador = new ProcessaPedido();

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Exibir gerente");
            System.out.println("2 - Exibir vendedor");
            System.out.println("3 - Exibir cliente");
            System.out.println("4 - Simular pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    gerente.apresentarse();
                    System.out.println("Média Salarial: R$" + gerente.calcularMedia());
                    System.out.println("Bônus: R$" + gerente.calcularBonus());
                    break;
                case 2:
                    vendedor.apresentarse();
                    vendedor.addSalarioRecebido(3100);
                    vendedor.addSalarioRecebido(3200);
                    System.out.println("Média Salarial: R$" + vendedor.calcularMedia());
                    System.out.println("Bônus: R$" + vendedor.calcularBonus());
                    break;
                case 3:
                    cliente.apresentarse();
                    break;
                case 4:
                    processador.processar(pedido);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
