package com.luan.vendas.model;

public class ProdutoVenda {
    
    private int id;
    private int idVenda;
    private int idProduto;
    private int qtdeProduto;

    public ProdutoVenda() {
    }

    public ProdutoVenda(int id, int idVenda, int idProduto, int qtdeProduto) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtdeProduto = qtdeProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }
}
