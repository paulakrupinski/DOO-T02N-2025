package pacote;
import java.util.ArrayList;
import java.util.List;
public class Gerente extends Pessoa {
   Loja loja;
   double salarioBase;
   List<Double> salarioRecebido = new ArrayList<>();
   public Gerente(String nome, int idade, Endereco endereco, Loja loja, double salarioBase, double... salarios) {
       super(nome, idade, endereco);
       this.loja = loja;
       this.salarioBase = salarioBase;
       for (double s : salarios) {
           salarioRecebido.add(s);
       }
   }
   @Override
   public void apresentarse() {
       System.out.println("Sou o gerente da loja " + loja.nomeFantasia + ".");
       super.apresentarse();
   }
   public double calcularMedia() {
       return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
   }
   public double calcularBonus() {
       return salarioBase * 0.35;
   }
}
