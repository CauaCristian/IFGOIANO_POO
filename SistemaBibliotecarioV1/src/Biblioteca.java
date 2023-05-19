import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String endereco;
    ArrayList<Publicaçao> publicaçoes;
    ArrayList<Cliente> clientes;
    ArrayList<Emprestimo> emprestimos;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.publicaçoes =  new ArrayList<Publicaçao>();
        this.clientes = new ArrayList<Cliente>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;

    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void listarDisponiveis(){
        System.out.println("----------------------------Disponiveis---------------------------");
        for(int i =0;i< publicaçoes.size();i++){
            if(publicaçoes.get(i).isAlugado() == false){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("publicação: "+ publicaçoes.get(i).getTitulo() + "\nnumero: " +  i);
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }
    public void listarIndisponiveis(){
        System.out.println("--------------------------Indisponiveis---------------------------");
        for(int i =0;i< publicaçoes.size();i++){
            if(publicaçoes.get(i).isAlugado() == true){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("publicação: "+publicaçoes.get(i).getTitulo() + "\nnumero: " +  i);
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    public Publicaçao buscarPublicaçao(int numero){
        if(publicaçoes.get(numero) != null){
            return publicaçoes.get(numero);
        }
        return null;
    }
    public Cliente buscarCliente(String cpf){
        for(int i = 0;i< clientes.size();i++){
            if(clientes.get(i).getCpf().equals(cpf)){
                return clientes.get(i);
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimo(Publicaçao publicaçao){
        for(int i =0;i< emprestimos.size();i++){
            if(publicaçao == emprestimos.get(i).getPublicaçao()){
                return emprestimos.get(i);
            }
        }
        return null;
    }

    public void listarEmprestimo(Cliente cliente){
        for(int i =0;i< emprestimos.size();i++){
            if(emprestimos.get(i).getCliente().equals(cliente) && emprestimos.get(i).getDataEmprestimo() != null){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("publicação: "+emprestimos.get(i).getPublicaçao().getTitulo());
                System.out.println("data de emprestimo: " + emprestimos.get(i).getDataEmprestimo());
                System.out.println("data de devolução: " + emprestimos.get(i).getDataDevoluçao());
                System.out.println("multa atual: " + emprestimos.get(i).calcularmulta() + " R$");
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

}
