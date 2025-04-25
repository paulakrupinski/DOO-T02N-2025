public class Item {

    private int id;
    private String nome;
    private String tipo;
    private Double preco;   
    private int quantidade;

    public Item(int id, String nome, String tipo, Double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return preco * quantidade;
    }

    public void gerarDescricao() {
        System.out.println("");
        System.out.println("Itens:");
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo +
            ", Preço unitário: R$ " + String.format("%.2f", preco) +
            ", Quantidade: " + quantidade +
            ", Total: R$ " + String.format("%.2f", getValor()));
    }
}
