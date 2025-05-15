import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        Hotel hotel = new Hotel();

        int opc = 0;

        while (opc !=7){
            System.out.println(">>>> MENU <<<<");
            System.out.println("Adicionar Quarto [1]");
            System.out.println("Listar Quartos [2]");
            System.out.println("Relizar CHECK IN [3]");
            System.out.println("Relizar CHECK OUT [4]");
            System.out.println("Verificar Disponibilidade [5]");
            System.out.println("SAIR [6]");
            opc = scan.nextInt();
            
            switch (opc) {
                case 1: 
                System.out.println("Digite o número do quarto:");
                int num =  scan.nextInt();
                System.out.println("Escolha o tipo de Quarto: [1] SIMPLES [2]DUPLO");
                int tipo = scan.nextInt();

                if(tipo == 1){
                    hotel.adicionarQuarto(new QuartoSimples(num));
                } else{
                    hotel.adicionarQuarto(new QuartoDuplo(num));
                }
                break;

                case 2:
                hotel.listarQuartos();
                break;

                case 3:
                System.out.println("Digite o nome do cliente: ");
                scan.nextLine();  
                String nome = scan.nextLine();
                System.out.println("Digite a idade do cliente: ");
                int idade = scan.nextInt();
                System.out.println("Digite o CPF do cliente: ");
                String cpf = scan.next();

                Cliente cliente = new Cliente(nome, idade, cpf);

                System.out.println("Digite o número do quarto para o check-in: ");
                int numQuartoCheckIn = scan.nextInt();
                System.out.println("Digite a data de entrada (dia): ");
                int dataIn = scan.nextInt();
                System.out.println("Digite a data de saída (dia): ");
                int dataOut = scan.nextInt();
                
                Quarto quartoCheckIn = null;
                for (Quarto quarto : hotel.getQuartos()) {
                    if(quarto.getNum() == numQuartoCheckIn){
                        quartoCheckIn = quarto;
                        break;
                    }
                }
                if(quartoCheckIn != null) {
                    hotel.realizarCheckIn(cliente, quartoCheckIn, dataIn, dataOut);
                }
                break;

                case 4:
                System.out.println("Digite o número do quarto para o check-out: ");
                int numQuartoCheckOut = scan.nextInt();
                
                Quarto quartoCheckOut = null;
                for (Quarto quarto : hotel.getQuartos()) {
                    if (quarto.getNum() == numQuartoCheckOut) {
                        quartoCheckOut = quarto;
                        break;
                    }
                }
                if (quartoCheckOut != null) {
                    hotel.realizarCheckOut(quartoCheckOut);
                } 
                break;

                case 5: 
                System.out.println("Digite o número do quarto:");
                int numQuartoDisp = scan.nextInt();
                System.out.println("Data de entrada (DIA): ");
                int dataInDisp = scan.nextInt();
                System.out.println("Data de Saida: ");
                int dataOutDisp = scan.nextInt();

                Quarto quartoDisp = null;
                for (Quarto quarto : hotel.getQuartos()) {
                    if (quarto.getNum() == numQuartoDisp) {
                        quartoDisp= quarto;
                        break;
            }
        }
        if(quartoDisp != null) {
            if(hotel.verificarDisponibilidade(quartoDisp, dataInDisp, dataOutDisp)) {
                System.out.println("Quarto disponivel");
            } else {
                System.out.println("INDISPONIVEL");
            }
        }
        break;

        case 6: 
        System.out.println("Saindo");
        break;

        default: System.out.println("ERROR");
        break;
        }
    }
}
}
            
    

