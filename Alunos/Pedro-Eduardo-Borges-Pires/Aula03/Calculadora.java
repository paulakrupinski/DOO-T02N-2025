package Aula03;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calculadora2 {

    private int quantity;
    private Double cost;
    private Double discount;


    List<Calculadora2> calculadoras = new ArrayList<Calculadora2>();
    public Calculadora2 (){

    }
    public Calculadora2(double cost, int quantity) {
        this.cost = cost;
        this.quantity = quantity;
    }

    public Calculadora2(int quantity, Double cost, Double discount) {
        this.quantity = quantity;
        this.cost = cost;
        this.discount = discount;
    }

    public Calculadora2(int quantity, double cost, Double discount, Date data) {
        this.quantity = quantity;
        this.cost = cost;
        this.discount = discount;
    }

    public Double totalValue()
    {
        if (quantity > 10) {
            setDiscount((quantity * cost) * 0.05);
            return (quantity * cost) * 0.95;
        }
        setDiscount(0.0);
        return quantity * cost;
    }

    public Double change(Double totalValue, Double payment){
        double result= 0.0;
        if (payment > totalValue){
            result = payment - totalValue;
        }
        return result;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }


    public void addLista(Calculadora2 calculadora){
        calculadoras.add(calculadora);
    }

    public void printLista (){
        for(Calculadora2 calculadora : calculadoras){
            System.out.println(calculadora.toString());
        }
    }

    @Override
    public String toString() {
        return "\nCusto: " + cost + " Quantidade: " + quantity + " Desconto: " + discount + "\n";
    }


}
