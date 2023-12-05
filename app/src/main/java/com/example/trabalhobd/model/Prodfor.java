package com.example.trabalhobd.model;

import java.io.Serializable;

public class Prodfor implements Serializable {

    private int id_prodfor;
    private int id_produto;
    private int id_fornecedor;


    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    public int getId_prodfor() {
        return id_prodfor;
    }

    public void setId_prodfor(int id_prodfor) {
        this.id_prodfor = id_prodfor;
    }


}
