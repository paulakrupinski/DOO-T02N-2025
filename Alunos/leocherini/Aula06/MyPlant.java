package calcMyPlant;
import java.util.Scanner;


public class MyPlant {
    public static void main(String[] args) {
        
        Vendedor[] vendedores = new Vendedor[10];
        Cliente[] clientes = new Cliente[10];
        int countVendedor = 0;
        int countCliente = 0;
        
       
        Loja loja = new Loja("My Plant", "My Plant ", "25.052.520/0001-90", "Cascavel", "Centro", "Rua Cobra", vendedores, clientes);
        double[] salariosFixos = {2000.0, 2100.0, 2200.0, 2300.0};
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1 - Adicionar Vendedor");
            System.out.println("2 - Adicionar Cliente");
            System.out.println("3 - Mostrar Vendedores");
            System.out.println("4 - Mostrar Clientes");
            System.out.println("5 - Mostrar Dados da Loja");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao) {
                case 1:
                    if (countVendedor < vendedores.length) {
                        System.out.print("Insira o Nome do Vendedor: ");
                        String nome = scanner.nextLine();
                        System.out.print("Insira a Idade do Vendedor: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        
                        System.out.println("Escolha um dos salários disponíveis:");
                        for (int i = 0; i < salariosFixos.length; i++) {
                            System.out.println((i + 1) + " - R$ " + salariosFixos[i]);
                        }
                        int escolhaSalario = scanner.nextInt();
                        double salarioEscolhido = (escolhaSalario >= 1 && escolhaSalario <= salariosFixos.length)
                            ? salariosFixos[escolhaSalario - 1] : salariosFixos[0]; 
                        
                        Vendedor v = new Vendedor(nome, idade, loja.getNomeFantasia(),"Cascavel", "Centro", "Rua A",salarioEscolhido, salariosFixos);
                        vendedores[countVendedor] = v;
                        countVendedor++;
                        System.out.println("Vendedor adicionado");
                    } else {
                        System.out.println("Limite atingido");
                    }
                    break;
                case 2:
                    if (countCliente < clientes.length) {
                        System.out.print("Insira o Nome do Cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Insira a Idade do Cliente: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Insira a Cidade do Cliente: ");
                        String cidade = scanner.nextLine();
                        System.out.print("Insira o Bairro do Cliente: ");
                        String bairro = scanner.nextLine();
                        System.out.print("Insira a Rua do Cliente: ");
                        String rua = scanner.nextLine();
                        
                        Cliente c = new Cliente(nome, idade, cidade, bairro, rua);
                        clientes[countCliente] = c;
                        countCliente++;
                        System.out.println("Cliente adicionado");
                    } else {
                        System.out.println("Limite atingida");
                    }
                    break;
                case 3:
                    System.out.println("Lista de Vendedores");
                    for (int i = 0; i < countVendedor; i++) {
                        vendedores[i].apresentarse();
                        System.out.printf("Média dos salários: %.2f\n", vendedores[i].calcularMedia());
                        System.out.printf("Bônus: %.2f\n", vendedores[i].calcularBonus());
                        
                    }
                    break;
                case 4:
                    System.out.println("Lista de Clientes ");
                    for (int i = 0; i < countCliente; i++) {
                        clientes[i].apresentarse();
                       
                    }
                    break;
                case 5:
                    System.out.println(" Dados da Loja");
                    loja.apresentarse();
                    loja.contarClientes();
                    loja.contarVendedores();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 6);
        
        scanner.close();
    }
}


