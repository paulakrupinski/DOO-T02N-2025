package Aula6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Loja loja = new Loja();
        System.out.println("=== Cadastro da Loja ===");
        System.out.print("Nome Fantasia: ");
        loja.nomeFantasia = scanner.nextLine();
        System.out.print("Razão Social: ");
        loja.razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        loja.cnpj = scanner.nextLine();
        System.out.print("Cidade: ");
        loja.cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        loja.bairro = scanner.nextLine();
        System.out.print("Rua: ");
        loja.rua = scanner.nextLine();

    
        System.out.print("\nQuantos clientes deseja cadastrar? ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); 
        loja.clientes = new Cliente[numClientes];

        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = new Cliente();
            System.out.println("\nCliente " + (i + 1));
            System.out.print("Nome: ");
            cliente.nome = scanner.nextLine();
            System.out.print("Idade: ");
            cliente.idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Cidade: ");
            cliente.cidade = scanner.nextLine();
            System.out.print("Bairro: ");
            cliente.bairro = scanner.nextLine();
            System.out.print("Rua: ");
            cliente.rua = scanner.nextLine();
            loja.clientes[i] = cliente;
        }

        
        System.out.print("\nQuantos vendedores deseja cadastrar? ");
        int numVendedores = scanner.nextInt();
        scanner.nextLine();
        loja.vendedores = new Vendedor[numVendedores];

        for (int i = 0; i < numVendedores; i++) {
            Vendedor vendedor = new Vendedor();
            System.out.println("\nVendedor " + (i + 1));
            System.out.print("Nome: ");
            vendedor.nome = scanner.nextLine();
            System.out.print("Idade: ");
            vendedor.idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Cidade: ");
            vendedor.cidade = scanner.nextLine();
            System.out.print("Bairro: ");
            vendedor.bairro = scanner.nextLine();
            System.out.print("Rua: ");
            vendedor.rua = scanner.nextLine();
            System.out.print("Salário base: ");
            vendedor.salarioBase = scanner.nextDouble();

            vendedor.salarioRecebido = new double[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Salário recebido mês " + (j + 1) + ": ");
                vendedor.salarioRecebido[j] = scanner.nextDouble();
            }
            scanner.nextLine(); 
            vendedor.loja = loja;
            loja.vendedores[i] = vendedor;
        }


        System.out.println("\n=== Dados da Loja ===");
        loja.apresentarse();
        System.out.println("Total de Clientes: " + loja.contarClientes());
        System.out.println("Total de Vendedores: " + loja.contarVendedores());

        System.out.println("\n=== Clientes Cadastrados ===");
        for (Cliente cliente : loja.clientes) {
            cliente.apresentarse();
            System.out.println();
        }

        System.out.println("=== Vendedores Cadastrados ===");
        for (Vendedor vendedor : loja.vendedores) {
            vendedor.apresentarse();
            System.out.println("Média Salarial: " + vendedor.calcularMedia());
            System.out.println("Bônus: " + vendedor.calcularBonus());
            System.out.println();
        }

        scanner.close();
    }
}
