import java.util.Scanner;

public class Endereco {
    String estado, cidade, bairro, complemento;
    int numero;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(bairro + ", " + cidade + " - " + estado + ", nº " + numero + " (" + complemento + ")");
    }
}
