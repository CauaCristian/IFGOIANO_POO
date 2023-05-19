import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cadastro cadastro = new Cadastro();

        Scanner scan =  new Scanner(System.in);

        ContaCorrente conta = cadastro.cadastrar();
        boolean sair = false;
        while (!sair) {
            System.out.println("---------------------------------------");
            System.out.println("Escolha uma operação");
            System.out.println("1 = saque");
            System.out.println("2 = deposito");
            System.out.println("3 = transferencia");
            System.out.println("4 = extrato");
            System.out.println("5 = trocar de conta");
            System.out.println("6 = sair");
            System.out.println("---------------------------------------");
            int operaçao = scan.nextInt();
            if (operaçao == 1){
                System.out.println("---------------------------------------");
                System.out.println("digite o valor que deseja sacar");
                double valor = scan.nextDouble();
                System.out.println("---------------------------------------");
                conta.sacar(valor);
            }
            if (operaçao == 2){
                System.out.println("---------------------------------------");
                System.out.println("digite o valor que deseja depositar");
                double valor = scan.nextDouble();
                System.out.println("---------------------------------------");
                conta.depositar(valor);
            }
            if (operaçao == 3){
                System.out.println("---------------------------------------");
                System.out.println("digite o valor que deseja transferir");
                double valor = scan.nextDouble();
                System.out.println("digite o numero da conta que deseja transferir o valor");
                int numero = scan.nextInt();
                System.out.println("---------------------------------------");
                ContaCorrente contaDestino = cadastro.buscarConta(numero);
                if(contaDestino == null){
                    System.out.println("---------------------------------------");
                    System.out.println("conta inexixtente");
                    System.out.println("---------------------------------------");
                }
                else {
                    conta.transferir(valor,contaDestino);
                }

            }
            if (operaçao == 4){
                conta.extrato();
            }
            if(operaçao == 5){
               conta = cadastro.logar();
            }
            if(operaçao == 6){
                System.out.println("---------------------------------------");
                System.out.println("------------------FIM!!!---------------");
                System.out.println("---------------------------------------");
                sair = true;
            }
            if (operaçao > 6){
                System.out.println("---------------------------------------");
                System.out.println("---------Operação não exixtente--------");
                System.out.println("---------------------------------------");
            }
        }
        scan.close();
    }
}
