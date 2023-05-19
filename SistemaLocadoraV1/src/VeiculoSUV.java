public class VeiculoSUV extends Veiculo{
    private double litrosPortaMalas;
    private String tipoTracao;
    private String tipoCombustivel;

    public VeiculoSUV(String marca, String modelo, String placa, String ano, Double preco,double valorMulta, double litrosPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, preco,valorMulta,3);
        this.litrosPortaMalas = litrosPortaMalas;
        this.tipoTracao = tipoTracao;
        this.tipoCombustivel = tipoCombustivel;
    }

    public Double getLitrosPortaMalas() {
        return litrosPortaMalas;
    }

    public void setLitrosPortaMalas(double litrosPortaMalas) {
        this.litrosPortaMalas = litrosPortaMalas;
    }


    public String getTipoTracao() {
        return tipoTracao;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
}
