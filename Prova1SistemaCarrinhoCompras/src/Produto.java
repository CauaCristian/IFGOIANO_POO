public class Produto {

    private String nomeProduto;

    private int quantidade;

    private double preço;

    public Produto(String nomeProduto, int quantidade, double preço) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preço = preço*quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }
}