
package calculadoraplantas;

public class Loja{
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    Endereco endereco;
    
    Vendedor[] vendedores;
    Cliente[] clientes;
    
    public int contarClientes(){
        return clientes.length;
    }
    
    public int contarVendedores(){
        return vendedores.length;
    }
    
    public void apresentarSe(){
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }
            
    }