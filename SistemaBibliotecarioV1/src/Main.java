import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Biblioteca do Instituto Federal Goiano","no mei do mato");
        Livro livro1 = new Livro(new Date(),"o conto do pescador americano com um cavalo de asa azul",2.5,"123456789","123123123321","2313313213");
        Livro livro2 = new Livro(new Date(),"harry potter e a vara do voldemort",2.5,"123453489","1231243534534523321","23765773213");
        Tese tese1 = new Tese(new Date(),"tese do cauã do bololo",30.5,650,"varios nada",new Date(),"Instituto Federal Goiano Campus mei do mato");
        Artigo artigo1 = new Artigo(new Date(),"Artigo 22",10.45,"não tem");
        biblioteca.publicaçoes.add(livro1);
        biblioteca.publicaçoes.add(livro2);
        biblioteca.publicaçoes.add(tese1);
        biblioteca.publicaçoes.add(artigo1);
        Scanner scan = new Scanner(System.in);
        boolean sair = false;
        while(!sair){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Operações");
            System.out.println("1 = Criar conta");
            System.out.println("2 = Alugar");
            System.out.println("3 = Devolver");
            System.out.println("4 = Renovar");
            System.out.println("5 = Listar meus emprestimos");
            System.out.println("6 = Ver multa pendente");
            System.out.println("7 = simular 7 dias de atraso");
            System.out.println("8 = Sair");
            System.out.println("-----------------------------------------------------------------");
            int op = scan.nextInt();
            scan.nextLine();
            if(op==1){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("qual tipo da conta que deseja criar ?");
                System.out.println("1 = Conta Padrão");
                System.out.println("2 = Conta Especial");
                System.out.println("-----------------------------------------------------------------");
                int tipoCliente = scan.nextInt();
                scan.nextLine();
                if(tipoCliente ==1){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu nome: ");
                    System.out.println("-----------------------------------------------------------------");
                    String nome = scan.nextLine();
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu telefone: ");
                    System.out.println("-----------------------------------------------------------------");
                    String telefone = scan.nextLine();
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu email: ");
                    System.out.println("-----------------------------------------------------------------");
                    String email = scan.nextLine();
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu cpf: ");
                    System.out.println("-----------------------------------------------------------------");
                    String cpf = scan.nextLine();
                    ClientePadrao clientePadrao = new ClientePadrao(nome,telefone,email,cpf);
                    biblioteca.clientes.add(clientePadrao);
                }
                if(tipoCliente ==2){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu nome: ");
                    System.out.println("-----------------------------------------------------------------");
                    String nome = scan.nextLine();
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu telefone: ");
                    System.out.println("-----------------------------------------------------------------");
                    String telefone = scan.nextLine();
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu email: ");
                    System.out.println("-----------------------------------------------------------------");
                    String email = scan.nextLine();
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite seu cpf: ");
                    System.out.println("-----------------------------------------------------------------");
                    String cpf = scan.nextLine();
                    ClienteEspecial clienteEspecial = new ClienteEspecial(nome,telefone,email,cpf);
                    biblioteca.clientes.add(clienteEspecial);
                }
            }
            if(op==2){
                biblioteca.listarDisponiveis();
                System.out.println("-----------------------------------------------------------------");
                System.out.println("digite seu cpf:");
                System.out.println("-----------------------------------------------------------------");
                String cpf = scan.nextLine();
                Cliente cliente = biblioteca.buscarCliente(cpf);
                if(cliente!=null){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite o numero correspondente a publicação que deseja alugar: ");
                    System.out.println("-----------------------------------------------------------------");
                    int numero = scan.nextInt();
                    scan.nextLine();
                    Publicaçao publicaçao = biblioteca.buscarPublicaçao(numero);
                    if(publicaçao!= null){
                        Emprestimo emprestimo = new Emprestimo(cliente,publicaçao);
                        biblioteca.emprestimos.add(emprestimo);
                        emprestimo.alugar();
                    }
                    else{
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("numero da publicação inexistente");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("cpf inexistente");
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if(op==3){
                biblioteca.listarIndisponiveis();
                System.out.println("-----------------------------------------------------------------");
                System.out.println("digite seu cpf:");
                System.out.println("-----------------------------------------------------------------");
                String cpf = scan.nextLine();
                Cliente cliente = biblioteca.buscarCliente(cpf);
                if(cliente!=null){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite o numero correspondente a publicação que deseja devolver: ");
                    System.out.println("-----------------------------------------------------------------");
                    int numero = scan.nextInt();
                    scan.nextLine();
                    Publicaçao publicaçao = biblioteca.buscarPublicaçao(numero);
                    if(publicaçao!= null){
                        Emprestimo emprestimo = biblioteca.buscarEmprestimo(publicaçao);
                        if(emprestimo!=null){
                            biblioteca.emprestimos.remove(emprestimo);
                            emprestimo.devolver();
                        }
                        else{
                            System.out.println("-----------------------------------------------------------------");
                            System.out.println("esta publicação nao esta alugada");
                            System.out.println("-----------------------------------------------------------------");
                        }
                    }
                    else{
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("numero da publicação inexistente");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("cpf inexistente");
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if(op==4){
                biblioteca.listarIndisponiveis();
                System.out.println("-----------------------------------------------------------------");
                System.out.println("digite seu cpf:");
                System.out.println("-----------------------------------------------------------------");
                String cpf = scan.nextLine();
                Cliente cliente = biblioteca.buscarCliente(cpf);
                if(cliente!=null){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite o numero correspondente a publicação que deseja renovar: ");
                    System.out.println("-----------------------------------------------------------------");
                    int numero = scan.nextInt();
                    scan.nextLine();
                    Publicaçao publicaçao = biblioteca.buscarPublicaçao(numero);
                    if(publicaçao!= null){
                        Emprestimo emprestimo = biblioteca.buscarEmprestimo(publicaçao);
                        if(emprestimo!=null){
                            emprestimo.renovar();
                        }
                        else{
                            System.out.println("-----------------------------------------------------------------");
                            System.out.println("esta publicação nao esta alugada");
                            System.out.println("-----------------------------------------------------------------");
                        }
                    }
                    else{
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("numero da publicação inexistente");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("cpf inexistente");
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if(op==5){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("digite seu cpf:");
                System.out.println("-----------------------------------------------------------------");
                String cpf = scan.nextLine();
                Cliente cliente = biblioteca.buscarCliente(cpf);
                if(cliente!=null){
                    biblioteca.listarEmprestimo(cliente);
                }
                else{
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("cpf inexistente");
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if(op==6){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("digite seu cpf:");
                System.out.println("-----------------------------------------------------------------");
                String cpf = scan.nextLine();
                Cliente cliente = biblioteca.buscarCliente(cpf);
                if(cliente!=null){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println(cliente.getMultaPendente() + " R$");
                    System.out.println("-----------------------------------------------------------------");
                }
                else{
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("cpf inexistente");
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if(op==7){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("digite seu cpf:");
                System.out.println("-----------------------------------------------------------------");
                String cpf = scan.nextLine();
                Cliente cliente = biblioteca.buscarCliente(cpf);
                if(cliente!=null){
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("digite o numero correspondente a publicação que deseja simular atraso: ");
                    System.out.println("-----------------------------------------------------------------");
                    int numero = scan.nextInt();
                    scan.nextLine();
                    Publicaçao publicaçao = biblioteca.buscarPublicaçao(numero);
                    if(publicaçao!= null){
                        Emprestimo emprestimo = biblioteca.buscarEmprestimo(publicaçao);
                        if(emprestimo!=null){
                            emprestimo.atrasar7dias();
                        }
                        else{
                            System.out.println("-----------------------------------------------------------------");
                            System.out.println("esta publicação nao esta alugada");
                            System.out.println("-----------------------------------------------------------------");
                        }
                    }
                    else{
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("numero da publicação inexistente");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
                else{
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("cpf inexistente");
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            if(op==8){
                System.out.println("-----------------------------------------------------------------");
                System.out.println("------------------------------fim!-------------------------------");
                System.out.println("-----------------------------------------------------------------");
                sair = true;
            }
        }
    }
}