import java.util.Date;

public class Livro extends Publicaçao{
    private String numeroEdiçao;
    private String nomeEditora;
    private String isbn;
    public Livro(Date dataPublicaçao, String titulo,Double valorMulta, String numeroEdiçao, String nomeEditora, String isbn) {
        super(dataPublicaçao, titulo, valorMulta);
        this.numeroEdiçao = numeroEdiçao;
        this.nomeEditora = nomeEditora;
        this.isbn = isbn;
    }
    public String getNumeroEdiçao() {
        return numeroEdiçao;
    }
    public void setNumeroEdiçao(String numeroEdiçao) {
        this.numeroEdiçao = numeroEdiçao;
    }
    public String getNomeEditora() {
        return nomeEditora;
    }
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
