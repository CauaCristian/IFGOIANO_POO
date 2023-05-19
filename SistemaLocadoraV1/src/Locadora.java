import java.util.ArrayList;

public class Locadora {
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Emprestimo> emprestimos;

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.veiculos = new ArrayList<Veiculo>();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void removeCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    public void addEmprestimos(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }
    public void removeEmprestimos(Emprestimo emprestimo){
        emprestimos.remove(emprestimo);
    }
    public void listarClientes(){
        for(int i=0;i< clientes.size();i++){
            System.out.println(
                    "numero: " + i +
                    " nome: " +  clientes.get(i).getNome()
            );
        }
    }
    public Cliente pegarCliente(int numero){
        if(numero< clientes.size()){
            Cliente cliente = clientes.get(numero);
            return cliente;
        }
        return null;
    }
    public void listarVeiculosDisponiveis(){
        for(int i = 0; i< veiculos.size();i++){
            if(veiculos.get(i).isAlugado() == false){
                System.out.println(
                        "numero: " + i +
                        " marca: " + veiculos.get(i).getMarca()+ " " +
                        " modelo: " + veiculos.get(i).getModelo()+ " " +
                        " ano: " + veiculos.get(i).getAno()
                );
            }
        }
    }
    public void listarVeiculosIndisponiveis(){
        for(int i = 0; i< veiculos.size();i++){
            if(veiculos.get(i).isAlugado() == true){
                System.out.println(
                        "numero: " + i +
                        " marca: " + veiculos.get(i).getMarca()+ " " +
                        " modelo: " + veiculos.get(i).getModelo()+ " " +
                        " ano: " + veiculos.get(i).getAno()
                );
            }
        }
    }

    public Veiculo pegarVeiculo(int numero){
        if(numero< veiculos.size()){
            Veiculo veiculo = veiculos.get(numero);
            return veiculo;
        }
        return null;
    }
    public void listarEmprestimo(Cliente cliente){
        for(int i = 0; i< emprestimos.size();i++){
            Emprestimo emprestimo = emprestimos.get(i);
            if(emprestimo.getCliente() == cliente){
                System.out.println("numero: " + i);
                System.out.println(emprestimo.getVeiculo().getModelo());
            }
        }
    }

    public Emprestimo pegarEmprestimo(int numero){
        if(numero< emprestimos.size()){
            Emprestimo emprestimo = emprestimos.get(numero);
            return emprestimo;
        }
        return null;
    }
}
