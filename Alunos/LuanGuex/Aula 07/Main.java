import system.Cliente;
import system.Endereco;
import system.Gerente;
import system.Item;
import system.Loja;
import system.Pedido;
import system.ProcessarPedido;
import system.Vendedor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int op = 0; 
        int[][] meses = new int[12][];
        float[][] totalVendido = new float[12][];
        float[][] totalDesconto = new float[12][];
        float total = 0;

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < 12; i++) {
            meses[i] = new int[diasPorMes[i]];
            totalVendido[i] = new float[diasPorMes[i]];
            totalDesconto[i] = new float[diasPorMes[i]];
        }
        
        Endereco endCliente1 = new Endereco("PR", "Capitão Lêonidas Marques", "Centro", "Rua Tibagi", 100, "Apto 101");
        Endereco endCliente2 = new Endereco("PR", "Cascavel", "Centro", "Jorge Lacerda", 200, "Apto 202");
        Endereco endCliente3 = new Endereco("PR", "Toledo", "Centro", "Rua Tilambucano", 300, "Casa");
        
        Endereco endVendedor1 = new Endereco("PE", "Xique-Xaque", "Limoeiro", "LaEle", 10, "Sala 1");
        Endereco endVendedor2 = new Endereco("SP", "Santos", "Baixada Santista", "Vila Belmiro", 20, "Sala 2");
        
        Endereco endLoja = new Endereco("SP", "São Paulo", "Centro", "Av. Brasil", 50, "Loja 1");
        
        Cliente[] clientes = {
            new Cliente("Luan", 20, endCliente1),
            new Cliente("Camila", 19, endCliente2),
            new Cliente("Travis Scott", 30, endCliente3)
        };
        
        Vendedor[] vendedores = {
            new Vendedor("Davi Brito", 30, endVendedor1, null, 1450.0),
            new Vendedor("Neymar", 33, endVendedor2, null, 2200.0)      
        };
        
        Gerente gerente = new Gerente("Ana Silva", 40, new Endereco("SP", "São Paulo", "Jardim Paulista", "Av. Paulista", 1500, "Escritório 300"), null, 3500);
        
        Loja myPlant = new Loja("My Plant", "My Plant Ltda", "22.777.666/0001-99", endLoja, clientes, vendedores);

        for (Vendedor vendedor : vendedores) {
            vendedor.setLoja(myPlant);
        }
        gerente.setLoja(myPlant);
        
        
        ProcessarPedido processaPedido = new ProcessarPedido();
        
        while (op != 8) {     
            System.out.println("\n\n[Menu]");
            System.out.println("[1] Calcular o preço total de plantas");
            System.out.println("[2] Calcular troco");
            System.out.println("[3] Relatório de vendas");
            System.out.println("[4] Mostrar pessoas");
            System.out.println("[5] Mostrar informações da loja");
            System.out.println("[6] Criar Pedido");
            System.out.println("[7] [Teste] Processar pedido");
            System.out.println("[8] Sair do programa");
            System.out.println("Digite uma opção: ");
            op = scanner.nextInt();
            
            switch (op) {
                case 1:
                    total = calcularPrecoTotal(scanner, meses, totalDesconto, totalVendido);
                    break;
                case 2:
                    calcularTroco(scanner, total);
                    break;
                case 3:
                    visualizarRelatorio(scanner, meses, totalDesconto, totalVendido);
                    break;
                case 4:
                    mostrarPessoas(clientes, scanner, vendedores, gerente);
                    break;
                case 5:
                    mostrarInformacoesLoja(myPlant);
                    break;
                case 6:
                    Item[] itens = {
                        new Item(1, "Musgo", "Briófita", 39.90),
                        new Item(2, "Pinheiro", "Gimnosperma", 59.90),
                        new Item(3, "Girassol", "Angiosperma", 29.90)
                    };
                    Pedido pedido = processaPedido.processar(clientes[0], vendedores[0], myPlant, itens);
                    System.out.println("\nDescrição do pedido:");
                    pedido.gerarDescricaoVenda();
                    System.out.println("Itens do pedido:");
                    for (Item item : itens) {
                        item.gerarDescricao();
                    }
                    break;
                case 7:
                    processaPedido.testeConfirmarPagamento();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
    
    public static float calcularPrecoTotal(Scanner scanner, int[][] meses, float[][] totalVendido, float[][] totalDesconto) {
        System.out.println("Insira o valor da planta: ");
        float valorP = scanner.nextFloat();
        
        System.out.println("Insira a quantidade de plantas: ");
        int quantP = scanner.nextInt();
        
        System.out.println("Insira o mês (1-12): ");
        int mes = scanner.nextInt() - 1;
        
        if (mes < 0 || mes >= 12) {
            System.out.println("Mês inválido");
            return 0;
        }
        
        System.out.println("Insira o dia: ");
        int dia = scanner.nextInt() - 1;
        
        if (dia < 0 || dia >= meses[mes].length) {
            System.out.println("Dia inválido");
            return 0;
        }
        
        meses[mes][dia] += quantP;
        
        float total = quantP * valorP;
        float desconto = 0;
        
        if (quantP >= 10) {
            desconto = total * 0.05f;
            total -= desconto;
            System.out.println("\nCliente recebeu um desconto de 5%");
        }
        
        System.out.printf("\nO total é de: R$%.2f", total);
        totalVendido[mes][dia] += total;
        totalDesconto[mes][dia] += desconto;
        
        return total;
    }
    
    public static void calcularTroco(Scanner scanner, float total) {
        System.out.println("Insira o dinheiro dado pelo cliente: ");
        float dinheiroC = scanner.nextFloat();
        
        if (dinheiroC < total) {
            System.out.printf("\nCliente está devendo: R$%.2f", total - dinheiroC);
        }
        else {
            System.out.printf("\nO troco do cliente deve ser de: R$%.2f\n", dinheiroC - total);
        }
    }
    
    public static void visualizarRelatorio(Scanner scanner, int[][] meses, float[][] totalVendido, float[][] totalDesconto) {
        System.out.println("\nRelatório de vendas");
        System.out.println("[1] Buscar venda por dia");
        System.out.println("[2] Buscar venda por mês");
        int op = scanner.nextInt();
        
        if (op == 1) {
            System.out.println("Insira o mês (1-12): ");
            int mes = scanner.nextInt() - 1;
            
            if (mes < 0 || mes >= 12) {
                System.out.println("Mês inválido");
                return;
            }
            
            System.out.println("Insira o dia: ");
            int dia = scanner.nextInt() - 1;
            
            if (dia < 0 || dia >= meses[mes].length) {
                System.out.println("Dia inválido");
                return;
            }
            
            System.out.printf("\nQuantidade de plantas vendidas em %d/%d: %d vendas", dia + 1, mes + 1, meses[mes][dia]);
            System.out.printf("\nTotal vendido: R$%.2f", totalVendido[mes][dia]);
            System.out.printf("\nTotal de desconto concedidos: R$%.2f", totalDesconto[mes][dia]);
        }
        else if (op == 2) {
            System.out.println("Insira o mês (1-12): ");
            int mes = scanner.nextInt() - 1;
            
            if (mes < 0 || mes >= 12) {
                System.out.println("Mês inválido");
                return;
            }
            
            int totalPlantasMes = 0;
            float totalReaisMes = 0, totalDescontoMes = 0;
            
            for (int i = 0; i < meses[mes].length; i++) {
                totalPlantasMes += meses[mes][i];
                totalReaisMes += totalVendido[mes][i];
                totalDescontoMes += totalDesconto[mes][i];
            }
            
            System.out.printf("\nQuantidade de plantas vendidas no mês %d: %d vendas", mes + 1, totalPlantasMes);
            System.out.printf("\nTotal vendido no mês: R$%.2f", totalReaisMes);
            System.out.printf("\nTotal de desconto concedidos no mês: R$%.2f", totalDescontoMes);
        }
    }
    
    public static void mostrarPessoas(Cliente[] clientes, Scanner scanner, Vendedor[] vendedores, Gerente gerente) {
        System.out.println("\n[1] Mostrar clientes\n[2] Mostrar vendedores\n[3] Mostrar gerente");
        int op = scanner.nextInt();
        
        if (op == 1) {
            System.out.println("Clientes:");
            for (Cliente cliente : clientes) {
                cliente.apresentaSe();
                System.out.println("-------------------------");
            }
        }
        else if (op == 2) {
            System.out.println("Vendedores:");
            for (Vendedor vendedor : vendedores) {
                vendedor.apresentaSe();
                vendedor.calcularMedia();
                vendedor.calcularBonus();
                System.out.println("-------------------------");
            }
        }
        else if (op == 3) {
            System.out.println("Gerente:");
            gerente.apresentaSe();
            gerente.calcularMedia();
            gerente.calcularBonus();
            System.out.println("-------------------------");
        }
        else {
            System.out.println("Opção inválida!");
        }
    }
    
    public static void mostrarInformacoesLoja(Loja loja) {
        System.out.println("\nInformações da Loja:");
        loja.apresentaSe();
        loja.contarClientes();
        loja.contarVendedores();
        System.out.println();
    }
}
