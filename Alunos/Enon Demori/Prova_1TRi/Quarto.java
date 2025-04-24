package provaEnon;


public abstract class Quarto {
    protected int numero;
    protected float valorDiaria;
    protected boolean disponivel;

    public Quarto(int numero, float valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract void realizarReserva(Cliente cliente);
    public abstract void realizarCheckIn();
    public abstract void realizarCheckOut();
}
