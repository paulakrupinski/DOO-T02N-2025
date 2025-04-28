package Aula04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    private int quantity;
    private Double cost;
    private Double discount;
    private LocalDate data;

    DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    List<Calculadora> calculadoras = new ArrayList<Calculadora>();
    public Calculadora (){

    }
    public Calculadora(double cost, int quantity) {
        this.cost = cost;
        this.quantity = quantity;
    }

    public Calculadora(int quantity, Double cost, Double discount) {
        this.quantity = quantity;
        this.cost = cost;
        this.discount = discount;
    }

    public Calculadora(int quantity, Double cost, Double discount, LocalDate data ) {
        this.quantity = quantity;
        this.data = data;
        this.discount = discount;
        this.cost = cost;
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void addLista(Calculadora calculadora){
        calculadoras.add(calculadora);
    }

    public void searchPerDate(LocalDate data){
       for (Calculadora calculadora : calculadoras) {
           if(calculadora.data.equals(data)){
               System.out.println(calculadora.toString());
           }
       }

    }

    public void printLista (){
        for(Calculadora calculadora : calculadoras){
            System.out.println(calculadora.toString());
        }
    }

    @Override
    public String toString() {
        return "\nCusto: " + cost + " Quantidade: " + quantity + " Desconto: " + discount + " Data: " + data.format(dtf) + "\n";
    }


}
