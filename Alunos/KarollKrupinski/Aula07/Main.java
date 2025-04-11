package Aula07;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Planta Decorativa", "Decoração", 49.90));
        itens.add(new Item(2, "Vaso Pequeno", "Acessório", 29.90));
        
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Rua Principal", "123", "Sala 1");
        Cliente cliente = new Cliente("João Silva", 30, endereco);
        Vendedor vendedor = new Vendedor("Maria Souza", 25, endereco, "My Plant Centro", 2500);
        Gerente gerente = new Gerente("Carlos Oliveira", 35, endereco, "My Plant Centro", 5000);

        while (true) {
            System.out.println("\n=== MENU MY PLANT ===");
            System.out.println("1. Criar novo pedido");
            System.out.println("2. Apresentar informações do gerente");
            System.out.println("3. Apresentar informações do vendedor");
            System.out.println("4. Apresentar informações do cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    ProcessaPedido processador = new ProcessaPedido();
                    Pedido pedido = processador.processar(1, cliente, vendedor, "My Plant Centro", itens);
                    pedido.gerarDescricaoVenda();
                    break;
                case 2:
                    gerente.apresentarse();
                    System.out.printf("Média salarial: R$%.2f\n", gerente.calcularMedia());
                    System.out.printf("Bônus: R$%.2f\n", gerente.calcularBonus());
                    break;
                case 3:
                    vendedor.apresentarse();
                    System.out.printf("Média salarial: R$%.2f\n", vendedor.calcularMedia());
                    System.out.printf("Bônus: R$%.2f\n", vendedor.calcularBonus());
                    break;
                case 4:
                    cliente.apresentarse();
                    cliente.getEndereco().apresentarLogradouro();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}