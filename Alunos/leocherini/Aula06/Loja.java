package calcMyPlant;



public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private Vendedor[] vendedores;
    private Cliente[] clientes;
    
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua,Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }
    
   
    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
    
    
    public void contarClientes() {
        int total = 0;
        for (Cliente c : clientes) {
            if (c != null) {
                total++;
            }
        }
        System.out.println("Total de Clientes: " + total);
    }
    
    
    public void contarVendedores() {
        int total = 0;
        for (Vendedor v : vendedores) {
            if (v != null) {
                total++;
            }
        }
        System.out.println("Total de Vendedores: " + total);
    }
    
   
    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
