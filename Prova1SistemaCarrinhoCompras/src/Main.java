import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.println("digite seu nome: ");
        String nome = scan.nextLine();
        System.out.println("digite seu telefone: ");
        String telefone = scan.nextLine();
        System.out.println("digite seu cpf: ");
        String cpf = scan.nextLine();
        Carrinho carrinho = new Carrinho(nome, telefone, cpf);
        carrinho.produtos.add(new Produto("TV SMART", 1,6800));
        carrinho.produtos.add(new Produto("NOTEBOOK", 1,3200));
        carrinho.produtos.add(new Produto("FOGÃO", 1,2500));
        carrinho.produtos.add(new Produto("GELADEIRA", 1,5700));
        boolean sair = false;
        while(!sair){
            System.out.println("--------------------------------------------");
            System.out.println("-- lista de produtos --");
            for(int i = 0; i<carrinho.produtos.size();i++){
                System.out.println("Produto nº: " + i + " nome: " + carrinho.produtos.get(i).getNomeProduto() + " preço: " + carrinho.produtos.get(i).getPreço());
            }
            System.out.println("--------------------------------------------");
            System.out.println("--------------------------------------------");
            System.out.println("-- lista de produtos no Carrinho --");
            double preçoFinal = 0.0;
            for(int i = 0; i<carrinho.carrinhoCompra.size();i++){
                System.out.println("Produto nº: " + i + " nome: " + carrinho.carrinhoCompra.get(i).getNomeProduto() + " preço: " + carrinho.carrinhoCompra.get(i).getPreço() + " quantidade: " + carrinho.carrinhoCompra.get(i).getQuantidade());
            }
            for(int i = 0; i<carrinho.carrinhoCompra.size();i++){
                preçoFinal = preçoFinal + carrinho.carrinhoCompra.get(i).getPreço();
            }
            System.out.println("Preço total do carrinho: " + preçoFinal);
            System.out.println("--------------------------------------------");

            System.out.println("--------------------------------------------");
            System.out.println("digite uma operação");
            System.out.println("1 = adicionar um produto ao carrinho");
            System.out.println("2 = remover um produto do carrinho");
            System.out.println("3 = sair");
            System.out.println("--------------------------------------------");
            int operacao = scan.nextInt();
            scan.nextLine();
            if(operacao==1){
                System.out.println("--------------------------------------------");
                System.out.println("digite o consecutivo nº desse produto");
                int numero = scan.nextInt();
                scan.nextLine();
                Produto produto = carrinho.buscarProduto(numero);
                System.out.println("digite a quantidade que deseja levar desse produto");
                int quantidade = scan.nextInt();
                scan.nextLine();
                carrinho.adicionarProduto(produto,quantidade);
            }
            if(operacao==2){
                System.out.println("--------------------------------------------");
                System.out.println("digite o consecutivo nº desse produto no carrinho");
                int numero = scan.nextInt();
                scan.nextLine();
                Produto produto = carrinho.buscarProdutoNoCarrinho(numero);
                carrinho.removerProduto(produto);
            }
            if(operacao==3){
                System.out.println("--------------------Fim---------------------");
                sair = true;
            }
            if(operacao>3){
                System.out.println("operação inexistente");
            }
        }

    }
}