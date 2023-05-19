import java.util.Calendar;
import java.util.Date;

public class Emprestimo {

    private Cliente cliente;
    private Publicaçao publicaçao;
    private Date dataEmprestimo;
    private Date dataDevoluçao;

    private int qtdRenovaçao;

    private Calendar calendarioDevoluçao = Calendar.getInstance();
    private Calendar calendarioEmprestimo = Calendar.getInstance();
    public Emprestimo(Cliente cliente, Publicaçao publicaçao) {
        this.cliente = cliente;
        this.publicaçao = publicaçao;
        this.qtdRenovaçao = 0;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Publicaçao getPublicaçao() {
        return publicaçao;
    }
    public void setPublicaçao(Publicaçao publicaçao) {
        this.publicaçao = publicaçao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevoluçao() {
        return dataDevoluçao;
    }

    public void setDataDevoluçao(Date dataDevoluçao) {
        this.dataDevoluçao = dataDevoluçao;
    }

    public int getQtdRenovaçao() {
        return qtdRenovaçao;
    }

    public void setQtdRenovaçao(int qtdRenovaçao) {
        this.qtdRenovaçao = qtdRenovaçao;
    }

    public boolean alugar(){
        if(cliente.getClass().equals(ClientePadrao.class)){
            ClientePadrao clientePadrao = (ClientePadrao) cliente;
            if(clientePadrao.isLivroAlugado() == false){
                if (publicaçao.isAlugado() == false){
                    this.dataEmprestimo = new Date();
                    this.calendarioEmprestimo.setTime(this.dataEmprestimo);
                    this.calendarioDevoluçao.setTime(this.dataEmprestimo);
                    this.calendarioDevoluçao.add(Calendar.DATE,7);
                    this.dataDevoluçao = calendarioDevoluçao.getTime();
                    this.publicaçao.setAlugado(true);
                    clientePadrao.setLivroAlugado(true);
                    return true;
                }
                return false;
            }
            return false;

        }
        if(cliente.getClass().equals(ClienteEspecial.class)){
            if (publicaçao.isAlugado() == false){
                this.dataEmprestimo = new Date();
                this.calendarioEmprestimo.setTime(this.dataEmprestimo);
                this.calendarioDevoluçao.setTime(this.dataEmprestimo);
                this.calendarioDevoluçao.add(Calendar.DATE,7);
                this.dataDevoluçao = calendarioDevoluçao.getTime();
                this.publicaçao.setAlugado(true);
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean renovar(){
        setQtdRenovaçao(+1);
        if(getQtdRenovaçao() <=3){
            this.calendarioDevoluçao.setTime(this.dataDevoluçao);
            this.calendarioDevoluçao.add(Calendar.DATE,7);
            this.dataDevoluçao = calendarioDevoluçao.getTime();
            return true;
        }
        return false;
    }
    public double calcularmulta(){
        Calendar calendarioAtual = Calendar.getInstance();
        calendarioAtual.set(Calendar.HOUR_OF_DAY,0);
        calendarioAtual.set(Calendar.MINUTE,0);
        calendarioAtual.set(Calendar.SECOND,0);
        calendarioAtual.set(Calendar.MILLISECOND,0);

        this.calendarioDevoluçao.set(Calendar.HOUR_OF_DAY,0);
        this.calendarioDevoluçao.set(Calendar.MINUTE,0);
        this.calendarioDevoluçao.set(Calendar.SECOND,0);
        this.calendarioDevoluçao.set(Calendar.MILLISECOND,0);

        long atraso = (calendarioAtual.getTimeInMillis() - calendarioDevoluçao.getTimeInMillis()) / (24 * 60 * 60 * 1000);

        if(atraso>0){
            double multa = atraso*this.publicaçao.getValorMulta();
            return multa;
        }
        return 0.0;
    }

    public Boolean devolver(){
        if(cliente.getClass().equals(ClientePadrao.class)){
            ClientePadrao clientePadrao = (ClientePadrao) cliente;
            if(clientePadrao.isLivroAlugado() == true){
                Double multaPendente = clientePadrao.getMultaPendente() + calcularmulta();
                clientePadrao.setMultaPendente(multaPendente);
                this.publicaçao.setAlugado(false);
                clientePadrao.setLivroAlugado(false);
                setQtdRenovaçao(0);
                return true;
            }
            return false;

        }
        if(cliente.getClass().equals(ClienteEspecial.class)){
            Double multaPendente = cliente.getMultaPendente() + calcularmulta();
            this.cliente.setMultaPendente(multaPendente);
            this.publicaçao.setAlugado(false);
            setQtdRenovaçao(0);
            return true;
        }
        return false;
    }

    public void atrasar7dias(){
        this.calendarioDevoluçao.setTime(this.dataEmprestimo);
        this.calendarioDevoluçao.add(Calendar.DATE,-7);
        this.dataDevoluçao = calendarioDevoluçao.getTime();
    }
}
