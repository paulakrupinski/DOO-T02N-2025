import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja("Plantas da Dona Gabrielinha", "Gabrielinha LTDA", "00.000.000/0001-00", "São Paulo", "Centro", "Rua das Flores");

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Apresentar Loja");
            System.out.println("2 - Adicionar Vendedor");
            System.out.println("3 - Adicionar Cliente");
            System.out.println("4 - Mostrar Quantidade de Clientes");
            System.out.println("5 - Mostrar Quantidade de Vendedores");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    loja.apresentarSe();
                    break;

                case 2:
                    System.out.print("Nome do vendedor: ");
                    String nomeVendedor = scanner.nextLine();
                    System.out.print("Idade do vendedor: ");
                    int idadeVendedor = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Cidade do vendedor: ");
                    String cidadeVendedor = scanner.nextLine();
                    System.out.print("Bairro do vendedor: ");
                    String bairroVendedor = scanner.nextLine();
                    System.out.print("Rua do vendedor: ");
                    String ruaVendedor = scanner.nextLine();
                    System.out.print("Salário base do vendedor: ");
                    double salarioBase = scanner.nextDouble();

                    Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, loja, cidadeVendedor, bairroVendedor, ruaVendedor, salarioBase);
                    loja.adicionarVendedor(vendedor);
                    System.out.println("Vendedor adicionado com sucesso!");
                    break;

                case 3:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Idade do cliente: ");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Cidade do cliente: ");
                    String cidadeCliente = scanner.nextLine();
                    System.out.print("Bairro do cliente: ");
                    String bairroCliente = scanner.nextLine();
                    System.out.print("Rua do cliente: ");
                    String ruaCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente);
                    loja.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 4:
                    System.out.println("Quantidade de clientes cadastrados: " + loja.contarClientes());
                    break;

                case 5:
                    System.out.println("Quantidade de vendedores cadastrados: " + loja.contarVendedores());
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
