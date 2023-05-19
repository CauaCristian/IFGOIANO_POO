public class ClientePadrao extends Cliente{
    private boolean livroAlugado;
    public ClientePadrao(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
        this.livroAlugado = false;
    }

    public boolean isLivroAlugado() {
        return livroAlugado;
    }

    public void setLivroAlugado(boolean livroAlugado) {
        this.livroAlugado = livroAlugado;
    }
}
