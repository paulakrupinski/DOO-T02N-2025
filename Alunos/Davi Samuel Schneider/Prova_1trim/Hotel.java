import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    ArrayList<Quarto> quartos = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();

        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("- - - - - - - - - -");
    }

    public void cadastarQuarto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número do quarto");
        String numQuarto = sc.nextLine();

        System.out.println("Diária do quarto");
        Double valorDiaria = sc.nextDouble();

        System.out.println("Tipo do quarto \n1-Simples\t2-Duplo");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            Simples quartoSimples = new Simples(numQuarto, valorDiaria);
            quartos.add(quartoSimples);
            System.out.println("Quarto cadastrado com sucesso!");
            System.out.println("- - - - - - - - - -");
        } else if (tipo == 2) {
            Duplo quartoDuplo = new Duplo(numQuarto, valorDiaria);
            quartos.add(quartoDuplo);
            System.out.println("Quarto cadastrado com sucesso!");
            System.out.println("- - - - - - - - - -");
        } else {
            System.out.println("Tipo inválido!");
            System.out.println("- - - - - - - - - -");
        }
    }

    public void reservarQuarto() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastado!");
            System.out.println("- - - - - - - - - -");
            return;
        }

        Cliente cliente = verificarCadastro();

        if(cliente == null) {
            System.out.println("Cliente não cadastrado!");
            System.out.println("- - - - - - - - - -");
            return;
        }
        Quarto quarto = verificarTipoQuarto();

        Scanner sc = new Scanner(System.in);
        System.out.println("Data de checkIn (DD/MM/AAAA)");
        String dataCheckIn = sc.nextLine();
        System.out.println("Data de checkOut (DD/MM/AAAA)");
        String dataCheckOut = sc.nextLine();
        LocalDate checkIn = LocalDate.parse(dataCheckIn, formatter);
        LocalDate checkOut = LocalDate.parse(dataCheckOut, formatter);


        Reserva reserva = new Reserva(checkOut, checkIn, quarto, cliente);
        cliente.setReserva(reserva);
        reservas.add(reserva);
        System.out.println("Quarto reservado com sucesso!");
        System.out.println("- - - - - - - - - -");
    }

    public void realizarCheckIn() {
        Cliente cliente = verificarCadastro();

        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                reserva.getQuarto().setDisponivel(false);
                System.out.println("Check-in realizado");
                System.out.println("- - - - - - - - - -");
            } else {
                System.out.println("Nenhuma reserva encontrada");
                System.out.println("- - - - - - - - - -");
            }
        }
    }

    public void realizarCheckOut() {
        Cliente cliente = verificarCadastro();

        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {

                relatorioOcupacao(reserva);
                reservas.remove(reserva);
                reserva.getQuarto().setDisponivel(true);
                System.out.println("Check-out realizado");
                System.out.println("- - - - - - - - - -");
                break;
            } else {
                System.out.println("Nenhuma reserva encontrada");
                System.out.println("- - - - - - - - - -");
            }
        }
    }

    public void relatorioOcupacao(Reserva reserva) {
        if (!reservas.isEmpty()) {
            long diasHospedagem = ChronoUnit.DAYS.between(reserva.getCheckIn(), reserva.getCheckOut());
            System.out.println("Perídodo de ocupação: " + diasHospedagem + " dia(s)");
            System.out.println("Valor: " + diasHospedagem * reserva.getQuarto().getValorDiaria());
            System.out.println("- - - - - - - - - -");
        }
    }

    public Cliente verificarCadastro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do hóspede");
        String nomeHospede = sc.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeHospede)) {
                return cliente;
            }
        }
        return null;
    }

    public Quarto verificarTipoQuarto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tipo do quarto \n1-Simples\t2-Duplos");
        int tipo = sc.nextInt();

        for (Quarto quarto : quartos) {
            if (tipo == 1 && quarto instanceof Simples && quarto.isDisponivel()) {
                return quarto;
            } else if (tipo == 2 && quarto instanceof Duplo && quarto.isDisponivel()) {
                return quarto;
            }
        }

        System.out.println("Quarto não disponivel!");
        return null;
    }
}
