package provaEnon;

public class Cliente {
    private static int contadorId = 1;
    private String nome;
    private int id;
    private Quarto quartoReserva;

    public Cliente(String nome) {
        this.nome = nome;
        this.id = contadorId++;
        this.quartoReserva = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public Quarto getQuartoReserva() {
        return quartoReserva;
    }

    public void setQuartoReserva(Quarto quartoReserva) {
        this.quartoReserva = quartoReserva; 
    }

    @Override
    public String toString() {
        return "Cliente [Nome: " + nome + ", ID: " + id + "]";
    }
}
