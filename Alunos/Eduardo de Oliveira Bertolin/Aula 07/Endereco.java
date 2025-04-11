package calculadoraplantas;

public class Endereco{
    String cidade;  
    String bairro;
    String rua;
    String numero;
    String complemento;
    
    
    public String apresentarLogradouro(){
        return (rua + ", n°" + numero + ", " + complemento + " - " + bairro + ", " + cidade);
        }
    }
