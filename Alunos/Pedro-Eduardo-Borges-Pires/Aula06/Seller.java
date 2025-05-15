package Entities;

public class Seller {
 /*- Com os atributos nome, idade, Loja, cidade, bairro, rua, salarioBase e salarioRecebido.
- Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.(Pode colocar no código os valores*)
- Métodos apresentarse calcularMedia e calcularBonus.
- Método apresentarse deve printar o nome, idade e Loja.
- calcularMedia deve trazer a média dos salários.
- calcularBonus onde a formulá é [salarioBase * 0.2]

  */


    private String name;
    private int age;
    private Store store;
    private String city;
    private String neighborhood;
    private String street;
    private Double baseSalary= 8.750;
    private Double[] receivedSalary = {10.000, 9.300, 12.500 };

    public Seller(){

    }

   public Seller(String name, int age, Store store, String city, String neighborhood, String street, Double baseSalary, Double[] receivedSalary) {
      this.name = name;
      this.age = age;
      this.store = store;
      this.city = city;
      this.neighborhood = neighborhood;
      this.street = street;
      this.baseSalary = baseSalary;
      this.receivedSalary = receivedSalary;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public Store getStore() {
      return store;
   }

   public String getCity() {
      return city;
   }

   public String getNeighborhood() {
      return neighborhood;
   }

   public String getStreet() {
      return street;
   }

   public Double getBaseSalary() {
      return baseSalary;
   }

   public Double[] getReceivedSalary() {
      return receivedSalary;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public void setStore(Store store) {
      this.store = store;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public void setNeighborhood(String neighborhood) {
      this.neighborhood = neighborhood;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public void setBaseSalary(Double baseSalary) {
      this.baseSalary = baseSalary;
   }

   public void setReceivedSalary(Double[] receivedSalary) {
      this.receivedSalary = receivedSalary;
   }

   @Override
   public String toString() {
      return "Seller{" +
              "name='" + name + '\'' +
              ", age=" + age +
              ", store=" + store +
              ", city='" + city + '\'' +
              ", neighborhood='" + neighborhood + '\'' +
              ", street='" + street + '\'' +
              ", baseSalary=" + baseSalary +
              ", receivedSalary=" + receivedSalary +
              '}';
   }

   public void apresentarSe(){
      System.out.println("Name: " + name + " Age: " + age + " Store: " + store);
   }

   public void calcularMedia(){
      Double soma=0.0;
    for(int i=0; i < receivedSalary.length; i++){
        soma = receivedSalary[i];
    }
      System.out.println("Media salarial: " + soma/receivedSalary.length);
   }

   public void calcularBonus(){
      System.out.println("Bonus: " + baseSalary * 0.2);
   }


}

