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

    public void apresentarLogradouro() {
        System.out.println(rua + ", Nº " + numero + ", " + bairro + ", " + cidade + "/" + estado + " - " + complemento);
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
