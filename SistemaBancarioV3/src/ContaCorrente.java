public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente titular,String agencia, String senha) {
        super(titular,agencia, senha);
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
}
