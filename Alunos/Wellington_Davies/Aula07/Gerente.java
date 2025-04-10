import java.util.ArrayList;


public class Gerente extends Funcionario {

    private String cargo;

    public Gerente(String nome, int idade, String loja, Double salarioBase, ArrayList<Double> salarioRecebido, String cargo) {
        super(nome, idade, loja, salarioBase, salarioRecebido);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public double calcularMedia() {
        double soma = 0.0;
        for (Double salario : getSalarioRecebido()) {
            soma += salario;
        }
        return soma / getSalarioRecebido().size(); 
    }

    @Override
    public double calcularBonus(Double valor){
        return valor + valor * 0.36;
    }

    @Override
    public void apresentarse(){
        System.out.println("FUNCIONARIO");
        System.out.println("------------------");
        System.out.println("Cargo: " + getCargo());
        System.out.println("Nome "+ getNome());
        System.out.println("Idade "+ getIdade());
        System.out.println("Loja "+ getLoja());
        System.out.println("------------------ \n");
    }
}
