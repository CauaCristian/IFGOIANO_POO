public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente Titular, String agencia, String senha) {
        super(Titular, agencia, senha);
    }
    public boolean depositar(double valor){
        if(valor > 0 ){
            super.setSaldo(super.getSaldo() + valor);
            return true;
        }
        return false;
    }
    public boolean sacar(double valor){
        if(valor > 0 && super.getSaldo() > valor){
            super.setSaldo( super.getSaldo() - valor);
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta destino){
        if(sacar(valor)){
            if(destino != null){
                destino.depositar(valor);
                return true;
            }
        }
        return false;
    }

    public Boolean render(){
        if(super.getSaldo() != 0 && super.getSaldo() > 0){
            double juros = getSaldo() * 0.005;
            super.setSaldo( super.getSaldo() + juros);
        }
        return false;
    }
}
