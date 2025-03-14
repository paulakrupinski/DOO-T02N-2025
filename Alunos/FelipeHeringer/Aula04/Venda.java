package Alunos.FelipeHeringer.Aula04;

public class Venda {
    protected Integer numVenda;
    protected Integer qtdPlantas;
    protected Double valorVenda;
    protected Double descontosAplicados;

    public Venda(Integer numVenda,Integer qtdPlantas, Double valorVenda , Double descontosAplicados) {
        this.numVenda = numVenda;
        this.qtdPlantas = qtdPlantas;
        this.valorVenda = valorVenda;
        this.descontosAplicados = descontosAplicados;
    }

    @Override
    public String toString() {
        return "Venda No: " + numVenda + 
        " Quantidade Plantas: " + qtdPlantas + " Valor da Venda: " + valorVenda
        + " Descontos Aplicados: " + descontosAplicados;
    }
    
}
