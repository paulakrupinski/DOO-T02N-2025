public class Clientes{

    private String nome;
    private int Cpf;

    public Clientes(String nome, int cpf) {
        this.nome = nome;
        Cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return Cpf;
    }

    public void setCpf(int cpf) {
        Cpf = cpf;
    }
    
}