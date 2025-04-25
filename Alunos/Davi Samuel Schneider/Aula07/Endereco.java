package domain;

public class Endereco {
    private String estado, cidade, bairro, numero, complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Estado: " + this.estado + "\nCidade: " + this.cidade + "\nBairro" + this.bairro + "\nNúmero: " + this.numero + "Complemento: " + this.complemento);
    }
}
