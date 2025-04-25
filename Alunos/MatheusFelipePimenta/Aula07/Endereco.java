package Aula07;

public class Endereco {
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;
    private String complemento;

    public Endereco(String bairro, String cidade, String estado, int numero, String complemento) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void mostrarEndereco() {
        System.out.println(bairro + ", Nº " + numero + " - " + cidade + ", " + estado + " (" + complemento + ")");
    }
}
