import domain.Cliente;
import domain.Reserva;
import domain.Quarto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        var listaClientes = new ArrayList<Cliente>();
        var listaQuartos = new ArrayList<Quarto>();
        var listaReservas = new ArrayList<Reserva>();
        while (true) {
            menu(listaClientes, listaQuartos, listaReservas);
        }
    }

    public static void menu(ArrayList<Cliente> listaClientes, ArrayList<Quarto> listaQuartos, ArrayList<Reserva> listaReservas) {
        System.out.println("""
                1 - Cadastrar Cliente
                2 - Cadastrar Quarto
                3 - Realizar Reserva
                4 - Realizar Check-in
                5 - Realizar Check-out
                6 - Desligar sistema
                7 - Listar Clientes
                8 - Listar Quartos
                9 - Listar Reservas
                Digite o número da opção desejada:
                """);
        var opcao = scanner.nextInt();
        executaOpcao(listaClientes, listaQuartos, listaReservas, opcao);
    }

    private static void executaOpcao(ArrayList<Cliente> listaClientes, ArrayList<Quarto> listaQuartos, ArrayList<Reserva> listaReservas, Integer opcao) {
        switch (opcao) {
            case 1:
                cadastrarCliente(listaClientes);
                break;
            case 2:
                cadastrarQuarto(listaQuartos);
                break;
            case 3:
                cadastrarReserva(listaReservas, listaQuartos, listaClientes);
                break;
            case 4:
                realizarCheckIn(listaClientes, listaReservas);
                break;
            case 5:
                realizarCheckOut(listaClientes, listaReservas, listaQuartos);
                break;
            case 6:
                System.exit(0);
                break;
            case 7:
                listaClientes.forEach(System.out::println);
                break;
            case 8:
                listaQuartos.forEach(System.out::println);
                break;
            case 9:
                listaReservas.forEach(System.out::println);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void realizarCheckOut(ArrayList<Cliente> listaClientes, ArrayList<Reserva> listaReservas, ArrayList<Quarto> listaQuartos) {
        System.out.println("Digite o CPF do cliente: ");
        var cpfCliente = scanner.next();
        if (!Reserva.verificaClienteHospedado(listaReservas, cpfCliente)) {
            System.out.println("O cliente com esse CPF não está hospedado!");
            return;
        }
        if (!Reserva.verificaClienteRealizonCheckIn(listaReservas, cpfCliente)) {
            System.out.println("O cliente com esse CPF não realizou o check-in!");
            return;
        }
        Reserva.realizarCheckOut(listaReservas, cpfCliente, listaQuartos);
        System.out.println("Check-out realizado com sucesso!");
    }

    private static void realizarCheckIn(ArrayList<Cliente> listaClientes, ArrayList<Reserva> listaReservas) {
        System.out.println("Digite o CPF do cliente: ");
        var cpfCliente = scanner.next();
        if (!Reserva.verificaClienteHospedado(listaReservas, cpfCliente)) {
            System.out.println("O cliente com esse CPF não está hospedado!");
            return;
        }
        Reserva.realizarCheckIn(listaReservas, cpfCliente);
        System.out.println("Check-in realizado com sucesso!");
    }

    private static void cadastrarReserva(ArrayList<Reserva> listaReservas, ArrayList<Quarto> listaQuartos, ArrayList<Cliente> listaClientes) {
        System.out.println("Digite o CPF do cliente: ");
        var cpfCliente = scanner.next();
        if (Reserva.verificaClienteHospedado(listaReservas, cpfCliente)) {
            System.out.println("O cliente com esse CPF já está hospedado!");
            return;
        }
        System.out.println("Digite o número do quarto: ");
        var numeroQuarto = scanner.nextInt();
        if (Reserva.verificaQuartoReservado(listaReservas, numeroQuarto)) {
            System.out.println("O quarto com esse número já está reservado!");
            return;
        }
        var quarto = new Quarto();
        for (Quarto quartoAux : listaQuartos) {
           if (quartoAux.getNumero() == numeroQuarto) {
               quarto = quartoAux;
           }
        }
        var cliente = new Cliente();
        for (Cliente clienteAux : listaClientes) {
            if (clienteAux.getCpf().equals(cpfCliente)) {
                cliente = clienteAux;
            }
        }
        if (cliente.isEmpty()) {
            System.out.println("Não existe cliente cadastrado com CPF digitado!");
            return;
        }
        if (quarto.isEmpty()) {
            System.out.println("Não existe quarto cadastrado com número digitado!");
            return;
        }
        quarto.setReservado(true);
        listaReservas.add(new Reserva(quarto, cliente));
        System.out.println("Reserva realizada com sucesso!");
    }

    private static void cadastrarCliente(ArrayList<Cliente> listaClientes) {
        System.out.println("Digite o nome do cliente: ");
        var nome = scanner.next();
        System.out.println("Digite o email do cliente: ");
        var email = scanner.next();
        System.out.println("Digite o CPF do cliente: ");
        var cpf = scanner.next();
        if (Cliente.verificaCpfCadastrado(listaClientes, cpf)) {
            System.out.println("Já existe cliente cadastrado com esse CPF!");
            return;
        }
        listaClientes.add(new Cliente(nome, email, cpf));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarQuarto(ArrayList<Quarto> listaQuartos) {
        System.out.println("Digite o número do quarto: ");
        var numero = scanner.nextInt();
        System.out.println("""
                Tipo de quarto:
                1 - Simples (2 pessoas)
                2 - Duplo (4 pessoas)
                Digite o tipo do quarto:
                """);
        var tipo = scanner.nextInt();
        if(Quarto.verificaQuartoReservado(listaQuartos, numero)) {
            System.out.println("Já existe quarto cadastro com esse número!");
            return;
        }
        listaQuartos.add(new Quarto(numero, tipo));
        System.out.println("Quarto cadastrado com sucesso!");
    }
}
