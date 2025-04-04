public class logica {

    public static void precoTotal(){

        Venda venda = new Venda();

        System.out.println("Entre com a quantidade");
        venda.setQuantidade(Calculadora.scan.nextInt());

        System.out.println("Entre com o valor: ");
        venda.setValor(Calculadora.scan.nextDouble());

        System.out.println("Entre com o mês (1 a 12): ");
        int mes = Calculadora.scan.nextInt();
        System.out.println("Entre com o dia (1 a 30): ");
        int dia = Calculadora.scan.nextInt();


        if (mes < 1 || mes > 12 || dia < 1 || dia > 30) {
            System.out.println("Data inválida!");
            return;
        }

        Calculadora.vendasPorDia[mes - 1][dia - 1] += venda.getQuantidade();

        double valorTotal = venda.getQuantidade() * venda.getValor();

        if (venda.getQuantidade() > 10) {
            venda.setIdDesconto(0);
            venda.incrementaDesconto();

            double valorDesconto = 0.05 * valorTotal;
            venda.setDesconto(valorDesconto);

            System.out.println("Preço total: " + valorTotal);
            System.out.println("Preço com desconto: " + (valorTotal - valorDesconto));
        } else {
            System.out.println("Preço total: " + valorTotal);
        }

        Calculadora.listaDeVenda.add(venda);
    }



    public static void calcularTroco(){
        System.out.println("Entre co" +
                "m o valor a ser dado pelo cliente: ");
        double valorDado = Calculadora.scan.nextDouble();

        System.out.println("Entre com o valor total da compra: ");
        double valorCompra = Calculadora.scan.nextDouble();

        double troco = valorDado - valorCompra;
        System.out.println("O valor do troco é: " + troco);
    }

    public static void listarVendas(){
        if (Calculadora.listaDeVenda.isEmpty()) {
            System.out.println("Lista vazia!!");
        } else {
            for (Venda venda : Calculadora.listaDeVenda) {
                System.out.println(venda);
            }
        }
    }

    public static void buscarVendasPorDia() {
        System.out.println("Entre com o mês (1 a 12): ");
        int mes = Calculadora.scan.nextInt();

        System.out.println("Entre com o dia (1 a 30): ");
        int dia = Calculadora.scan.nextInt();

        if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 30) {
            int totalVendas = Calculadora.vendasPorDia[mes - 1][dia - 1];
            System.out.println("Total de vendas no dia " + dia + "/" + mes + " = " + totalVendas);
        } else {
            System.out.println("Data inválida!");
        }
    }

}

