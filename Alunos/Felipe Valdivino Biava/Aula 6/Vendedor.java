import java.util.Arrays;

public class Vendedor {

    private String nome;
    private int idade;
    private String Loja;
    private String cidade;
    private String bairro;
    private String rua;
    private String salarioBase;
    private String[] salarioRecebido = {"1300,00", "1400,00", "1500,00"};

    public Vendedor() {

    }

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, String salarioBase, String[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.Loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public String getLoja() {
        return Loja;
    }

    public void setLoja(String loja) {
        Loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(String salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(String[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    @Override
    public String toString() {
        return "Vendedor = [" +
                "nome: '" + nome + '\'' +
                ", idade: " + idade +
                ", Loja: '" + Loja + '\'' +
                ", cidade:'" + cidade + '\'' +
                ", bairro:'" + bairro + '\'' +
                ", rua: '" + rua + '\'' +
                ", salarioBase: '" + salarioBase + '\'' +
                ", salarioRecebido: " + Arrays.toString(salarioRecebido) +
                ']';
    }


}
