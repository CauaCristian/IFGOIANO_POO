public class ContaCorrente {
    
    // atributos

    double saldo, debito, deposito, transferencia;
    String nome, cpf, agencia,senha;

    int numeroConta;
    // metodos sacar, depositar, transferir e receber.

    void sacar(){
        if(saldo>=debito){
            saldo = saldo-debito;
            System.out.println();
            System.out.println("saque efetuado com sucesso");
        }
        else{
            System.out.println();
            System.out.println("Você nao tem saldo suficiente para efetuar o saque");
        }
    }
    void depositar(){
        saldo = saldo+deposito;
        System.out.println();
        System.out.println("Deposito efetuado com sucesso");
    }
    void transferir(){
        if(saldo>=transferencia){
            saldo = saldo-transferencia;
            System.out.println();
            System.out.println("transferência efetuada com sucesso");
        }
        else{
            System.out.println();
            System.out.println("Você nao tem saldo suficiente para efetuar a transferência");
        }
    }
}

