package com.example.trabalhobd.datamodel;

import android.util.Log;

public class ProdutoDataModel {

    // Nome da tabela

    public static final String TABELA = "produto";

    // atributos com os nomes dos campos

    public static final String ID_PRODUTO = "id_produto"; // integer Primary key
    public static final String NOME = "nome"; // text

    public static final String QUANTIDADE  = "quantidade"; //integer

    public static final String TIPO = "tipo"; // text

    public static final String ID_CLIENTE = "id_cliente"; // FK INTEGER


    // Query para criar a tabela no banco de dados
    public static  String queryCriaTabela = "";

    // metodo para criar script para criar tabela

    public static String criarTabela(){

        // concatenacao de string

        Log.i("DB_Crud", "criarTabela: CRIANDO TABELA");

        queryCriaTabela += "CREATE TABLE "+TABELA+" (";
        queryCriaTabela += ID_PRODUTO+" integer primary key autoincrement, ";
        queryCriaTabela += NOME+" text, "; // nome text
        queryCriaTabela += QUANTIDADE+" integer, "; // nome text
        queryCriaTabela += TIPO+" text, "; // nome text

        queryCriaTabela += ID_CLIENTE+" integer, foreign key("+ID_CLIENTE+") references 'cliente'('id') ON DELETE CASCADE" ; // nome text
        queryCriaTabela += ")";

        return queryCriaTabela;
    }
}

