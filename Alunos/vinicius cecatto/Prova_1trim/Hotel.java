package Prova_1trim;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Quarto> quartos = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();

    public boolean cadastrarCliente(String nome, String cpf) {

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Erro: CPF já cadastrado.");
                return false;
            }
        }

        Cliente novoCliente = new Cliente(nome, cpf);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado: " + nome);
        return true;
    }

    public boolean cadastrarQuarto(int numero, double precoDiaria, String tipo) {

        for (Quarto quarto : quartos) {
            if (quarto.numero == numero) {
                System.out.println("Erro: Número de quarto já cadastrado.");
                return false;
            }
        }

        Quarto novoQuarto = new Quarto(numero, precoDiaria, tipo);
        quartos.add(novoQuarto);
        System.out.println("Quarto cadastrado: " + numero);
        return true;
    }

    public boolean verificarDisponibilidade(int numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numeroQuarto && quarto.isDisponivel()) {
                for (Reserva reserva : reservas) {
                    if (reserva.quarto.numero == numeroQuarto &&
                            !((dataCheckOut.isBefore(reserva.dataCheckIn) || dataCheckIn.isAfter(reserva.dataCheckOut)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public Reserva fazerReserva(String cpf, int numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Erro: Cliente não encontrado.");
            return null;
        }

        Quarto quarto = null;
        for (Quarto q : quartos) {
            if (q.numero == numeroQuarto) {
                quarto = q;
                break;
            }
        }

        if (quarto == null) {
            System.out.println("Erro: Quarto não encontrado.");
            return null;
        }

        if (verificarDisponibilidade(numeroQuarto, dataCheckIn, dataCheckOut)) {
            Reserva reserva = new Reserva(cliente, quarto, dataCheckIn, dataCheckOut);
            reservas.add(reserva);
            return reserva;
        } else {
            System.out.println("Erro: Quarto indisponível para as datas informadas.");
            return null;
        }
    }

    public Reserva buscarReservaPorQuarto(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.quarto.numero == numeroQuarto) {
                return reserva;
            }
        }
        return null;
    }

    public void realizarCheckOut(int numeroQuarto) {
        Reserva reserva = buscarReservaPorQuarto(numeroQuarto);
        if (reserva != null) {
            reserva.realizarCheckOut();
            reservas.remove(reserva);
        }
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        for (Reserva reserva : reservas) {
            System.out.println("Reserva: Cliente=" + reserva.cliente.getNome() +
                    ", Quarto=" + reserva.quarto.numero +
                    ", Check-In=" + reserva.dataCheckIn +
                    ", Check-Out=" + reserva.dataCheckOut);
        }
    }
}