public class Reservas{
    private List<Quarto> quartos;
    private Map<Quarto, Cliente> reservas;

    public boolean reservar(Cliente cliente, Quarto quarto, LocalDate data) {
        if (quarto.isDisponivel()) {
            reservas.put(quarto, cliente);
            quarto.setOcupado(true);
            return true;
        }
        return false;
    }

    public boolean verificarDisponibilidade(Quarto quarto) {
        return quarto.isDisponivel();
    }
}
