public class VeiculoPopular extends Veiculo{
    private boolean Arcondicionado;

    public VeiculoPopular(String marca, String modelo, String placa, String ano, Double preco,double valorMulta, boolean arcondicionado) {
        super(marca, modelo, placa, ano, preco,valorMulta,1);
        Arcondicionado = arcondicionado;
    }
    public Boolean getArcondicionado() {
        return Arcondicionado;
    }

    public void setArcondicionado(boolean arcondicionado) {
        Arcondicionado = arcondicionado;
    }
}
