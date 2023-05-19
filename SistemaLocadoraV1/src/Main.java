import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Locadora locadora = new Locadora("locadora sul","Av São Francisco","2222-4444");
        ClienteFisico clienteFisico = new ClienteFisico("cliente teste fisico","342442","av sla","234324234324");
        ClienteJuridico clienteJuridico = new ClienteJuridico("cliente teste juridico","342442","av sla","234324234324");
        VeiculoLuxo veiculoLuxo = new VeiculoLuxo("land-rover","velar","234-abc","2023",4000.0,400.0,8,400.0,true);
        VeiculoPopular veiculoPopular = new VeiculoPopular("ford","fiesta","f34-adc","2017",1500.0,150.0,true);
        VeiculoSUV veiculoSUV = new VeiculoSUV("jeep","compass","365-adf","2021",2500.0,250.0,350.0,"4x4","diesel");
        locadora.addCliente(clienteFisico);
        locadora.addCliente(clienteJuridico);
        locadora.addVeiculo(veiculoSUV);
        locadora.addVeiculo(veiculoPopular);
        locadora.addVeiculo(veiculoLuxo);
        boolean sair = false;
        while(!sair){
            System.out.println("operações");
            System.out.println("1 = adicionar veiculo");
            System.out.println("2 = adicionar cliente");
            System.out.println("3 = realizar emprestimo");
            System.out.println("4 = finalizar um emprestimo");
            System.out.println("5 = renovar emprestimo");
            System.out.println("6 = sair");
            int op = scan.nextInt();
            scan.nextLine();
            if(op == 1){
                System.out.println("qual tipo de veiculo deseja adicionar ?");
                System.out.println("1 = Popular");
                System.out.println("2 = Suv");
                System.out.println("3 = Luxo");
                int tipo = scan.nextInt();
                scan.nextLine();
                if(tipo == 1){
                    System.out.println("digite a marca do carro");
                    String marca = scan.nextLine();
                    System.out.println("digite o modelo do carro");
                    String modelo = scan.nextLine();
                    System.out.println("digite a placa do carro");
                    String placa = scan.nextLine();
                    System.out.println("digite o ano do carro");
                    String ano = scan.nextLine();
                    System.out.println("digite um preço do aluguel com ,");
                    double preco = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("digite uma multa do aluguel com ,");
                    double multa = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("o carro possui ar condicionado?");
                    System.out.println("1 = sim");
                    System.out.println("2 = nao");
                    int simOuNao = scan.nextInt();
                    scan.nextLine();
                    boolean ar = false;
                    if(simOuNao == 1){
                        ar = true;
                    }
                    if(simOuNao == 2){
                        ar = false;
                    }
                    else{
                        System.out.println("numero de operação inexistente");
                    }
                    VeiculoPopular veiculo = new VeiculoPopular(marca,modelo,placa,ano,preco,multa,ar);
                    locadora.addVeiculo(veiculo);
                }
                if(tipo == 2){
                    System.out.println("digite a marca do carro");
                    String marca = scan.nextLine();
                    System.out.println("digite o modelo do carro");
                    String modelo = scan.nextLine();
                    System.out.println("digite a placa do carro");
                    String placa = scan.nextLine();
                    System.out.println("digite o ano do carro");
                    String ano = scan.nextLine();
                    System.out.println("digite um preço do aluguel com ,");
                    double preco = scan.nextDouble();
                    System.out.println("digite uma multa do aluguel com ,");
                    double multa = scan.nextDouble();
                    System.out.println("digite a litragem do porta mala com ,");
                    double litragem = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("digite a tração do veiculo");
                    String tracao = scan.nextLine();
                    System.out.println("digite o tipo de combustivel");
                    String combustivel = scan.nextLine();
                    VeiculoSUV veiculo = new VeiculoSUV(marca,modelo,placa,ano,preco,multa,litragem,tracao,combustivel);
                    locadora.addVeiculo(veiculo);
                }
                if(tipo == 3){
                    System.out.println("digite a marca do carro");
                    String marca = scan.nextLine();
                    System.out.println("digite o modelo do carro");
                    String modelo = scan.nextLine();
                    System.out.println("digite a placa do carro");
                    String placa = scan.nextLine();
                    System.out.println("digite o ano do carro");
                    String ano = scan.nextLine();
                    System.out.println("digite um preço do aluguel com ,");
                    double preco = scan.nextDouble();
                    System.out.println("digite uma multa do aluguel com ,");
                    double multa = scan.nextDouble();
                    System.out.println("digite a quantidade de airbags");
                    int qtdAirbags = scan.nextInt();
                    scan.nextLine();
                    System.out.println("digite a litragem do porta mala com ,");
                    double litragem = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("o carro possui gps?");
                    System.out.println("1 = sim");
                    System.out.println("2 = nao");
                    int simOuNao = scan.nextInt();
                    scan.nextLine();
                    boolean gps = false;
                    if(simOuNao == 1){
                        gps = true;
                    }
                    if(simOuNao == 2){
                        gps = false;
                    }
                    else{
                        System.out.println("numero de operação inexistente");
                    }
                    VeiculoLuxo veiculo = new VeiculoLuxo(marca,modelo,placa,ano,preco,multa,qtdAirbags,litragem,gps);
                    locadora.addVeiculo(veiculo);
                }
                else{
                    System.out.println("numero de operação inexistente");
                }
            }
            if(op == 2){
                System.out.println("qual tipo de cliente deseja cadastrar?");
                System.out.println("1 = Físico");
                System.out.println("2 = Jurídico");
                int tipo = scan.nextInt();
                scan.nextLine();
                if(tipo == 1){
                    System.out.println("digite o nome do cliente");
                    String nome = scan.nextLine();
                    System.out.println("digite o telefone do cliente");
                    String telefone = scan.nextLine();
                    System.out.println("digite o endereço do cliente");
                    String endereco = scan.nextLine();
                    System.out.println("digite o cpf do cliente");
                    String cpf = scan.nextLine();
                    ClienteFisico cliente = new ClienteFisico(nome,telefone,endereco,cpf);
                    locadora.addCliente(cliente);
                }
                if(tipo == 2){
                    System.out.println("digite o nome do cliente");
                    String nome = scan.nextLine();
                    System.out.println("digite o telefone do cliente");
                    String telefone = scan.nextLine();
                    System.out.println("digite o endereço do cliente");
                    String endereco = scan.nextLine();
                    System.out.println("digite o cnpj do cliente");
                    String cnpj = scan.nextLine();
                    ClienteJuridico cliente = new ClienteJuridico(nome,telefone,endereco,cnpj);
                    locadora.addCliente(cliente);
                }
                else{
                    System.out.println("numero de operação inexistente");
                }
            }
            if(op == 3){
                locadora.listarVeiculosDisponiveis();
                System.out.println("digite o numero do veiculo que deseja alugar");
                int numero = scan.nextInt();
                scan.nextLine();
                Veiculo veiculo = locadora.pegarVeiculo(numero);
                if(veiculo != null){
                    locadora.listarClientes();
                    System.out.println("digite o numero do cliente que deseja vincular ao emprestimo");
                    int numeroCliente = scan.nextInt();
                    scan.nextLine();
                    Cliente cliente = locadora.pegarCliente(numeroCliente);
                    if(cliente != null){
                        try {
                            locadora.addEmprestimos(new Emprestimo(veiculo,cliente));
                        } catch (CarroAlugadoException e) {
                            e.printStackTrace();
                        } catch (ClienteSemPermissãoException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("cliente inexistente");
                    }
                }
                else{
                    System.out.println("carro inexistente");
                }
            }
            if(op == 4){
                locadora.listarClientes();
                System.out.println("digite o numero do cliente que deseja devolver o emprestimo");
                int numeroCliente = scan.nextInt();
                scan.nextLine();
                Cliente cliente = locadora.pegarCliente(numeroCliente);
                if(cliente != null){
                    locadora.listarEmprestimo(cliente);
                    System.out.println("digite o numero do emprestimo");
                    int numeroEmprestimo = scan.nextInt();
                    scan.nextLine();
                    Emprestimo emprestimo = locadora.pegarEmprestimo(numeroEmprestimo);
                    if(emprestimo != null){
                        emprestimo.devolver();
                        System.out.println("valor a pagar: " + emprestimo.getValorEmprestimo());
                        locadora.removeEmprestimos(emprestimo);
                    }
                    else{
                        System.out.println("emprestimo inexistente");
                    }
                }
                else{
                    System.out.println("cliente inexistente");
                }
            }
            if(op == 5){
                locadora.listarClientes();
                System.out.println("digite o numero do cliente que deseja renovar o emprestimo");
                int numeroCliente = scan.nextInt();
                scan.nextLine();
                Cliente cliente = locadora.pegarCliente(numeroCliente);
                if(cliente != null){
                    locadora.listarEmprestimo(cliente);
                    System.out.println("digite o numero do emprestimo");
                    int numeroEmprestimo = scan.nextInt();
                    scan.nextLine();
                    Emprestimo emprestimo = locadora.pegarEmprestimo(numeroEmprestimo);
                    if(emprestimo != null){
                        emprestimo.renovar();
                    }
                    else{
                        System.out.println("emprestimo inexistente");
                    }
                }
                else{
                    System.out.println("cliente inexistente");
                }
            }
            if(op == 6){
                sair = true;
            }
            else{
                System.out.println("numero de operação inexistente");
            }
        }
    }
}