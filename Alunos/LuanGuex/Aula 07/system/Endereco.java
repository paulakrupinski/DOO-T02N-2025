package system;

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
        System.out.printf("%s, %s, nº %d, %s - %s/%s", rua, bairro, numero, complemento, cidade, estado);
    }
    
    public String getLogradouro() {
        return String.format("%s, %s, nº %d, %s - %s/%s", rua, bairro, numero, complemento, cidade, estado);
    }
}
