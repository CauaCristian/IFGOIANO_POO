public abstract class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private String ano;
    private double preco;
    private boolean alugado;
    private int quantidadeRenovacaoSemCusto;
    private double valorMulta;

    public Veiculo(String marca, String modelo, String placa, String ano, double preco,double valorMulta,int quantidadeRenovacaoSemCusto) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
        this.alugado = false;
        this.valorMulta = valorMulta;
        this.quantidadeRenovacaoSemCusto = quantidadeRenovacaoSemCusto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco() {
        return preco;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public int getQuantidadeRenovacaoSemCusto() {
        return quantidadeRenovacaoSemCusto;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }
}
