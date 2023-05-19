import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Veiculo veiculo;
    private Cliente cliente;
    private int quantidadeRenovacao;
    private double valorEmprestimo;

    public Emprestimo(Veiculo veiculo, Cliente cliente) throws CarroAlugadoException, ClienteSemPermissãoException {
        if(cliente.permisaoAluguel() == true){
            if(veiculo.isAlugado() == false){
                this.veiculo = veiculo;
                this.cliente = cliente;
                this.quantidadeRenovacao = 0;
                this.valorEmprestimo = veiculo.getPreco();
                this.dataEmprestimo = LocalDate.now();
                this.dataDevolucao = LocalDate.now().plusDays(7);
                this.veiculo.setAlugado(true);
                this.cliente.setQuantidadeDeCarrosAlugados(+1);
            }
            else{
                throw new CarroAlugadoException("este carro ja esta alugado");
            }
        }
        else{
            throw new ClienteSemPermissãoException("este cliente nao possui permissao para alugar mais veiculos");
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getQuantidadeRenovacao() {
        return quantidadeRenovacao;
    }

    public void setQuantidadeRenovacao(int quantidadeRenovacao) {
        this.quantidadeRenovacao = quantidadeRenovacao;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }
    public double calcularMulta(){
        double multaTotal;
        double multaAtraso;
        double multaRenovacao;
        if(LocalDate.now().isAfter(this.dataDevolucao)){
            Period period = Period.between(LocalDate.now(),this.dataDevolucao);
            int diasAtrasados = Math.abs(period.getDays());
            multaAtraso = diasAtrasados*this.veiculo.getValorMulta();
        }
        else{
            multaAtraso = 0.0;
        }
        if(this.quantidadeRenovacao>this.veiculo.getQuantidadeRenovacaoSemCusto()){
            int quantidadeRenovacaoComCusto = Math.abs(this.quantidadeRenovacao - this.veiculo.getQuantidadeRenovacaoSemCusto());
            multaRenovacao = quantidadeRenovacaoComCusto * this.veiculo.getValorMulta();
        }
        else{
            multaRenovacao = 0.0;
        }
        multaTotal = multaAtraso + multaRenovacao;
        return multaTotal;
    }
    public double calcularValorEmprestimo(){
        double valor;
        valor = this.valorEmprestimo + calcularMulta();
        return valor;
    }

    public void devolver(){
        this.veiculo.setAlugado(false);
        this.cliente.setQuantidadeDeCarrosAlugados(-1);
        this.valorEmprestimo = calcularValorEmprestimo();
    }
    public void renovar(){
        this.quantidadeRenovacao += 1;
        this.dataDevolucao = this.dataDevolucao.plusDays(7);
    }

    public void simularAtraso7dias(){
        int dias = this.quantidadeRenovacao*7+14;
        this.dataDevolucao = this.dataDevolucao.plusDays(-dias);
    }

}
