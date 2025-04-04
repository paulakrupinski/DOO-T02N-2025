import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static Loja loja;
		public static Scanner scan = new Scanner(System.in);
		public static List<String> registroVendas = new ArrayList<>();
        public static List<Vendedor> vendedores = new ArrayList<>();
        public static List<Cliente> clientes = new ArrayList<>();
		public static void main(String[] args) {
         loja = new Loja("Loja de Plantas GBRL", "My Plant", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores", vendedores, clientes);


			while(true) {
				System.out.println();
				System.out.println("SISTEMA LOJA DE PLANTAS");
				System.out.println("[1] - Calcular Preço Total");
				System.out.println("[2] - Calcular Troco");
				System.out.println("[3] - Relatório de Vendas");
				System.out.println("[4] - Buscar Vendas");
                System.out.println("[5] - Cadastrar Vendedor");
                System.out.println("[6] - Cadastrar Cliente");
                System.out.println("[7] - Exibir Dados da Loja");
                System.out.println("[8] - Salário Vendedor");
                System.out.println("[0] - Sair");
				System.out.println();
				System.out.print("Escolha uma opção: ");
				int opcao = scan.nextInt();
				scan.nextLine();

				switch(opcao) {

				case 1: 
					precoTotal();
				break;

				case 2: 
					calcularTroco();
				break;

				case 3:
					relatorioVendas();
				break;	

                case 4: 
                    buscarDataVenda();
                break;

				case 5: 
					cadastrarVendedor();
				break;
                case 6:
                    cadastrarCliente();
                break;
                case 7: 
                loja.apresentarse();
                loja.contarVendedores();
                for ( Vendedor vendedor : vendedores){
                    vendedor.apresentarSe();
                }
                loja.contarClientes();
                for( Cliente cliente : clientes){
                    cliente.apresentarse();
                }
                break;
                case 8: 
                for ( Vendedor vendedor : vendedores){
                    vendedor.salarioVer();
                }
                break;
                case 0: 
                    System.out.println("saindo...");
                    return;
				default: 
					System.out.println("Opção inválida!");
				}
			}
		}

		public static void precoTotal() {
			System.out.print("Digite o preco do item: R$");
			double preco = scan.nextDouble();
			System.out.print("Digite a quantidade vendida do item: ");
			double quantidade = scan.nextDouble();
			double total = quantidade * preco;
			double desconto = 0;

            scan.nextLine();
            System.out.print("Insira a data da venda(DD/MM):\n");
            String dataVenda = scan.nextLine();

			if(quantidade > 10) {
				desconto = total * 0.05;
				total -= desconto;
				System.out.print("Desconto aplicado! Valor com o desconto: R$"+total);
				System.out.println();
			} else {
				System.out.print("O preço total da venda: R$"+total);
				System.out.println();
			}

			registrarVendas(quantidade, total, desconto, dataVenda);

		}

		public static void calcularTroco() {
			System.out.print("Digite o valor recebido pelo cliente: R$");
			double valorCliente = scan.nextDouble();
			System.out.print("Digite o valor total da compra: ");
			double valorTotal = scan.nextDouble();


			if(valorCliente < valorTotal) {
				double falta = valorTotal- valorCliente;
				System.out.println("O valor recebido pelo cliente é inferior ao valor total da compra");
				System.out.println("Falta R$"+falta+ " para completar o pagamento");
			} else {
				double troco = valorCliente - valorTotal;
				System.out.println("O troco a ser devolvido é: R$" +troco);
			}
		}

		public static void registrarVendas(double quantidade, double total, double desconto, String dataVenda) {
			String venda = "Quantidade: "+quantidade+ " Total: R$"+total+ " Desconto: R$"+desconto+ " Data: "+dataVenda;
			registroVendas.add(venda);
		}

		public static void relatorioVendas() {
			if(registroVendas.isEmpty()) {
				System.out.println("Nenhuma venda cadastrada!");
			} else {
				System.out.println("=== Relatório de Vendas ===");
				for (String venda : registroVendas) {
					System.out.println(venda);
				}
			}
		}
        
        public static void buscarDataVenda() {
            System.out.println("Digite a Data para a Busca: \n");
            String dataBusca = scan.nextLine();
            double totalVendas = 0;

            for (String data : registroVendas) {
                if(data.contains(dataBusca)) {
                    System.out.println(data);
                    totalVendas += 1;
                }
            }
            System.out.println("Total de vendas encontradas: "+ totalVendas);
        }

        public static void cadastrarVendedor(){
           System.out.println("Insira o nome: ");
           String nome = scan.nextLine();
           System.out.println("Insira sua Idade: ");
           int idade = scan.nextInt();
           scan.nextLine();
           System.out.println("Insira a Loja: ");
           String loja = scan.nextLine();
           System.out.println("Insira a Cidade: ");
           String cidade = scan.nextLine();
           System.out.println("Insira o Bairro: ");
           String bairro = scan.nextLine();
           System.out.println("Insira a Rua: ");
           String rua = scan.nextLine();

           Vendedor vendedor = new Vendedor(nome, idade, loja, cidade, bairro, rua, idade, null);
           vendedores.add(vendedor);
           System.out.println("Vendedor Cadastrado com SUCESSO!");

        }

        public static void cadastrarCliente(){
            System.out.println("Insira o Nome: ");
            String nome = scan.nextLine();
            System.out.println("Insira a Idade: ");
            int idade = scan.nextInt();
            scan.nextLine();
            System.out.println("Insira a Cidade: ");
            String cidade = scan.nextLine();
            System.out.println("Insira a rua: ");
            String rua = scan.nextLine();
            
            Cliente cliente = new Cliente(nome, idade, cidade, cidade, rua);
            clientes.add(cliente);

        }
	}

