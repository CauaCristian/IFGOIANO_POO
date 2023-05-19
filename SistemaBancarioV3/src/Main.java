import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean sair = false;
        ArrayList<Conta> contas = new ArrayList<Conta>();
        ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<ContaPoupanca>();
        while(!sair){
            System.out.println("1 = criar conta");
            System.out.println("2 = depositar");
            System.out.println("3 = sacar");
            System.out.println("4 = transferir");
            System.out.println("5 = extrato");
            System.out.println("6 = render");
            System.out.println("0 = sair");
            int operacao = scan.nextInt();
            scan.nextLine();
            if(operacao== 1){
                boolean exit = false;
                while (!exit){
                    System.out.println("digite o numero correspondente a conta que deseja criar");
                    System.out.println("1 = Conta Corrente");
                    System.out.println("2 = Conta Poupança");
                    System.out.println("3 = Conta Especial");
                    System.out.println("4 = Conta Empresarial");
                    System.out.println("5 = Nào desejo criar mais nem uma conta");
                    int op = scan.nextInt();
                    scan.nextLine();
                    if(op== 1){
                        System.out.println("digite seu nome: ");
                        String nome = scan.nextLine();
                        System.out.println("digite sua idade: ");
                        int idade = scan.nextInt();
                        scan.nextLine();
                        System.out.println("digite seu cpf: ");
                        String cpf = scan.nextLine();
                        Cliente titular = new PessoaFisica(nome,idade,cpf);
                        System.out.println("digite o numero da sua agencia: ");
                        String agencia = scan.nextLine();
                        System.out.println("digite sua senha: ");
                        String senha = scan.nextLine();
                        contas.add(new ContaCorrente(titular,agencia,senha));
                        System.out.println("numero da conta criada: " + contas.get(contas.size()-1).getNumero());
                    }
                    if(op== 2){
                        System.out.println("digite seu nome: ");
                        String nome = scan.nextLine();
                        System.out.println("digite sua idade: ");
                        int idade = scan.nextInt();
                        scan.nextLine();
                        System.out.println("digite seu cpf: ");
                        String cpf = scan.nextLine();
                        Cliente titular = new PessoaFisica(nome,idade,cpf);
                        System.out.println("digite o numero da sua agencia: ");
                        String agencia = scan.nextLine();
                        System.out.println("digite sua senha: ");
                        String senha = scan.nextLine();
                        ContaPoupanca conta = new ContaPoupanca(titular,agencia,senha);
                        contas.add(conta);
                        contasPoupancas.add(conta);
                        System.out.println("numero da conta criada: " + contas.get(contas.size()-1).getNumero());
                    }
                    if(op== 3){
                        System.out.println("digite seu nome: ");
                        String nome = scan.nextLine();
                        System.out.println("digite sua idade: ");
                        int idade = scan.nextInt();
                        scan.nextLine();
                        System.out.println("digite seu cpf: ");
                        String cpf = scan.nextLine();
                        Cliente titular = new PessoaFisica(nome,idade,cpf);
                        System.out.println("digite o numero da sua agencia: ");
                        String agencia = scan.nextLine();
                        System.out.println("digite sua senha: ");
                        String senha = scan.nextLine();
                        contas.add(new ContaEspecial(titular,agencia,senha));
                        System.out.println("numero da conta criada: " + contas.get(contas.size()-1).getNumero());
                    }
                    if(op== 4){
                        System.out.println("digite seu nome: ");
                        String nome = scan.nextLine();
                        System.out.println("digite sua idade: ");
                        int idade = scan.nextInt();
                        scan.nextLine();
                        System.out.println("digite seu cnpj: ");
                        String cnpj = scan.nextLine();
                        PessoaJuridica titular = new PessoaJuridica(nome,idade,cnpj);
                        System.out.println("digite o numero da sua agencia: ");
                        String agencia = scan.nextLine();
                        System.out.println("digite sua senha: ");
                        String senha = scan.nextLine();
                        contas.add(new ContaEmpresarial(titular,agencia,senha));
                        System.out.println("numero da conta criada: " + contas.get(contas.size()-1).getNumero());

                    }
                    if(op== 5){
                        exit = true;
                    }

                }
            }
            if(operacao ==2){
                System.out.println("informe o numero da sua conta");
                int numero = scan.nextInt();
                scan.nextLine();
                Conta conta;
                for(int i = 0; i < contas.size();i++){
                    if(numero == contas.get(i).getNumero()){
                        conta =  contas.get(i);
                        System.out.println("digite o valor que deseja depositar: ");
                        double valor = scan.nextDouble();
                        conta.depositar(valor);
                    }
                }
            }
            if(operacao ==3){
                System.out.println("informe o numero da sua conta");
                int numero = scan.nextInt();
                scan.nextLine();
                Conta conta;
                for(int i = 0; i < contas.size();i++){
                    if(numero == contas.get(i).getNumero()){
                        conta =  contas.get(i);
                        System.out.println("digite o valor que deseja sacar: ");
                        double valor = scan.nextDouble();
                        conta.sacar(valor);
                    }
                }
            }
            if(operacao ==4){
                System.out.println("informe o numero da sua conta");
                int numero = scan.nextInt();
                scan.nextLine();
                Conta conta;
                for(int i = 0; i < contas.size();i++){
                    if(numero == contas.get(i).getNumero()){
                        conta =  contas.get(i);
                        System.out.println("informe o numero da conta que deseja transferir: ");
                        numero = scan.nextInt();
                        for(i = 0; i < contas.size();i++){
                            if(numero == contas.get(i).getNumero()){
                                System.out.println("digite o valor que deseja transferir: ");
                                double valor = scan.nextDouble();
                                Conta contadestino =  contas.get(i);
                                conta.transferir(valor, contadestino);
                            }
                        }

                    }
                }
            }
            if(operacao ==5){
                System.out.println("informe o numero da sua conta");
                int numero = scan.nextInt();
                scan.nextLine();
                Conta conta;
                for(int i = 0; i < contas.size();i++){
                    if(numero == contas.get(i).getNumero()){
                        conta =  contas.get(i);
                        System.out.println("Numero Conta: " + conta.getNumero());
                        System.out.println("saldo Conta: " + conta.getSaldo());
                    }
                }
            }
            if(operacao ==6){
                System.out.println("informe o numero da sua conta");
                int numero = scan.nextInt();
                scan.nextLine();
                Conta conta;
                ContaPoupanca contaPoupanca;

                for(int i = 0; i < contasPoupancas.size();i++){
                    if(numero == contasPoupancas.get(i).getNumero()){
                        contaPoupanca = contasPoupancas.get(i);
                        for(int in = 0; in < contas.size();in++){
                            if(numero == contas.get(in).getNumero()){
                                conta = contas.get(in);
                                double saldoVelho = conta.getSaldo();
                                contaPoupanca.setSaldo(saldoVelho);
                            }
                        }
                        contaPoupanca.render();
                        System.out.println("rendimento aplicado com sucesso");
                        for(int in = 0; in < contas.size();in++){
                            if(numero == contas.get(in).getNumero()){
                                conta = contas.get(in);
                                double saldoNovo = contaPoupanca.getSaldo();
                                conta.setSaldo(saldoNovo);
                                System.out.println("rendimento aplicado com sucesso");
                            }
                        }
                    }
                }

            }
            if(operacao == 0){
                sair = true;
            }
    }
}
}