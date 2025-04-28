package prova1_tri;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Hotel {

    List<Quarto> quartos = new ArrayList<>();
    List<Reserva> reservas = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    public void cadastrarQuarto(int codQuarto, String tipoQuarto, double precoDiaria, int hospedesQuarto, boolean disponibilidadeQuarto) {
        Quarto quarto = new Quarto(quartos.size() + 1, tipoQuarto, precoDiaria, hospedesQuarto, disponibilidadeQuarto);
        quartos.add(quarto);
    }

    public void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Não há quartos cadastrados.");
        } else {
            System.out.println("\n----- Lista de Quartos -----");
            for (Quarto quarto : quartos) {
                System.out.println(quarto); // Exibe a string retornada pelo método toString da classe Quarto
            }
        }
    }

    public void cadastrarReserva(Cliente cliente, int codQuarto, int diasReservados, double valorTotal, LocalDate checkIn, LocalDate checkOut) {

        for (Quarto quarto : quartos) {

            if (quarto.codQuarto == codQuarto && quarto.disponibilidadeQuarto) {
                Reserva reserva = new Reserva(cliente, quarto, diasReservados, valorTotal, checkIn, checkOut);
                reservas.add(reserva);
                System.out.println("Reserva realizada com sucesso!");
                return;
            }
        }
        System.out.println("Quarto indisponível.");
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    // Realizar check-in
    public void realizarCheckIn(Cliente cliente, int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.quarto.codQuarto == numeroQuarto && reserva.cliente.nome.equals(cliente.nome) && reserva.quarto.disponibilidadeQuarto) {
                reserva.quarto.setDisponibilidadeQuarto(false);
                System.out.println("Check-in realizado com sucesso!");
                return;
            }
        }
        System.out.println("Reserva não encontrada ou quarto já ocupado.");
    }

    // Realizar check-out
    public void realizarCheckOut(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.quarto.codQuarto == numeroQuarto && !reserva.quarto.disponibilidadeQuarto) {
                reserva.checkOut();
                System.out.println("Check-out realizado com sucesso!");
                return;
            }
        }
        System.out.println("Check-out não pode ser realizado. Verifique o número do quarto.");
    }

    // Histórico de reservas por hóspede
    public void exibirHistoricoReservas(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.cliente.nome.equals(nomeHospede)) {
                System.out.println(reserva);
            }
        }
    }
}
