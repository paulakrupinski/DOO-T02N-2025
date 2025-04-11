package aula2;

public class Endereco {
    public String estado;
    public String cidade;
    public String bairro;
    public String rua;
    public int numero;

    public Endereco() {
    	this("PR", "Santa", "Iza", "Bel", 99);
    }
    public Endereco(String estado, String cidade, String bairro, String rua, int numero) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public String apresentarLogradouro() {
        return  estado + " Cidade:" + cidade + ", bairro:" + bairro + ", rua:"+rua +", Nº" + numero +".";
    }
}
