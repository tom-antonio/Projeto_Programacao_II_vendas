package com.luan.vendas.model;

public class ProdutoVenda {
    
    private int id;
    private Venda venda;
    private Produto produto;

    public ProdutoVenda() {
    }

    public ProdutoVenda(int id, Venda venda, Produto produto) {
        this.id = id;
        this.venda = venda;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
