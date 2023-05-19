import java.util.Date;

public class Artigo extends Publicaçao{
    private String resumo;
    public Artigo(Date dataPublicaçao, String titulo,Double valorMulta,String resumo) {
        super(dataPublicaçao, titulo, valorMulta);
        this.resumo = resumo;

    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
