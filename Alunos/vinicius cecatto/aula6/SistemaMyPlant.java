package aula6;

import java.util.Scanner;

public class SistemaMyPlant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando uma instância da loja com entradas do usuário
        System.out.println("=== CADASTRO DA LOJA ===");
        System.out.print("Digite o nome fantasia da loja: ");
        String nomeFantasia = scanner.nextLine();

        System.out.print("Digite a razão social da loja: ");
        String razaoSocial = scanner.nextLine();

        System.out.print("Digite o CNPJ da loja: ");
        String cnpj = scanner.nextLine();

        System.out.print("Digite a cidade da loja: ");
        String cidadeLoja = scanner.nextLine();

        System.out.print("Digite o bairro da loja: ");
        String bairroLoja = scanner.nextLine();

        System.out.print("Digite a rua da loja: ");
        String ruaLoja = scanner.nextLine();

        Loja minhaLoja = new Loja(nomeFantasia, razaoSocial, cnpj, cidadeLoja, bairroLoja, ruaLoja);

        // Cadastrando vendedores
        System.out.println("\n=== CADASTRO DE VENDEDORES ===");
        System.out.print("Quantos vendedores deseja cadastrar? ");
        int numVendedores = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        for (int i = 1; i <= numVendedores; i++) {
            System.out.println("\n--- Vendedor " + i + " ---");
            System.out.print("Nome: ");
            String nomeVendedor = scanner.nextLine();

            System.out.print("Idade: ");
            int idadeVendedor = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Salário Base: ");
            double salarioBase = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer

            // Endereço do vendedor
            System.out.print("Cidade: ");
            String cidadeVendedor = scanner.nextLine();

            System.out.print("Bairro: ");
            String bairroVendedor = scanner.nextLine();

            System.out.print("Rua: ");
            String ruaVendedor = scanner.nextLine();

            // Criando o vendedor e adicionando à loja
            Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, minhaLoja.nomeFantasia, cidadeVendedor, bairroVendedor, ruaVendedor, salarioBase);
            minhaLoja.vendedores.add(vendedor);
        }

        // Cadastrando clientes
        System.out.println("\n=== CADASTRO DE CLIENTES ===");
        System.out.print("Quantos clientes deseja cadastrar? ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        for (int i = 1; i <= numClientes; i++) {
            System.out.println("\n--- Cliente " + i + " ---");
            System.out.print("Nome: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Idade: ");
            int idadeCliente = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            // Endereço do cliente
            System.out.print("Cidade: ");
            String cidadeCliente = scanner.nextLine();

            System.out.print("Bairro: ");
            String bairroCliente = scanner.nextLine();

            System.out.print("Rua: ");
            String ruaCliente = scanner.nextLine();

            // Criando o cliente e adicionando à loja
            Cliente cliente = new Cliente(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente);
            minhaLoja.clientes.add(cliente);
        }

        // Apresentando informações da loja
        System.out.println("\n=== INFORMAÇÕES DA LOJA ===");
        minhaLoja.apresentarse();
        System.out.println("Quantidade de Vendedores: " + minhaLoja.contarVendedores());
        System.out.println("Quantidade de Clientes: " + minhaLoja.contarClientes());

        // Apresentando informações dos vendedores
        System.out.println("\n=== INFORMAÇÕES DOS VENDEDORES ===");
        for (Vendedor vendedor : minhaLoja.vendedores) {
            vendedor.apresentarse();
            System.out.println("Média de Salários Recebidos: R$ " + vendedor.calcularMedia());
            System.out.println("Bônus: R$ " + vendedor.calcularBonus());
            System.out.println();
        }

        // Apresentando informações dos clientes
        System.out.println("\n=== INFORMAÇÕES DOS CLIENTES ===");
        for (Cliente cliente : minhaLoja.clientes) {
            cliente.apresentarse();
        }

        scanner.close();
    }
}