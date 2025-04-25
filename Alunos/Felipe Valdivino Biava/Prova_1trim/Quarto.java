import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Quarto {

    private int tipo;
    private List<Quarto> listaDeQuarto;
    private String nome;
    private int id;
    private int disponibilidade = 4;
    private Cliente cliente;
    private int valor;
    private static LocalDate dataEntrada;
    private static LocalDate dataSaida;
    private static double valorDiaria;

    public int proximoId = 1;
    public int proxDisponibilidade;

    public Quarto(){
        proxDisponibilidade = disponibilidade;
        listaDeQuarto = new ArrayList<>();
    }

    public Quarto(int tipo, List<Quarto> listaDeQuarto, int disponibilidade, int id, LocalDate dataEntrada, LocalDate dataSaida, int valor, double valorDiaria) {
        this.tipo = tipo;
        this.listaDeQuarto = listaDeQuarto;
        this.proxDisponibilidade = disponibilidade;
        this.id = proximoId++;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.valorDiaria = valorDiaria;
    }

    public boolean checkin(Cliente cliente){
        if(this.proxDisponibilidade > 0){
            this.cliente = cliente;
            this.proxDisponibilidade--;
            System.out.println("Check-in realizado para o cliente: " + cliente.getNome() + " no quarto " + this.nome);
            return true;
        }else{
            System.out.println("Desculpe, quarto já reservado para: " + cliente.getNome() + " no quarto " + this.nome);

        }
        return false;
    }

    public boolean checkout(){
        if(this.proxDisponibilidade > 0){
            this.cliente = cliente;
            this.proxDisponibilidade++;
            System.out.println("Check-out realizado para o cliente: " + cliente.getNome() + " no quarto " + this.nome);
        }else{
            System.out.println("Desculpe, quarto já reservado para: " + cliente.getNome() + " no quarto " + this.nome);

        }
        return false;
    }

    public static void calcularDiaria(){
        long diasDeEstadia = ChronoUnit.DAYS.between(dataEntrada, dataSaida);

        double total = diasDeEstadia * valorDiaria;

    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setListaDeQuarto(List<Quarto> listaDeQuarto) {
        this.listaDeQuarto = listaDeQuarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getProximoId() {
        return proximoId;
    }

    public void setProximoId(int proximoId) {
        this.proximoId = proximoId;
    }

    public int getProxDisponibilidade() {
        return proxDisponibilidade;
    }

    public void setProxDisponibilidade(int proxDisponibilidade) {
        this.proxDisponibilidade = proxDisponibilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Quarto> getListaDeQuarto() {
        return listaDeQuarto;
    }

    public void setListaDeQuartos(List<Quarto> listaDeQuarto) {
        this.listaDeQuarto = listaDeQuarto;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "tipo=" + tipo +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                ", disponibilidade=" + disponibilidade +
                ", valor=" + valor +
                '}';
    }
}
