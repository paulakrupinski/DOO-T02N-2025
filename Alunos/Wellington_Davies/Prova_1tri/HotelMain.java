import java.time.LocalDate;

public class HotelMain {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.cadastrarCliente("Wellington", "99988877766");
        hotel.cadastrarCliente("Bruno", "11122233344");

        hotel.adicionarQuarto(new QuartoSimples(101));
        hotel.adicionarQuarto(new QuartoDuplo(202));

        System.out.println("Verificando quartos disponiveis ");
        hotel.verificarDisponibilidade(LocalDate.now());

        Clientes cliente = hotel.buscarCliente("99988877766");
        Clientes cliente2 = hotel.buscarCliente("11122233344");

        Reserva reserva = hotel.reservarQuarto(cliente, 101, LocalDate.now(), LocalDate.now().plusDays(2));
        Reserva reserva2 = hotel.reservarQuarto(cliente2, 202, LocalDate.now().plusDays(2), LocalDate.now().plusDays(3));

        System.out.println("Reservado para " + cliente2.getNome());
        hotel.checkOut(101);

        System.out.println("Reservado para " + cliente.getNome());
        hotel.checkOut(202);

        hotel.verificarDisponibilidade(LocalDate.now());
    }
}
