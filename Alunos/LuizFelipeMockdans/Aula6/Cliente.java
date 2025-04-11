public class Cliente {
    private String nome;
    private Integer idade;
    private String cidade;
    private String bairro;
    private String rua;

    
    public Cliente() {
    }

    
    public Cliente(String nome, Integer idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    
    public void apresentarSe() {
        System.out.println("Nome: " + (nome != null ? nome : "Não informado"));
        System.out.println("Idade: " + (idade != null ? idade : "Não informada"));
        System.out.println("Cidade: " + (cidade != null ? cidade : "Não informada"));
        System.out.println("Bairro: " + (bairro != null ? bairro : "Não informado"));
        System.out.println("Rua: " + (rua != null ? rua : "Não informada"));
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
