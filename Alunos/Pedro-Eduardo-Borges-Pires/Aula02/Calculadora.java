package Alunos.Pedro_Pires.Aula01.Aula02;

public class Calculadora {

    private Double value;
    private int quantity;


    public Calculadora() {
    }

    public Calculadora(Double value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void precoTotal(){
        System.out.println("Preco total: R$" + value * quantity);
    }

    public void troco(Double payment){
        Double totalValue = value * quantity;
        if(totalValue < payment){
            System.out.println("Troco: R$" + (totalValue - payment));
        }
    }
}
