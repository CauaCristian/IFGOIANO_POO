import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {

    Scanner scan = new Scanner(System.in);
    Validaçao validaçao = new Validaçao();
    ArrayList<ContaCorrente> contaCorrente = new ArrayList<ContaCorrente>();
    void puxarinfo() {
            System.out.println("---------------cadastro----------------");
            System.out.println("Crie no minimo duas contas");
            System.out.println("digite seu cpf: ");
            String cpf = scan.nextLine();
            while (validaçao.cpf(cpf)){
                System.out.println("digite seu cpf: ");
                 cpf = scan.nextLine();
            }
            System.out.println("digite seu nome: ");
            String nome = scan.nextLine();
            Pessoa titular = new Pessoa(nome, cpf);
            System.out.println("digite sua agência: ");
            String agencia = scan.nextLine();
            while(validaçao.agencia(agencia)){
                System.out.println("digite sua agência: ");
                agencia = scan.nextLine();
            }
            System.out.println("digite sua senha: ");
            String senha = scan.nextLine();
            while(validaçao.senha(senha)){
                System.out.println("digite sua senha: ");
                senha = scan.nextLine();
            }
            contaCorrente.add(new ContaCorrente(titular, agencia, senha));
            System.out.println("---------------------------------------");

            int i = (contaCorrente.size())-1;
            ContaCorrente conta = contaCorrente.get(i);
            System.out.println("------conta criado com sucesso!!!------");
            System.out.println("Seu numero da conta e: "+ conta.getNumero());
            System.out.println("---------------------------------------");

    }
    public ContaCorrente buscarConta(int numero) {

        for (int i=0;i<contaCorrente.size();i++) {
            if (contaCorrente.get(i).getNumero() == numero ) {
                ContaCorrente conta = contaCorrente.get(i);
                return conta;
            }
        }
        return null;
    }
    public ContaCorrente logar() {
        System.out.println("----------------login------------------");
        System.out.println("digite a SENHA da sua conta: ");
        String senha = scan.nextLine();
        System.out.println("digite o NUMERO da sua conta: ");
        int numero = scan.nextInt();
        System.out.println("---------------------------------------");
        ContaCorrente contaValida = buscarConta(numero);
        if (contaValida == null) {
            Boolean valida = false;
            while(!valida){
                System.out.println("digite o NUMERO da sua conta: ");
                numero = scan.nextInt();
                contaValida = buscarConta(numero);
                if (contaValida == null){
                    System.out.println("---------------------------------------");
                    System.out.println("Seu numero esta incorreto");
                    System.out.println("---------------------------------------");
                }
                else {
                    valida = true;
                }
            }
        }
        else  {
            boolean logado = false;

            while (!logado) {
                if (senha.equals(contaValida.getSenha())){
                    logado = true;
                    return contaValida;
                }else{
                    System.out.println("---------------------------------------");
                    System.out.println("sua senha esta incorreta");
                    System.out.println("---------------------------------------");
                    System.out.println("digite a senha da sua conta: ");
                    senha = scan.nextLine();
                    System.out.println("---------------------------------------");
                }
            }
            return contaValida;
        }
        return contaValida;
    }
    ContaCorrente cadastrar (){
        Scanner scan = new Scanner(System.in);
        boolean cadastrado = false;
        while(!cadastrado){

            puxarinfo();
            System.out.println("---------------------------------------");
            System.out.println("1 = quero fazer outro cadastro");
            System.out.println("2 = quero fazer meu login");
            System.out.println("---------------------------------------");
            int opçao = scan.nextInt();
            if (opçao == 1){
                puxarinfo();
                ContaCorrente conta = logar();
                cadastrado = true;
                return conta;
            }
            if(opçao == 2){
                ContaCorrente conta;
                conta =  logar();
                cadastrado = true;
                return conta;
            }
            if(opçao>2){
                System.out.println("---------------------------------------");
                System.out.println("numero digitado invalido faça seu login para continuar");
                System.out.println("---------------------------------------");
                cadastrado = true;
            }
        }
        return null;
    }



}

