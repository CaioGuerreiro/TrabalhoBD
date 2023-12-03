package com.example.trabalhobd.model;

import java.io.Serializable;

public class Prodfor implements Serializable {

    private int id_prodfor;
    private String nome_produto;
    private String nome_fornecedor;

    public int getId_prodfor() {
        return id_prodfor;
    }

    public void setId_prodfor(int id_prodfor) {
        this.id_prodfor = id_prodfor;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }
}
