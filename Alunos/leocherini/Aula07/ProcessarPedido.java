package myplant;

import java.util.Date;
import java.util.Scanner;

public class ProcessarPedido {
    public Pedido processarComEntradaUsuario(Scanner scanner, Cliente cliente, Vendedor vendedor, String loja) {
        System.out.println("\n--- CRIAÇÃO DO PEDIDO ---");
        
        System.out.print("Informe o ID do pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Quantos itens deseja adicionar? ");
        int qtdItens = scanner.nextInt();
        scanner.nextLine();
        
        Item[] itens = new Item[qtdItens];
        for (int i = 0; i < qtdItens; i++) {
            System.out.println("\nItem #" + (i + 1));
            System.out.print("Informe o ID do item: ");
            int idItem = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Informe o nome do item: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Informe o tipo do item: ");
            String tipoItem = scanner.nextLine();
            System.out.print("Informe o valor do item: ");
            double valorItem = scanner.nextDouble();
            scanner.nextLine();
            
            itens[i] = new Item(idItem, nomeItem, tipoItem, valorItem);
        }
        
        // Datas: dataCriacao = agora, dataPagamento = null, dataVencimentoReserva = agora + 1 dia
        Date dataCriacao = new Date();
        Date dataPagamento = null;
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + 86400000);
        
        Pedido pedido = new Pedido(idPedido, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        if (confirmarPagamento(pedido)) {
            System.out.println("Pagamento confirmado para o pedido.");
        } else {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
        }
        return pedido;
    }
    
    private boolean confirmarPagamento(Pedido pedido) {
        Date now = new Date();
        return now.compareTo(pedido.getDataVencimentoReserva()) <= 0;
    }
}