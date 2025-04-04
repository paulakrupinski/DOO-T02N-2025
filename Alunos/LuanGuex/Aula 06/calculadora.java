import java.util.Scanner;

class Vendedor{
    String nome;
    String cidade;
    String bairro;
    String rua;
    Loja loja;
    int idade;
    double salarioBase;
    double[] salarioRecebido;

    public Vendedor(String nome, String cidade, String bairro, String rua, Loja loja, int idade, double salarioBase, double salarioRecebido){
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.loja = loja;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[]{salarioBase, salarioBase, salarioBase};
    }

    public void apresentacaSe(){
        System.out.printf("\nNome: %s\nIdade: %d\nLoja: %s", nome, idade, loja.nomeFantasia);
    }

    public void calcularMedia(){
        double soma = 0;

        for(double salario : salarioRecebido){
            soma += salario;
        }
        
        System.out.printf("\nA média salarial é R$%.2f", soma / salarioRecebido.length);
    }

    public void calcularBonus(){
        System.out.printf("\nO seu bonus é de R$%.2f", salarioBase * 0.20);
    }
}

class Cliente{
    String nome;
    String cidade;
    String bairro;
    String rua;
    int idade;

    public Cliente(String nome, String cidade, String bairro, String rua, int idade){
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.idade = idade;
    }

    void apresentacaSe() {
        System.out.println("\nNome: " + nome + "\nIdade: " + idade);
    }
}

class Loja{
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    Cliente[] clientes;
    Vendedor[] vendedores;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua, Cliente[] clientes, Vendedor[] vendedores){
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public void contarClientes(){
        System.out.printf("\nQuantidade de clientes: %d", clientes.length);
    }

    public void contarVendedores(){
        System.out.printf("\nQuantidade de vendedores: %d", vendedores.length);
    }

    public void apresentacaSe(){
        System.out.printf("\nNome fantasia: %s\nCNPJ: %s\nEndereço: %s, %s, %s", nomeFantasia, cnpj, rua, bairro, cidade);
    }
}

public class calculadora {
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
        };

        Cliente[] clientes = {
            new Cliente("Luan", "Capitão Lêonidas Marques", "Centro", "Rua Tibagi", 20),
            new Cliente("Camila", "Cascavel", "Centro", "Jorge Lacerda", 19),
            new Cliente("Travis Scott", "Toledo", "Centro", "Rua Tilambucano", 30)
        };

        
        Vendedor[] vendedores = {
            new Vendedor("Davi Brito", "Xique-Xaque", "Limoeiro", "LaEle", null, 30, 1450 , 1450),
            new Vendedor("Neymar", "Santos", "Baixada Santista", "Vila Belmiro", null, 33, 2200, 2200)
        };

        Loja myPlant = new Loja("My Plant", "My Plant ltda", "22.777.666/0001-99", "São Paulo", "Centro", "Av. Brasil", clientes, vendedores);

        for (Vendedor vendedor : vendedores) {
            vendedor.loja = myPlant;
        }

        while (op != 6) {     
            System.out.println("\n\n[Menu]\n[1] Calcular o preço total\n[2] Calcular troco\n[3] Relatório de vendas\n[4] Mostrar pessoas\n[5] Mostrar informações da loja\n[6] Sair");
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
                    mostrarPessoas(clientes, scanner, vendedores);
                    break;
                case 5:
                    mostrarInformacoesLoja(myPlant);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    public static float calcularPrecoTotal(Scanner scanner, int[][] meses, float totalVendido[][], float totalDesconto[][]) {
        System.out.println("Insira o valor da planta: ");
        float valorP = scanner.nextFloat();

        System.out.println("Insira a quantidade de plantas: ");
        int quantP = scanner.nextInt();

        System.out.println("Insira o mês (1-12): ");
        int mes = scanner.nextInt() - 1;

        if (mes < 0 || mes >= 12){
            System.out.println("Mês inválido");
            return 0;
        }

        System.out.println("Insira o dia: ");
        int dia = scanner.nextInt() - 1;

        if (dia < 0 || dia >= meses[mes].length){
            System.out.println("Dia inválido");
            return 0;
        }

        meses[mes][dia] += quantP;

        float total = quantP * valorP; float desconto = 0;

        if (quantP >= 10){
            desconto = total * 0.05f;
            total -= desconto;
            System.out.println("\nCliente recebeu um desconto de 5%");
        } 
        
        System.out.printf("\nO total é de: %.2f", total);          
    
        totalVendido[mes][dia] += total;
        totalDesconto[mes][dia] += desconto;
      
        return total;
    }

    public static void calcularTroco(Scanner scanner, float total) {
        System.out.println("Insira o dinheiro dado pelo cliente: ");
        float dinheiroC = scanner.nextFloat();

        if (dinheiroC < total){
            System.out.printf("\nCliente está devendo: R$%.2f", dinheiroC - total);
        }
        
        else{
            System.out.printf("\nO troco do cliente deve ser de: %.2f\n", dinheiroC - total);
        }
    }

    public static void visualizarRelatorio(Scanner scanner, int meses[][], float totalVendido[][], float totalDesconto[][]) {

        System.out.println("\nRelatório de vendas");
        System.out.println("[1] Buscar venda por dia");
        System.out.println("[2] Buscar venda por mês");
        int op = scanner.nextInt();

        if (op == 1){
            System.out.println("Insira o mês (1-12): ");
            int mes = scanner.nextInt() - 1;

            if (mes < 0 || mes >= 12){
                System.out.println("Mês inválido");
                return;
            }

            System.out.println("Insira o dia: ");
            int dia = scanner.nextInt() - 1;

            if (dia < 0 || dia >= meses[mes].length){
                System.out.println("Dia inválido");
                return;
            }

            System.out.printf("\nQuantidade de plantas vendidas em %d/%d: %d vendas", dia + 1, mes + 1, meses[mes][dia]);
            System.out.printf("\nTotal vendido: R$%.2f", totalVendido[mes][dia]);
            System.out.printf("\nTotal de desconto concedidos: R$%.2f", totalDesconto[mes][dia]);
        }

        if (op == 2){
            System.out.println("Insira o mês (1-12): ");
            int mes = scanner.nextInt() - 1;

            if (mes < 0 || mes >= 12){
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

    public static void mostrarPessoas(Cliente[] clientes, Scanner scanner, Vendedor[] vendedores){
        System.out.println("\n[1] Mostrar clientes\n[2] Mostrar vendedores");
        int op = scanner.nextInt();

        if (op == 1) {
            System.out.println("Clientes");
            for (int i = 0; i < clientes.length; i++){
                clientes[i].apresentacaSe();
                System.out.println("\n-------------------------");
            }
        }

        else if (op == 2) {
            System.out.println("Vendedores");
            for(int i = 0; i < vendedores.length; i++){
                vendedores[i].apresentacaSe();
                vendedores[i].calcularMedia();
                vendedores[i].calcularBonus();
                System.out.println("\n-------------------------");

            }
        }

        else{
            System.out.println("\nOpção inválida!");
        }
    }

    public static void mostrarInformacoesLoja(Loja loja){
        System.out.println("\nInformações da Loja");
        loja.apresentacaSe();
        loja.contarClientes();
        loja.contarVendedores();
    }
}
