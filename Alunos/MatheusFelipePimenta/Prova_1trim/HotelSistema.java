import java.util.*;

public class HotelSistema {
    static List<Cliente> clientes = new ArrayList<>();
    static List<Quarto> quartos = new ArrayList<>();
    static List<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {

            
            
            System.out.println(" \nEscolha uma opção do menu: \n");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar quarto");
            System.out.println("3. Fazer reserva");
            System.out.println("4. Check-in");
            System.out.println("5. Check-out");
            System.out.println("6. Verificar disponibilidade");
            System.out.println("Sair \n");
          
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> cadastrarCliente(sc);
                case 2 -> cadastrarQuarto(sc);
                case 3 -> fazerReserva(sc);
                case 4 -> checkIn(sc);
                case 5 -> checkOut(sc);
                case 6 -> verificarDisponibilidade(sc);
            }
        } while (opcao != 0);
        sc.close();
    }

    private static void cadastrarCliente(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        clientes.add(new Cliente(nome, cpf));
        System.out.println("Cliente cadastrado com sucesso!\n");
    }

    private static void cadastrarQuarto(Scanner sc) {
        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Tipo (1-Simples, 2-Duplo): ");
        int tipo = sc.nextInt();
        if (tipo == 1) quartos.add(new QuartoSimples(numero));
        else quartos.add(new QuartoDuplo(numero));
        System.out.println("Quarto cadastrado com sucesso!\n");
    }

    private static void fazerReserva(Scanner sc) {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        Cliente cliente = clientes.stream().filter(c -> c.cpf.equals(cpf)).findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.\n");
            return;
        }
        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        Quarto quarto = quartos.stream().filter(q -> q.numero == numero).findFirst().orElse(null);
        if (quarto == null || quarto.ocupado) {
            System.out.println("Quarto indisponível.\n");
            return;
        }
        sc.nextLine();
        try {
            System.out.print("Data de entrada (dd/MM/yyyy): ");
            Date entrada = new GregorianCalendar().getTime(); // simplificado para testes
            System.out.print("Data de saída (dd/MM/yyyy): ");
            Date saida = new GregorianCalendar().getTime(); // simplificado para testes
            quarto.ocupado = true;
            reservas.add(new Reserva(cliente, quarto, entrada, saida));
            System.out.println("Reserva realizada com sucesso!\n");
        } catch (Exception e) {
            System.out.println("Erro nas datas.\n");
        }
    }

    private static void checkIn(Scanner sc) {
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        System.out.println("Check-in realizado para cliente " + cpf + "\n");
    }

    private static void checkOut(Scanner sc) {
        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        Reserva reserva = reservas.stream().filter(r -> r.quarto.numero == numero).findFirst().orElse(null);
        if (reserva != null) {
            reserva.quarto.ocupado = false;
            double total = reserva.calcularTotal();
            reservas.remove(reserva);
            System.out.printf("Check-out realizado. Total a pagar: R$ %.2f\n\n", total);
        } else {
            System.out.println("Reserva não encontrada.\n");
        }
    }

    private static void verificarDisponibilidade(Scanner sc) {
        System.out.print("Número do quarto: ");
        int numero = sc.nextInt();
        Quarto quarto = quartos.stream().filter(q -> q.numero == numero).findFirst().orElse(null);
        if (quarto != null && quarto.isDisponivel()) {
            System.out.println("Quarto disponível.\n");
        } else {
           System.out.println("Quarto ocupado ou cheio");
        }
    }
}
