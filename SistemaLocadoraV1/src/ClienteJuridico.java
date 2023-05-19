public class ClienteJuridico extends Cliente{
    private String cnpj;
    public ClienteJuridico(String nome, String telefone, String endereco,String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    @Override
    public boolean permisaoAluguel() {
        if(super.getQuantidadeDeCarrosAlugados() < Double.POSITIVE_INFINITY){
            return true;
        }
        return false;
    }
}
