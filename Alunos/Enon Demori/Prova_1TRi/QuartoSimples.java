package provaEnon;

public class QuartoSimples extends Quarto {
    public QuartoSimples(int numero) {
        super(numero, 100.0f); 
    }

    @Override
    public void realizarReserva(Cliente cliente) {
        if (isDisponivel()) {
            System.out.println("Reserva realizada para o cliente " + cliente.getNome() + " no quarto simples " + numero);
            setDisponivel(false);
        } else {
            System.out.println("Quarto simples " + numero + " não disponível para reserva.");
        }
    }

    @Override
    public void realizarCheckIn() {
        System.out.println("Check-in realizado no quarto simples " + numero);
    }

    @Override
    public void realizarCheckOut() {
        System.out.println("Check-out realizado no quarto simples " + numero);
        setDisponivel(true);
    }
}
