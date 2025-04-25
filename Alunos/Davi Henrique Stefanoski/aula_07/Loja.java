package pacote;
import java.util.ArrayList;
import java.util.List;
public class Loja {
   String nomeFantasia;
   String razaoSocial;
   String cnpj;
   String cidade;
   String bairro;
   String rua;
   List<Vendedor> vendedores = new ArrayList<>();
   List<Cliente> clientes = new ArrayList<>();
   public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
       this.nomeFantasia = nomeFantasia;
       this.razaoSocial = razaoSocial;
       this.cnpj = cnpj;
       this.cidade = cidade;
       this.bairro = bairro;
       this.rua = rua;
   }
   public void contarClientes() {
       System.out.println("Quantidade de clientes: " + clientes.size());
   }
   public void contarVendedores() {
       System.out.println("Quantidade de vendedores: " + vendedores.size());
   }
   public void apresentarse() {
       System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
   }
}
