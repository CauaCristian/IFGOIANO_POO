import java.util.ArrayList;
import java.util.Date;

public abstract class Publicaçao {
    private Date dataPublicaçao;
    private String titulo;
    private boolean alugado;
    private Double valorMulta;
    ArrayList<Publicaçao> referencia;
    ArrayList<Autor> autores;
    public Publicaçao(Date dataPublicaçao, String titulo, Double valorMulta) {
        this.dataPublicaçao = dataPublicaçao;
        this.titulo = titulo;
        this.alugado = false;
        this.valorMulta = valorMulta;
        this.autores = new ArrayList<Autor>();
        this.referencia = new ArrayList<Publicaçao>();
    }
    public Date getDataPublicaçao() {
        return dataPublicaçao;
    }
    public void setDataPublicaçao(Date dataPublicaçao) {
        this.dataPublicaçao = dataPublicaçao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAlugado() {
        return this.alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public ArrayList<Publicaçao> getReferencia() {
        return referencia;
    }


    public ArrayList<Autor> getAutores() {
        return autores;
    }


    public boolean addAutor(Autor autor){
        if(autores.add(autor)){
            return true;
        }
        return false;
    }
    public boolean removeAutor(Autor autor){
        if(autores.remove(autor)){
            return true;
        }
        return false;
    }

    public boolean addReferencia(Publicaçao publicaçao){
        if(referencia.add(publicaçao)){
            return true;
        }
        return false;
    }

    public boolean removeReferencia(Publicaçao publicaçao){
        if(referencia.remove(publicaçao)){
            return true;
        }
        return false;
    }

}
