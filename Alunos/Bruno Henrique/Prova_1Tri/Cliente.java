public class Cliente {
    private String nome;
    private String idade;
    private String ocupacao;

    public Cliente(String nome, String idade, String ocupacao) {
        this.nome = nome;
        this.idade = idade;
        this.ocupacao = ocupacao;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public void checkIn() {

    }

    public void checkOut() {
    }
}
