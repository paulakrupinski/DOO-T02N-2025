package Entities;

import java.util.List;

public class Store {
    /*Atributos, nome fantasia, razão social, cpnj, cidade, bairro, rua, array vendedores, array de clientes.
- contarClientes, mosta a quantidade de clientes
- contarVendedores, mosta a quantidade de vendedores.
- Método apresentarse, printa nomeFantasia, cnpj e endereco.
     */

    private String name;
    private String legalName;
    private String identificationNumber;
    private String city;
    private String neighborhood;
    private String street;
    private List<Seller> sellers;
    private List<Costumer> costumers;

    public Store() {

    }

    public Store(String name, String legalName, String identificationNumber, String city, String neighborhood, String street) {
        this.name = name;
        this.legalName = legalName;
        this.identificationNumber = identificationNumber;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public String getLegalName() {
        return legalName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
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

    public void contarClientes(){
        System.out.println("Numero de clientes: " + costumers.size());
    }

    public void contarVendedores(){
        System.out.println("Numero de vendedores: " + sellers.size());
    }

    public void apresentarSe(){
        System.out.println("Name: " + name + " CNPJ: " + identificationNumber + " Cidade: " + city
                + " Bairro: " + neighborhood + " rua: " + street );
    }

    public void addCostumer(Costumer costumer){
        costumers.add(costumer);
    }

    public void addSeller(Seller seller){
        sellers.add(seller);
    }

}
