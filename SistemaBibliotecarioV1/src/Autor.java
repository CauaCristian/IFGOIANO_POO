public class Autor {
    private String nome;
    private String titulaçao;
    public Autor(String nome, String titulaçao) {
        this.nome = nome;
        this.titulaçao = titulaçao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTitulaçao() {
        return titulaçao;
    }
    public void setTitulaçao(String titulaçao) {
        this.titulaçao = titulaçao;
    }
}
