package Prova_1TRI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        executar();
        
    }

    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        Funcionalidades funcionalidade = new Funcionalidades();
        Clientes cliente = new Clientes();
        Quartos quarto = new Quartos();

        boolean executando = true;

        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar quarto");
            System.out.println("3. Fazer check-in");
            System.out.println("4. Fazer check-out");
            System.out.println("5. Calcular valor total da reserva");
            System.out.println("6. Mostrar quartos disponíveis");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente.cadastrarCliente();
                    break;
                case 2:
                    quarto.cadastrarQuarto();
                    break;
                case 3:
                    funcionalidade.checkIn(cliente, quarto);
                    break;
                case 4:
                    funcionalidade.checkOut(cliente, quarto, true);
                    break;
                case 5:
                    funcionalidade.calcularValorTotal(quarto, 3); 
                    break;
                    case 6:
                    funcionalidade.mostrarQuartosDisponiveis(new Quartos[]{quarto});
                    
                    break;
                case 7:
                    executando = false;
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
