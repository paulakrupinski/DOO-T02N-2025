package fag;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.objeto.Cliente;
import fag.objeto.Endereco;
import fag.objeto.Gerente;
import fag.objeto.Item;
import fag.objeto.Pedido;
import fag.objeto.ProcessaPedido;
import fag.objeto.Vendedor;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco endereco = new Endereco("MG", "Belo Horizonte", "Centro", "123", "Apto 101");
        Cliente cliente = new Cliente("João", 30, endereco);
        Vendedor vendedor = new Vendedor("Carlos", 28, endereco, "My Plant", 2000.0, Arrays.asList(2100.0, 2200.0, 2300.0));
        Gerente gerente = new Gerente("Fernanda", 40, endereco, "My Plant", 5000.0, Arrays.asList(5200.0, 5300.0, 5400.0));

        ProcessaPedido processa = new ProcessaPedido();

        int opcao;
        do {
            System.out.println("\n--- Menu My Plant ---");
            System.out.println("1. Dados do cliente");
            System.out.println("2. Dados do vendedor");
            System.out.println("3. Dados do gerente");
            System.out.println("4. Criar pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente.apresentarSe();
                    cliente.getEndereco().apresentarLogradouro();
                    break;
                case 2:
                    vendedor.apresentarSe();
                    System.out.printf("Média Salarial: R$ %.2f\n", vendedor.calcularMedia());
                    System.out.printf("Bônus: R$ %.2f\n", vendedor.calcularBonus());
                    vendedor.getEndereco().apresentarLogradouro();
                    break;
                case 3:
                    gerente.apresentarSe();
                    System.out.printf("Média Salarial: R$ %.2f\n", gerente.calcularMedia());
                    System.out.printf("Bônus: R$ %.2f\n", gerente.calcularBonus());
                    gerente.getEndereco().apresentarLogradouro();
                    break;
                case 4:
                    Pedido pedido = processa.processar(1, cliente, vendedor, "My Plant");

                    System.out.println("\n--- Itens do Pedido ---");
                    for (Item item : pedido.getItens()) {
                        item.gerarDescricao();
                    }

                    System.out.println("\n--- Resumo do Pedido ---");
                    pedido.gerarDescricaoVenda();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}