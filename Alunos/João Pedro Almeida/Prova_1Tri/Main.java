import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel hotel = new Hotel(); 

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n Bem Vindo Ao (Hotel Code) Escolha seu serviço Abaixo");
            System.out.println("(1) Cadastre Aqui Seus Clientes");
            System.out.println("(2) Cadastre Aqui qual Quarto");
            System.out.println("(3) Reserve aqui o Quarto");
            System.out.println("(4) Faça aqui seu check-out");
            System.out.println("(5) Veja se tem Quartos Livres");
            System.out.println("(6) Digite para Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite aqui o nome do Cliente -->: ");
                    String nome = input.nextLine();
                    hotel.cadastrarCliente(nome);
                    break;
                case 2:
                    System.out.print("Qual numero do quarto deseja?: ");
                    int numero = input.nextInt();
                    input.nextLine();
                    System.out.print("Escolha qual sera o modelo do quarto (Simples) - (Duplo): ");
                    String tipo = input.nextLine();
                    hotel.cadastrarQuarto(numero, tipo);
                    break;
                case 3:
                    System.out.print("Quantos dias Ira Ficar Hospedado/a? ");
                    int dias = input.nextInt();
                    hotel.reservarQuarto(dias);
                    break;
                case 4:
                    hotel.realizarCheckOut();
                    break;
                case 5:
                    hotel.verificarDisponibilidade();
                    break;
                case 6:
                    System.out.println("Obrido Pela Experiencia, saindo...");
                    break;
                default:
                    System.out.println("nao e uma opcão.");
            }
        }

        input.close();
    }
}
