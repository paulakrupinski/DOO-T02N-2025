import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
<<<<<<< HEAD
        
        Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-99", "São Paulo", "Centro", "Rua Principal", 2, 2);
        
        int opcao;
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Mostrar Dados da Empresa");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro do Vendedor:");
                    System.out.print("Nome: ");
                    String nomeVendedor = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeVendedor = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Loja: ");
                    String lojaVendedor = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidadeVendedor = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairroVendedor = scanner.nextLine();
                    System.out.print("Rua: ");
                    String ruaVendedor = scanner.nextLine();
                    System.out.print("Salario base: ");
                    double salarioBase = scanner.nextDouble();
                    scanner.nextLine();  

                    Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, lojaVendedor, cidadeVendedor, bairroVendedor, ruaVendedor, salarioBase);
                    loja.adicionarVendedor(vendedor, loja.vendedores.length - 1); 
                    break;

                case 2:
                    System.out.println("Cadastro do Cliente:");
                    System.out.print("Nome: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadeCliente = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Cidade: ");
                    String cidadeCliente = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairroCliente = scanner.nextLine();
                    System.out.print("Rua: ");
                    String ruaCliente = scanner.nextLine();
                    
                    Cliente cliente = new Cliente(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente);
                    loja.adicionarCliente(cliente, loja.clientes.length - 1); 
                    break;

                case 3:
                    loja.apresentarse();
                    loja.contarClientes();
                    loja.contarVendedores();
                    for (int i = 0; i < loja.vendedores.length; i++) {
                        if (loja.vendedores[i] != null) {
                            loja.vendedores[i].apresentarse();
                        }
                    }
                    for (int i = 0; i < loja.clientes.length; i++) {
                        if (loja.clientes[i] != null) {
                            loja.clientes[i].apresentarse();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
=======
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
>>>>>>> 81b82703e40058f8f27258b38f55beb365e243e0
