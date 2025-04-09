package Alunos.FelipeHeringer.Aula07;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    
    public Endereco() {
        
    }

    public void apresentarLogradouro() {
        System.out.println("Endereco [ estado= "+ estado + ", cidade=" + cidade + ", bairro=" 
                + bairro + ", rua=" + rua + ", numero=" + numero + ", complemento= " + complemento + "]");
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
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }    
}
