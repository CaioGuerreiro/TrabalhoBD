package com.example.trabalhobd.datamodel;

import android.util.Log;

public class FornecedorDataModel {

    // Nome da tabela

    public static final String TABELA = "fornecedor";

    // atributos com os nomes dos campos

    public static final String ID_FORNECEDOR = "id_fornecedor"; // integer Primary key
    public static final String NOME = "nome"; // text

    public static final String CNPJ  = "cnpj"; //text




    // Query para criar a tabela no banco de dados
    public static  String queryCriaTabela = "";

    // metodo para criar script para criar tabela

    public static String criarTabela(){

        // concatenacao de string

        Log.i("DB_Crud", "criarTabela: CRIANDO TABELA");

        queryCriaTabela += "CREATE TABLE "+TABELA+" (";
        queryCriaTabela += ID_FORNECEDOR+" integer primary key autoincrement, ";
        queryCriaTabela += NOME+" text, ";
        queryCriaTabela += CNPJ+" text ";
        queryCriaTabela += ")";

        return queryCriaTabela;
    }
}

