import java.util.ArrayList;

public class Carrinho extends Cliente{

    ArrayList<Produto> produtos = new ArrayList<Produto>();


    ArrayList<Produto> carrinhoCompra = new ArrayList<Produto>();

    public Carrinho(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    Produto buscarProduto(int numero){
        for(int i = 0; i< produtos.size();i++){
            Produto produto;
            return produto = produtos.get(numero);
        }
        return null;
    }
    Produto buscarProdutoNoCarrinho(int numero){
        Produto produto;
        return produto = carrinhoCompra.get(numero);
    }
    void adicionarProduto(Produto produto, int quantidade){
        for (int i = 0;i<quantidade;i++){
            carrinhoCompra.add(produto);
        }
    }
    void removerProduto(Produto produto){
            carrinhoCompra.remove(produto);
    }



}
