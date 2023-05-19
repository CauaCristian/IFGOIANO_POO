import java.util.Random;

public abstract class Conta {
    Random random = new Random();
    private int numero;
    private String agencia;
    private String senha;
    private double saldo;
    public Conta(Cliente Titular, String agencia, String senha){
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = 0;
        this.numero = random.nextInt(999999999);
        String.format("%09d", this.numero);
    };

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean depositar(double valor);
    public abstract boolean sacar(double valor);
    public abstract boolean transferir(double valor, Conta destino);
}
