package Aula07;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    public static List<Venda>listaDeVenda = new ArrayList<Venda>();

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        //teste para ver se o metodo confirmarPagamento() realmente funciona
        Calendar calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, -2);
        ProcessaPedido processaPedido = new ProcessaPedido();

        processaPedido.setDataVencimentoReserva(calendario.getTime());

        processaPedido.testarConfirmarPedido();

        int op;
        do{
            System.out.println("\n [1] - Calcular Preço Total \n" +
                    " [2] - Calcular Troco \n" +
                    " [3] - Listar vendas \n" +
                    " [4] - Criar Pedido" +
                    " \n" +
                    " [5] - Sair ");
            op = scan.nextInt();

            switch(op){
                case 1:
                    Venda.precoTotal();break;
                case 2:
                    Venda.calcularTroco();break;
                case 3:
                    Venda.listarVendas();break;
                case 4:
                    Cliente cliente = new Cliente();
                    cliente.setNome("Felipe");
                    cliente.setIdade(20);

                    Vendedor vendedor = new Vendedor();
                    vendedor.setNome("Luiz");
                    vendedor.setIdade(30);
                    vendedor.setLoja("Drogaria massa");
                    vendedor.setSalarioBase("1300,00", "1400,00", "1500,00");
                    vendedor.setSalarioRecebido("1300,00", "1400,00", "1500,00");

                    Item item = new Item();
                    item.setNome("Planta1");
                    item.setTipo("Planta");
                    item.setValor(1.99);

                    Endereco endereco = new Endereco();
                    endereco.setCidade("Santa Tereza do Oeste");
                    endereco.setBairro("Jardim União");
                    endereco.setComplemento("Centro");
                    endereco.setEstado("Paraná");
                    endereco.setNumero(1905);

                    Pedido pedido = new Pedido();
                    pedido.gerarDescricaoVenda();
                    break;
                case 5:
                    break;



            }
        }while(op != 5);



        System.out.println("Sistema finalizado!!!");
    }



}


