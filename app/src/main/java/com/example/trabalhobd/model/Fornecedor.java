package com.example.trabalhobd.model;

import java.io.Serializable;
import java.util.List;

public class Fornecedor implements Serializable {
    public List<Prodfor> getProdforList() {
        return prodforList;
    }

    public void setProdforList(List<Prodfor> prodforList) {
        this.prodforList = prodforList;
    }

    private List<Prodfor> prodforList;


    private int id_fornecedor;
    private String nome;
    private String cnpj;

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
