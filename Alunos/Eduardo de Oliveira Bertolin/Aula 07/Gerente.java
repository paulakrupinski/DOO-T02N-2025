package calculadoraplantas;

public class Gerente extends Pessoa{
    public Loja loja;
    double salarioBase;
    double[] salarioRecebido = {2.700, 2.800, 2.900};
    
    @Override
    public void apresentarSe(){
        super.apresentarSe();
        System.out.println("Loja: " + loja.nomeFantasia);
    }
    
    public double calcularMedia(){
        double soma = 0;
        for (double salario : salarioRecebido){
            soma += salario;
        }
        return (soma / salarioRecebido.length);
    }
    
    public double calcularBonus(){
        return (salarioBase * 0.35);
    }
    
    }