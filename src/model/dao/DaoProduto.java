package model.dao;

import java.util.ArrayList;

import model.Produto;

public class DaoProduto extends AbstractDao {
    // Atributos estáticos
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    // Métodos
    // Inclui uma lista de produtos na lista estática
    public static void incluirProdutos(Produto[] novaLista) throws Exception {
        for (int i = 0; i < novaLista.length; i++) {
            DaoProduto.produtos.add(novaLista[i]);
        }
    }

    // Inclui um produto na lista estática
    public static void incluirProduto(Produto novoProduto) throws Exception {
        DaoProduto.produtos.add(novoProduto);
    }

    // Retorna uma cópia da lista de produtos
    public static Produto[] getProdutos() {
        Produto[] copia = new Produto[DaoProduto.getNumProdutos()];
        for(int i = 0; i < copia.length; i++)
            copia[i] = DaoProduto.getProdutoIndice(i);
        return copia;
    }

    // Retorna o número de produtos cadastrados
    public static int getNumProdutos() {
        return DaoProduto.produtos.size();
    }

    // Retorna o produto de um determinado índice
    public static Produto getProdutoIndice(int indice) {
        return DaoProduto.produtos.get(indice);
    }

    // Retorna o produto de um determinado código de barras
    public static Produto getProdutoCodigoDeBarras(String codigoDeBarras) {
        for (Produto produto : DaoProduto.produtos) {
            if (produto.getCodigoDeBarras().equals(codigoDeBarras)) {
                return produto;
            }
        }
        return null;
    }

    // Exclui um produto
    public static void excluirProduto(Produto produto) throws Exception {
        if (DaoProduto.produtos.contains(produto))
            DaoProduto.produtos.remove(produto);
        else
            throw new Exception("Produto não encontrado!");
    }

    // Altera um produto
    public static void alterarProduto(Produto produtoAntigo) throws Exception {
        if (!DaoProduto.produtos.contains(produtoAntigo))
            throw new Exception("Produto não encontrado!");
    }

    // Checa se a lista de produtos está vazia
    public static boolean estaVazia() {
        return DaoProduto.produtos.isEmpty();
    }

    // Retorn o ultimo produto da lista
    public static Produto getUltimoProduto() {
        return DaoProduto.produtos.get(DaoProduto.produtos.size() - 1);
    }

}
