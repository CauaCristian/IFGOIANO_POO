public class VeiculoLuxo extends Veiculo{
    private int quantidadeAirbags;
    private double listrosPortaMalas;
    private boolean gps;

    public VeiculoLuxo(String marca, String modelo, String placa, String ano, double preco,double valorMulta, int quantidadeAirbags, double listrosPortaMalas, boolean gps) {
        super(marca, modelo, placa, ano, preco,valorMulta,5);
        this.quantidadeAirbags = quantidadeAirbags;
        this.listrosPortaMalas = listrosPortaMalas;
        this.gps = gps;
    }

    public int getQuantidadeAirbags() {
        return quantidadeAirbags;
    }

    public void setQuantidadeAirbags(int quantidadeAirbags) {
        this.quantidadeAirbags = quantidadeAirbags;
    }

    public double getListrosPortaMalas() {
        return listrosPortaMalas;
    }

    public void setListrosPortaMalas(double listrosPortaMalas) {
        this.listrosPortaMalas = listrosPortaMalas;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }
}
