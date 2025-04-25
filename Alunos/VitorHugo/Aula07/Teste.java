package Aula07;

import java.util.Date;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Cadastro de Endereço =====");
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Número: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero, complemento);

        System.out.println("\n===== Cadastro de Cliente =====");
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Idade: ");
        int idadeCliente = Integer.parseInt(sc.nextLine());

        Cliente cliente = new Cliente(nomeCliente, idadeCliente, endereco);

        System.out.println("\n===== Cadastro de Vendedor =====");
        System.out.print("Nome do vendedor: ");
        String nomeVendedor = sc.nextLine();
        System.out.print("Idade: ");
        int idadeVendedor = Integer.parseInt(sc.nextLine());
        System.out.print("Loja: ");
        String loja = sc.nextLine();

        Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, endereco, loja);

        System.out.println("\n===== Cadastro de Itens do Pedido =====");
        System.out.print("Quantos itens deseja adicionar? ");
        int quantidade = Integer.parseInt(sc.nextLine());

        Item[] itens = new Item[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nItem " + (i + 1));
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Tipo: ");
            String tipo = sc.nextLine();
            System.out.print("Valor: ");
            double valor = Double.parseDouble(sc.nextLine());
            itens[i] = new Item(id, nome, tipo, valor);
        }

        System.out.println("\nCriando Pedido...");
        Date agora = new Date();
        Date vencimento = new Date(System.currentTimeMillis() + 86400000); // 1 dia depois
        Pedido pedido = new ProcessaPedido().processar(1, cliente, vendedor, loja, itens, agora, agora, vencimento);

        if (pedido != null) {
            pedido.gerarDescricaoVenda();
        }

        sc.close();
    }
}
