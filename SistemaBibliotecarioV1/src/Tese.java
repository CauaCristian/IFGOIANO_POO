import java.util.ArrayList;
import java.util.Date;

public class Tese extends Publicaçao{
    private int numeroPaginas;
    private String resumo;
    private Date dataDeDefesa;
    private String instituiçaoDeDefesa;
    public Tese(Date dataPublicaçao, String titulo,Double valorMulta, int numeroPaginas, String resumo, Date dataDeDefesa, String instituiçaoDeDefesa) {
        super(dataPublicaçao, titulo,valorMulta);
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.dataDeDefesa = dataDeDefesa;
        this.instituiçaoDeDefesa = instituiçaoDeDefesa;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public Date getDataDeDefesa() {
        return dataDeDefesa;
    }
    public void setDataDeDefesa(Date dataDeDefesa) {
        this.dataDeDefesa = dataDeDefesa;
    }
    public String getInstituiçaoDeDefesa() {
        return instituiçaoDeDefesa;
    }
    public void setInstituiçaoDeDefesa(String instituiçaoDeDefesa) {
        this.instituiçaoDeDefesa = instituiçaoDeDefesa;
    }

    @Override
    public boolean addAutor(Autor autor) {
        if(super.autores.size() < 1){
            super.autores.add(autor);
            return true;
        }
        return false;
    }
}
