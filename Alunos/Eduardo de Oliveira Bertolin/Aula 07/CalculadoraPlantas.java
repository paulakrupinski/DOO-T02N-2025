package calculadoraplantas;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class CalculadoraPlantas {
    
    private static final int MESES = 12;
    private static final int DIAS = 31;
    private static int [][] vendas = new int[MESES][DIAS];

    //Calcular Preco Total
    public static double calcularPrecoTotal(int quantidade, double precoUnitario){
        
    return (quantidade * precoUnitario);
        }
    
    //Calcular Desconto
    public static double calcularDesconto(int quantidade, double precoUnitario){
        
        double total = (quantidade * precoUnitario);
        
        if (quantidade > 10){
        return (total * 0.05);
        } 
        
        return 0.0;
        
    }
    
    //Calcular Troco
    public static double calcularTroco(double valorPago, double totalCompraTroco){
    return (valorPago - totalCompraTroco);
    }
    
    //Registrar venda
    public static void registrarVenda(int mes,int dia, int quantidade){
        if((mes >= 1 && mes <= 12) && (dia >= 1 && dia <= 31)){
            vendas [mes - 1][dia - 1] += quantidade;
        } else {
            System.out.println("Data inválida!");
        }
    }
    
    //Consultar venda
    public static int consultarVendas(int mes, int dia){
        if((mes >= 1 && mes <= 12) && (dia >= 1 && dia <= 31)){
            return vendas[mes - 1][dia - 1];
        }
        System.out.println("Data inválida!");
        return -1;
    }
    
    
    
             
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        int totalPlantasVendidas = 0;
            double valorTotalVendas = 0.0;
            double valorTotalTroco = 0.0;
        
        do{
            System.out.println("\n-- Sistema My Plant --");
            System.out.println("[1] - Calcular preço total");
            System.out.println("[2] - Calcular troco");
            System.out.println("[3] - Registro de vendas");
            System.out.println("[4] - Consultar vendas por dia e mês");
            System.out.println("[5] - Criar pedido (teste)");
            System.out.println("[6] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.print("\n");
            
        
            switch (opcao){
            
                case 1:
                    System.out.print("Informe a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Informe o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    System.out.print("Informe o dia da venda (1-31): ");
                    int dia = scanner.nextInt();
                    System.out.print("Informe o mês da venda (1-12): ");
                    int mes = scanner.nextInt();   
                    
                    double desconto = calcularDesconto (quantidade, precoUnitario);
                    double totalCompra = calcularPrecoTotal (quantidade, precoUnitario)
                            - desconto;
                    
                    System.out.println("O preço total é de R$:" + totalCompra);
                    
                    if (desconto > 0.0){
                        System.out.println("Foi aplicado um desconto de R$:" + desconto);
                    }
                    
                    //Registro vendas
                    
                    totalPlantasVendidas += quantidade;
                    valorTotalVendas += totalCompra;
                    valorTotalTroco += desconto;
                    registrarVenda(mes, dia, quantidade);
                    
                    break;
                    
                case 2:
                    System.out.print("Informe o valor total da compra: ");
                    double totalCompraTroco = scanner.nextDouble();
                    System.out.print("Informe o valor pago: ");
                    double valorPago = scanner.nextDouble();
                    
                    double troco = calcularTroco(valorPago, totalCompraTroco);
                    System.out.println("O troco a ser dado é de R$: " + troco);
                    
                    break;
                    
                case 3:
                    System.out.println("Total de plantas vendidas: " + 
                            totalPlantasVendidas);
                    System.out.println("Valor total de vendas R$:" + valorTotalVendas);
                    System.out.println("Valor dos descontos aplicados R$:" + 
                            valorTotalTroco);
                    
                    break;
                    
                case 4:
                    System.out.print("Informe o dia da venda (1-31): ");
                    int diaConsulta = scanner.nextInt();
                    System.out.print("Informe o mês da venda (1-12): ");
                    int mesConsulta = scanner.nextInt();

                        
                    int vendasDoDia = consultarVendas(mesConsulta, diaConsulta);
                    
                    if (vendasDoDia != -1){
                        System.out.println("Quantidade de vendas no dia " + 
                                diaConsulta + "/" + mesConsulta + ": " + vendasDoDia + "\n");
                    }
                
                    break;
                    
                case 5:
                    //Cliente
                    Cliente cliente = new Cliente();
                    cliente.nome = "Lucas";
                    cliente.idade = 20;

                    //Vendedor
                    Vendedor vendedor = new Vendedor();
                    vendedor.nome = "Marina";
                    vendedor.idade = 25;
                    vendedor.loja = "My Plant";

                    // Loja fake
                    Loja loja = new Loja();
                    loja.nomeFantasia = "My Plant";
                    loja.cnpj = "1234567890001";

                    // Endereço
                    Endereco endereco = new Endereco();
                    endereco.rua = "Av. das Flores";
                    endereco.numero = "123";
                    endereco.bairro = "Centro";
                    endereco.cidade = "Cascavel";
                    endereco.complemento = "Sala 5";
                    cliente.endereco = endereco;
                    vendedor.endereco = endereco;
                    loja.endereco = endereco;

                    // Itens
                    Item[] itens = new Item[2];
                    itens[0] = new Item();
                    itens[0].id = 1;
                    itens[0].nome = "Planta 1";
                    itens[0].tipo = "Ornamental";
                    itens[0].valor = 30;

                    itens[1] = new Item();
                    itens[1].id = 2;
                    itens[1].nome = "Planta 2";
                    itens[1].tipo = "Ornamental";
                    itens[1].valor = 45;

                    // Data de vencimento: amanhã
                    Calendar calendario = Calendar.getInstance();
                    calendario.add(Calendar.DATE, 1);
                    Date vencimento = calendario.getTime();

                    // Processa pedido
                    ProcessaPedido processador = new ProcessaPedido();
                    Pedido pedido = processador.processar(1, new Date(), 
                            vencimento, cliente, vendedor, loja, itens);

                    // Mostra resultado
                    pedido.gerarDescricaoVenda();
                    break;

                case 6:
                    System.out.println("Saindo da calculadora, até mais!");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente:");
            } 
        }
        while(opcao != 6);
    }  
}