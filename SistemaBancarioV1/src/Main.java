import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente();
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("------- Faça seu cadastro ------");

        System.out.println("Nome: ");
        contaCorrente.nome = scan.nextLine();

        boolean cpfInvalido = true;
        while (cpfInvalido == true){
            System.out.println("Cpf: ");
            contaCorrente.cpf = scan.nextLine();
            String cpfSemEspaço = contaCorrente.cpf.replace(" ", "");
            String cpfSemPonto = cpfSemEspaço.replace(".", "");
            String cpfTratado = cpfSemPonto.replace("-", "");
            String vetorCpf[] = cpfTratado.split("");
            boolean erro = false;
            for (int i = 0; i < vetorCpf.length; i++) {

                if (!Character.isDigit(cpfTratado.charAt(i))) {

                    erro = true;

                    break;

                }
            }
            if (erro){
                System.out.println();
                System.out.println("Não pode conter letras");
            }
            else {
                if (vetorCpf.length > 11 ){
                    System.out.println();
                    System.out.println("cpf invalido, numero muito grande, use o formato 000.000.000-00");
                }
                if (vetorCpf.length < 11){
                    System.out.println();
                    System.out.println("cpf invalido, numero muito pequeno, use o formato 000.000.000-00");
                }
                if (vetorCpf.length == 11){
                    cpfInvalido = false;
                }
            }
        }

        contaCorrente.numeroConta = random.nextInt(999999999);
        String.format("%09d", contaCorrente.numeroConta);


        boolean agenciaInvalida = true;
        while (agenciaInvalida == true){
            System.out.println("Agência: ");
            contaCorrente.agencia = scan.nextLine();

            String vetorAgencia[] = contaCorrente.agencia.split("");
            boolean erro = false;
            for (int i = 0; i < vetorAgencia.length; i++) {

                if (!Character.isDigit(contaCorrente.agencia.charAt(i))) {

                    erro = true;

                    break;

                }
            }
            if (erro){
                System.out.println();
                System.out.println("Não pode conter letras");
            }
            else{
                if (vetorAgencia.length > 4 ){
                    System.out.println();
                    System.out.println("Agência invalida, numero muito grande, formato recomendado 0000");
                }
                if (vetorAgencia.length < 4){
                    System.out.println();
                    System.out.println("Agência invalido, numero muito pequeno, formato recomendado 0000");
                }
                if (vetorAgencia.length == 4){
                    agenciaInvalida = false;
                }
            }

        }

        boolean senhaInvalida = true;
        while (senhaInvalida == true){
            System.out.println("Senha: ");
            contaCorrente.senha = scan.nextLine();

            String vetorSenha[] = contaCorrente.senha.split("");
            boolean erro = false;
            for (int i = 0; i < vetorSenha.length; i++) {

                if (!Character.isDigit(contaCorrente.senha.charAt(i))) {

                    erro = true;

                    break;

                }
            }
            if (erro){
                System.out.println();
                System.out.println("Não pode conter letras");
            }
            else {
                senhaInvalida = false;
            }
            System.out.println("--------------------------------");
            System.out.println();
        }

        System.out.println("--------------------------------");
        System.out.println();
        System.out.println(" conta cadastrada com sucesso!!!");
        System.out.println(" numero da conta: " + contaCorrente.numeroConta);
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();

        boolean login = false;
        while (!login){
            int senhaInteira = Integer.parseInt(contaCorrente.senha);
            int numeroContaInteiro = contaCorrente.numeroConta;
            System.out.println();
            System.out.println("------------- Login ------------");
            System.out.println();
            System.out.println("numero da conta: ");
            int validarNumeroConta = scan.nextInt();
            System.out.println("senha: ");
            int validarSenha = scan.nextInt();
            System.out.println();
            System.out.println("--------------------------------");

            if (validarNumeroConta != numeroContaInteiro){
                System.out.println();
                System.out.println("seu numero da conta esta incorreta");

            }
            else{
                if (validarSenha != senhaInteira){
                    System.out.println();
                    System.out.println("sua senha esta incorreta");

                }
                else{
                    login = true;
                    System.out.println("  login efetuado com sucesso!!! ");
                    System.out.println("--------------------------------");
                }
            }
        }
        boolean encerrar = false;
        while (!encerrar){
            System.out.println();
            System.out.println("----- Escolha uma operação ------");
            System.out.println("Seu saudo atual e de: " + contaCorrente.saldo);
            System.out.println("0 = Saque");
            System.out.println("1 = Deposito");
            System.out.println("2 = Transferencia");
            System.out.println("3 = Extrato");
            System.out.println("4 = sair");
            System.out.println("---------------------------------");
            System.out.println();
            int operaçao = scan.nextInt();

            if (operaçao == 0) {
                if (contaCorrente.saldo == 0){
                    System.out.println();
                    System.out.println("Você não possui dinheiro para sacar nessa conta");
                }
                else {
                    System.out.println("Digite o valor que deseja sacar");
                    contaCorrente.debito = scan.nextDouble();
                    contaCorrente.sacar();
                }
            }
            if(operaçao == 1){
                System.out.println("Digite o valor que deseja depositar");
                contaCorrente.deposito = scan.nextDouble();
                contaCorrente.depositar();
            }
            if(operaçao == 2){
                System.out.println("Digite o valor que deseja transferir");
                contaCorrente.transferencia = scan.nextDouble();
                contaCorrente.transferir();
            }
            if(operaçao == 3){
                System.out.println();
                System.out.println("------------ Extrato ------------");
                System.out.println("Nome: " + contaCorrente.nome);
                System.out.println("Cpf: " + contaCorrente.cpf);
                System.out.println("Numero da conta: " + contaCorrente.numeroConta);
                System.out.println("Agência: " + contaCorrente.agencia);
                System.out.println("Saldo: " + contaCorrente.saldo);
                System.out.println("Ultimo deposito: " + contaCorrente.deposito);
                System.out.println("Ultimo saque: " + contaCorrente.debito);
                System.out.println("Ultima transferência: " + contaCorrente.transferencia);
                System.out.println("---------------------------------");
                System.out.println();
            }
            if(operaçao == 4){
                encerrar = true;
                System.out.println();
                System.out.println("---------------------------------");
                System.out.println("------------ Fim !!! ------------");
                System.out.println("---------------------------------");
            }
            if(operaçao > 4){
                System.out.println("Valor da operação não existente, digite um valor de 0 a 4");
                System.out.println();
            }
        }
    }
}
