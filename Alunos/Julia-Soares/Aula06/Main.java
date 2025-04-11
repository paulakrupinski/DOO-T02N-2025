import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando a loja
        Loja loja = new Loja();
        loja.setNomeFantasia("Loja Exemplo");
        loja.setRazaoSocial("Loja Exemplo LTDA");
        loja.setCnpj("12.345.678/0001-99");
        loja.setCidade("São Paulo");
        loja.setBairro("Centro");
        loja.setRua("Avenida Principal");

        // Criando vendedores
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setNome("Carlos Santos");
        vendedor1.setIdade(40);
        vendedor1.setCidade("São Paulo");
        vendedor1.setBairro("Jardins");
        vendedor1.setRua("Rua C");
        vendedor1.setSalarioBase(3000.00);
        vendedor1.setLoja(loja);

        Vendedor vendedor2 = new Vendedor();
        vendedor2.setNome("Ana Costa");
        vendedor2.setIdade(35);
        vendedor2.setCidade("São Paulo");
        vendedor2.setBairro("Moema");
        vendedor2.setRua("Rua D");
        vendedor2.setSalarioBase(3500.00);
        vendedor2.setLoja(loja);

        loja.setVendedores(new Vendedor[]{vendedor1, vendedor2});

        // Criando clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        cliente1.setIdade(30);
        cliente1.setCidade("São Paulo");
        cliente1.setBairro("Centro");
        cliente1.setRua("Rua A");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Oliveira");
        cliente2.setIdade(25);
        cliente2.setCidade("Rio de Janeiro");
        cliente2.setBairro("Copacabana");
        cliente2.setRua("Rua B");

        loja.setClientes(new Cliente[]{cliente1, cliente2});

        // Menu interativo
        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Apresentar Loja");
            System.out.println("2. Contar Clientes");
            System.out.println("3. Contar Vendedores");
            System.out.println("4. Apresentar Vendedores");
            System.out.println("5. Calcular Média de Salários dos Vendedores");
            System.out.println("6. Calcular Bônus dos Vendedores");
            System.out.println("7. Apresentar Clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    loja.apresentarSe();
                    break;
                case 2:
                    loja.contarClientes();
                    break;
                case 3:
                    loja.contarVendedores();
                    break;
                case 4:
                    for (Vendedor vendedor : loja.getVendedores()) {
                        vendedor.apresentarSe();
                    }
                    break;
                case 5:
                    for (Vendedor vendedor : loja.getVendedores()) {
                        vendedor.calcularMedia();
                    }
                    break;
                case 6:
                    for (Vendedor vendedor : loja.getVendedores()) {
                        vendedor.calcularBonus();
                    }
                    break;
                case 7:
                    for (Cliente cliente : loja.getClientes()) {
                        cliente.apresentarSe();
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}