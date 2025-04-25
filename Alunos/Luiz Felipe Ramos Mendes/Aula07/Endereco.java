public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;
    private String rua;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento, String rua) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
    }

    public void apresentarLogradouro() {
        System.out.println("Rua: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado + ", Número: " + numero + ", Complemento: " + complemento);
    }
}
