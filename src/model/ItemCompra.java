package model;

import java.io.Serializable;

public class ItemCompra implements Serializable{
    // Atributos
    private int quantidade;
    private float precoUnitario;
    private Produto produto;

    // Construtor
    public ItemCompra(int quantidade, Produto produto) throws Exception {
        this.setQuantidade(quantidade);
        this.setPrecoUnitario(produto.getPrecoAtual());
        this.setProduto(produto);
    }

    // Getters e Setters
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) throws Exception {
        ItemCompra.validarQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) throws Exception {
        ItemCompra.validarProduto(produto);
        this.produto = produto;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(float preco) throws Exception {
        this.precoUnitario = preco;
    }

    // Validações
    public static void validarQuantidade(int quantidade) throws Exception {
        if(quantidade <= 0)
            throw new Exception("Quantidade deve ser maior que zero");
    }

    public static void validarProduto(Produto produto) throws Exception {
        if(produto == null)
            throw new Exception("Produto não pode ser nulo");
    }

    // Métodos
    public float getPrecoTotal() {
        return this.getQuantidade() * this.getPrecoUnitario();
    }

    public String toString() {
        return this.getQuantidade() + "x " + this.getProduto().getNome() + " - R$ " + String.format("%.2f", this.getPrecoTotal());
    }
}
