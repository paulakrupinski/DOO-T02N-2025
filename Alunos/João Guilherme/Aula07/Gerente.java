public class Gerente {
  public String nome;
  public int idade;
  public String loja;
  public Endereco endereco;
  public double salarioBase;
  public double[] salariosRecebidos;

  public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase, double[] salariosRecebidos) {
      this.nome = nome;
      this.idade = idade;
      this.loja = loja;
      this.endereco = endereco;
      this.salarioBase = salarioBase;
      this.salariosRecebidos = salariosRecebidos;
  }

  public void apresentarSe() {
      System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
  }

  public double calcularMedia() {
      double soma = 0;
      for (double s : salariosRecebidos) {
          soma += s;
      }
      return soma / salariosRecebidos.length;
  }

  public double calcularBonus() {
      return salarioBase * 0.35;
  }
}