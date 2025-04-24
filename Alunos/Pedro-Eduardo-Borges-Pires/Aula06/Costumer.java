package Entities;

import java.util.ArrayList;
import java.util.List;

public class Costumer {
    /*- com os atributos nome, idade, cidade, bairro e rua.
- Método apresentarse deve printar o nome, idade.
     */

    private String name;
    private int age;
    private String city;
    private String neighbourhood;
    private String street;

    List<Costumer> list = new ArrayList<>();

    public Costumer(){

    }

    public Costumer(String name, int age, String city, String neighbourhood, String street) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.neighbourhood = neighbourhood;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getStreet() {
        return street;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public void apresentarSe(){
        System.out.println("Name: " + name + " Age: " + age);
    }

    public void addCostumer(Costumer costumer) {
        list.add(costumer);
    }

    public void printaCostumer(){
        for(Costumer costumer : list){
            System.out.println(costumer);
        }
    }
}
