public class logica {

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

}
