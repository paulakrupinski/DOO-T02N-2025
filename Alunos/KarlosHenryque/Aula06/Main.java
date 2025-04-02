import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
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
