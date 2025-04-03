import java.util.*;

class Vendedor {
    String nome, loja, cidade, bairro, rua;
    int idade;
    double salarioBase;
    List<Double> salarioRecebido = new ArrayList<>(Arrays.asList(2000.0, 2100.0, 2200.0));

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

    void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Loja {
    String nomeFantasia, razaoSocial, cnpj, cidade, bairro, rua;
    List<Vendedor> vendedores = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

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

class MyPlant {
    static List<String> registroVendas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void calcularPrecoTotal() {
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Preço Unitário: ");
        double preco = scanner.nextDouble();
        double total = quantidade * preco;
        if (quantidade > 10) total *= 0.95;
        System.out.println("Total a pagar: " + total);
        registroVendas.add("Quantidade: " + quantidade + ", Total: " + total);
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

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("[1] - Calcular Preço Total\n[2] - Calcular Troco\n[3] - Mostrar Registro de Vendas\n[4] - Sair");
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
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
