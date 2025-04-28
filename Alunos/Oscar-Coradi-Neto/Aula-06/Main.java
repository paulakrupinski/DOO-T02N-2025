import java.util.ArrayList;

// Classe Vendedor
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
        
        // Adicionando três valores de salário
        salarioRecebido.add(salarioBase);
        salarioRecebido.add(salarioBase * 1.1);  // Exemplo de valor para o segundo salário
        salarioRecebido.add(salarioBase * 1.2);  // Exemplo de valor para o terceiro salário
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

// Classe Cliente
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

// Classe Loja
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

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

// Classe Principal (para testar as classes)
public class Main {  // Alterado o nome da classe principal para 'Main'
    public static void main(String[] args) {
        // Criando vendedores
        Vendedor vendedor1 = new Vendedor("Carlos", 30, "Loja A", "São Paulo", "Centro", "Rua 1", 2000);
        Vendedor vendedor2 = new Vendedor("Ana", 25, "Loja A", "São Paulo", "Centro", "Rua 2", 2500);

        // Criando clientes
        Cliente cliente1 = new Cliente("João", 35, "São Paulo", "Centro", "Rua 3");
        Cliente cliente2 = new Cliente("Maria", 28, "São Paulo", "Centro", "Rua 4");

        // Criando loja
        Loja loja = new Loja("Loja A", "Razão Social A", "12.345.678/0001-99", "São Paulo", "Centro", "Rua 5");

        // Adicionando vendedores e clientes à loja
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        // Testando os métodos
        vendedor1.apresentarse();
        System.out.println("Média dos salários: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        cliente1.apresentarse();

        loja.apresentarse();
        System.out.println("Quantidade de clientes: " + loja.contarClientes());
        System.out.println("Quantidade de vendedores: " + loja.contarVendedores());
    }
}
