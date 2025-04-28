import java.util.*;

class Vendedor {
    String nome, loja, cidade, bairro, rua;
    int idade;
    double salarioBase;
    List<Double> salarioRecebido = new ArrayList<>(Arrays.asList(2000.0, 2100.0, 2200.0));

    Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
    }

    void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    String nome, cidade, bairro, rua;
    int idade;

    Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Venda {
    int quantidade;
    double total;

    Venda(int quantidade, double total) {
        this.quantidade = quantidade;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Total: " + total;
    }
}

class Loja {
    String nomeFantasia, razaoSocial, cnpj, cidade, bairro, rua;
    List<Vendedor> vendedores = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    int contarClientes() {
        return clientes.size();
    }

    int contarVendedores() {
        return vendedores.size();
    }

    void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + cidade + ", " + bairro + ", " + rua);
    }
}

public class gabrielinha {
    static List<Venda> registroVendas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Loja loja = new Loja("My Plant", "My Plant LTDA", "1234567890001", "São Paulo", "Centro", "Rua das Flores");

    static void calcularPrecoTotal() {
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Preço Unitário: ");
        double preco = scanner.nextDouble();
        double total = quantidade * preco;
        if (quantidade > 10) {
            total *= 0.95;
        }
        System.out.println("Total a pagar: " + total);
        registroVendas.add(new Venda(quantidade, total));
    }

    static void calcularTroco() {
        System.out.print("Valor recebido: ");
        double recebido = scanner.nextDouble();
        System.out.print("Valor da compra: ");
        double compra = scanner.nextDouble();
        System.out.println("Troco: " + (recebido - compra));
    }

    static void mostrarRegistroVendas() {
        registroVendas.forEach(System.out::println);
    }

    static void cadastrarCliente() {
        scanner.nextLine(); // Consumir quebra de linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        Cliente cliente = new Cliente(nome, idade, cidade, bairro, rua);
        loja.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void cadastrarVendedor() {
        scanner.nextLine(); // Consumir quebra de linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Salário Base: ");
        double salarioBase = scanner.nextDouble();
        Vendedor vendedor = new Vendedor(nome, idade, loja.nomeFantasia, cidade, bairro, rua, salarioBase);
        loja.adicionarVendedor(vendedor);
        System.out.println("Vendedor cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        try {
            boolean executando = true;
            while (executando) {
                System.out.println("[1] - Calcular Preço Total\n[2] - Calcular Troco\n[3] - Mostrar Registro de Vendas\n[4] - Cadastrar Cliente\n[5] - Cadastrar Vendedor\n[6] - Sair");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        calcularPrecoTotal();
                        break;
                    case 2:
                        calcularTroco();
                        break;
                    case 3:
                        mostrarRegistroVendas();
                        break;
                    case 4:
                        cadastrarCliente();
                        break;
                    case 5:
                        cadastrarVendedor();
                        break;
                    case 6:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
