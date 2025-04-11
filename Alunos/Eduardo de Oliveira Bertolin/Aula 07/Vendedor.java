package calculadoraplantas;

public class Vendedor extends Pessoa{
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    double[] salarioRecebido = {1.700,1.800,1.900};
    
    @Override
    public void apresentarSe(){
        super.apresentarSe();
        System.out.println("Loja: " + loja);
    }
    
    public double calcularMedia(){
        double soma = 0;
        for (double salario : salarioRecebido){
            soma += salario;
        }
        return (soma / salarioRecebido.length);
    }
    
    public double calcularBonus(){
        return (salarioBase * 0.2);
    }
    
    }
