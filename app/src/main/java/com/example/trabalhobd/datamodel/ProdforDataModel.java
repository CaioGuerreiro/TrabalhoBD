package com.example.trabalhobd.datamodel;

import android.util.Log;

public class ProdforDataModel {

    // Nome da tabela

    public static final String TABELA = "prodfor";

    // atributos com os nomes dos campos

    public static final String ID_PRODFOR = "id_prodfor"; // integer Primary key
    public static final String NOME_PRODUTO = "nome_produto"; // text
    public static final String NOME_FORNECEDOR = "nome_fornecedor"; //text




    // Query para criar a tabela no banco de dados
    public static  String queryCriaTabela = "";

    // metodo para criar script para criar tabela

    public static String criarTabela(){

        // concatenacao de string

        Log.i("DB_Crud", "criarTabela: CRIANDO TABELA");

        queryCriaTabela += "CREATE TABLE "+TABELA+" (";
        queryCriaTabela += ID_PRODFOR+" integer primary key autoincrement, ";
        queryCriaTabela += NOME_PRODUTO +" text, ";
        queryCriaTabela += NOME_FORNECEDOR +" text,";
        queryCriaTabela += "FOREIGN KEY("+ NOME_FORNECEDOR +") REFERENCES Fornecedor(nome), ";
        queryCriaTabela += "FOREIGN KEY("+ NOME_PRODUTO +") REFERENCES produto(nome) ON DELETE CASCADE";
        queryCriaTabela += ")";

        return queryCriaTabela;
    }
}

