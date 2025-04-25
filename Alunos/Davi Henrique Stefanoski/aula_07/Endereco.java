package pacote;

public class Endereco {
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numero;
    String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarEndereco() {
        System.out.println("Endereço: " + rua + ", " + numero + " - " + bairro + ", " + cidade + " - " + estado);
        if (!complemento.isEmpty()) {
            System.out.println("Complemento: " + complemento);
        }
    }
}