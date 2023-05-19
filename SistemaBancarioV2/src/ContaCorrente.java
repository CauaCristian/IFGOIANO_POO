import java.util.Random;


public class ContaCorrente {
    Random random = new Random();

    private Pessoa titular;
    private int numero;
    private String agencia;
    private String senha;
    private double saldo;
    public ContaCorrente (Pessoa titular, String agencia, String senha){
        this.titular = titular;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = 0;
        this.numero = random.nextInt(999999999);
        String.format("%09d", this.numero);
    };

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean sacar(double valor){
        if(valor <= this.saldo && valor > 0){
            this.saldo = this.saldo - valor;
            System.out.println("----------------------------------");
            System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + "  - Saque realizado com sucesso!");
            System.out.println("----------------------------------");
            return true;
        }
        System.out.println("----------------------------------");
        System.out.println("Conta: "+ this.numero + " titular: " + this.titular.getNome() + " - Erro ao realizar o saque!");
        System.out.println("----------------------------------");
        return false;
    }

    public boolean depositar(double valor){
        if(valor > 0){
            this.saldo = this.saldo + valor;
            System.out.println("----------------------------------");
            System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + " - Deposito realizado com sucesso!");
            System.out.println("----------------------------------");
            return true;
        }
        System.out.println("----------------------------------");
        System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + " - Erro ao realizar o depositar!");
        System.out.println("----------------------------------");
        return false;
    }

    public boolean transferir(double valor, ContaCorrente contaDestino){
        System.out.println("----------------------------------");
        System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + " - Iniciou a transferencia");
        System.out.println("----------------------------------");
        if(this.sacar(valor)){
            if(contaDestino != null && contaDestino.depositar(valor)){
                System.out.println("----------------------------------");
                System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + " - Transferencia concluida");
                System.out.println("----------------------------------");
                return true;
            }
            System.out.println("----------------------------------");
            System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + " - Erro na transferencia");
            System.out.println("----------------------------------");
            return false;
        }
        else {
            System.out.println("----------------------------------");
            System.out.println("Conta: "+ this.numero+ " titular: " + this.titular.getNome() + " - Erro na transferencia");
            System.out.println("----------------------------------");
            return false;
        }

    }

    void extrato(){
        System.out.println("----------------------------------");
        System.out.println("Nome: "+ this.titular.getNome());
        System.out.println("Cpf: "+ this.titular.getCpf());
        System.out.println("Agência: "+ this.agencia);
        System.out.println("Numero conta: "+ this.numero);
        System.out.println("Saldo: "+ this.saldo);
        System.out.println("----------------------------------");
    }

}


