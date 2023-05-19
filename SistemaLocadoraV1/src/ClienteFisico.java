public class ClienteFisico extends Cliente{
    private String cpf;
    public ClienteFisico(String nome, String telefone, String endereco,String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean permisaoAluguel() {
        if(super.getQuantidadeDeCarrosAlugados() < 1){
            return true;
        }
        return false;
    }
}
