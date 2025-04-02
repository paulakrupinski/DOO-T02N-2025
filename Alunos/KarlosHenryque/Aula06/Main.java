import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-99", "Centro", "Comercial", "Rua das Flores");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Vendedor");
            System.out.println("2. Adicionar Cliente");
            System.out.println("3. Exibir Informacoes da Loja");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Vendedor: ");
                    String nomeV = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeV = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeV = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairroV = scanner.nextLine();
                    System.out.print("Rua: ");
                    String ruaV = scanner.nextLine();
                    System.out.print("Salario Base: ");
                    double salarioBase = scanner.nextDouble();
                    double[] salarios = {salarioBase, salarioBase + 200, salarioBase + 100};
                    loja.adicionarVendedor(new Vendedor(nomeV, idadeV, loja.getNomeFantasia(), cidadeV, bairroV, ruaV, salarioBase, salarios));
                    System.out.println("Vendedor adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome do Cliente: ");
                    String nomeC = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeC = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeC = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairroC = scanner.nextLine();
                    System.out.print("Rua: ");
                    String ruaC = scanner.nextLine();
                    loja.adicionarCliente(new Cliente(nomeC, idadeC, cidadeC, bairroC, ruaC));
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 3:
                    loja.apresentarse();
                    System.out.println("Total de clientes: " + loja.contarClientes());
                    System.out.println("Total de vendedores: " + loja.contarVendedores());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
}