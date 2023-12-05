package com.example.trabalhobd.datamodel;

import android.util.Log;

public class ProdforDataModel {

    // Nome da tabela

    public static final String TABELA = "prodfor";

    // atributos com os nomes dos campos

    public static final String ID_PRODFOR = "id_prodfor"; // integer Primary key
    public static final String ID_PRODUTO = "id_produto"; // text
    public static final String ID_FORNECEDOR = "id_fornecedor"; //text




    // Query para criar a tabela no banco de dados
    public static  String queryCriaTabela = "";

    // metodo para criar script para criar tabela

    public static String criarTabela(){

        // concatenacao de string

        Log.i("DB_Crud", "criarTabela: CRIANDO TABELA");

        queryCriaTabela += "CREATE TABLE "+TABELA+" (";
        queryCriaTabela += ID_PRODFOR+" integer primary key autoincrement, ";
        queryCriaTabela += ID_PRODUTO +" INTEGER, ";
        queryCriaTabela += ID_FORNECEDOR +" INTEGER,";
        queryCriaTabela += "FOREIGN KEY("+ ID_FORNECEDOR +") REFERENCES Fornecedor(id_fornecedor), ";
        queryCriaTabela += "FOREIGN KEY("+ ID_PRODUTO +") REFERENCES produto(id_produto) ON DELETE CASCADE";
        queryCriaTabela += ")";

        return queryCriaTabela;
    }
}

