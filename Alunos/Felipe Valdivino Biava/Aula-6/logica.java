public class logica {

    //Classe venda 👇
    public static void precoTotal(){
        Venda venda = new Venda();

        System.out.println("Entre com a quantidade");
        venda.setQuantidade(Calculadora.scan.nextInt());

        System.out.println("Entre com o valor: ");
        venda.setValor(Calculadora.scan.nextDouble());

        double valortotal = venda.getQuantidade() * venda.getValor();


        if(venda.getQuantidade() > 10){
            int id = 0;
            venda.setIdDesconto(id);
            venda.incrementaDisconto();
            double valorDesconto = 0.05 * valortotal;
            venda.setDesconto(valorDesconto);
            System.out.println("Preço total: " + valortotal);
            System.out.println("Preço com desconto: " + (valortotal - valorDesconto));
        }else{
            System.out.println("Preço total: " + valortotal);
        }

        Calculadora.listaDeVenda.add(venda);

    }

    public static void calcularTroco(){
        System.out.println("Entre com o valor a ser dado pelo cliente: ");
        double valorDado = Calculadora.scan.nextDouble();

        System.out.println("Entre com o valor total da compra: ");
        double valorCompra = Calculadora.scan.nextDouble();

        double resultado = valorDado - valorCompra;

        System.out.println("O valor do troco é: " + resultado);

    }

    public static void listarVendas(){
        for (int i = 0; i < Calculadora.listaDeVenda.size(); i++) {
            System.out.println(Calculadora.listaDeVenda.get(i));
        }

        if(Calculadora.listaDeVenda.isEmpty()){
            System.out.println("Lista vazia!!");
        }
    }

    //Classe Vendedor 👇

    public static void calcularMedia() {

        Vendedor vendedor = new Vendedor();
        if (vendedor.getSalarioRecebido().length == 0) {
            System.out.println("Nenhum salário registrado.");
            return;
        }

        double soma = 0;
        for (String salario : vendedor.getSalarioRecebido()) {
            soma += Double.parseDouble(salario.replace(",", "."));
        }

        double media = soma / vendedor.getSalarioRecebido().length;
            System.out.println("Média salarial: " + media);
    }

    public static void calcularBonus() {
        Vendedor vendedor = new Vendedor();
        double bonus = Double.parseDouble(vendedor.getSalarioBase().replace(",",".")) * 0.2;
        System.out.println("Cálculo do Bônus: %.2f%n " + bonus);
    }

    public static void apresentarVendedor() {
        Vendedor vendedor = new Vendedor();
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Idade: " + vendedor.getIdade());
        System.out.println("Loja: " + vendedor.getLoja());
    }

    //Classe Cliente 👇

    public static void apresentarCliente(){
        Cliente cliente = new Cliente();

        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Idade: " + cliente.getIdade());
    }

    //Classe Loja 👇

    public void contarClientes() {
        Loja loja = new Loja();
        System.out.println("Quantidade de clientes: " + loja.getListaDeClientes().size());
    }

    public void contarVendedores() {
        Loja loja = new Loja();
        System.out.println("Quantidade de vendedores: " + loja.getListaDeVendedores().size());
    }

    public void apresentarSe() {
        Loja loja = new Loja();
        System.out.println("Nome Fantasia: " + loja.getNomeFantasia());
        System.out.println("CNPJ: " + loja.getCnpj());
        System.out.println("Endereço: " + loja.getRua() + ", " + loja.getBairro() + ", " + loja.getCidade());
    }







}
