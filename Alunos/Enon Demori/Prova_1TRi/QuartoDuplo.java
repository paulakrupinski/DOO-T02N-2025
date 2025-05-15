package provaEnon;

public class QuartoDuplo extends Quarto {
    public QuartoDuplo(int numero) {
        super(numero, 200.0f);
    }

    @Override
    public void realizarReserva(Cliente cliente) {
        if (isDisponivel()) {
            System.out.println("Reserva realizada para o cliente " + cliente.getNome() + " no quarto duplo " + numero);
            setDisponivel(false);
        } else {
            System.out.println("Quarto duplo " + numero + " não disponível para reserva.");
        }
    }

    @Override
    public void realizarCheckIn() {
        System.out.println("Check-in realizado no quarto duplo " + numero);
    }

    @Override
    public void realizarCheckOut() {
        System.out.println("Check-out realizado no quarto duplo " + numero);
        setDisponivel(true);
    }
}
