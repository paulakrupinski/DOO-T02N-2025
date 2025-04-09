import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Professor, deixei o menu funcional, mas com todos os valore ja definidos e todos os metodos ja funcionais

    static Vendedor vendedor1;
    static Gerente gerente1;
    static Cliente cliente;
    static ArrayList<Item> listaItens = new ArrayList<>();
    static ProcessaPedido processador = new ProcessaPedido();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inicializarDados();

        int opcao = -1;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Apresentar Vendedor e Gerente");
            System.out.println("2. Mostrar salário com bônus e média");
            System.out.println("3. Apresentar Cliente");
            System.out.println("4. Adicionar Itens ao Pedido");
            System.out.println("5. Processar Pedido");
            System.out.println("6. Gerar Descrição do Pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    vendedor1.apresentarse();
                    gerente1.apresentarse();
                    break;
                case 2:
                    double bonusVendedor = vendedor1.calcularBonus(vendedor1.getSalarioBase());
                    System.out.println("Salário do vendedor com bônus: R$ " + bonusVendedor);
                    System.out.println("Média salarial do vendedor: R$ " + vendedor1.calcularMedia());

                    double bonusGerente = gerente1.calcularBonus(gerente1.getSalarioBase());
                    System.out.println("Salário do gerente com bônus: R$ " + bonusGerente);
                    System.out.println("Média salarial do gerente: R$ " + gerente1.calcularMedia());
                    break;
                case 3:
                    cliente.apresentarse();
                    break;
                case 4:
                    adicionarItensExemplo(); // reutiliza os itens criados
                    System.out.println("Itens adicionados ao pedido:");
                    for (Item item : listaItens) {
                        item.gerarDescricao();
                    }
                    break;
                case 5:
                    LocalDate hoje = LocalDate.now();
                    LocalDate vencimento = hoje.plusDays(2);
                    processador.processar(1, hoje, hoje, vencimento, cliente, vendedor1, "Loja Curitiba", listaItens);
                    break;
                case 6:
                    if (processador.getPedido() != null) {
                        System.out.println(processador.getPedido().gerarDescricaoVenda());
                    } else {
                        System.out.println("Nenhum pedido foi processado ainda.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
        sc.close();
    }

    // Método para inicializar objetos fixos
    private static void inicializarDados() {
        ArrayList<Double> salariosVendedor = new ArrayList<>();
        salariosVendedor.add(1000.0);
        salariosVendedor.add(1500.0);
        salariosVendedor.add(2000.0);

        ArrayList<Double> salariosGerente = new ArrayList<>();
        salariosGerente.add(3000.0);
        salariosGerente.add(3500.0);
        salariosGerente.add(4000.0);

        vendedor1 = new Vendedor("Vendedor", 20, "Loja Curitiba", 2000.0, salariosVendedor, "vendedor");
        gerente1 = new Gerente("Gerente", 50, "Loja Curitiba", 2800.0, salariosGerente, "gerente");

        Endereco endereco = new Endereco("PR", "Curitiba", "Centro", "Rua das Flores", 123, "Apto 202");
        cliente = new Cliente("Wellington", 24, endereco);
    }

    // Método para adicionar itens ao pedido
    private static void adicionarItensExemplo() {
        listaItens.clear(); // limpa se já tiver
        Item item1 = new Item(1, "Babosa", "Planta", 59.90, 2);
        Item item2 = new Item(2, "Rosa", "Flor", 199.99, 3);
        listaItens.add(item1);
        listaItens.add(item2);
    }
}
